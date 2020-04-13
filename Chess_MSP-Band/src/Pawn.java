import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color, Table table){
        this.setColor(color);       
        this.setTable(table);
        this.setName(color==Color.WHITE? 'P' : 'p');
        this.setValue(Constants.PAWN_VALUE);
    }


    public ArrayList<Move> searchMoves(int src){
        ArrayList<Move> moves = new ArrayList<>();
        return moves;
    }

    public boolean isChecking(int src, int king){
        int attackRight = src + 11;
        int attackLeft = src - 9;

        if(king == attackLeft) return true;
        if(king == attackRight) return true;

        return false;
    }

}
