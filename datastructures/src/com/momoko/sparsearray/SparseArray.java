package com.momoko.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by momoko on 2021/1/21.
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0:表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //3. 遍历二维数组，得到对应位置的非0数据
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];

                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组的形式");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组保存到文件中
        FileWriter fos = null;
        try {
            fos = new FileWriter(new File("sparseArr.txt"));
            for (int i = 0; i < sparseArr.length; i++) {
                fos.write(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将稀疏数组-->原始的二维数组
        //从文件中读取稀疏数组

        int line = 0;
        BufferedReader fis = null;
        int[][] chessArr2 = new int[0][];
        int row = 0,col = 0,value = 0;
        try {
            fis = new BufferedReader(new FileReader("sparseArr.txt"));
            String str;
            while ((str = fis.readLine()) != null){

                String[] temp = str.split("\t");
                for(int i = 0;i < temp.length;i++) {
                    row = Integer.parseInt(temp[0]);
                    col = Integer.parseInt(temp[1]);
                    value = Integer.parseInt(temp[2]);
                }
                if (line == 0) {
                    //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
                    chessArr2 = new int[row][col];
                } else {
                    chessArr2[row][col] = value;
                }
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出恢复后的二维数组
        System.out.println();
        System.out.println("从文件中恢复的稀疏数组");

        for (int[] row1 : chessArr2) {
            for (int data : row1) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}