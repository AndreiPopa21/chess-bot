import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       ReceiverXboard.receive();
       // GameManager.newGame(Color.WHITE);
        /*GameManager.executeMove(new Move(
            Constants.E2, Constants.E4, 0
        ));

        GameManager.executeMove(new Move(
            Constants.D7, Constants.D6, 0
        ));*/

        /*MinimaxData bestMove = MiniMax.computeMove(
            GameManager.getTable(), GameManager.getColor());
        
        System.out.println(bestMove);

       /* System.out.println(MiniMax.allMovesToString(MiniMax.allMoves(GameManager.getTable().getSquares(),Color.BLACK)));
        GameManager.executeMove(new Move(Constants.D2,Constants.D4, 0));
        System.out.println(MiniMax.allMovesToString(MiniMax.allMoves(GameManager.getTable().getSquares(),Color.WHITE)));

        GameManager.executeMove(new Move(Constants.D7,Constants.D5, 0));
        System.out.println(MiniMax.allMovesToString(MiniMax.allMoves(GameManager.getTable().getSquares(),Color.BLACK)));

        System.out.println(MiniMax.evaluate(GameManager.getTable().getSquares(),Color.BLACK,Color.WHITE));
*/

/*        GameManager.newGame(Color.WHITE);
      
        ArrayList<Move> moves = MiniMax.allMoves(
            GameManager.getTable().getSquares(), Color.BLACK);

        for(int i = 0 ; i < moves.size(); i++){
            System.out.println(moves.get(i).toString());
        }*/

    }
}
