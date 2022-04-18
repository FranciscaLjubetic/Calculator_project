package numbertypespolimorfism;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lScanner = new Scanner(System.in);
        System.out.println("Enter a number to get its type:");
        int num = lScanner.nextInt();

        Number primity = new IsPrime();
        Number palindromy = new IsPalindrome();
        Number fibonaccity = new IsFibonacci();

        primity.setNum(num);
        palindromy.setNum(num);
        fibonaccity.setNum(num);

        primity.printResults();
        palindromy.printResults();
        fibonaccity.printResults();

        lScanner.close();
    }
}
