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

        int arrSize = (int) Math.pow(3, num);
        String[][] ar = new String[arrSize][arrSize];

        // resultArray의 모든 Value를 x로 넣기
        ar = replaceAllValue(ar, "x");

        //재귀함수를 이용한 풀이
        ar = recursiveMethod(ar, arrSize, num);

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

    private String[][] recursiveMethod(String[][] ar, int arrSize, int seq) {
        if(seq < 0){
            return ar;
        }else
            return recursiveMethod(eraseLogic(ar,arrSize,seq), arrSize, seq - 1);
    }

    //가운데 공간을 비우는 Logic
    private String[][] eraseLogic(String[][] ar, int arrSize, int seq) {
        int temp = (int) Math.pow(3, seq);

        for (int i = 0; i < arrSize / temp; i++) {
            for (int j = 0; j < arrSize / temp; j++) {

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
