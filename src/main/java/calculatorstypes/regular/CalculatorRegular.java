package calculatorstypes.regular;

import calculatorstypes.interfaces.PrintResults;

import java.util.Scanner;

public class CalculatorRegular {
    String Opr;
    double Op1;
    double Op2;
    static Double result = 0.0;
    Scanner lScanner = new Scanner(System.in);

    public void askOperation( ){

       System.out.println("Enter the operation line by line. Use + - * or / and two numbers to calculate:");

       Opr = this.lScanner.nextLine();
       Op1 = this.lScanner.nextDouble();
       Op2 = this.lScanner.nextDouble();

       operAte();

       p.printResults();

   }

    public void operAte() {

        switch(this.Opr)
        {
            case "+":
                result = Op2 + Op1;
                break;

            case "-":
                result = Op2 - Op1;
                break;

            case "*":
                result = Op2 * Op1;
                break;

            case "/":
                if(Op1==0) {
                    System.out.println("Cannot be divided by zero");
                }
                else {
                    result =  Op2 / Op1;
                }
                break;
            default:
                System.out.println("wrong sign, try again");
                break;
        }
    }

    PrintResults p = () -> System.out.println(result);


}
