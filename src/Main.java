import java.util.Scanner;

public class Main {
    public static boolean found = false;
    public static String playerOne, playerTwo, word, iWord;
    public static StringBuilder dWord = new StringBuilder();
    public static int k, playerTwoLives;

    public static void main(String[] args) {
        System.out.println("-------------Hangman Game-------------\n");

        System.out.print("Input player 1 name: ");
        Scanner scanName1 = new Scanner(System.in);
        playerOne = scanName1.nextLine();

        System.out.print("Input player 2 name: ");
        Scanner scanName2 = new Scanner(System.in);
        playerTwo = scanName2.nextLine();

        System.out.println("\n");

        System.out.print(playerOne + " input a word on the screen but don't let " + playerTwo + " see it: ");
        Scanner scanWord1 = new Scanner(System.in);
        iWord = scanWord1.nextLine();
        word = iWord.toLowerCase();

        playerTwoLives = word.length() + 1;

        System.out.println("\nNow, input a clue to the word so " + playerTwo + " can guess it.");
        System.out.print("Clue: ");
        Scanner scanClue = new Scanner(System.in);
        String clue = scanClue.nextLine();

        System.out.println("\n\n\n\n\n\n" + playerTwo + ", the clue is " + clue);

        k = 0;


        System.out.print("Word: ");
        while (k < word.length()) {
            dWord.append("_");
            k++;
        }
        k = 0;
        System.out.println(dWord);
        System.out.println(" ");

        for (int i = 0; i < playerTwoLives; i++) {
            System.out.println(playerTwo + " you have " + playerTwoLives + " lives");

            System.out.println(" ");
            System.out.print(playerTwo + " guess a letter from the word: ");
            Scanner scanWordOneG = new Scanner(System.in);
            char wordOneG = scanWordOneG.next().charAt(0);

            wordChecker(wordOneG);
            found = false;
            livesChecker(playerTwoLives);
        }
    }

    public static void wordChecker(char wordOneG) {
        for (int j = 0; j < word.length(); j++) {
            found = wordOneG == word.charAt(j);
            if (found) {
                dWord.setCharAt(j, wordOneG);
                System.out.print("Word: " + dWord);
                System.out.println("\n");
                break;
            }
        }
        if (!found) {
            playerTwoLives--;
        }
    }

    public static void livesChecker(int lives) {
        if (lives == 0) {
            System.out.println("Oops! " + playerTwo + " you lose, its Game over!!");
            playAgain();
        } else {
            System.out.print("");
        }
    }

    public static void playAgain() {
        System.out.println("Do you want to play again (Y/N): ");
        String[] call = {"call"};
        main(call);
    }
}