package Lesson_1.TypeCasting;
class TypeCasting {
    public static void main(String[] args) {
        char ch = 'f'; // character 'f'
        int asciiValue = (int) ch;
        // explicitly casting char to int to get ASCII value

        System.out.println("Character: " + ch);
        System.out.println("ASCII Value: " + asciiValue);

        // casting from int (ASCII value) back to char
        int anotherAsciiValue = 106;
        char anotherChar = (char) anotherAsciiValue;
        // explicitly casting int to char
    }
}