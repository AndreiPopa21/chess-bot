import java.util.ArrayList;

enum PAWN_STATE{
    HAS_ENPASSANT,  //daca la ultima mutare, pionula fost mutat 2 spatii in fata si acum are un punct de enpassant
    NOT_ENPASSANT, //daca pionul nu a fost mutat inca de pe loc, odata ce se muta o pozitie, automat se sare la HAD_ENPASSANT
    HAD_ENPASSANT //daca pionul este in imposibilitatea de a mai avea un punct de enpassant
}

public class Pawn extends Piece {

    private PAWN_STATE pawnState = null;

    public Pawn(Color color, Position initialPosition, Table table){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'P' : 'p');
        this.pawnState = PAWN_STATE.NOT_ENPASSANT;
    }

    public void setPawnState(PAWN_STATE pawnState){
        if(this.pawnState == null){
            this.pawnState = PAWN_STATE.NOT_ENPASSANT;
            return;
        }
        if(this.pawnState == PAWN_STATE.NOT_ENPASSANT && pawnState == PAWN_STATE.HAS_ENPASSANT){
            this.pawnState = PAWN_STATE.HAS_ENPASSANT;
            return;
        }
        if(this.pawnState == PAWN_STATE.HAS_ENPASSANT && pawnState == PAWN_STATE.HAD_ENPASSANT){
            this.pawnState = PAWN_STATE.HAD_ENPASSANT;
            return;
        }
    }
    public PAWN_STATE getPawnState(){return  this.pawnState;}

    @Override
    public void move(String command) {
        ArrayList<String> allCommands = this.getAllPossibleMoves();
        if(!allCommands.contains(command)){
            System.out.println("Invalid command performed by " +
                    (this.getColor()==Color.WHITE? "White" : "Black") + " Pawn at: " +
                    this.getPosition().letter +
                    this.getPosition().digit);
            System.out.println(allCommands);
            return;
        }
        getTable().movePiece(this,command);
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        if(this.isCaptured())
            return null;

        ArrayList<String> moves = new ArrayList<>();
        Position currPosition = this.getPosition();
        int column = Math.abs((int) currPosition.letter - 104); //get matrix row index
        int row = currPosition.digit-1;

        if(this.getColor() == Color.WHITE) {
            Piece p = getTable().getConfiguration()[row + 1][column];
            if (p.getName().equals('-'))
                moves.add(Table.generateMoveCommand(this.getPosition(), 1, 0));

            int[] attackRowOff = {1, 1};
            int[] attackColOff = {1, -1};
            for (int i = 0; i < attackRowOff.length; i++) {

                int nextRow = row + attackRowOff[i];
                int nextCol = column + attackColOff[i];
                if(nextRow < 0 || nextRow >=8 || nextCol < 0 || nextCol >= 8)
                    continue;

                if (getTable().getConfiguration()[nextRow][nextCol]
                        .getColor() == Color.BLACK)
                    moves.add(Table.generateMoveCommand(this.getPosition(),
                            attackRowOff[i], attackColOff[i]));

            }
        }

        if(this.getColor() == Color.BLACK){
            Piece p = getTable().getConfiguration()[row-1][column];
            if(p.getName().equals('-'))
            moves.add(Table.generateMoveCommand(this.getPosition(),-1,0));

            int[] attackRowOff = {-1,-1};
            int[] attackColOff = {1,-1};
            for(int i = 0; i < attackRowOff.length; i++){
                int nextRow = row + attackRowOff[i];
                int nextCol = column + attackColOff[i];
                if(nextRow < 0 || nextRow >=8 || nextCol < 0 || nextCol >= 8)
                    continue;
                if(getTable().getConfiguration()[row+attackRowOff[i]][column+attackColOff[i]]
                        .getColor() == Color.WHITE)
                    moves.add(Table.generateMoveCommand(this.getPosition(),
                            attackRowOff[i],attackColOff[i]));
            }

        }
        if(this.getPawnState() == PAWN_STATE.NOT_ENPASSANT){
            if(this.getColor() == Color.WHITE){
                Piece p = getTable().getConfiguration()[row+2][column];
                if(p.getName().equals('-'))
                    moves.add(Table.generateMoveCommand(this.getPosition(),2, 0));
            }
            if(this.getColor() == Color.BLACK){
                Piece p = getTable().getConfiguration()[row-2][column];
                if(p.getName().equals('-'))
                    moves.add(Table.generateMoveCommand(this.getPosition(),-2,0));
            }
        }




        return moves;
    }


}
