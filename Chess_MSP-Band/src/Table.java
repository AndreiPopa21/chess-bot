import java.util.ArrayList;

public class Table {

    private Piece[][] tableConfig= new Piece[8][8];
    private ArrayList<Piece> whiteCaptured = new ArrayList<>();
    private ArrayList<Piece> blackCaptured = new ArrayList<>();

    public Table(){
        generateTable();
    }

    public void generateTable(){
        tableConfig[0][7] = new Rook(Color.WHITE,new Piece.Position('a',1),this);
        tableConfig[0][6] = new Knight(Color.WHITE,new Piece.Position('b',1),this);
        tableConfig[0][5] = new Bishop(Color.WHITE,new Piece.Position('c',1),this);
        tableConfig[0][4] = new Queen(Color.WHITE,new Piece.Position('d',1),this);
        tableConfig[0][3] = new King(Color.WHITE,new Piece.Position('e',1),this);
        tableConfig[0][2] = new Bishop(Color.WHITE,new Piece.Position('f',1),this);
        tableConfig[0][1] = new Knight(Color.WHITE,new Piece.Position('g',1),this);
        tableConfig[0][0]= new Rook(Color.WHITE,new Piece.Position('h',1),this);

        tableConfig[1][7] = new Pawn(Color.WHITE,new Piece.Position('a',2),this);
        tableConfig[1][6] = new Pawn(Color.WHITE,new Piece.Position('b',2),this);
        tableConfig[1][5] = new Pawn(Color.WHITE,new Piece.Position('c',2),this);
        //tableConfig[1][5] = new NoPiece();
        tableConfig[1][4] = new Pawn(Color.WHITE,new Piece.Position('d',2),this);
        //tableConfig[1][4] = new NoPiece();
        tableConfig[1][3] = new Pawn(Color.WHITE,new Piece.Position('e',2),this);
        //tableConfig[1][3] = new NoPiece();
        tableConfig[1][2] = new Pawn(Color.WHITE,new Piece.Position('f',2), this);
        tableConfig[1][1] = new Pawn(Color.WHITE,new Piece.Position('g',2), this);
       // tableConfig[1][1] = new NoPiece(new Piece.Position('0',0));
        tableConfig[1][0] = new Pawn(Color.WHITE,new Piece.Position('h',2), this);

        tableConfig[7][7] = new Rook(Color.BLACK,new Piece.Position('a',8),this);
        tableConfig[7][6] = new Knight(Color.BLACK,new Piece.Position('b',8),this);
        tableConfig[7][5] = new Bishop(Color.BLACK,new Piece.Position('c',8),this);
        tableConfig[7][4] = new Queen(Color.BLACK,new Piece.Position('d',8),this);
        tableConfig[7][3] = new King(Color.BLACK,new Piece.Position('e',8),this);
        tableConfig[7][2] = new Bishop(Color.BLACK,new Piece.Position('f',8),this);
        tableConfig[7][1] = new Knight(Color.BLACK,new Piece.Position('g',8),this);
        tableConfig[7][0]= new Rook(Color.BLACK,new Piece.Position('h',8),this);

        tableConfig[6][7] = new Pawn(Color.BLACK,new Piece.Position('a',7),this);
        tableConfig[6][6] = new Pawn(Color.BLACK,new Piece.Position('b',7), this);
        tableConfig[6][5] = new Pawn(Color.BLACK,new Piece.Position('c',7),this);
        tableConfig[6][4] = new Pawn(Color.BLACK,new Piece.Position('d',7),this);
        tableConfig[6][3] = new Pawn(Color.BLACK,new Piece.Position('e',7),this);
        tableConfig[6][2] = new Pawn(Color.BLACK,new Piece.Position('f',7),this);
        tableConfig[6][1] = new Pawn(Color.BLACK,new Piece.Position('g',7),this);
        tableConfig[6][0] = new Pawn(Color.BLACK,new Piece.Position('h',7),this);

        for(int i = 2; i < 6; i++){
            for(int j = 0;j < 8; j++){
                tableConfig[i][j] = new NoPiece();
            }
        }

        //tableConfig[5][0] = new Pawn(Color.BLACK,new Piece.Position('h',6));
       // tableConfig[5][7] = new Pawn(Color.BLACK,new Piece.Position('a',6));
    }

    public Piece[][] getConfiguration(){return this.tableConfig;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        //tableConfig[0][0].getName();
        for(int i = 0; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                sb.append(tableConfig[i][j].getName().toString()+' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static Character convertIntToCharCol(int x){
        if(x<0 || x>=8)
            return null;
        switch (x){
            case 0:
                return 'h';
            case 1:
                return 'g';
            case 2:
                return 'f';
            case 3:
                return 'e';
            case 4:
                return 'd';
            case 5:
                return 'c';
            case 6:
                return 'b';
            case 7:
                return 'a';
            default:
                return null;
        }
    }
    public static String generateMoveCommand(Piece.Position currPosition, int rowOff, int colOff){
        StringBuilder moveBuilder = new StringBuilder();
        moveBuilder.append(currPosition.letter);
        moveBuilder.append(currPosition.digit);

        int currCol = Math.abs((int) currPosition.letter - 104);
        int currRow = currPosition.digit-1;

        int newRow = currRow + rowOff + 1;
        int newCol = currCol + colOff;

        moveBuilder.append(Table.convertIntToCharCol(newCol));
        moveBuilder.append(newRow);
        return moveBuilder.toString();
    }

    public void addCapturedWhite(Piece p){
        if(p.getColor() == Color.BLACK)
            return;
        if(p.isCaptured())
            return;
        p.setCaptured(true);
        whiteCaptured.add(p);
    }
    public void addCapturedBlack(Piece p){
        if(p.getColor() == Color.WHITE)
            return;
        if(p.isCaptured())
            return;
        p.setCaptured(true);
        blackCaptured.add(p);
    }

    public ArrayList<Piece> getWhiteCaptured(){return this.whiteCaptured;}
    public ArrayList<Piece> getBlackCaptured(){return this.blackCaptured;}

    public void movePiece(Piece p,String command){
        char sourceLetter = command.charAt(0);
        char sourceDigit = command.charAt(1);
        char destLetter = command.charAt(2);
        char destDigit = command.charAt(3);


        int sourceColumn = Math.abs((int) sourceLetter  - 104);
        int sourceRow = sourceDigit - 49;

        int destColumn = Math.abs((int) destLetter - 104);
        int destRow = destDigit -49;

        //System.out.println(sourceRow + " | " + sourceColumn + " | " + destRow + " | " + destColumn);

        Piece aux = this.getConfiguration()[sourceRow][sourceColumn];
        this.getConfiguration()[sourceRow][sourceColumn] = new NoPiece();

        Piece destPiece = this.getConfiguration()[destRow][destColumn];

        if(destPiece.getName().equals('-')){
            //nu am capturat nimic
            this.getConfiguration()[destRow][destColumn] = aux;
            this.getConfiguration()[destRow][destColumn]
                    .setPosition(new Piece.Position(destLetter,destDigit));
            return;
        }
        if(destPiece.getColor() == Color.WHITE) {
            this.addCapturedWhite(destPiece);
            destPiece.setCaptured(true);
            this.getConfiguration()[destRow][destColumn] = aux;
            this.getConfiguration()[destRow][destColumn]
                    .setPosition(new Piece.Position(destLetter, destColumn));
            return;
        }
        if(destPiece.getColor() == Color.BLACK) {
            this.addCapturedBlack(destPiece);
            destPiece.setCaptured(true);
            this.getConfiguration()[destRow][destColumn] = aux;
            this.getConfiguration()[destRow][destColumn]
                    .setPosition(new Piece.Position(destLetter, destColumn));
            return;
        }
    }

    public void move(String command){
        System.out.println(command);
        char sourceLetter = command.charAt(0);
        char sourceDigit = command.charAt(1);

        int sourceColumn = Math.abs((int) sourceLetter  - 104);
        int sourceRow = sourceDigit - 49;
        System.out.println(sourceColumn);
        System.out.println(sourceRow);
        getConfiguration()[sourceRow][sourceColumn].move(command);

    }
}
