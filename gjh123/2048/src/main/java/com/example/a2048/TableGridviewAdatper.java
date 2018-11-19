package com.example.a2048;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TableGridviewAdatper extends BaseAdapter {

    Context context;
    int[][] table;
    TableGridviewAdatper(Context context , int[][] table){
        this.context = context;
        this.table =table;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 16;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;

        if (convertView == null){
            viewHodler   = new ViewHodler();
            convertView = View.inflate(context,R.layout.imgs,null);
            viewHodler.imageView = (ImageView) convertView.findViewById(R.id.img);
            viewHodler.textView = (TextView) convertView.findViewById(R.id.numbertext);

            convertView.setTag(viewHodler);
        }else{
            viewHodler =(ViewHodler) convertView.getTag();
        }
        //给不同的数字添加不同的颜色，颜色随便啦！颜色放在Color.xml里
        //根据position判断table的行与列因为position的位置是从1到16的
        switch(table[((int)position/4)][position%4]){
            case 0: viewHodler.imageView.setBackgroundResource(R.color.color0);
                viewHodler.textView.setText("");break;
            case 2: viewHodler.imageView.setBackgroundResource(R.color.color2);
                     viewHodler.textView.setText("2");break;
            case 4: viewHodler.imageView.setBackgroundResource(R.color.color4);
                    viewHodler.textView.setText("4");break;
            case 8: viewHodler.imageView.setBackgroundResource(R.color.color8);
                viewHodler.textView.setText("8");break;
            case 16: viewHodler.imageView.setBackgroundResource(R.color.color16);
                viewHodler.textView.setText("16");break;
            case 32: viewHodler.imageView.setBackgroundResource(R.color.color32);
                viewHodler.textView.setText("32");break;
            case 64: viewHodler.imageView.setBackgroundResource(R.color.color64);
                viewHodler.textView.setText("64");break;
            case 128: viewHodler.imageView.setBackgroundResource(R.color.color128);
                viewHodler.textView.setText("128");;break;
            case 256: viewHodler.imageView.setBackgroundResource(R.color.color256);
                viewHodler.textView.setText("256");break;
            case 512: viewHodler.imageView.setBackgroundResource(R.color.color512);
                viewHodler.textView.setText("512");break;
            case 1024: viewHodler.imageView.setBackgroundResource(R.color.color1024);
                viewHodler.textView.setText("1024");break;
            case 2048: viewHodler.imageView.setBackgroundResource(R.color.color2048);
                viewHodler.textView.setText("2048");break;
        }
        return  convertView;
    }

}
class  ViewHodler{
    ImageView imageView;
    TextView textView;
}
