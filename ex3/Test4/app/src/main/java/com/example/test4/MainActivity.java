package com.example.test4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.test4.R; // ✅ 自己包的 R

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        dataList = new ArrayList<>();

        // 初始化数据
        for (int i = 1; i <= 10; i++) {
            dataList.add("Item " + i);
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, dataList);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            int selectedCount = 0;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked) selectedCount++;
                else selectedCount--;
                mode.setTitle(selectedCount + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                selectedCount = 0;
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.action_delete) {
                    for (int i = listView.getCount() - 1; i >= 0; i--) {
                        if (listView.isItemChecked(i)) {
                            dataList.remove(i);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "已删除选中项", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                } else {
                    return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                selectedCount = 0;
            }
        });
    }
}
