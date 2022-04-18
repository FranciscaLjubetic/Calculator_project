package calculatorstypes.steroids;

import calculatorstypes.interfaces.IsValid;
import calculatorstypes.interfaces.PrintResults;
import calculatorstypes.interfaces.ToNumber;
import calculatorstypes.regular.CalculatorRegular;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorwithSteroids extends CalculatorRegular {
    Double result = 0.0;
    Double Op1 = 0.0;
    Double Op2 = 0.0;
    String Opr = "";
    ArrayList<Double> Number1 = new ArrayList<>();
    ArrayList<Double> Number2 = new ArrayList<>();
    ArrayList<Double> Result = new ArrayList<>();

    public void askOperation( ){
        Scanner lScanner = new Scanner(System.in);
        System.out.println("Enter the first list of numbers splitted by space:");
        String data1 = lScanner.nextLine();
        System.out.println("Enter the second list of numbers splitted by space:");
        String data2 = lScanner.nextLine();
        System.out.println("Enter the operator using '+', '-', '*' or '/':");
        String operator = lScanner.nextLine();

        String[] Number1Array = data1.split(" ");
        String[] Number2Array = data2.split(" ");

        if(data1.isEmpty() || data2.isEmpty() || operator.isEmpty()){
            System.out.println("You should provide complete information.");
            lScanner.close();
            return;
        }

        int queueLen = Math.max(Number2Array.length, Number1Array.length);

        for (String el: Number1Array) {
            if (!v.isValid(el)){
                System.out.println("You should provide only numbers splitted by spaces in the first and second line.");
                lScanner.close();
                return;
            }
        }

        for (String el: Number2Array){
            if(!v.isValid(el)){
                System.out.println("You should provide only numbers splitted by spaces in the first and second line.");
                lScanner.close();
                return;
            }
        }

        if(!operator.matches("[-+*/]")) {
            System.out.println("The operator can only be +, -, * or /");
            lScanner.close();
            return;
        }

        for (String s : Number1Array) {
            Number1.add(t.toNumber(s));
        }

        for (String s : Number2Array) {
            Number2.add(t.toNumber(s));
        }

        if(Number2Array.length < queueLen){
            for (int rell = 0; rell < queueLen-Number2Array.length; rell++ ){
                Number2.add((double) 0);
            }
        }

        if (Number1Array.length < queueLen){
            for (int rell = 0; rell < queueLen-Number1Array.length; rell++ ){
                Number1.add((double) 0);
            }
        }

        for (int z=0; z < queueLen; z++ ){
            Op1 = Number2.get(z);
            Op2 = Number1.get(z);
            Opr = operator;
            operAte();
            Result.add(result);
        }

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
        }
    }

    ToNumber t = Double::valueOf;

    IsValid v = (str) -> str.chars().allMatch(Character::isDigit);

    PrintResults p = () -> {
        String Chain = Result.toString();
        String subfinalChain = Chain.substring( 1, Chain.length() - 1 );
        String finalChain = subfinalChain.replace( ",", " ");
        System.out.println(finalChain);
    };
}
