import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? "R" : "r");
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
