package _03.Practice;

import java.util.*;

public class NewUseRecursive {
    protected final int INPUT; // input값
    protected final int RESULT_SIZE; // 결과로 프린트 될 사이즈
    protected Set<XYset> xYSets = new HashSet<>(); // 빈 공간의 X, Y 좌표 들의 Set

    public NewUseRecursive(int input) {
        INPUT = input;
        RESULT_SIZE = (int) Math.pow(3, input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewUseRecursive test = new NewUseRecursive(sc.nextInt());
        test.solve();
    }

    protected void solve() {
        // 구현한 재귀 함수
        recursive(RESULT_SIZE / 2, RESULT_SIZE / 2 , INPUT);

        // 결과값을 출력하는 함수
        printResult(xYSets);
    }

    // print 함수
    private void printResult(Set x) {
        for (int i = 0; i < RESULT_SIZE; i++) {
            for (int j = 0; j < RESULT_SIZE; j++) {
                if (x.contains(new XYset(j, i))) {
                    System.out.print("  ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    private void recursive(int centerX, int centerY, int repeatCount) { //x,y는 index 값 0부터 시작
        //HashSet 공백으로 넣을 좌표를 넣는다
        addLogic(centerX, centerY, repeatCount);

        //현재 중앙과 다음 반복의 중앙값과의 x, y값의 차이, 같기때문에 한 변수만 선언
        int distanceFromCenter = (int) Math.pow(3, repeatCount-1);

        if (repeatCount <= 0) {
            return;
        } else {
            recursive(centerX - distanceFromCenter, centerY - distanceFromCenter, repeatCount - 1); //1
            recursive(centerX, centerY - distanceFromCenter, repeatCount - 1);                             //2
            recursive(centerX + distanceFromCenter, centerY - distanceFromCenter, repeatCount - 1); //3
            recursive(centerX - distanceFromCenter, centerY, repeatCount - 1);                             //4
                                                                                                               //5
            recursive(centerX + distanceFromCenter, centerY, repeatCount - 1);                             //6
            recursive(centerX - distanceFromCenter, centerY + distanceFromCenter, repeatCount - 1); //7
            recursive(centerX, centerY + distanceFromCenter, repeatCount - 1);                             //8
            recursive(centerX + distanceFromCenter, centerY + distanceFromCenter, repeatCount - 1); //9
        }
    }

    private void addLogic(int x, int y, int repeatCount) {
        int addLength = (int) Math.pow(3,repeatCount-1);

        for (int i = x - addLength/2; i < (x+addLength/2) + addLength%2  ; i++) {
            for (int j = y - addLength/2; j < (y+addLength/2) + addLength%2  ; j++) {

                xYSets.add(new XYset(i, j));

            }
        }
    }


}

