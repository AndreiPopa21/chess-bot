import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? 'B' : 'b');
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
