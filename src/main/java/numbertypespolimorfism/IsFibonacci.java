package numbertypespolimorfism;

import java.util.ArrayList;

public class IsFibonacci extends Number{

    @Override
    public boolean isValid() {
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        if (this.value < 0){
            return false;
        }

        if (this.value == 0 || this.value==1 || this.value== 2 ){
            return true;
        }
        else {
            for (int i= 2; i < this.value+1; i++){
                int fib_i = fib.get(i-1)+ fib.get(i-2);
                fib.add(fib_i);

                if(this.value == fib.get(i)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printResults() {
        String fib = isValid() ? "and it belongs to Fibonacci.": "and it doesn't belong to Fibonacci.";
        System.out.println(fib);
    }
}
