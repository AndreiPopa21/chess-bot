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
                moves.add(new Move(src,next,0));
                continue;
            } 
            if(nextSq.getPiece().getColor() == this.getColor()) continue;
            moves.add(new Move(src, next, 0));
        }

        ArrayList<Move> finalMoves = new ArrayList<>();
        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            Piece initialDest = getTable().applyMove(move);
            boolean checked = getTable().isKingChecked(this.getColor());
            if(!checked){
              //  System.out.println("[King] This is a final move: " + move.toString());
                finalMoves.add(move);
            } 
            getTable().undoMove(move, initialDest);
        }

        if(this.getColor() == Color.WHITE){
            if(castlingWhiteKing()) finalMoves.add(
                new Move(0,0,Constants.WHITE_KING_SIDE_CASTLING));
            if(castlingWhiteQueen()) finalMoves.add(
                new Move(0,0,Constants.WHITE_QUEEN_SIDE_CASTLING));
        }else{
            if(castlingBlackKing()) finalMoves.add(
                new Move(0,0,Constants.BLACK_KING_SIDE_CASTLING));
            if(castlingBlackQueen()) finalMoves.add(
                new Move(0,0,Constants.BLACK_QUEEN_SIDE_CASTLING));
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




    public boolean castlingWhiteKing(){

//        System.out.println("[Table] Se evalueaza white king-side castling");

        Square e1 = getTable().getSquares().get(Constants.E1);
        Square f1 = getTable().getSquares().get(Constants.F1);
        Square g1 = getTable().getSquares().get(Constants.G1);
        Square h1 = getTable().getSquares().get(Constants.H1);
        
        // (TODO) searchHistoryFor('K');
        if(GameManager.searchHistoryFor("KA")){
          //  System.out.println("[King] WHITE King a fost mutat, nu se poate face KING-SIDE");
            return false;
        } 

        if(GameManager.searchHistoryFor("R2")){
        //    System.out.println("[King] Tura H1 a fost mutata, nu se poate face KING-SIDE");
            return false;
        } 


        if(e1.hasPiece()){
            if(!e1.getPiece().getName().equals('K')){
        //        System.out.println("[Table] NU E REGE white king-side castling");
                return false;
            }
        }else{
      //      System.out.println("[Table] NU E REGE white king-side castling");
            return false;
        }

        if(h1.hasPiece()){
            if(!h1.getPiece().getName().equals('R')){
        //        System.out.println("[Table] NU E TURA white king-side castling");
                return false;
            }
        }else{
     //       System.out.println("[Table] NU E TURA white king-side castling");
            return false;
        }

        if(f1.hasPiece() || g1.hasPiece()) return false;

        if(getTable().isKingChecked(Color.WHITE)) return false;

        Move checkMove = new Move(Constants.E1,Constants.F1,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.WHITE)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

        checkMove = new Move(Constants.E1,Constants.G1,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.WHITE)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

       // System.out.println("[Table] E posibil white king-side castling");

        return true;
    }

    public boolean castlingWhiteQueen(){

    //    System.out.println("[Table] Se evalueaza white queen-side castling");

        Square e1 = getTable().getSquares().get(Constants.E1);
        Square d1 = getTable().getSquares().get(Constants.D1);
        Square c1 = getTable().getSquares().get(Constants.C1);
        Square b1 = getTable().getSquares().get(Constants.B1);
        Square a1 = getTable().getSquares().get(Constants.A1);

        if(GameManager.searchHistoryFor("KA")){
        //    System.out.println("[King] WHITE King a fost mutat, nu se poate face QUEEN-SIDE");
            return false;
        }

        if(GameManager.searchHistoryFor("R1")){
       //     System.out.println("[King] Tura A1 a fost mutat, nu se poate face QUEEN-SIDE");
            return false;
        }

        if(e1.hasPiece()){
            if(!e1.getPiece().getName().equals('K')){
                return false;
            }
        }else{
            return false;
        }

        if(a1.hasPiece()){
            if(!a1.getPiece().getName().equals('R')){
                return false;
            }
        }else{  
            return false;
        }


        if(b1.hasPiece() || c1.hasPiece() || d1.hasPiece()) return false;

        if(getTable().isKingChecked(Color.WHITE)) return false;


        Move checkMove = new Move(Constants.E1,Constants.D1,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.WHITE)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

        checkMove = new Move(Constants.E1,Constants.C1,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.WHITE)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

      //  System.out.println("[Table] SE POATE white queen-side castling");

        return true;
    }

    public boolean castlingBlackKing(){

   //     System.out.println("[Table] Se evalueaza black king-side castling");

        Square e8 = getTable().getSquares().get(Constants.E8);
        Square f8 = getTable().getSquares().get(Constants.F8);
        Square g8 = getTable().getSquares().get(Constants.G8);
        Square h8 = getTable().getSquares().get(Constants.H8);


        if(GameManager.searchHistoryFor("kn")){
          //  System.out.println("[King] BLACK King a fost mutat, nu se poate face KING-SIDE");
            return false;
        }

        if(GameManager.searchHistoryFor("r2")){
       //     System.out.println("[King] Tura H8 a fost mutat, nu se poate face KING-SIDE");
            return false;
        }

        if(e8.hasPiece()){
            if(!e8.getPiece().getName().equals('k')){
                return false;
            }
        }else{
            return false;
        }

        if(h8.hasPiece()){
            if(!h8.getPiece().getName().equals('r')){
                return false;
            }
        }else{
            return false;
        }

        if(f8.hasPiece() || g8.hasPiece()) return false;

        if(getTable().isKingChecked(Color.BLACK)) return false;

        Move checkMove = new Move(Constants.E8,Constants.F8,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.BLACK)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

        checkMove = new Move(Constants.E8,Constants.G8,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.BLACK)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

      //  System.out.println("[Table] SE POATE black king-side castling");

        return true;
    }

    public boolean castlingBlackQueen(){

  //      System.out.println("[Table] Se evalueaza black queen-side castling");

        Square e8 = getTable().getSquares().get(Constants.E8);
        Square d8 = getTable().getSquares().get(Constants.D8);
        Square c8 = getTable().getSquares().get(Constants.C8);
        Square b8 = getTable().getSquares().get(Constants.B8);
        Square a8 = getTable().getSquares().get(Constants.A8);


        if(GameManager.searchHistoryFor("kn")){
      //      System.out.println("[King] BLACK King a fost mutat, nu se poate face QUEEN-SIDE");
            return false;
        }

        if(GameManager.searchHistoryFor("r1")){
   //         System.out.println("[King] Tura A8 a fost mutata, nu se poate face QUEEN-SIDE");
            return false;
        }



        if(e8.hasPiece()){
            if(!e8.getPiece().getName().equals('k')){
                return false;
            }
        }else{
            return false;
        }

        if(a8.hasPiece()){
            if(!a8.getPiece().getName().equals('r')){
                return false;
            }
        }else{  
            return false;
        }


        if(b8.hasPiece() || c8.hasPiece() || d8.hasPiece()) return false;

        if(getTable().isKingChecked(Color.BLACK)) return false;


        Move checkMove = new Move(Constants.E8,Constants.D8,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.BLACK)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

        checkMove = new Move(Constants.E8,Constants.C8,0);
        getTable().applyMove(checkMove);
        if(getTable().isKingChecked(Color.BLACK)){
            getTable().undoMove(checkMove, null);
            return false;
        }
        getTable().undoMove(checkMove, null);

      //  System.out.println("[Table] SE POATE black queen-side castling");

        return true;
    }
    

}
