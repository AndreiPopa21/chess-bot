import java.util.ArrayList;

public class King extends Piece {
    public King(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? 'K' : 'k');
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
