import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Color color, Position initialPosition, Table table){
        this.setColor(color);
        this.setPosition(initialPosition);
        this.setCaptured(false);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'R' : 'r');
    }

    @Override
    public void move(String command) {
        ArrayList<String> allCommands = this.getAllPossibleMoves();
        if(!allCommands.contains(command)){
            System.out.println("Invalid command performed by " +
                    (this.getColor()==Color.WHITE? "White" : "Black") + " Rook at: " +
                    this.getPosition().letter +
                    this.getPosition().digit);
            return;
        }
        getTable().movePiece(this,command);
    }

    @Override
    public ArrayList<String> getAllPossibleMoves() {
        if(this.isCaptured())
            return null;
        ArrayList<String> moves = new ArrayList<>();

        int rowOff[] = {1, 0, -1, 0};
        int colOff[] = {0, -1, 0, 1};
        Position currPosition = this.getPosition();
        int column = Math.abs((int) currPosition.letter - 104); //get matrix row index
        int row = currPosition.digit-1;

        for(int i = 0; i < rowOff.length; i++){
            int increment = 1;
            boolean found = false;
            while(!found){
                int newRow = row + rowOff[i] * increment;
                int newCol = column + colOff[i] * increment;
                if(newRow < 0 || newRow >=8 || newCol < 0 || newCol >= 8){
                    found = true;
                    continue;
                }
                Piece p = getTable().getConfiguration()[newRow][newCol];
                if(p.getName().equals('-')){
                    moves.add(Table.generateMoveCommand(currPosition,rowOff[i]*increment,colOff[i]*increment));
                    increment++;
                    continue;
                }
                if(p.getColor() == Color.WHITE && this.getColor()==Color.WHITE){
                    found = true;
                    continue;
                }
                if(p.getColor() == Color.BLACK && this.getColor() == Color.BLACK){
                    found = true;
                    continue;
                }
                if(p.getName().equals('K') || p.getName().equals('k')){
                    found = true;
                    continue;
                }

                moves.add(Table.generateMoveCommand(currPosition,rowOff[i]*increment,colOff[i]*increment));
                found = true;
            }
        }
        if(moves.isEmpty())
            System.out.println("Nu s-a gasit nicio mutare pentru tura de pe: "
                    + this.getPosition().letter
                    + this.getPosition().digit);
        return moves;
    }
}
