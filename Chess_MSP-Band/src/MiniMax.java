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

    public static ArrayList<Move> allMoves(HashMap<Integer,Square> h, Color c){
        ArrayList<Move> allMV = new ArrayList<>();
        int tablePozition;
        for (Map.Entry<Integer,Square> i : h.entrySet()) {
            Square elem = i.getValue();
            if (elem.hasPiece()) {
                tablePozition = i.getKey();
                if (elem.getPiece().getColor() == c) {
                    allMV.addAll(elem.getPiece().searchMoves(tablePozition));
                }
            }
        }
        return allMV;
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
