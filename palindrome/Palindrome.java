public class Palindrome {
    StringBuffer string = new StringBuffer();
    StringBuffer temp = new StringBuffer();
    static Boolean isPalindrome;
    public void Main(String str){
        string = new StringBuffer(); //necessary to reset because .append will keep adding inputs without reset
        temp = new StringBuffer();
        str.replace(" ", "");
        string.append(str);
        //temporary stringbuffer to hold input string because .reverse will change contents of stringBuffer that it is called on
        //, breaking the code
        temp.append(str);
        checkIfPalindrome();
    }

    private void checkIfPalindrome(){

        StringBuffer reverse = new StringBuffer(temp.reverse());
        // System.out.println(string.toString().equals(reverse.toString()));
        //.equals() compares references, so to compare values use toString
        if (string.toString().equals(reverse.toString())){
            isPalindrome = true;
            // System.out.print(string.reverse());
            // System.out.println("Palindrome");
        }
        else{
            isPalindrome = false;
            // System.out.println("Not a Palindrome");
        }
    }

    public String returnResult(){
        String result;
        if (isPalindrome) result = "Palindrome";
        else{
            result = "Not a palindrome";
            System.out.println("Not a Palindrome");
        }
        return result;
    }
}
