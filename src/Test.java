public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        int input = 10;
        System.out.println(test.recursive(input));
    }

    private int recursive(int n) {
        if(n == 0 ){
            return 1;
        }else{
            return 2 * recursive(n-1);
        }

    }
}



