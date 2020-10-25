package _03.Practice;

import java.util.Scanner;

public class UseRecursive {
    protected final int INPUT;
    protected final int RESULT_ARRAY_SIZE;

    public UseRecursive(int input) {
        INPUT = input;
        RESULT_ARRAY_SIZE = (int) Math.pow(3, input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        UseRecursive test = new UseRecursive(input);
        test.solve();
    }

    // ForExplanin Class 를 위해 default 접근지정자 사용
    protected void solve() {
        // resultArray 생성
        String[][] resultArray = new String[RESULT_ARRAY_SIZE][RESULT_ARRAY_SIZE];

        // resultArray의 모든 Value를 x로 넣기
        resultArray = replaceAllValue(resultArray, "x");

        //재귀함수를 이용한 풀이
        int repeatCount = INPUT - 1; //
        resultArray = recursiveMethod(resultArray, repeatCount);

        //생성된 Array를 출력
        printArray(resultArray);
    }

    protected String[][] replaceAllValue(String[][] resultArray, String replaceString) {
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray.length; j++) {
                resultArray[i][j] = replaceString;
            }
        }
        return resultArray;
    }

    protected String[][] recursiveMethod(String[][] resultArray, int repeatCount) {
        if(repeatCount < 0){
            return resultArray;
        }else
            return recursiveMethod(eraseLogic(resultArray,  repeatCount),  repeatCount - 1);
    }

    //가운데 공간을 비우는 Logic
    protected String[][] eraseLogic(String[][] resultArray, int repeatCount) {
        int midRangeLength = (int) Math.pow(3, repeatCount);

        for (int i = 0; i < RESULT_ARRAY_SIZE / midRangeLength; i++) {
            for (int j = 0; j < RESULT_ARRAY_SIZE / midRangeLength; j++) {

                if (i % 3 == 1 && j % 3 == 1) {

                    for (int k = 0; k < midRangeLength; k++) {
                        for (int l = 0; l < midRangeLength; l++) {
                            resultArray[midRangeLength * i + k][midRangeLength * j + l] = " ";
                        }
                    }

                }

            }
        }
        return resultArray;
    }

    protected void printArray(String[][] resultArray) {
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray.length; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }

}
