/**
 * @ClassName Board
 * @Description It is the abstract class for the game's board
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public abstract class Board {
    /**
     * the size of the board
     */
    protected int boardSize;

    /**
     * the 2-dimensional board
     */
    protected Cell[][] board;

    // constructor
    public Board(int boardSize){
        this.boardSize = boardSize;
        this.boardInit(boardSize);
    }

    // get the size of the board
    public int getBoardSize() {return boardSize;}

    // set the size of the board
    public void setBoardSize(int boardSize){
        this.boardSize = boardSize;
    }

    // get the 2-dimensional board
    public Cell[][] getBoard(){
        return this.board;
    }

    // Board initialization. Set each cell to an empty char ' '.
    public void boardInit(int boardSize){
        this.board = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = new Cell(' ',' ');
            }
        }
    }
}

