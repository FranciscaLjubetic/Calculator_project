package calculatorstypes.inversepolish;


import calculatorstypes.interfaces.IsValid;
import calculatorstypes.interfaces.PrintResults;
import calculatorstypes.interfaces.ToNumber;
import calculatorstypes.regular.CalculatorRegular;

import java.util.Scanner;
import java.util.Stack;

public class CalculatorPolish extends CalculatorRegular {

    Double result = 0.0;
    Double Op1 = 0.0;
    Double Op2 = 0.0;
    String Opr = "";
    Scanner lScanner = new Scanner(System.in);
    Stack<Double> operationSentence = new Stack<>();
    String[] splitOperation;
    String data;
    Double op_i;

    @Override
    public void askOperation( ){

        System.out.println("Enter your sentence to calculate ( use + - * or /, and split your numbers by space)");
        data = lScanner.nextLine();
        splitOperation = data.split(" ");

        if (splitOperation.length < 3
                || !v.isValid(splitOperation[0])
                || !v.isValid(splitOperation[1])){
            System.out.println("You should enter processable sentences.");
            lScanner.close();
        }

        operationSentence.push(t.toNumber(splitOperation[0]));
        operationSentence.push(t.toNumber(splitOperation[1]));

        for (String el: splitOperation) {
            Opr = el;
            Op1 = operationSentence.get(operationSentence.size()-1);
            Op2 = operationSentence.get(operationSentence.size()-2);

            if(!el.matches("[\\d.]+|[-+*/]")){
                System.out.println("You should provide numbers or operators.");
                lScanner.close();
            }

            if(!v.isValid(el)){
                operAte();
                r.reduceResult();
            }
            else{op_i = t.toNumber(Opr);
                operationSentence.push(op_i);
            }
        }
        p.printResults();
        lScanner.close();
    }


    ReduceResult r = () -> {
        operationSentence.pop();
        operationSentence.pop();
        operationSentence.push(result);
    };

    @Override
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
        }
    }

    ToNumber t = Double::valueOf;

    IsValid v = (str) -> str.chars().allMatch(Character::isDigit);

    PrintResults p = () -> System.out.println(result);
}
