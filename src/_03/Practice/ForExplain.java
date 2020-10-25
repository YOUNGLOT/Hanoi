package _03.Practice;

public class ForExplain extends UseRecursive{
    public ForExplain(int input) {
        super(input);
    }

    public static void main(String[] args) {
        ForExplain test = new ForExplain(3);
        test.solve();
    }

    @Override
    protected void solve(){
        String[][] resultArray = new String[RESULT_ARRAY_SIZE][RESULT_ARRAY_SIZE];

        resultArray = replaceAllValue(resultArray, "x");
        eraseLogic(resultArray, 0);
        printArray(resultArray);

        System.out.println();

        resultArray = replaceAllValue(resultArray, "x");
        eraseLogic(resultArray, 1);
        printArray(resultArray);

        System.out.println();

        resultArray = replaceAllValue(resultArray, "x");
        eraseLogic(resultArray, 2);
        printArray(resultArray);

    }




}
