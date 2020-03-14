import java.util.ArrayList;

public class NoPiece extends Piece {

    public NoPiece(Position position){
        this.setColor(Color.NOCOLOR);
        this.setCaptured(false);
        this.setPosition(position);
        this.setName('-');
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
