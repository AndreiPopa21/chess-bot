import java.util.ArrayList;

enum KING_STATES{
    CHECKED,
    NOT_CHECKED,
    CASTLED,
    UNCASTLED,
    MOVED,
    CHECKMATED
}

public class King extends Piece {

    private KING_STATES kingState = null;

    public King(Color color, Position initialPosition, Table table){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setTable(table);
        this.kingState = KING_STATES.UNCASTLED;
        this.setName(color==Color.WHITE? 'K' : 'k');
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        if(this.kingState == KING_STATES.CHECKMATED)
            return null;
        ArrayList<String> moves = new ArrayList<>();
        int[] rowOff = {-1,-1,0,1,1,1,0,-1};
        int[] colOff = {0,1,1,1,0,-1,-1,-1};
        Position currPosition = this.getPosition();

        int column = Math.abs((int) currPosition.letter - 104); //get matrix row index
        int row = currPosition.digit-1;

        for(int i = 0; i < rowOff.length; i++){
            int newRow = row + rowOff[i];
            int newCol = column + colOff[i];
            if(newRow < 0 || newRow >= 8 || newCol < 0 || newCol>=8)
                continue;
            Piece p = getTable().getConfiguration()[newRow][newCol];
            if(p.getName().equals('-')){
                moves.add(Table.generateMoveCommand(currPosition,rowOff[i],colOff[i]));
                continue;
            }
            if(p.getColor() == Color.WHITE && this.getColor()==Color.WHITE){
                System.out.println("Mi-am gasit coechipier alb: " + Table.convertIntToCharCol(newCol) + " " + (++newRow));
                continue;
            }
            if(p.getColor() == Color.BLACK && this.getColor() == Color.BLACK){
                System.out.println("Mi-am gasit coechipier negru: " + Table.convertIntToCharCol(newCol) + " " + (++newRow));
                continue;
            }
            if(p.getName().equals('K') || p.getName().equals('k')){
                continue; //you cannot capture a King
            }
            moves.add(Table.generateMoveCommand(currPosition,rowOff[i],colOff[i]));
        }
        return moves;
    }

    @Override
    public void move(String command) {

    }

}
