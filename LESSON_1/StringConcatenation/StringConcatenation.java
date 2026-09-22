package Lesson_1.StringConcatenation;
import java.util.*;

class StringConcatenation {
    public static void main(String[] args) {
        String str1 = "Bonjour", str2 = "Mademoiselle";
        // Using the + operator
        String result1 = str1 + " " + str2;
        // Using the concat method
        String result2 = str1.concat(" ").concat(str2);

        System.out.println("Using the + operator: " + result1);
        System.out.println("Using the concat method: " + result2);
    }
}