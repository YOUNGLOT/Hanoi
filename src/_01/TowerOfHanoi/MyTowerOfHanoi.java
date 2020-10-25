package _01.TowerOfHanoi;

import java.util.Scanner;

public class MyTowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyTowerOfHanoi my = new MyTowerOfHanoi();
        System.out.println("총 이동 횟수 : " + my.recursiveMethod(sc.nextInt()));
    }

    int recursiveMethod(int n) {
        return (n == 1) ? n : (int) Math.pow(2, n - 1) + recursiveMethod(n - 1);
    }

    //삼항 연산자 사용 전
    /*private int getResult(int n) {
        if (n == 1)
            return n;
        else
            return (int) Math.pow(2, n - 1) + getResult(n - 1);
    }*/
}
