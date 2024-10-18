import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private char[][] board = new char[ROWS][COLS];
    private char currentPlayer = PLAYER1;
    
    public ConnectFour() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean dropDisc(int col) {
        if (col < 0 || col >= COLS || board[0][col] != EMPTY) {
            return false;
        }

        int row = ROWS - 1;
        while (row >= 0 && board[row][col] != EMPTY) {
            row--;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        return checkLines();
    }

    private boolean checkLines() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (checkDirection(r, c, 1, 0) || 
                    checkDirection(r, c, 0, 1) || 
                    checkDirection(r, c, 1, 1) || 
                    checkDirection(r, c, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int rowDir, int colDir) {
        char start = board[row][col];
        if (start == EMPTY) return false;

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;
            if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != start) {
                return false;
            }
            count++;
        }
        return count == 4;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConnectFour game = new ConnectFour();
        boolean gameWon = false;

        while (!gameWon) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", enter column (0-6): ");
            int column = scanner.nextInt();

            if (game.dropDisc(column)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    gameWon = true;
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}
