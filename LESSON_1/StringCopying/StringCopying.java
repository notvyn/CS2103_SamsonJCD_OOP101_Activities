package Lesson_1.StringCopying;
class StringCopying {
    public static void main(String[] args) {
        String str1 = "Mademoiselle";
        String str2 = str1.substring(0);

        System.out.println("Original String: " +str1);
        System.out.println("Copied String: " +str2);
    }
}