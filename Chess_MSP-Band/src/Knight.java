import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Color color, Position initialPosition){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setName(color==Color.WHITE? "N" : "n");
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
