package _01.TowerOfHanoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareBenefit {

    // 스캐너의 사용은 Skip 하겠습니다.
    public static void main(String[] args) {
        int inputNum = 20;

        List MyCode_UsingMemory = new ArrayList<Integer>();
        List GoogleCode_UsingMemory = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            GoogleCode_UsingMemory.add(doGoogleCode(inputNum));
            MyCode_UsingMemory.add(doMyCode(inputNum));
        }
        long MySum = 0;
        long GoogleSum = 0;
        for (int i = 0; i < 1000; i++) {
            MySum += (long) MyCode_UsingMemory.get(i)/1000;
            GoogleSum += (long) GoogleCode_UsingMemory.get(i)/1000;
        }
        System.out.printf("MyCode의 평균 메모리 사용량 : %d byte \nGoogleCode의 평균 메모리 사용량 : %d byte", MySum, GoogleSum);
    }

    private static long doGoogleCode(int input){

        long beforeMem = getNowMemory();

        GoogleTowerOfHanoi towerOfHanoi = new GoogleTowerOfHanoi();
        towerOfHanoi.moveHanoiTower("1","2","3",input);
        towerOfHanoi.showResult();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

    private static long doMyCode(int input){
        long beforeMem = getNowMemory();

        MyTowerOfHanoi my = new MyTowerOfHanoi();
        System.out.println("총 이동 횟수 : "+my.recursiveMethod(input));

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

    private static long getNowMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }


}
