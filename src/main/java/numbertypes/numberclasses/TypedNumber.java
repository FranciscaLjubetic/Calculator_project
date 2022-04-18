package numbertypes.numberclasses;
import java.util.ArrayList;
import java.util.Scanner;

public class TypedNumber extends Number implements Validator{

    @Override
    public boolean isPalindrome(int num) {
        String numElements = Integer.toString(num);
        if(numElements.length() == 1){
            return false;
        } else {
            for(int i = 0; i < num; i++) {
                char first = numElements.charAt(i);
                char last = numElements.charAt(numElements.length()-1-i);

                if(first != last){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isPrime(int num) {
        if(num == 0 || num == 1 ){
            return false;
        }

        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isFibonacci(int n) {
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        if (n < 0){
            return false;
        }

        if (n == 0 || n==1 || n== 2 ){
            return true;
        }
        else {
            for (int i= 2; i < n+1; i++){
                int fib_i = fib.get(i-1)+ fib.get(i-2);
                fib.add(fib_i);

                if(n == fib.get(i)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printResult() {
        String pal = isPalindrome(this.value) ? "The number " + this.value + " is palindrome, ": "The number " + this.value + " is not palindrome, ";
        String pr = isPrime(this.value) ? "is prime  ": "is not prime ";
        String fib = isFibonacci(this.value) ? "and belongs to Fibonacci.": "and it doesn't belong to Fibonacci.";

        System.out.println(pal + pr + fib);
    }

    public void asknumTypes() {
        Scanner lScanner = new Scanner(System.in);
        System.out.println("Enter a number to get its type:");
        int num = lScanner.nextInt();

        TypedNumber numToAsk = new TypedNumber();

        numToAsk.setNum(num);

        numToAsk.printResult();

        lScanner.close();
    }
}
