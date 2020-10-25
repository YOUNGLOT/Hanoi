package _01.TowerOfHanoi;

import java.util.Scanner;

public class YHTowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = recursiveMethod(sc.nextInt());
        System.out.println("총 이동 횟수 : " + result);
    }

    private static int recursiveMethod(int n) {
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
