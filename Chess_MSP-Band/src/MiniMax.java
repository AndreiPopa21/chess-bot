import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public final class MiniMax {
    private static Table currTable = null;
    static char []balck_piece = {'n','k','p','b','q','r'};
    static char []white_piece = {'N','P','K','B','Q','R'};
    static int index_black = 0;
    static int index_white = 0;
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
        for (Map.Entry<Integer,Square> i : GameManager.getTable().getSquares().entrySet())
        {
            Square elem = i.getValue();
            if (elem.hasPiece())
            {
                System.out.println(balck_piece[index_black]);
                if(elem.getPiece().getName().equals(balck_piece[index_black]))
                {
                    blackKnight = i.getKey();
                }
            }
        }

        if (blackKnight == -1)
        {
            index_black++;
            System.out.println(index_black);
            if (index_black < balck_piece.length)
                moveBlack();
            else
                System.out.println("1-0 {Black resigns}");
        }
        int index;
        ArrayList<Move> posibilMoves = new ArrayList<Move>();
        if (GameManager.getTable().getSquares().get(blackKnight) == null) {
            System.out.println("Is null get");
            moveBlack();
        }
            posibilMoves = GameManager.getTable().getSquares().get(blackKnight).getPiece().searchMoves(blackKnight);

        if (posibilMoves.size()!= 0 ) {
            index = new Random().nextInt(posibilMoves.size());
            GameManager.getTable().updateTable(posibilMoves.get(index));
            GameManager.printTable();
            Sender.parserMove(posibilMoves.get(index));
        }else
        {
            System.out.println("A intrat in black +++");
            index_black++;
            System.out.println(index_black);
            if (index_black < balck_piece.length)
                moveBlack();
            else
                System.out.println("1-0 {Black resigns}");
        }

      /*  if(whiteHorse.getAllPossibleMoves() != null){
            ArrayList<String> whiteHorseMoves = whiteHorse.getAllPossibleMoves();
            int index = new Random().nextInt(whiteHorseMoves.size());
            recv.table.move(whiteHorseMoves.get(index));
            System.out.println("move " + whiteHorseMoves.get(index)) ;
            System.out.flush();
        }else{
            //System.out.println("Calul alb a fost capturat");
            System.out.println("0-1 {White resigns}");
        }*/
    }

    public static void moveWhite() {

        int whiteKnight = -1;
        for (Map.Entry<Integer, Square> i : GameManager.getTable().getSquares().entrySet()) {
            Square elem = i.getValue();
            if (elem.hasPiece()) {
                if (elem.getPiece().getName().equals(white_piece[index_white])) {
                    whiteKnight = i.getKey();
                }
            }
        }
       // System.out.println(whiteKnight);
        int index;
        ArrayList<Move> posibilMoves = GameManager.getTable().getSquares().get(whiteKnight).getPiece().searchMoves(whiteKnight);

        if (posibilMoves.size() != 0) {
            index = new Random().nextInt(posibilMoves.size());
            GameManager.getTable().updateTable(posibilMoves.get(index));
            Sender.parserMove(posibilMoves.get(index));
        } else {
            index_white++;
            if (index_white < white_piece.length)
                moveWhite();
            else
                System.out.println("1-0 {White resigns}");
        }



       /* if(blackHorse.getAllPossibleMoves() != null) {
            ArrayList<String> blackHorseMoves = blackHorse.getAllPossibleMoves();
            int index = new Random().nextInt(blackHorseMoves.size());
            recv.table.move(blackHorseMoves.get(index));
            System.out.println("move " + blackHorseMoves.get(index)) ;
            System.out.flush();
        }
        else{
            //System.out.println("Calul negru a fost capturat");
            System.out.println("1-0 {Black resigns}");
        }*/
    }

}
