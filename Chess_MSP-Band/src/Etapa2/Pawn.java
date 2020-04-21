import java.util.ArrayList;
import java.util.Vector;

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

    //metoda care cauta toate mutarile posibile pentru pion
    public ArrayList<Move> searchMoves(int src){
        
        ArrayList<Move> moves = new ArrayList<>();

        int increment = (getColor() == Color.WHITE) ? 1 : -1;

        int front = src + increment;
        int doubleFront = src + 2*increment;

        Square frontSq = getTable().getSquares().get(front);
        Square doubleSq = getTable().getSquares().get(doubleFront);

        if(frontSq != null){
            if(!frontSq.hasPiece()){
                moves.add(new Move(src,front,0));

                if(doubleSq != null){
                    if(!doubleSq.hasPiece()){
                        if(this.getColor() == Color.BLACK){
                            if(src % 10 == 7){
                                moves.add(new Move(src,doubleFront,0));
                            }
                        }else {
                            if(src % 10 == 2){
                                moves.add(new Move(src,doubleFront,0));
                            }
                        }
                    }
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
                moves.add(new Move(src,next, 0));
            }
        }

        ArrayList<Move> finalMoves = new ArrayList<>();

        //se filtreaza mutarile gasite, o mutare care pune regele in pericol de sah e invalida
        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move, this.getColor())){
                finalMoves.add(move);
            }
        }

        //te uiti la toate mutarile valide si observi daca vreuna e de tip promotion
        //daca e cazul, i se pune un flag de promotion la moveType
        for(int i = 0; i < finalMoves.size(); i++){
            if(checkPromotion(finalMoves.get(i))){
               // System.out.println("[Pawn] Mutare de promotion: "
               //  + finalMoves.get(i).toString());
                finalMoves.get(i).moveType = Constants.QUEEN_PROMOTION;
            }
        }


        
        if(this.getColor() == Color.WHITE){
            if(whiteRightEnpassant(src)){
                finalMoves.add(
                    new Move(src,src+10+1,Constants.EN_PASSANT));
            }
            if(whiteLeftEnpassant(src)){
                finalMoves.add(
                    new Move(src,src+1-10,Constants.EN_PASSANT));
            }
        }else{
            if(blackRightEnpassant(src)){
                finalMoves.add(
                    new Move(src,src+10-1,Constants.EN_PASSANT));
            }
            if(blackLeftEnpassant(src)){
                finalMoves.add(
                    new Move(src,src-10-1,Constants.EN_PASSANT));
            }
        }

        return finalMoves;
    }


    //metoda din clasa de baza care verifica daca pionul da sah regelui advers
    public boolean isChecking(int src, int king){
        int attackRight = 0;
        int attackLeft = 0;

        if(this.getColor() == Color.WHITE){
            attackRight = src + 10 + 1;
            attackLeft = src - 10 + 1;
        }else{
            attackRight = src + 10 -1;
            attackLeft = src - 10 -1 ;
        }

        if(king == attackLeft) return true;
        if(king == attackRight) return true;

        return false;
    }

    //metoda care evalueaza daca prin mutarea data ca argument se face promovarea pionului
    public boolean checkPromotion(Move move){
        
        int src = move.source;
        int dest = move.dest;

        if(move.moveType == Constants.EN_PASSANT) return false;
        
        if(getColor() == Color.WHITE){
            if(src % 10 != 7) return false;
            if(dest % 10 != 8) return false;
            return true;
        }else{
            if(src % 10 != 2) return false;
            if(src % 10 != 1) return false;
            return true;
        }
    }


    //metoda care evalueaza posibilitatea pentru un pion alb de a lua en-passant prin dreapta
    public boolean whiteRightEnpassant(int src){

      //  System.out.println("[Pawn] Se evalueaza white-right enpassant pentru pionul de pe: " + src);

        if(src % 10 != 5){
           // System.out.println("[Pawn] Nu este linia corespunzatoare: " + src);
            return false;
        } 

        int right = src + 10;
        Square rightSq = getTable().getSquares().get(right);
        if(rightSq == null) return false;
        if(!rightSq.hasPiece()) return false;
        if(!rightSq.getPiece().getName().equals('p')) return false;

        //TODO : search history
        Vector<HistoryPairs> hp = GameManager.getHistory();
        if(hp.size() < 4) return false;

        HistoryPairs lastRecord = hp.lastElement();
        int source = src + 10 + 2;
        int dest = src + 10;
        
        Move cv = new Move(lastRecord.startPosition,lastRecord.finishPosition,0);
        //System.out.println("[Pawn] Last record a aratat ca ultima mutare facuta este: " + cv.toString());

        if(lastRecord.startPosition == source){
            if(lastRecord.finishPosition == dest){
                Move checkMove = new Move(src,dest+1,0);
                Square targetSq = getTable().getSquares().get(dest);
                Piece backup = targetSq.getPiece();
                targetSq.setPiece(null);
                getTable().applyMove(checkMove);
                if(getTable().isKingChecked(Color.WHITE)){
                  //  System.out.println("[Pawn] Regele din pacate a fost gasit in sah facand acest enpassant: " + checkMove.toString());
                  //  System.out.println("[Pawn] NU este white-right enpassant");
                    getTable().undoMove(checkMove, null);
                    targetSq.setPiece(backup);
                    return false;
                }

              //  System.out.println("[Pawn] ESTE white-right enpassant");
                getTable().undoMove(checkMove, null);
                targetSq.setPiece(backup);
                return true;
            }
        }

        return false;
    }


    //metoda care evalueaza posibilitatea pentru un pion alb de a lua en-passant prin stanga
    public boolean whiteLeftEnpassant(int src){

     //   System.out.println("[Pawn] Se evalueaza white-left enpassant pentru pionul de pe: " + src);

        if(src % 10 != 5){
       //     System.out.println("[Pawn] Nu este linia corespunzatoare: " + src);
            return false;
        } 

        int left = src - 10;
        Square leftSq = getTable().getSquares().get(left);
        if(leftSq == null) return false;
        if(!leftSq.hasPiece()) return false;
        if(!leftSq.getPiece().getName().equals('p')) return false;

        //TODO : search history
        Vector<HistoryPairs> hp = GameManager.getHistory();
        if(hp.size() < 4) return false;

        HistoryPairs lastRecord = hp.lastElement();
        int source = src - 10 + 2;
        int dest = src - 10;

          
        Move cv = new Move(lastRecord.startPosition,lastRecord.finishPosition,0);
       // System.out.println("[Pawn] Last record a aratat ca ultima mutare facuta este: " + cv.toString());

        if(lastRecord.startPosition == source){
            if(lastRecord.finishPosition == dest){
                Move checkMove = new Move(src,dest+1,0);
                Square targetSq = getTable().getSquares().get(dest);
                Piece backup = targetSq.getPiece();
                targetSq.setPiece(null);
                getTable().applyMove(checkMove);
                if(getTable().isKingChecked(Color.WHITE)){
             //       System.out.println("[Pawn] Regele din pacate a fost gasit in sah facand acest enpassant: " + checkMove.toString());
              //      System.out.println("[Pawn] NU este white-left enpassant");
                    getTable().undoMove(checkMove, null);
                    targetSq.setPiece(backup);
                    return false;
                }

            //    System.out.println("[Pawn] ESTE white-left enpassant");
                getTable().undoMove(checkMove, null);
                targetSq.setPiece(backup);
                return true;
            }
        }

        return false;
    }


    //metoda care evalueaza posibilitatea pentru un pion negru de a lua en-passant prin dreapta
    public boolean blackRightEnpassant(int src){

       // System.out.println("[Pawn] Se evalueaza black-right enpassant pentru pionul de pe: " + src);

        if(src % 10 != 4){
         //   System.out.println("[Pawn] Nu este linia corespunzatoare: " + src);
            return false;
        } 

        int right = src + 10;
        Square rightSq = getTable().getSquares().get(right);
        if(rightSq == null) return false;
        if(!rightSq.hasPiece()) return false;
        if(!rightSq.getPiece().getName().equals('P')) return false;

        //TODO : search history
        Vector<HistoryPairs> hp = GameManager.getHistory();
        if(hp.size() < 4) return false;

        HistoryPairs lastRecord = hp.lastElement();
        int source = src + 10 - 2;
        int dest = src + 10;

        if(lastRecord.startPosition == source){
            if(lastRecord.finishPosition == dest){
                Move checkMove = new Move(src,dest-1,0);
                Square targetSq = getTable().getSquares().get(dest);
                Piece backup = targetSq.getPiece();
                targetSq.setPiece(null);
                getTable().applyMove(checkMove);
                if(getTable().isKingChecked(Color.WHITE)){

                 //   System.out.println("[Pawn] NU este black-right enpassant");
                    getTable().undoMove(checkMove, null);
                    targetSq.setPiece(backup);
                    return false;
                }

               // System.out.println("[Pawn] ESTE black-right enpassant");
                getTable().undoMove(checkMove, null);
                targetSq.setPiece(backup);
                return true;
            }
        }

        return false;
    }


    //metoda care evalueaza posibilitatea pentru un pion negru de a lua en-passant prin stanga
    public boolean blackLeftEnpassant(int src){

     //   System.out.println("[Pawn] Se evalueaza black-left enpassant pentru pionul de pe: " + src);

        if(src % 10 != 4){
       //     System.out.println("[Pawn] Nu este linia corespunzatoare: " + src);
            return false;
        } 

        int left = src - 10;
        Square leftSq = getTable().getSquares().get(left);
        if(leftSq == null) return false;
        if(!leftSq.hasPiece()) return false;
        if(!leftSq.getPiece().getName().equals('P')) return false;

        //TODO : search history
        Vector<HistoryPairs> hp = GameManager.getHistory();
        if(hp.size() < 4) return false;

        HistoryPairs lastRecord = hp.lastElement();
        int source = src - 10 - 2;
        int dest = src - 10;

        if(lastRecord.startPosition == source){
            if(lastRecord.finishPosition == dest){
                Move checkMove = new Move(src,dest-1,0);
                Square targetSq = getTable().getSquares().get(dest);
                Piece backup = targetSq.getPiece();
                targetSq.setPiece(null);
                getTable().applyMove(checkMove);
                if(getTable().isKingChecked(Color.WHITE)){

                 //   System.out.println("[Pawn] NU este black-left enpassant");

                    getTable().undoMove(checkMove, null);
                    targetSq.setPiece(backup);
                    return false;
                }

               // System.out.println("[Pawn] ESTE black-left enpassant");
                getTable().undoMove(checkMove, null);
                targetSq.setPiece(backup);
                return true;
            }
        }

        return false;
    }

}
