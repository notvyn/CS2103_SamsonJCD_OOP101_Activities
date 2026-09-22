package Lesson_1.StringComparison;
class StringComparison {
    public static void main(String[] args) {
        String str1 = "strawberry";
        String str2 = "strawberry"; 
        // String str2 = "strawberries"; 

        // content comparison
        boolean isEqual = str1.equals(str2);

        // Lexicographic comparison
        int result = str1.compareTo(str2);

        System.out.println("Content Comparison: " + isEqual);
        System.out.println("Lexicographic Comparison: " + result);
    }
}