/**Board class that will be used to track the different states */
public class Board {
    /**2D char array that is modified during the game */
    private char[][] board = { { ' ', ' ', ' ' },
                                { ' ', ' ', ' ' },
                                { ' ', ' ', ' ' }};

    /**
     * Method that will be used to update the board
     * checks to see if the location is valid within the board
     * and checks to see if spot is empty
     * @param token to be placed on board
     * @param row of token location
     * @param col of token location
     * @return boolean value on if token was successfully placed
     */
    public boolean placeToken(char token, int row, int col){
        if ((row < 0 || row > 2) || (col < 0 || col > 2)) // checking to see if the row and col are out of bounds
            return false;
        if (board[row][col] != ' ') // Checking to see if board location is not empty
            return false;
        board[row][col] = token; //placing token
        return true;
    }

    /**
     * Method to be used to display the board to the user.
     */
    public void display(){
        System.out.println("  0 1 2");
        for (int i = 0; i < board.length; i++){
            System.out.print(i + " ");
            for (int j = 0; j < board.length; j++){
                if (j == 2)
                    System.out.print(board[i][j]);
                else
                    System.out.print(board[i][j] + "|");
            }
            System.out.println();
            if (i == 0 || i == 1){
                System.out.println("  -----");
            }
        }
    }

    /**
     * Method to be used to save the current state of the board using Memento
     * object
     * @return Memento object of the saved state of the Board object
     */
    public Memento save() {
        return new Memento(this.board);
    }

    /**
     * Method to restore the Board to state of the 
     * passed in Memento object
     * @param m Memento object
     */
    public void restore(Memento m) {
        this.board = m.getState();
    }
}
