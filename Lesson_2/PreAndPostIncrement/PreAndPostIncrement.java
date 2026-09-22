package Lesson_2.PreAndPostIncrement;
class PreAndPostIncrement {
    public static void main(String[] args) {
        int x = 5;
        int y = x++ + ++x;
        // 5 + 1 = 6 (x)
        // +
        // 6 + 1 = 7 (x)
        // 5 + 7 = 12

        // 5++1 (6) + 1++6
        // 5 + 7
        // 12

        System.out.println(y);
    }
}