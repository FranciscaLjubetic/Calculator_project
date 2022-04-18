import calculatorstypes.inversepolish.CalculatorPolish;
import calculatorstypes.regular.CalculatorRegular;
import calculatorstypes.steroids.CalculatorwithSteroids;
import numbertypes.numberclasses.TypedNumber;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try{

            Scanner lScanner = new Scanner(System.in);
            System.out.println("Please select mode: 1-Regular, 2-InversePolish, 3- Listed, 4-Number Type");
            System.out.println("Remember to use coma to write non integer numbers");
            String option  = lScanner.nextLine();

            CalculatorRegular c1 = new CalculatorRegular();
            CalculatorRegular c2 = new CalculatorPolish();
            CalculatorRegular c3 = new CalculatorwithSteroids();
            TypedNumber numToAsk = new TypedNumber();

            switch(option)
            {
                case "1":
                    c1.askOperation();
                    break;

                case "2":
                    c2.askOperation();
                    break;

                case "3":
                    c3.askOperation();
                    break;

                case "4":
                    numToAsk.asknumTypes();
                    break;

                default:
                    System.out.println("You must select a valid option.");
                    break;
            }
            lScanner.close();

        } catch (Exception e){
            System.out.println("Please provide right data and try again");
        }
    }
}

