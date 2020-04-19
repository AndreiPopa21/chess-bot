import java.util.ArrayList;
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

    public static void setTable (){
        currTable = GameManager.getTable();
    }

    public static void thinkMove() {
       /* Piece blackHorse = board[7][1];
        Piece whiteHorse = board[0][1];*/
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
