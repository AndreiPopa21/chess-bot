import java.util.ArrayList;

enum Color{
    WHITE,
    BLACK,
    NOCOLOR
}

public abstract class Piece {
    private Color color;
    private String name;
    private Boolean captured;
    private Position position;

    public Color getColor(){return this.color;}
    public String getName(){return this.name;}
    public Boolean isCaptured(){return this.captured;}
    public Position getPosition(){return this.position;}

    public void setColor(Color color){this.color = color;}
    public void setName(String name){this.name = name;}
    public void setCaptured(Boolean captured){this.captured = captured;}
    public void setPosition(Position position){this.position =position;}

    public static class Position{
        public char letter;
        public int digit;
        public Position(char letter, int digit){
            this.letter = letter;
            this.digit = digit;
        }
    }

    public void movePiece(Integer xOffset, Integer yOffset){

    }

    public abstract ArrayList<String> getAllPossibleMoves();
}
