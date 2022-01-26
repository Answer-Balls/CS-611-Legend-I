import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @ClassName World
 * @Description It is the class for the world of the game
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class World extends Board{

    // the probability of the inaccessible area is 0.2
    private static double XProb = 0.2;

    // the probability of the market area is 0.3
    private static double MProb = 0.3;

    private Random random = new Random();

    /**
     * The x-coordinate of the team's current location
     */
    private int xlabel;
    /**
     * The y-coordinate of the team's current location
     */
    private int ylabel;

    public int getXlabel() {return xlabel;}

    public int getYlabel() {return ylabel;}

    public void setXlabel(int xlabel){this.xlabel = xlabel;}

    public void setYlabel(int ylabel) {this.ylabel = ylabel;}

    public World(int boardSize) {
        super(boardSize);
    }


    // Initialize the world of the game
    public void worldInit(){
        setMarket();
        setBlock();
        while(true){
            int i = random.nextInt(boardSize);
            int j = random.nextInt(boardSize);
            if (board[i][j].getContent() == ' '){
                // Initialize the position of heros
                board[i][j].setContent('T');
                System.out.println("Your team is at: " + "(" + i + "," + j + ")" );
                setXlabel(i);
                setYlabel(j);
                break;
            }
        }
    }

    // Initialize the distribution of market
    public void setMarket(){
        int m = (int) (boardSize*boardSize*MProb);
        int counter = 0;
        while(true){
            int i = random.nextInt(boardSize*boardSize);
            if (board[i / boardSize][(i%boardSize)].getType() != 'M' && counter < m){
                board[i / boardSize][(i%boardSize)].setContent('M');
                board[i / boardSize][(i%boardSize)].setType('M');
                counter += 1;
            }
            if (counter == m){
                break;
            }
        }
    }

    // Initialize the distribution of Inaccessible area
    public void setBlock(){
        int n = (int) (boardSize*boardSize*XProb);
        int counter = 0;
        while(true){
            int i = random.nextInt(boardSize*boardSize);
            if (board[i / boardSize][(i%boardSize)].getType() != 'X' && counter < n){
                board[i / boardSize][(i%boardSize)].setType('X');
                board[i / boardSize][(i%boardSize)].setContent('X');
                counter += 1;
            }
            if (counter == n){
                break;
            }
        }
    }


    // World display function. Print the world whenever necessary.
    public void printWorld(){
        System.out.println("The world of play: ");
        for (int i = 0; i < this.boardSize; ++i) {
            System.out.print("+---");
        }
        System.out.println("+");

        for (int i = 0; i < this.boardSize; ++i) {
            System.out.print("|");
            for (int j = 0; j < this.boardSize; ++j){
                System.out.print(" " + this.board[i][j].getContent() + " |");
            }
            System.out.println();
            for (int k = 0; k < this.boardSize; ++k) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}
