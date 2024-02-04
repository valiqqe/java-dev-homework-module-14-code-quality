import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }
}

class TicTacToeGame {
    private static Scanner scan = new Scanner(System.in);
    private char[] box;

    public TicTacToeGame() {
        box = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    }

    public void play() {
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        boolean gameOver = false;

        while (!gameOver) {
            displayBoard();

            if (!boxEmpty) {
                initializeBoard();
                boxEmpty = true;
            }

            if (checkWinner('X')) {
                displayResult("You won the game!");
                gameOver = true;
            } else if (checkWinner('O')) {
                displayResult("You lost the game!");
                gameOver = true;
            } else if (isBoardFull()) {
                displayResult("It's a draw!");
                gameOver = true;
            } else {
                userMove();
                if (!gameOver) {
                    computerMove();
                }
            }
        }
        scan.close();
    }

    private void displayBoard() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private void initializeBoard() {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }

    private boolean checkWinner(char player) {
        return ((box[0] == player && box[1] == player && box[2] == player) || //row
                (box[3] == player && box[4] == player && box[5] == player) || //row
                (box[6] == player && box[7] == player && box[8] == player) || //row
                (box[0] == player && box[3] == player && box[6] == player) || //column
                (box[1] == player && box[4] == player && box[7] == player) || //column
                (box[2] == player && box[5] == player && box[8] == player) || //column
                (box[0] == player && box[4] == player && box[8] == player) || //diagonal
                (box[2] == player && box[4] == player && box[6] == player));  //diagonal
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;
            }
        }
        return true;
    }

    private void userMove() {
        int input;

        while (true) {
            input = scan.nextInt();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private void computerMove() {
        int rand;

        while (true) {
            rand = (int) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private void displayResult(String message) {
        System.out.println(message + "\nCreated by Shreyas Saha. Thanks for playing!");
    }
}