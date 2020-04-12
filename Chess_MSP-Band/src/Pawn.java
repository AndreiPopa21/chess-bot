import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color, Table table){
        this.setColor(color);       
        this.setTable(table);
        this.setName(color==Color.WHITE? 'P' : 'p');
        this.setValue(Constants.PAWN_VALUE);
    }


    public ArrayList<Move> searchMoves(int src){
        return null;
    }

    /*
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
    }*/


}
