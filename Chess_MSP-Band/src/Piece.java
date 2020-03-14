import java.util.ArrayList;

enum Color{
    WHITE,
    BLACK,
    NOCOLOR
}

public abstract class Piece {
    private Color color;
    private Character name;
    private Boolean captured;
    private Position position;
    private Table table;

    public Color getColor(){return this.color;}
    public Character getName(){return this.name;}
    public Boolean isCaptured(){return this.captured;}
    public Position getPosition(){return this.position;}
    public Table getTable(){return this.table;}

    public void setColor(Color color){this.color = color;}
    public void setName(Character name){this.name = name;}
    public void setCaptured(Boolean captured){
        this.captured = captured;
    }
    public void setPosition(Position position){this.position =position;}
    public void setTable(Table table){this.table = table;}

    public static class Position{
        public char letter;
        public int digit;
        public Position(char letter, int digit){
            this.letter = letter;
            this.digit = digit;
        }
    }

    public abstract void move(String command);
    public abstract ArrayList<String> getAllPossibleMoves();
}
