package numbertypes;
import numbertypes.numberclasses.TypedNumber;
import java.util.Scanner;


public abstract class Main {

    public static void main(String[] args) {
        Scanner lScanner = new Scanner(System.in);
        System.out.println("Enter a number to get its type:");
        int num = lScanner.nextInt();

        TypedNumber numToAsk = new TypedNumber();

        numToAsk.setNum(num);

        numToAsk.printResult();

        lScanner.close();
    }
}
