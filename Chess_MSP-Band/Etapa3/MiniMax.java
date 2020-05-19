import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//clasa Minimax e de tip Singleton si reprezinta componenta logica de joc
//GameManager paseaza o configuratie lui Minimax, iar acesta cea mai buna miscare
//in prezent, clasa implementeaza cu succes un algoritm Minimax cu Alpha-Beta
public final class MiniMax {
    
    //constanta care seteaza adancimea de cautat pentru algoritmul Minimax
    //pentru valori DEPTH >= 5 , cautarea e mult prea costisitoare ca timp
    public static final int DEPTH = 4;


    //constructor privat
    private MiniMax(){

    }

    //metoda se foloseste de ce este in ScoreManager pentru a evalua o configuratie
    public static int evaluate(Table h,Color maxi, Color mini) {
        
       return ScoreManager.greatEvaluate(h,maxi,mini);

        /*
        int scoremaxi = 0,scoremini = 0;
        int tablePozition;
        for (Map.Entry<Integer,Square> i : h.entrySet()) {
            Square elem = i.getValue();
            if (elem.hasPiece()) {
                tablePozition = i.getKey();
                if (elem.getPiece().getColor() == maxi) {
                    scoremaxi += ScoreManager.getScore(elem.getPiece(),tablePozition);
                } else if (elem.getPiece().getColor() == mini) {
                    scoremini += ScoreManager.getScore(elem.getPiece(),tablePozition);
                }
            }
        }

        return (scoremaxi - scoremini);
        */
    }


    //metoda care intoarce toate mutarile valide pe care poate sa le faca un jucator
    //pe o configuratie valida
    public static ArrayList<Move> allMoves(HashMap<Integer,Square> map, Color color){
        ArrayList<Move> allMoves = new ArrayList<>();
        int tablePosition;
        for (Map.Entry<Integer,Square> entry : map.entrySet()) {
            Square elem = entry.getValue();
            if (elem.hasPiece()) {
                tablePosition = entry.getKey();
                if (elem.getPiece().getColor() == color) {
                    allMoves.addAll(elem.getPiece().searchMoves(tablePosition));
                }
            }
        }
        return allMoves;
    }


    //converteste intr-un format String lista de mutari valide
    public static String allMovesToString(ArrayList<Move> allMV){
        String out="";
        for(Move m : allMV){

            out += m.toString()+GameManager.getTable().getSquares().get(m.source).getPiece().getName()+" ";
        }
        return out;
    }


    //metoda care este apelata de GameManager pentru a intoarce cea mai buna mutare
    //pentru configuratia curenta si pentru playerul dati ca argumente
    public static MinimaxData computeMove(Table table, Color color){
      
        Color maxColor = color;
        Color minColor = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    

        ArrayList<Move> possibleMoves = MiniMax.allMoves(table.getSquares(), maxColor);
        if(possibleMoves.size() == 0){
            if(table.isKingChecked(maxColor)){
                return new MinimaxData(new Move(0,0,Constants.WE_ARE_CHECKMATED),0);
            }
            else{
                return new MinimaxData(new Move(0,0,Constants.WE_ARE_STALLED), 0);
            }
        }


        return MiniMax.maxi(
            table, new Move(0,0,0), maxColor, minColor,
            Integer.MIN_VALUE+100000, Integer.MAX_VALUE-100000, DEPTH);
        
    }


    //metoda maxi din Minimax
    public static MinimaxData maxi(
        Table table,
        Move appliedMove,
        Color maxColor,
        Color minColor,
        int alpha,
        int beta,
        int curr_depth){

            ArrayList<Move> possibleMoves = MiniMax.allMoves(table.getSquares(), maxColor);

            if(possibleMoves.size() == 0){
                if(table.isKingChecked(maxColor)){
                    //practic e sah - mat
                    return new MinimaxData(
                        appliedMove, Constants.MAXI_CHECKMATED);
                }
                else{
                    //se considera pat pentru jucatorul curent (STALEMATE)
                    return new MinimaxData(
                        appliedMove, Constants.MAXI_STALEMATE);
                }
            }


            if(curr_depth == 0){
                int score = MiniMax.evaluate(
                    table, maxColor, minColor);
                return new MinimaxData(appliedMove, score);
            }
            
            
           // int maxScore = Integer.MIN_VALUE;
            Move maxMove = new Move(0,0,0);

            for(int i = 0; i < possibleMoves.size(); i++){

                Table newTable = new Table(table);
                Move currMove = possibleMoves.get(i);

                //persista mutarea in istoric - a se sterge cand se revine
                GameManager.record(currMove, newTable);
                newTable.updateTable(currMove);


                MinimaxData feedback = MiniMax.mini(
                    newTable, currMove, maxColor, minColor,
                     alpha, beta, curr_depth-1);
                
                //sterge de pe istoric mutarea
                GameManager.getHistory().remove(GameManager.getHistory().size()-1);

                int feedbackScore = feedback.score;


                if (feedbackScore >= beta ){
                    return new MinimaxData(maxMove, beta);
                }

                if (feedbackScore > alpha){
                    alpha = feedbackScore;
                    maxMove = currMove;
                }

            }

            return new MinimaxData(maxMove, alpha);
    }

    //metoda mini din Minimax
    public static MinimaxData mini(
        Table table,
        Move appliedMove,
        Color maxColor,
        Color minColor,
        int alpha,
        int beta,
        int curr_depth){

            ArrayList<Move> possibleMoves = MiniMax.allMoves(table.getSquares(), minColor);

            if(possibleMoves.size() == 0){
                if(table.isKingChecked(minColor)){
                    //practic e sah - mat
                    return new MinimaxData(
                        appliedMove, Constants.MINI_CHECKMATED);
                }
                else{
                    //se considera pat pentru jucatorul curent (STALEMATE)
                    return new MinimaxData(
                        appliedMove, Constants.MINI_STALEMATE);
                }
            }


            if(curr_depth == 0){
                int score = MiniMax.evaluate(
                    table, maxColor, minColor);
                return new MinimaxData(appliedMove, score);
            }

            //int minScore = Integer.MAX_VALUE;
            Move minMove = new Move(0,0,0);

            for(int i = 0; i < possibleMoves.size(); i++){

                Table newTable = new Table(table);
                Move currMove = possibleMoves.get(i);

                //persista mutarea in istoric - a se sterge cand se revine
                GameManager.record(currMove, newTable);
                newTable.updateTable(currMove);

                MinimaxData feedback = MiniMax.maxi(
                    newTable, currMove, maxColor, minColor,
                    alpha, beta, curr_depth-1);
                
                //sterge de pe istoric mutarea
                if(GameManager.getHistory().size() > 0)
                    GameManager.getHistory().remove(GameManager.getHistory().size()-1);

                int feedbackScore = feedback.score;
              

                if (feedbackScore <= alpha){
                    return new MinimaxData(minMove, alpha);
                }

                if (feedbackScore < beta){
                    beta = feedbackScore;
                    minMove = currMove;
                }

            }

            return new MinimaxData(minMove, beta);
    }
}
