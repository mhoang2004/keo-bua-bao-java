import java.util.Random;
import java.util.Scanner;

public class Game {
    final static int SIZE = 6;

    public static void main(String[] args) {
        String[][] board = createBoard();
        printBoard(board);

        clearScreen(30000);

        System.out.print("Are you ready? ");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        String[][] askBoard = new String[SIZE][SIZE];
        int x, y, score = 0;
        while (score < 10) {
            // reset ask board
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    askBoard[j][k] = "   ";
                }
            }

            // create question
            Random rand = new Random();
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
            askBoard[x][y] = "???";

            // print Board, Scores
            printBoard(askBoard);
            System.out.println("Score: " + score);

            // ask user their answer;
            System.out.print("Your answer: ");
            String userAns = scanner.next();

            System.out.println("Answer: " + board[x][y]);
            Boolean res = checkAns(userAns, board[x][y]);
            if (res) {
                score++;
                System.out.println("Congratulation!!");

                clearScreen(2000);
            } else {
                System.out.println("You Lost!");
                System.exit(0);
            }
        }
        System.out.println("You Win!");
    }

    static Boolean checkAns(String userAns, String ans) {
        userAns = userAns.toLowerCase();
        ans = ans.toLowerCase();

        if (ans.equals("bao")) {
            if (userAns.equals("keo")) {
                return true;
            }
        } else if (ans.equals("keo")) {
            if (userAns.equals("bua")) {
                return true;
            }
        } else {
            if (userAns.equals("bao")) {
                return true;
            }
        }
        return false;
    }

    static void shuffleArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            Random rand = new Random();
            int index = rand.nextInt(SIZE * SIZE);

            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static String[][] createBoard() {
        // 0: keo, 1: bua, 2: bao
        int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2 };

        int[][] board = new int[SIZE][SIZE];
        String[][] realBoard = new String[SIZE][SIZE];

        shuffleArray(nums);

        int i = 0;
        for (int[] a : board)
            for (int j = 0; j < SIZE; j++)
                a[j] = nums[i++];

        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                if (board[j][k] == 1)
                    realBoard[j][k] = "keo";
                else if (board[j][k] == 2)
                    realBoard[j][k] = "bua";
                else
                    realBoard[j][k] = "bao";
            }
        }

        return realBoard;
    }

    static void printBoard(String[][] ar) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("|  " + ar[i][j] + " ");
            }
            System.out.println();
            System.out.println("-------------------------------------------");

        }
    }

    private static void clearScreen(int delay) {
        try {
            Thread.sleep(delay); // 30 seconds in milliseconds
            // Check the operating system
            String os = System.getProperty("os.name").toLowerCase();

            // Execute the appropriate command to clear the screen based on the operating
            // system
            if (os.contains("win")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix-like systems (Linux, macOS)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle exceptions if any
            e.printStackTrace();
        }
    }
}
