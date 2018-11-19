package com.example.a2048;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends Activity implements View.OnClickListener {
    LinkedList<Integer> mnumberlist = new LinkedList<>();
    int[][] tablet = new int[4][4];

    GridView tablegridView;
    Button leftButton;
    Button rightButton;
    Button upButton;
    Button downButton;
    Button restartButton;
    Scoll scoll;//这个就是算法代码
    TableGridviewAdatper adatper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoll  = new Scoll(tablet);
        scoll.start();

        leftButton =(Button) findViewById(R.id.leftButton);
        rightButton = (Button)findViewById(R.id.rightButton);
        upButton = (Button)findViewById(R.id.upButton);
        downButton = (Button) findViewById(R.id.downButton);
        restartButton = (Button) findViewById(R.id.restartbutton);
        restartButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);

        tablegridView = (GridView) findViewById(R.id.tablegridveiw);
        tablegridView.setScrollContainer(false);
        adatper = new TableGridviewAdatper(this,tablet);
        tablegridView.setAdapter(adatper);
    }

    @Override
    public void onClick(View v) {
        //保存一份数据
        int[][] table2 = new int[4][4];
        for (int i = 0; i< 4; i++){
            for (int j = 0; j < 4; j++){
                table2[i][j] = tablet[i][j];
            }
        }
        switch (v.getId()){
            case R.id.leftButton: scoll.leftSroll();break;
            case R.id.rightButton: scoll.rightSroll();break;
            case R.id.upButton:scoll.upSroll();break;
            case R.id.downButton:scoll.downSroll();break;
            case R.id.restartbutton:scoll.start();break;
        }
//判断滑动时有没有格子可以动，我是将数据在操作前保存了一份再与计算之后做比较，如果一样就不用添加数字了
        int k = 0;
        for (int i = 0; i< 4; i++){
            for (int j = 0; j < 4; j++){
                if(table2[i][j] != tablet[i][j]&&k==0){
                    scoll.insertNumber();
                    adatper.notifyDataSetChanged();//通知adapter刷新页面
                    k++;
                }
                if (tablet[i][j] == 2048)
                    Toast.makeText(this,"恭喜成功",Toast.LENGTH_SHORT).show();
            }
        }
//判断是否游戏结束
        if (scoll.isGameOver()){
            Toast.makeText(this,"没有格子可以移动了，请重新开始",Toast.LENGTH_SHORT).show();
        }

    }
}
