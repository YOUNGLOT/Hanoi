package _03.Practice;

import java.util.Scanner;

public class UseFor extends UseRecursive{
    public UseFor(int input) {
        super(input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        UseFor test = new UseFor(input);
        test.solve();
    }
    @Override
    protected void solve() {
        // resultArray 생성
        String[][] resultArray = new String[RESULT_ARRAY_SIZE][RESULT_ARRAY_SIZE];

        // resultArray의 모든 Value를 x로 넣기
        resultArray = replaceAllValue(resultArray, "x");

        //재귀함수를 이용한 풀이 -> For문을 이용한 풀이
        resultArray = forMethod(resultArray);

        //생성된 Array를 출력
        printArray(resultArray);
    }

    private String[][] forMethod(String[][] resultArray) {
        for (int i = 0; i < super.INPUT; i++) {
            resultArray = eraseLogic(resultArray, i);
        }
        return resultArray;
    }
}
