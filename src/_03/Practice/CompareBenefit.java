package _03.Practice;

import java.util.ArrayList;
import java.util.List;

public class CompareBenefit extends _01.TowerOfHanoi.CompareBenefit {
    public static void main(String[] args) {
        //스캐너 대신 미래 인풋값 설정
        int input = 4;

        //메모리 사용량을 넣을 리스트
        List useRecursiveMems = new ArrayList<Long>();
        List useForMems = new ArrayList<Long>();

        for (int i = 0; i < 100; i++) {
            useForMems.add(doUseFor(input));
            useRecursiveMems.add(doUseRecursive(input));
        }

        long forSum = 0;
        long recursiveSum = 0;

        for (int i = 0; i < 100; i++) {
            forSum += (long) useForMems.get(i);
            recursiveSum += (long) useRecursiveMems.get(i);
        }
        System.out.printf("UseRecursive 평균 메모리 사용량 : %d , UseFor 평균 메모리 사용량 : %d", recursiveSum, forSum);
    }

    private static long doUseFor(int input){
        long beforeMem = getNowMemory();

        UseFor uF = new UseFor(input);
        uF.solve();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

    private static long doUseRecursive(int input){
        long beforeMem = getNowMemory();

        UseRecursive uR = new UseRecursive(input);
        uR.solve();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }
}
