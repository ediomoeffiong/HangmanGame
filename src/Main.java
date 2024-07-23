import java.util.Scanner;

public class Main {
    public static boolean found = false;
    public static boolean won = false;
    public static String playerOne, playerTwo, word, iWord, dWordd, clue;
    public static StringBuilder dWord = new StringBuilder();
    public static int k, playerTwoLives;
    public static int tries = 30;

    public static void main(String[] args) {
        dWord.delete(0, dWord.length());
        won = false;
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
        clue = scanClue.nextLine();

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

        Scanner scanWordOneG = new Scanner(System.in);

        for (int i = 0; i < playerTwoLives; i++) {
            livesChecker(playerTwoLives);

            System.out.println(" ");
            System.out.print(playerTwo + " guess a letter from the word: ");

            char wordOneG = scanWordOneG.next().charAt(0);


            wordChecker(wordOneG);
            found = false;
        }
    }

    public static void wordChecker(char wordOneG) {
        for (int j = 0; j < word.length(); j++) {
            livesChecker(playerTwoLives);
            found = wordOneG == word.charAt(j);
            dWordd = dWord.toString();

            for (int b = 0; b < word.length(); b++) {
                found = wordOneG == word.charAt(b);
                if (found && dWordd.charAt(j) == '_') {
                    dWord.setCharAt(j, wordOneG);
                }
            }

            System.out.print("Word: " + dWord);
            System.out.println("\n");
            winChecker();
/*
            if (j == word.length() - 1) {
                j = 0;
            }*/
        }
        if (!found) {
            playerTwoLives--;
        }

    }

    public static void livesChecker(int lives) {
        System.out.println(playerTwo + " you have " + playerTwoLives + " lives");
        if (lives == 0) {
            System.out.println("Oops! " + playerTwo + " you lose, its Game over!!");
            playAgain();
        }
    }

    public static void playAgain() {
        System.out.print("\n\nDo you want to play again (Y/N): ");
        Scanner playAgainS = new Scanner(System.in);
        String playAgain = playAgainS.nextLine();

        if (playAgain.equals("Y") || playAgain.equals("y")) {
            System.out.println("\n\n\n\n\n\n\n");
            String[] call = {"call"};
            main(call);
        } else if (playAgain.equals("N") || playAgain.equals("n")) {
            System.out.println("\n\nGoodbye!");
            System.exit(0);
        } else {
            System.out.println("\nInvalid input!");
            playAgain();
        }
    }

    public static void winChecker() {
        String win = dWord.toString();
        if (win.equals(word)) {
            won = true;
            System.out.println(playerTwo + " won. The word is \"" + word + "\".");

            playAgain();
        }
    }
}