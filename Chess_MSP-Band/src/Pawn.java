import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? "P" : "p");
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
