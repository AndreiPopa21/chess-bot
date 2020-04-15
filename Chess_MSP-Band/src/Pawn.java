import java.util.ArrayList;

public class Pawn extends Piece {

    public int[] rowOff = new int[]{1,1};
    public int[] colOff = new int[]{-10,10};

    public boolean movedTwice;

    public Pawn(Color color, Table table){
        this.setColor(color);       
        this.setTable(table);
        this.setName(color==Color.WHITE? 'P' : 'p');
        this.setValue(Constants.PAWN_VALUE);
        this.movedTwice = false;
    }


    public ArrayList<Move> searchMoves(int src){
        
        ArrayList<Move> moves = new ArrayList<>();

        int increment = (getColor() == Color.WHITE) ? 1 : -1;

        int front = src + increment;
        int doubleFront = src + 2*increment;

        Square frontSq = getTable().getSquares().get(front);
        Square doubleSq = getTable().getSquares().get(doubleFront);

        if(frontSq != null){
            if(!frontSq.hasPiece()){
                moves.add(new Move(src,front,null));
            }
        }

        if(doubleSq != null){
            if(!doubleSq.hasPiece()){
                if(!movedTwice){
                    moves.add(new Move(src,doubleFront,null));
                }
            }
        }

        //se verifica pozitiile de atac
        for(int i = 0 ; i < rowOff.length; i++){
            int next = src + (rowOff[i] + colOff[i]) * increment;
            Square nextSq = getTable().getSquares().get(next);
            if(nextSq == null) continue;
            if(!nextSq.hasPiece()) continue;
            if(nextSq.getPiece().getColor() != this.getColor()){
                moves.add(new Move(src,next, null));
            }
        }

        ArrayList<Move> finalMoves = new ArrayList<>();

        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move, this.getColor())){
                finalMoves.add(move);
            }else{
                System.out.println("[Pawn] Cannot perform " + move.toString() + " because king bounded");
            }
        }

        return finalMoves;
    }

    public boolean isChecking(int src, int king){
        int attackRight = src + 11;
        int attackLeft = src - 9;

        if(king == attackLeft) return true;
        if(king == attackRight) return true;

        return false;
    }

}
