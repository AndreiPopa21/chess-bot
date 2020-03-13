import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? "Q" : "q");
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
