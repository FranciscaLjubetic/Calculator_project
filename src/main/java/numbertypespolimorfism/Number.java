package numbertypespolimorfism;

public abstract class Number implements PrintResults, Validator {
    protected int value;

    public void setNum(int num){
        this.value = num;
    };

    public abstract void printResults();

    public abstract boolean isValid();
}
