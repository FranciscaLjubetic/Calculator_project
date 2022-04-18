package numbertypespolimorfism;

public class IsPrime extends Number{

    @Override
    public boolean isValid(){
        if(this.value == 0 || this.value == 1 ){
            return false;
        }

        for(int i = 2; i < this.value; i++) {
            if (this.value % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void printResults() {
        String pl = isValid() ? "The number " + this.value + " is prime,": "The number " + this.value + " is not prime,";
        System.out.println(pl);
    }
}
