package _01.TowerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoi {
    int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.moveHanoiTower("1","2","3",n);
        towerOfHanoi.showResult();
    }

    public void moveHanoiTower(String first, String center, String last, int n){
        //first     원반들이 있던 탑
        //center    중간 위치 탑
        //last      원반들을 옮길 목적지 탑
        if (n == 1) {
            ++count;
            //System.out.printf("%d, % d : %s -> %s\n",count,n,first,last);
        }else{
            moveHanoiTower(first, last, center, n-1);
            ++count;
            //System.out.printf("%d, %d : %s -> %s\n",count,n,first,last);
            moveHanoiTower(center, first, last, n-1);
        }
    }

    private void showResult(){
        System.out.printf("총 이동 횟수 : %d", count);
    }
}
