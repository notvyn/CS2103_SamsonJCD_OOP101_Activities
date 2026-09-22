import java.util.Scanner;

public class PascalTriangleExplanation {

    // Global scanner to avoid closing System.in multiple times
    private static Scanner sc = new Scanner(System.in);

    public static void displayText(String text, int time) {
        System.out.println();
        drawBorder(); // First Border

        typeWord(text, time);

        drawBorder(); // Ending Border
        System.out.println();
    }

    public static void typeWord(String word, int time) {
        try {
            for (int i = 0; i < word.length(); i++) {
                System.out.print(word.charAt(i));
                Thread.sleep(time);
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void drawBorder() {
        for (int i = 0; i < 100; i++ ) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static boolean isResponseValid(char response) {
        return response == 'Y' || response == 'N';
    }

    public static char getResponse() {
        char response;
        
        do {
            response = Character.toUpperCase(sc.next().charAt(0));
            sc.nextLine();
            
            if (!isResponseValid(response)) {
                System.out.println("Invalid input. Please enter Y or N:");
            }

        } while (!isResponseValid(response)); // Loops WHILE invalid

        return response;
    }

    public static void nextDialogue(char response, String yesMessage, String noMessage) {
        if (response == 'Y') {
            displayText(yesMessage, 20);
        } else if (response == 'N') {
            typeWord(noMessage, 20);
        }
    }

    public static void pressEnterToContinue() {
        System.out.printf("\n[Press ENTER]");
        sc.nextLine();
    }

    // MAIN CODE FOR PASCAL TRIANGLE
    public static void drawPascalTriangle() {
        // System.out.print("Enter number of rows: ");
        // int rows = sc.nextInt();
        int rows = 5;

        for (int i = 0; i < rows; i++) {

            int number = 1;

            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", number);
                number = number * (i - j) / (j + 1);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        displayText("HELLO THERE!", 20);

        typeWord("HAVE YOU EVER WONDERED HOW PASCAL TRIANGLE WORKS? (Y/N)", 0);
        
        char response1 = getResponse();

        if (response1 == 'Y') {
            typeWord("DO YOU WANT TO KNOW? (Y/N)", 20);
        } else  if (response1 == 'N') {
            typeWord("", 20);
            return;
        }

        char response2 = getResponse();

        if (response2 == 'Y') {
            displayText("LET'S DISCUSS IT, SHALL WE!", 20);
            typeWord("PASCAL'S TRIANGLE LOOKS LIKE THIS:", 20);
            drawPascalTriangle();
            pressEnterToContinue();
        } else if (response2 == 'N') {
            typeWord("SEE YOU NEXT TIME I GUESS! ;P", 20);
        }

        typeWord("SO... HOW DOES IT WORK?", 20);
        System.out.println();
        typeWord("WELL, IT'S ACTUALLY PRETTY SIMPLE.", 20);
        System.out.println();

        typeWord("EVERY NUMBER IN THE MIDDLE", 20);
        typeWord("COMES FROM ADDING THE TWO NUMBERS ABOVE IT.", 20);

        System.out.printf(
            "\n" + //
            "        3       3\n" + //
            "         \\     /\n" + //
            "           6\n" + //
            "\n" + //
            "3 + 3 = 6\n"
        );

        pressEnterToContinue();

        typeWord("BUT THERE'S ALSO A MATHEMATICAL WAY", 20);
        typeWord("TO CALCULATE THESE NUMBERS...", 20);
        
        sc.close(); // Close scanner safely at the very end of the program
    }
}
