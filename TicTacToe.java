import java.util.Scanner;
/**
 * A simple game of Tic Tac Toe.
 * 
 * @author Mackenzie Bloswick
 * @version 3/22/2017
 */
public class TicTacToe
{
   private Piece[][] board;
   private int playerTurn = 1;
   private Piece currentPiece = Piece.X;
   private Piece winner;


    public TicTacToe()
    {
        board = new Piece[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }
    
    public void printBoard()
    {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                if (board[i][j] == Piece.EMPTY) {
                    System.out.print(" ");
                }else {
                    System.out.print(board[i][j]);
                }
                if (j == 2) {
                    System.out.print("|");
                }
            }
        }
    }
    
    public void takeTurn(int slot) {        
        if (slot == 1 && board[0][0] == Piece.EMPTY) {
            board[0][0] = currentPiece;
            changeTurn();
        }else if (slot == 2 && board[0][1] == Piece.EMPTY) {
            board[0][1] = currentPiece;
            changeTurn();
        }else if (slot == 3 && board[0][2] == Piece.EMPTY) {
            board[0][2] = currentPiece;
            changeTurn();
        }else if (slot == 4 && board[1][0] == Piece.EMPTY) {
            board[1][0] = currentPiece;
            changeTurn();
        }else if (slot == 5 && board[1][1] == Piece.EMPTY) {
            board[1][1] = currentPiece;
            changeTurn();
        }else if (slot == 6 && board[1][2] == Piece.EMPTY) {
            board[1][2] = currentPiece;
            changeTurn();
        }else if (slot == 7 && board[2][0] == Piece.EMPTY) {
            board[2][0] = currentPiece;
            changeTurn();
        }else if (slot == 8 && board[2][1] == Piece.EMPTY) {
            board[2][1] = currentPiece;
            changeTurn();
        }else if (slot == 9 && board[2][2] == Piece.EMPTY) {
            board[2][2] = currentPiece;
            changeTurn();
        }else {
            System.out.println("That space is taken.");
        }
    }
    
    public void changeTurn() {
        if (playerTurn == 1) {
            playerTurn = 2;
        }else if (playerTurn == 2) {
            playerTurn = 1;
        }
        if (playerTurn == 1) {
            currentPiece = Piece.X;
        }else {
            currentPiece = Piece.O;
        }
    }
    
    public void displayEndGame() {
        if (winner == Piece.X) {
            System.out.println("\nPlayer 1 is the winner! Congratulations!");
        }else if (winner == Piece.O) {
            System.out.println("\nPlayer 2 is the winner! Congratulations!");
        }else if (winner == Piece.EMPTY) {
            System.out.println("\nCats game! You both lose!");
        }else {
            System.out.println("\nThe game is not over yet. Please keep playing."); //This should never happen.
        }
    }
    
    public void winState() {
        if (board[0][0] != Piece.EMPTY && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            winner = board[0][0];
        }else if (board[1][0] != Piece.EMPTY && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            winner = board[1][0];
        }else if (board[2][0] != Piece.EMPTY && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            winner = board[2][0];
        }else if (board[0][0] != Piece.EMPTY && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            winner = board[0][0];
        }else if (board[0][1] != Piece.EMPTY && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            winner = board[0][1];
        }else if (board[0][2] != Piece.EMPTY && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            winner = board[1][0];
        }else if (board[0][0] != Piece.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0];
        }else if (board[2][0] != Piece.EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            winner = board[2][0];
        }else if (board[0][0] != Piece.EMPTY && board[0][1] != Piece.EMPTY && board[0][2] != Piece.EMPTY
            && board[1][0] != Piece.EMPTY && board[1][1] != Piece.EMPTY && board[1][2] != Piece.EMPTY
            && board[2][0] != Piece.EMPTY && board[2][1] != Piece.EMPTY && board[2][2] != Piece.EMPTY) {
                winner = Piece.EMPTY;
        }
    }
    
    public void playGame() {
        Scanner scan = new Scanner(System.in);
        printBoard();
        while (winner == null) {
            System.out.println ("\nPlayer " + playerTurn + ", please enter where you would like to move.");
            int move = scan.nextInt();
            if (move > 0 && move < 10) {
                takeTurn(move);
                winState();
                printBoard();
            }
        }
        displayEndGame();
    }
}
