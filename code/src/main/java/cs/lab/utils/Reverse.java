package cs.lab.utils;

public class Reverse {
    public static String reverse(String text){
        StringBuilder textBuffer = new StringBuilder(text);
        return textBuffer.reverse().toString();
    }
}
