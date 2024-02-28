public class Board {
    /* A class representation of a TicTacToe board.
    The board is a 9 element array. The constructor (provided)
    initializes these values to the strings "1", "2", ... "9".
    When a player makes a move on the board, that element in the
    array should be replaced by "X" or "O" respectively.
    https://en.wikipedia.org/wiki/Tic-tac-toe

    Complete the isEmptyPosition(pos), displayBoard(), winner(),
    and applyMove(move) methods.
    */
    public String[] board = new String[9];

    /**
     * The board is initialized to hold strings containing numbers
     * ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
     */
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    /**
     * // TODO: Return if the desired position has not been filled yet.
     *
     * @param pos the desired position 1-9
     * @return true if an X or O has already been placed at the position,
     * or false a number is at the position.
     */

    public boolean isEmptyPosition(int pos) {
            if (board[pos - 1].equals("X") || board[pos - 1].equals("O")) {
                return false;
            }
            return true;
    }

    /**
     * TODO: Display the current board in the console.
     */
    public void displayBoard() {
        /* An example of what an in progress game may look like:
        |---|---|---|
        | 1 | X | O |
        |-----------|
        | 4 | 5 | X |
        |-----------|
        | 7 | 8 | O |
        |---|---|---|
         */
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }

    /**
     * TODO: Return the winner of the game or null.
     *
     * @return "X" or "O" if a respective player has achieved 3 in a row,
     * "draw" if the board is full and no player won,
     * or null if there is no winner.
     */
    public String winner() {
        if(horWinner() != null){
            return horWinner();
        }
        if(verWinner() != null){
            return verWinner();
        }
        if(diagWinner() != null){
            return diagWinner();
        }
        return isFull();
    }
    public String horWinner() {
        if(board[0].equals(board[1]) && board[2].equals(board[0])) {
            return board[0];
        }
        if(board[3].equals(board[4]) && board[5].equals(board[3])) {
            return board[3];
        }
        if(board[6].equals(board[7]) && board[8].equals(board[6])) {
            return board[6];
        }
        return null;
    }

    public String verWinner() {
        if(board[0].equals(board[3]) && board[6].equals(board[0])) {
            return board[0];
        }
        if(board[1].equals(board[4]) && board[7].equals(board[1])) {
            return board[1];
        }
        if(board[2].equals(board[5]) && board[8].equals(board[2])) {
            return board[2];
        }
        return null;
    }

    public String diagWinner() {
        if(board[0].equals(board[4]) && board[8].equals(board[0])) {
            return board[0];
        }
        if(board[2].equals(board[4]) && board[6].equals(board[2])) {
            return board[2];
        }
        return null;
    }

    public String isFull() {
        for (int a = 0; a < 9; a++) {
         if(isEmptyPosition(a+1) == true) {
             return null;
         }
        }
        return "draw";
    }




    /**
     * TODO: Apply a given move to the board.
     *
     * @param move contains the player's symbol (move.player.symbol)
     *             and the location they'd like to place it (move.pos).
     */
    public void applyMove(Move move) {
     board[move.pos - 1] = move.player.symbol;

    }
}
