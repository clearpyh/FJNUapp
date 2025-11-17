# Android-Development
## '这里是fjnu 23级软件工程3班121052023087浦颖昊安卓实验课内容'
实验项目目录结构如下（所有项目除命名不同，结构相同）
app/<br> 
 ├─ java/com.example.文件名/<br> 
 │   ├─MainActivity.java<br> 
 └─ res/<br>  
     ├─layout/<br>   
     └─values/<br>   
     └─xml/<br>
     └─drawable<br>
     └─mipmap<br>
# 实验二
##  text1
### 实验目的 利用线性布局实现界面
#### 实验结果截图展示
<img width="1080" height="2400" alt="Screenshot_20251117_101756" src="https://github.com/user-attachments/assets/13d650b1-5714-44de-849f-ce3ead717e91" />
#### 核心代码实现

<!-- 根布局：竖直排列 4 行 -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000"
    android:padding="8dp">

    <!-- 每一行都是水平 LinearLayout，通过 layout_weight 平分按钮宽度 -->
    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <Button
            android:text="One,One"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"/>

        <Button
            android:text="One,Two"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"/>

        <Button
            android:text="One,Three"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"/>

        <Button
            android:text="One,Four"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"/>
    </LinearLayout>
</LinearLayout>

## test 2
### 实验目的 利用表格布局实现界面
#### 实验结果截图展示
<img width="1080" height="2400" alt="Screenshot_20251117_105754" src="https://github.com/user-attachments/assets/ebe7b1d0-afd4-4c81-b7ab-8e81d874fee7" />

#### 核心代码展示
<!-- TableLayout 核心布局 -->
<TableLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000"
    android:stretchColumns="1"
    android:padding="8dp">

    <!-- 标题行 -->
    <TableRow>
        <TextView
            android:text="Hello TableLayout"
            android:textColor="#FFFFFF"
            android:textSize="18sp"
            android:layout_span="2"
            android:padding="8dp"/>
    </TableRow>

    <!-- 菜单项示例 -->
    <TableRow>
        <TextView
            android:text="Open..."
            android:textColor="#FFFFFF"
            android:padding="8dp"/>
        <TextView
            android:text="Ctrl+O"
            android:textColor="#AAAAAA"
            android:padding="8dp"/>
    </TableRow>

    <TableRow>
        <TextView
            android:text="Save..."
            android:textColor="#FFFFFF"
            android:padding="8dp"/>
        <TextView
            android:text="Ctrl+S"
            android:textColor="#AAAAAA"
            android:padding="8dp"/>
    </TableRow>

</TableLayout>

## test3
### 实验目的 利用ConstraintLayout实现界面1
#### 实验结果截图展示
<img width="1080" height="2400" alt="Screenshot_20251117_104833" src="https://github.com/user-attachments/assets/63a7bfea-630e-4bf9-a876-084a731ec22b" />

#### 核心代码展示
<!-- 根布局：ConstraintLayout -->
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 输入栏 -->
    <EditText
        android:id="@+id/editTextInput"
        android:layout_width="0dp"
        android:layout_height="60dp"
        android:background="#D7D7B7"
        android:gravity="end|center_vertical"
        android:hint="Input"
        android:text="0.0"
        android:textSize="24sp"
        android:focusable="false"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp"
        android:padding="10dp"/>

    <!-- 按钮区域：GridLayout -->
    <GridLayout
        android:id="@+id/gridLayout"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:columnCount="4"
        android:rowCount="4"
        android:alignmentMode="alignMargins"
        android:useDefaultMargins="true"
        app:layout_constraintTop_toBottomOf="@id/editTextInput"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <!-- 按钮示例 -->
        <Button android:text="7" />
        <Button android:text="8" />
        <Button android:text="9" />
        <Button android:text="×" />

    </GridLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
## test 4
### 实验目的 利用ConstraintLayout实现界面2
#### 实验结果截图展示
<img width="1080" height="2400" alt="Screenshot_20251117_110014" src="https://github.com/user-attachments/assets/5d33cb78-c2f1-4f24-b704-c2b62c9d95bb" />

#### 核心代码展示
<!-- 根布局：ConstraintLayout -->
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 顶部导航栏 -->
    <LinearLayout
        android:id="@+id/top_bar"
        android:orientation="horizontal"
        android:gravity="center"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <ImageView android:layout_width="24dp" android:layout_height="24dp" />
        <TextView android:text="Space Stations" android:textSize="14sp"/>
        <ImageView android:layout_width="24dp" android:layout_height="24dp" />
        <TextView android:text="Flights" android:textSize="14sp"/>
        <ImageView android:layout_width="24dp" android:layout_height="24dp" />
        <TextView android:text="Rovers" android:textSize="14sp"/>
    </LinearLayout>

    <!-- 中间选择框 -->
    <LinearLayout
        android:id="@+id/route_select"
        android:orientation="horizontal"
        android:gravity="center"
        app:layout_constraintTop_toBottomOf="@id/top_bar"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <Button android:text="DCA" android:layout_width="80dp"/>
        <ImageView android:layout_width="40dp" android:layout_height="40dp"/>
        <Button android:text="MARS" android:layout_width="80dp"/>
    </LinearLayout>

    <!-- 其他操作按钮 -->
    <Button android:id="@+id/btn_oneway" android:text="One Way"/>
    <Button android:id="@+id/btn_traveller" android:text="1 Traveller"/>
    <ImageView android:id="@+id/img_planet" android:layout_width="150dp"/>
    <Button android:id="@+id/btn_depart" android:text="DEPART"/>

</androidx.constraintlayout.widget.ConstraintLayout>






     


