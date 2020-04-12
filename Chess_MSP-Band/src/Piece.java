import java.util.ArrayList;

enum Color{
    WHITE,
    BLACK,
    NOCOLOR
}

public abstract class Piece {
    private Color color;
    private Character name;
    private Table table;
    private int value;

    public Color getColor(){return this.color;}
    public Character getName(){return this.name;}
    public Table getTable(){return this.table;}
    public int getValue(){return this.value;}

    public void setColor(Color color){this.color = color;}
    public void setName(Character name){this.name = name;}
    public void setValue(int value){this.value = value;}
    public void setTable(Table table){this.table = table;}

    public abstract ArrayList<Move> searchMoves(int src);
    public abstract boolean isChecking(int src, int king);

    public boolean isKing(Piece piece){
        if(piece == null) {
            return false;
        }
        if(piece.getName().equals('K')) {
            return true;
        }
        if(piece.getName().equals('k')) {
            return true;
        }
        return false;
    }
}
