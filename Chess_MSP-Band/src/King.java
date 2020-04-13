import java.util.ArrayList;

public class King extends Piece {

    public int[] rowOff = new int[]{-1,-1,0,1,1,1,0,-1};
    public int[] colOff = new int[]{0,-10,-10,-10,0,10,10,10};

    public King(Color color, Table table){
        this.setColor(color);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'K' : 'k');
        this.setValue(Constants.KING_VALUE);
    }


    public ArrayList<Move> searchMoves(int src){

        ArrayList<Move> moves = new ArrayList<>();

        for(int i = 0; i < rowOff.length; i++){
            int next = src + rowOff[i] + colOff[i];
            Square nextSq = getTable().getSquares().get(next);
            if(nextSq == null) continue;
            if(!nextSq.hasPiece()){
                moves.add(new Move(src,next,null));
                continue;
            } 
            if(nextSq.getPiece().getColor() == this.getColor()) continue;
            moves.add(new Move(src, next, null));
        }

        ArrayList<Move> finalMoves = new ArrayList<>();
        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            Piece initialDest = getTable().applyMove(move);
            boolean checked = getTable().isKingChecked(this.getColor());
            if(!checked) finalMoves.add(move);
            getTable().undoMove(move, initialDest);
        }

        //daca finalMoves e empty si regele e checked in acest moment, e sah mat
        //daca finalMoves e empty si nicio alta piesa nu mai poate fi mutata in afara de rege
        //se considera Pat
        return finalMoves;
    }

    // e un sah mai ciudat, dar functia se dovedeste utila pt a evita ca
    // doi regi sa fie unu langa celalalt
    public boolean isChecking(int src, int king){
        for(int i = 0; i < rowOff.length; i++){
            int next = src + rowOff[i] + colOff[i];
            if(next == king) return true;
        }
        return false;
    }


}
