package _03.Practice;

import java.util.ArrayList;
import java.util.List;

public class CompareBenefit extends _01.TowerOfHanoi.CompareBenefit {
    public static void main(String[] args) {
        //스캐너 대신 미래 인풋값 설정
        int input = 5;


        CompareBenefit cB = new CompareBenefit();

        long forSum = 0;
        long newRecursiveSum = 0;
        long recursiveSum = 0;
        //forSum = cB.checkForMem(input);
        //recursiveSum = cB.checkRecursiveMem(input);
        newRecursiveSum = cB.checkNewRecursiveMem(input);

        //System.out.printf("UseFor 평균 메모리 사용량 : %d\n", forSum);
        //System.out.printf("UseRecursive 평균 메모리 사용량 : %d \n", recursiveSum);
        System.out.printf("newUseRecoursive 평균 메모리 사용량 : %d", newRecursiveSum);

    }

    private long checkForMem(int input) {
        List useForMems = new ArrayList<Long>();
        for (int i = 0; i < 50; i++) {
            long usedMem = doUseFor(input);
            useForMems.add(usedMem);
        }
        long forSum = 0;
        for (int i = 0; i < useForMems.size(); i++) {
            forSum += (long) useForMems.get(i) / useForMems.size();
        }
        return forSum;
    }

    private long checkRecursiveMem(int input) {
        List useRecursiveMems = new ArrayList<Long>();
        for (int i = 0; i < 50; i++) {
            long usedMem = doUseRecursive(input);
            useRecursiveMems.add(usedMem);
        }
        long recursiveSum = 0;
        for (int i = 0; i < useRecursiveMems.size(); i++) {
            recursiveSum += (long) useRecursiveMems.get(i) / useRecursiveMems.size();
        }
        return recursiveSum;
    }

    private long checkNewRecursiveMem(int input) {
        List useNewRecursiveMems = new ArrayList<Long>();
        for (int i = 0; i < 50; i++) {
            long usedMem = doUseNewRecoursive(input);
            useNewRecursiveMems.add(usedMem);
        }
        long newRecursiveSum = 0;
        for (int i = 0; i < useNewRecursiveMems.size(); i++) {
            newRecursiveSum += (long) useNewRecursiveMems.get(i) / useNewRecursiveMems.size();
        }
        return newRecursiveSum;
    }

    private static long doUseFor(int input) {
        long beforeMem = getNowMemory();

        UseFor uF = new UseFor(input);
        uF.solve();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

    private static long doUseRecursive(int input) {
        long beforeMem = getNowMemory();

        UseRecursive uR = new UseRecursive(input);
        uR.solve();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

    private static long doUseNewRecoursive(int input) {
        long beforeMem = getNowMemory();

        NewUseRecursive nUR = new NewUseRecursive(input);
        nUR.solve();

        long afterMem = getNowMemory();
        return afterMem - beforeMem;
    }

}
