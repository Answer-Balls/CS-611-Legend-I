/**
 * @ClassName Cell
 * @Description It is the class for the cells of the map
 * @Author Andy Sheng
 * @Date 2021/11/03
 */

public class Cell{
    private char content;       // Record the content of each cell of the board('X' or 'O')
    private char type;

    public Cell(char content, char type){
        this.type = type;
        this.content = content;
    }

    public char getContent(){
        return content;
    }

    public char getType() {return type; }

    public void setContent(char content){
        this.content = content;
    }

    public void setType(char type) {
        this.type = type;
    }
}