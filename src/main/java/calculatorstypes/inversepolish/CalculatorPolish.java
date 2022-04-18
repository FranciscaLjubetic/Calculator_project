package calculatorstypes.inversepolish;


import calculatorstypes.interfaces.IsValid;
import calculatorstypes.interfaces.PrintResults;
import calculatorstypes.interfaces.ToNumber;
import calculatorstypes.regular.CalculatorRegular;

import java.util.Scanner;
import java.util.Stack;

public class CalculatorPolish extends CalculatorRegular implements ReduceResult, IsValid, ToNumber {

    Double result = 0.0;
    Double Op1 = 0.0;
    Double Op2 = 0.0;
    String Opr = "";
    Scanner lScanner = new Scanner(System.in);;
    Stack<Double> operationSentence = new Stack<Double>();
    String[] splitOperation;
    String data;
    Double op_i;

    @Override
    public void askOperation( ){

        System.out.println("Enter your sentence to calculate ( use + - * or /, and split your numbers by space)");
        data = lScanner.nextLine();
        splitOperation = data.split(" ");

        if (splitOperation.length < 3
                || !isValid(splitOperation[0])
                || !isValid(splitOperation[1])){
            System.out.println("Please provide arguments in the required format. Try again");
            lScanner.close();
        }

        operationSentence.push(toNumber(splitOperation[0]));
        operationSentence.push(toNumber(splitOperation[1]));

        for (String el: splitOperation) {
            Opr = el;
            Op1 = operationSentence.get(operationSentence.size()-1);
            Op2 = operationSentence.get(operationSentence.size()-2);

            if(!el.matches("[\\d.]+|[-+*/]")){
                System.out.println("Please provide arguments in the required format. Try again");
                lScanner.close();
            };

            if(!isValid(el)){
                operAte();
                reduceResult();
            }
            else{op_i = toNumber(Opr);
                operationSentence.push(op_i);
            };
        }
        p.printResults();
        lScanner.close();
    };


    @Override
    public void reduceResult() {
        operationSentence.pop();
        operationSentence.pop();
        operationSentence.push(result);
    }

    @Override
    public boolean isValid(String str) {
        if(str.chars().allMatch(Character::isDigit)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Double toNumber(String str) {
        Double num = Double.valueOf(str);
        return num;
    }

    public void operAte() {

        switch(Opr)
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
