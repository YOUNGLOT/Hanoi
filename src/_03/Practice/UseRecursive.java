package _03.Practice;

import java.util.Scanner;

public class UseRecursive {

    public static void main(String[] args) {
        UseRecursive test = new UseRecursive();
        test.solve();
    }

    private void solve() {
        //스캐너로 입력 받고 resultArray 생성
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int num1 = (int) Math.pow(3, num);
        String[][] ar = new String[num1][num1];

        // resultArray의 모든 Value를 x로 넣기
        ar = replaceAllValue(ar, "x");

        ar = recursiveMethod(ar, num1, num);

        //생성된 Array를 출력
        printArray(ar);
    }

    private String[][] replaceAllValue(String[][] array, String replaceString) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = replaceString;
            }
        }
        return array;
    }

    private String[][] recursiveMethod(String[][] ar, int num, int seq) {
        if(seq == 0){
            return eraseLogic(ar,num,seq);
        }else
            return recursiveMethod(eraseLogic(ar,num,seq), num, seq - 1);
    }

    private String[][] eraseLogic(String[][] ar, int num, int seq) {
        int temp = (int) Math.pow(3, seq);

        for (int i = 0; i < num / temp; i++) {
            for (int j = 0; j < num / temp; j++) {

                if (i % 3 == 1 && j % 3 == 1) {

                    for (int k = 0; k < temp; k++) {
                        for (int l = 0; l < temp; l++) {
                            ar[temp * i + k][temp * j + l] = " ";
                        }
                    }

                }

            }
        }

        return ar;
    }

    private void printArray(String[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }



}
