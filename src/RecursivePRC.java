public class RecursivePRC {

    public static void main(String[] args) {
        RecursivePRC tp = new RecursivePRC();

        String str = "Hello";
        int tempInt = 56;

        System.out.print("문자열 길이의 출력 \"Hello\" : ");
        System.out.println(tp.getLengthOfString(str));

        System.out.print("\n문자열 프린트 \"Hello\" : ");
        tp.printString(str);
        System.out.println("\n");

        System.out.print("문자열 뒤집어서 프린트 \"Hello\" : ");
        tp.reversePrintString(str);
        System.out.println("\n");

        System.out.print("2진수로 반환하여 출력 56 : ");
        tp.printInBinary(tempInt);
        System.out.println();

        System.out.println("\n배열의 합 구하기 data = {1,2,3,4,5,6,7,8,9};\n: "+tp.sum(7,data));
    }



    //region 앞의 예제
    //문자열의 길이 출력
    public int getLengthOfString(String string) {
        if (string == null) {
            return 0;
        }

        // base case(재귀함수 호출에서 빠져 나가기 위한 경우)
        if (string.equals(""))
            return 0;
            // Recursive case 자신을 호출하는 함수를 표현하는 경우
        else
            return 1 + getLengthOfString(string.substring(1));
    }

    // 문자열의 프린트
    public void printString(String string) {
        if (string.length() == 0) {
            return;
        } else {
            System.out.print(string.charAt(0));
            printString(string.substring(1));
        }
    }

    // 문자열을 뒤집어서 프린트
    public void reversePrintString(String string){
        if(string.length()==0){
            return;
        } else {
            reversePrintString(string.substring(1));
            System.out.print(string.charAt(0));
        }
    }

    //2진수로 변환하여 출력
    public void printInBinary(int n) {
        if (n<2) {
            System.out.print(n);
        }else {
            printInBinary(n/2); // n을 2로 나눈 몫을 먼저 2진수로 변환하여 출력한 후
            System.out.print(n%2); // n을 2로 나눈 나머지를 인쇄한다.
        }
    }

    // 배열의 합 구하기
    // data[0]에서 data[n-1]까지의 합
    private static int[] data = {1,2,3,4,5,6,7,8,9};
    private int sum(int n, int[] data) {
        if (n<=0) {
            return 0;
        }else {
            return sum(n - 1, data) + data[n - 1];
        }
    }


}
