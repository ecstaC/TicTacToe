import java.util.*;
public class tictactoe{

//Defining the Board 
    char[][] board = {
    {' ', ' ', ' '},
    {' ', ' ', ' '},
    {' ', ' ', ' '}
    
    };

//Displaying the board
    public static void displayBoard(char[][] board) {
    for (int i = 0; i < 3; i++) {
        System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
        if (i < 2) System.out.println("---|---|---");
    }
}


//Player input
public static void playerMove(char[][] board, char player) {
    Scanner scanner = new Scanner(System.in);
    int row, col;

    while (true) {
        System.out.println("Player " + player + ", enter your move (row and column): ");
        row = scanner.nextInt();
        col = scanner.nextInt();

        // Check if the move is valid
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = player; // Update the board
            break; // Exit the loop
        } else {
            System.out.println("This move is not valid.");
        }
    }
}

//Check for win or lose

public static boolean checkWin(char[][] board, char player) {
    // Check rows, columns, and diagonals
    for (int i = 0; i < 3; i++) {
        if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Rows
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Columns
            return true;
        }
    }
    return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Diagonal \
           (board[0][2] == player && board[1][1] == player && board[2][0] == player); // Diagonal /
}

public static boolean checkDraw(char[][] board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == ' ') return false; // Empty space found
        }
    }
    return true; // No empty spaces, so it's a draw
}


// Mian Class
public static void main(String[] args) {
    char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    char currentPlayer = 'X';

    while (true) {
        displayBoard(board);
        playerMove(board, currentPlayer);

        if (checkWin(board, currentPlayer)) {
            displayBoard(board);
            System.out.println("Player " + currentPlayer + " wins!");
            break;
        }
        
        if (checkDraw(board)) {
            displayBoard(board);
            System.out.println("The game is a draw!");
            break;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
    }
}

}