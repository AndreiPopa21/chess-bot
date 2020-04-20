import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class MiniMax {
    private static Table currTable = null;
    static char[] balck_piece = {'p','p','q','b','r','k'};
    static char[] white_piece = {'P','P','Q','B','R','K'};
    public static int index_black = 0;
    public static int index_white = 0;

    public static final int DEPTH = 4;


    private MiniMax(){

    }

    public static int evaluate(HashMap<Integer,Square> h,Color maxi, Color mini) {
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
    }

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

    public static String allMovesToString(ArrayList<Move> allMV){
        String out="";
        for(Move m : allMV){

            out += m.toString()+GameManager.getTable().getSquares().get(m.source).getPiece().getName()+" ";
        }
        return out;
    }

    public static void setTable (){
        currTable = GameManager.getTable();
    }


    public static MinimaxData computeMove(Table table, Color color){
       /*ArrayList<Move> moves = MiniMax.allMoves(table.getSquares(), color);
        if(moves.size() == 0){
            Sender.resignPrint();
        }
        int index = new Random().nextInt(moves.size());
        return new MinimaxData(moves.get(index), 0);*/
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
                    table.getSquares(), maxColor, minColor);
                return new MinimaxData(appliedMove, score);
            }
            
            
           // int maxScore = Integer.MIN_VALUE;
            Move maxMove = new Move(0,0,0);

            for(int i = 0; i < possibleMoves.size(); i++){

                Table newTable = new Table(table);
                Move currMove = possibleMoves.get(i);
                newTable.updateTable(currMove);

                //persista mutarea in istoric - a se sterge cand se revine
                GameManager.record(currMove);

                MinimaxData feedback = MiniMax.mini(
                    newTable, currMove, maxColor, minColor,
                     alpha, beta, curr_depth-1);
                
                //sterge de pe istoric mutarea
                GameManager.getHistory().remove(GameManager.getHistory().size()-1);

                int feedbackScore = feedback.score;

              /*  if(feedbackScore > maxScore){
                    maxScore = feedbackScore;
                    maxMove = currMove;
                }*/

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
                    table.getSquares(), maxColor, minColor);
                return new MinimaxData(appliedMove, score);
            }

            //int minScore = Integer.MAX_VALUE;
            Move minMove = new Move(0,0,0);

            for(int i = 0; i < possibleMoves.size(); i++){

                Table newTable = new Table(table);
                Move currMove = possibleMoves.get(i);
                newTable.updateTable(currMove);

                //persista mutarea in istoric - a se sterge cand se revine
                GameManager.record(currMove);

                MinimaxData feedback = MiniMax.maxi(
                    newTable, currMove, maxColor, minColor,
                    alpha, beta, curr_depth-1);
                
                //sterge de pe istoric mutarea
                if(GameManager.getHistory().size() > 0)
                    GameManager.getHistory().remove(GameManager.getHistory().size()-1);

                int feedbackScore = feedback.score;
               // Move feedbackMove = feedback.move;

                /*if(feedbackScore < minScore){
                    minScore = feedbackScore;
                    minMove = currMove;
                }*/

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



















    public static void thinkMove() {

        if (GameManager.getColor() == Color.BLACK) {
            moveBlack();
        }else {
            moveWhite();
        }
    }

    public static void moveBlack(){
        int blackKnight = -1 ;
        boolean found = false;
        ArrayList<Move> posibilMoves = new ArrayList<Move>();
        while ((index_black < balck_piece.length)&&(!found))
        {
            for (Map.Entry<Integer,Square> i : GameManager.getTable().getSquares().entrySet())
            {
                Square elem = i.getValue();
                if (elem.hasPiece())
                {
                    System.out.println(balck_piece[index_black]);
                    if(elem.getPiece().getName().equals(balck_piece[index_black]))
                    {
                        blackKnight = i.getKey();
                        posibilMoves = GameManager.getTable().getSquares().get(blackKnight).getPiece().searchMoves(blackKnight);
                        if (posibilMoves.size() != 0)
                        {
                            found = true;
                            break ;
                        }

                    }

                }
            }
            if (found)
            {
                break;
            }
            index_black++;
        }

        if (index_black == balck_piece.length)
        {
            Sender.resignPrint();
            return;
        }


        posibilMoves = GameManager.getTable().getSquares().get(blackKnight).getPiece().searchMoves(blackKnight);
        int index;

        if (posibilMoves.size()!= 0 ) {
            index = new Random().nextInt(posibilMoves.size());

            GameManager.record(posibilMoves.get(index));
            GameManager.getTable().updateTable(posibilMoves.get(index));
            System.out.println(GameManager.toStringHistory());
            GameManager.printTable();
            Sender.parserMove(posibilMoves.get(index));
        }

    }

    public static void moveWhite() {

        int blackKnight = -1 ;
        boolean found = false;
        ArrayList<Move> posibilMoves = new ArrayList<Move>();
        while ((index_white < white_piece.length)&&(!found))
        {
            for (Map.Entry<Integer,Square> i : GameManager.getTable().getSquares().entrySet())
            {
                Square elem = i.getValue();
                if (elem.hasPiece())
                {
                    System.out.println(white_piece[index_white]);
                    if(elem.getPiece().getName().equals(white_piece[index_white]))
                    {
                        blackKnight = i.getKey();
                        posibilMoves = GameManager.getTable().getSquares().get(blackKnight).getPiece().searchMoves(blackKnight);
                        if (posibilMoves.size() != 0)
                        {
                            found = true;
                            break ;
                        }

                    }

                }
            }
            if (found)
            {
                break;
            }
            index_white++;
        }

        if (index_white == white_piece.length)
        {
            Sender.resignPrint();
            return;
        }


        posibilMoves = GameManager.getTable().getSquares().get(blackKnight).getPiece().searchMoves(blackKnight);
        int index;

        if (posibilMoves.size()!= 0 ) {
            index = new Random().nextInt(posibilMoves.size());

            GameManager.record(posibilMoves.get(index));
            GameManager.getTable().updateTable(posibilMoves.get(index));
            System.out.println(GameManager.toStringHistory());
            GameManager.printTable();
            Sender.parserMove(posibilMoves.get(index));
        }
    }

}
