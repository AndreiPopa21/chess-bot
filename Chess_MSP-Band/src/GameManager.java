import java.util.ArrayList;
import java.util.Vector;

//clasa de tip Singleton 
//GameManager este clasa care leaga toate celelalte componente independente
//este abstractizarea jucatorului

public final class GameManager{
    
    private static Table currTable = null;
    private static Color currPlayer;

    //vector care stocheaza dinamic istoricul mutarilor
    private static Vector<HistoryPairs> history = new Vector<HistoryPairs>();

    //variabila care se incrementeaza odata cu fiecare tura
    private static int currMove = 1;
    

    //constructor privat, clasa GameManager urmeaza pattern-ul de Singleton
    private GameManager(){
        //do nothing 
    }

    //metoda care initializeaza parametrii unui joc nou
    public static void newGame(Color playeColor){
        currMove = 1;
        currPlayer = playeColor;
        currTable = new Table();
        ScoreManager.readValue();
    }


    //metoda care apeleaza configuratia actuala a tablei
    public static void printTable(){
        if(currTable == null){
            System.out.println("NULL table, nothing to be printed");
            return;
        }
        System.out.println(currTable.toString());
    }


    //metoda care seteaza culoarea jucatorului nostru
    public static void setColor(Color color){
        currPlayer = color;
    }


    //metoda care returneaza culoarea jucatorului nostru
    public static Color getColor(){
        return currPlayer;
    }


    //metoda care returneaza tabla principala
    public static Table getTable(){
        return currTable;
    }


    //metoda care returneaza istoricul jocului
    public static Vector<HistoryPairs> getHistory(){
        return history;
    }


    //metoda care primeste o mutare si o executa (in prezent fara a valida mutarea primita)
    public static boolean executeMove(Move move){
       // if(validateMove(move)){
            record(move, currTable);
            nextMove();
            getTable().updateTable(move);
            //printTable();
           // toStringHistory();
            return true;
        /*}else{
            System.out.println("[GameManager] Cannot execute illegal move: " + move.toString());
            printTable();
            return false;
        }*/
    }


    //metoda care ia actiune pentru tura curenta, porneste Minimax sa gandeasca
    public static void manageTurn(){
        MinimaxData result = MiniMax.
            computeMove(GameManager.getTable(), GameManager.getColor());
        
        Move resultMove = result.move;
        if(resultMove.source == 0 
            && resultMove.dest == 0 
            && resultMove.moveType == Constants.WE_ARE_CHECKMATED){
            System.out.println("[GameManager] Jocul s-a terminat, am luat sah mat");
            return;
        }   

        if(resultMove.source == 0 
            && resultMove.dest == 0 
            && resultMove.moveType == Constants.WE_ARE_CHECKMATED){
            System.out.println("[GameManager] Jocul s-a terminat, am luat STALEMATE");
            return;
        }   

        GameManager.executeMove(result.move);
        Sender.parserMove(result.move);
    }

    //metoda care se ocupa cu validarea unei mutari raportat la configuratia curenta
    public static boolean validateMove(Move move){

        if( move.moveType != 0 && move.moveType!=Constants.QUEEN_PROMOTION){
            return getTable().validateSpecialMove(move);
        }


        int src = move.source;
        int dest = move.dest;
        Square srcSq = getTable().getSquares().get(src);
        Square destSq = getTable().getSquares().get(dest);

        if(srcSq == null){
            System.out.println("[GameManager] Invalid source square: " + move.toString());
            return false;
        } 
        if(destSq == null){
            System.out.println("[GameManager] Invalid source square: " + move.toString());  
            return false;
        } 
        
        if(!srcSq.hasPiece()){
            System.out.println("[GameManager] Source square does not have piece: " + move.toString());
            return false;
        }

        ArrayList<Move> moves = srcSq.getPiece().searchMoves(srcSq.getPosition());
        /*for(int i = 0; i < moves.size(); i++){
            System.out.println("[GameManager] Valid Move: " + moves.get(i).toString());
        }*/
        for(int i = 0; i < moves.size(); i++){
            Move next = moves.get(i);
            if((next.source == move.source) 
                && (next.dest == move.dest)){
                    return true;
                }
        }

        return false;
    }


    //metoda care primeste o mutare si o tabla si inregistreaza mutarea in istoric
    public static void record(Move move, Table table){
        HistoryPairs hp;
        if (move.moveType == Constants.WHITE_KING_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E1,Constants.G1,'K',move);

        } else if (move.moveType == Constants.WHITE_QUEEN_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E1,Constants.C1,'K',move);

        } else if (move.moveType == Constants.BLACK_KING_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E8,Constants.G8,'k',move);

        } else if (move.moveType == Constants.BLACK_QUEEN_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E8,Constants.C8,'k',move);

        } else {
       
            int src = move.source;
            int dest = move.dest;
            Square sq = table.getSquares().get(move.source);
            char name = sq.getPiece().getName();
            hp = new HistoryPairs(src, dest, name, move);
            
        }
        history.add(hp);
    }


    //metoda care incrementeaza variabila de tura
    public static void nextMove(){
        currMove += 1;
    }


    //metoda care intoarce numarul curent de ture jucate
    public static int getCurrMove(){
        return currMove;
    }


    //metoda care formateaza intr-un String istoricul actual
    public static String toStringHistory() {
        String out = "";
        String a ,b,c,d;
        for (HistoryPairs i : history)
        {
            a = String.valueOf((char)(i.startPosition % 10 + 48));
            b = String.valueOf((char)(i.startPosition / 10));
            c = String.valueOf((char)(i.finishPosition % 10 + 48));
            d = String.valueOf((char)(i.finishPosition / 10));
            out += String.valueOf(i.piece)+b+a+d+c+" ";
        }
        return out;
    }


    //metoda care cauta in istoricul lui GameManager dupa numele unei piese
    //metoda este folosita in determinarea posibilitatii de rocada
    //daca un rege are o mutare inregistrata, respectiv tura corespondenta de rocada,
    //atunci rocada nu poate avea lor
    public static boolean searchHistoryFor(String name) {

        if (name.compareTo("KA") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.E1) {
                    return true;
                }
            }
        } else if (name.compareTo("kn") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.E8) {
                    return true;
                }
            }
            //r1 tura neagra de pe A8
        } else if (name.compareTo("r1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.A8) {
                    return true;
                }
            }
            // r2 tura neagra pentru H8
        } else if (name.compareTo("r2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.H8) {
                    return true;
                }
            }
            // R1 tura alba pentru A1
        } else if (name.compareTo("R1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.A1) {
                    return true;
                }
            }
            // R2 tura alba pt H1
        } else if (name.compareTo("R2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.H1) {
                    return true;
                }
            }
        }

        return false;
    }

}
