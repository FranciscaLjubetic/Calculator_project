package numbertypespolimorfism;

public class IsPalindrome extends Number{

    @Override
    public boolean isValid() {
        String numElements = Integer.toString(this.value);
        if(numElements.length() == 1){
            return false;
        } else {
            for(int i = 0; i < this.value; i++) {
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
    public void printResults() {
        String pl = isValid() ? "is palindrome,": "is not palindrome,";
        System.out.println(pl);
    }
}
