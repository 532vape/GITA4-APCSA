public class Bob {
    private StringBuffer text = new StringBuffer();
    public void Main(String input){
        text.delete(0, text.length()); //reset StringBuffer
        text.append(input);
        if (input.toLowerCase().contains("bob")){
            int start = input.indexOf("bob");
            int end = start + 3; //length of "bob"
            text.delete(start, end);
            text.append("bob");
        }
    }

    public StringBuffer returntext(){
        return text;
    }
}
