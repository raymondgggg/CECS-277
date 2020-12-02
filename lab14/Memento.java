/**Memento class for the Board object */
public class Memento {
    /**Char array to represent the tic tac toe game */
    private char[][] board = {  { ' ', ' ', ' ' },
                                { ' ', ' ', ' ' },
                                { ' ', ' ', ' ' } };

    /**
     * Constructor - takes in the 2d array for the board and 
     * initializes the board instance variable
     * @param b char 2d array for the board
     */
    public Memento(char[][] b) {
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b.length; j++){
                this.board[i][j] = b[i][j];
            }
        }
    }

    /**
     * Method to get the state of the board 
     * @return the 2d char array representing the board
     */
    public char[][] getState() {
        return this.board;
    }
}
