package com.example.a2048;

import java.util.LinkedList;

/**
 * Created by Rindiaco on 2017/8/21.
 */

public class Scoll {
    private LinkedList<Integer> mnumberlist;
    private int[][] tablet ;
    Scoll(int[][] tablet){
        this.tablet = tablet;
        mnumberlist = new LinkedList<>();
    }

    void start(){
        int key  = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4;j++ ){
                tablet[i][j] = 0;
                key= (int)(Math.random()*8);
                if (key%2 == 0&&key%3!=0){
                    tablet[i][j] = key;
                }
                System.out.print(tablet[i][j]+" ");
            }
            System.out.println();
        }
    }
    void insertNumber(){
        int key  = 0;
         int k = 0;
        while (k==0){
                int a = (int)(Math.random()*4);
                int b = (int)(Math.random()*4);
                key = (int)(Math.random()*7);
                if (key%2 == 0&&key%3!=0){
                    if (tablet[a][b]==0) {
                        tablet[a][b] = key;
                        k++;
                        break;
                    }
                }
//                System.out.print(tablet[i][j]+" ");
            }

    }

    void oneLineCount(){
        for (int p = 0; p < mnumberlist.size();) {
            if (mnumberlist.get(p) == 0) {
                mnumberlist.remove(p);
            }else {
                p++;
            }
        }
        for (int k = 0; k < mnumberlist.size()-1; k++){
            if (mnumberlist.get(k).equals(mnumberlist.get(k+1))){
                Integer a = new Integer(mnumberlist.get(k)*2);
                mnumberlist.remove(k);
                mnumberlist.add(k,a);
                mnumberlist.remove(k+1);
            }
        }
    }

    boolean isGameOver(){
        int k = 0;
        for (int i = 0; i < 3 && k==0 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                if (tablet[i][j] == tablet[i][j + 1]|| tablet[i][j] == 0||tablet[i][j+1]==0){
                    k++;
                    break;
                }else if(tablet[i][j] == tablet[i+1][j]|| tablet[i+1][j] == 0||tablet[i+1][j]==0){
                    k++;
                    break;
                }
            }
        }
        if (tablet[2][3]==tablet[3][3]||tablet[3][3]==tablet[3][2]||tablet[3][3]==0)k=1;
        if(k==0){
          return  true;
        }
        return false;
    }
    void leftSroll(){
        for (int i = 0; i < 4 ;i++){
            for (int j = 0; j < 4;j++){
                mnumberlist.add(j,tablet[i][j]);
            }
            oneLineCount();//合并同类项
            for (int c = 0 ; c<4;c++){
                if (c < mnumberlist.size())
                    tablet[i][c] = mnumberlist.get(c);
                else
                    tablet[i][c] = 0;
                System.out.print(tablet[i][c]+" ");
            }
            mnumberlist.clear();
        }
    }
    void rightSroll(){
        for(int i = 0; i < 4; i++){
            int k = 0;
            for (int j = 3; j > -1; j--) {
                mnumberlist.add(k,tablet[i][j]);
                k++;
            }
            oneLineCount();//合并同类项
            int d = 0;
            for (int c = 3 ; c > -1; c--){
                if (d < mnumberlist.size())
                    tablet[i][c] = mnumberlist.get(d);
                else
                    tablet[i][c] = 0;
                d++;
            }

            mnumberlist.clear();
        }
        print();
    }
    void downSroll(){
        for(int j = 0; j < 4; j++){
            int k = 0;
            for (int i = 3; i > -1; i--) {
                mnumberlist.add(k,tablet[i][j]);
                k++;
            }
            oneLineCount();//合并同类项
            int d = 0;
            for (int c = 3 ; c > -1; c--){
                if (d<mnumberlist.size())
                    tablet[c][j] = mnumberlist.get(d);
                else
                    tablet[c][j] =0;
                d++;
            }
            mnumberlist.clear();
        }
        print();
    }
    void upSroll(){
        for(int j = 0; j < 4; j++){
            for (int i = 0; i < 4; i++) {
                mnumberlist.add(i,tablet[i][j]);
            }
            oneLineCount();//合并同类项
            for (int c = 0 ; c < 4; c++){
                if (c < mnumberlist.size())
                    tablet[c][j] = mnumberlist.get(c);
                else
                    tablet[c][j] = 0;
            }
            mnumberlist.clear();
        }
    }
    void print(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablet[i][j]+" ");
            }
            System.out.println();
        }
    }
}
