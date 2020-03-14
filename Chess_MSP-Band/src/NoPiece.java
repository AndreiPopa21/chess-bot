import java.util.ArrayList;

public class NoPiece extends Piece {

    public NoPiece(Position position){
        this.setColor(Color.NOCOLOR);
        this.setCaptured(false);
        this.setPosition(position);
        this.setName('-');
    }

    public NoPiece(){
        this(new Position('0',0));
    }

    @Override
    public void move(String command) {

    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        return null;
    }
}
