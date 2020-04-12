import java.util.ArrayList;
import java.util.HashMap;

public class Table {

    
    private Color playerColor;
    private char kingName;
    private char queenName;
    private char bishopName;
    private char knightName;
    private char rookName;
    private char pawnName;
    private HashMap<Integer,Square> squaresMap = new HashMap<>();


    public Table(Color playerColor){
        this.playerColor = playerColor;
        standardGame();
        setNames(playerColor);
    }

    private void setNames(Color color){
        kingName = (color == Color.WHITE) ? 'K' : 'k';
        queenName = (color == Color.WHITE) ? 'Q' : 'q';
        bishopName = (color == Color.WHITE) ? 'B' : 'b';
        knightName = (color == Color.WHITE) ? 'N' : 'n';
        rookName = (color == Color.WHITE) ? 'R' : 'r';
        pawnName = (color == Color.WHITE) ? 'P' : 'p';
    }

    private void standardGame(){
        squaresMap.clear();

        //linia 1
        squaresMap.put(Constants.A1, new Square(Constants.A1, null));
        squaresMap.put(Constants.B1, new Square(Constants.B1, null));
        squaresMap.put(Constants.C1, new Square(Constants.C1, null));
        squaresMap.put(Constants.D1, new Square(Constants.D1, null));
        squaresMap.put(Constants.E1, new Square(Constants.E1, null));
        squaresMap.put(Constants.F1, new Square(Constants.F1, null));
        squaresMap.put(Constants.G1, new Square(Constants.G1, null));
        squaresMap.put(Constants.H1, new Square(Constants.H1, null));

        //linia 2
        squaresMap.put(Constants.A2, new Square(Constants.A2, null));
        squaresMap.put(Constants.B2, new Square(Constants.B2, null));
        squaresMap.put(Constants.C2, new Square(Constants.C2, null));
        squaresMap.put(Constants.D2, new Square(Constants.D2, null));
        squaresMap.put(Constants.E2, new Square(Constants.E2, null));
        squaresMap.put(Constants.F2, new Square(Constants.F2, null));
        squaresMap.put(Constants.G2, new Square(Constants.G2, null));
        squaresMap.put(Constants.H2, new Square(Constants.H2, null));

        //linia 3
        squaresMap.put(Constants.A3, new Square(Constants.A3, null));
        squaresMap.put(Constants.B3, new Square(Constants.B3, null));
        squaresMap.put(Constants.C3, new Square(Constants.C3, null));
        squaresMap.put(Constants.D3, new Square(Constants.D3, null));
        squaresMap.put(Constants.E3, new Square(Constants.E3, null));
        squaresMap.put(Constants.F3, new Square(Constants.F3, null));
        squaresMap.put(Constants.G3, new Square(Constants.G3, null));
        squaresMap.put(Constants.H3, new Square(Constants.H3, null));

        //linia 4
        squaresMap.put(Constants.A4, new Square(Constants.A4, null));
        squaresMap.put(Constants.B4, new Square(Constants.B4, null));
        squaresMap.put(Constants.C4, new Square(Constants.C4, null));
        squaresMap.put(Constants.D4, new Square(Constants.D4, null));
        squaresMap.put(Constants.E4, new Square(Constants.E4, null));
        squaresMap.put(Constants.F4, new Square(Constants.F4, null));
        squaresMap.put(Constants.G4, new Square(Constants.G4, null));
        squaresMap.put(Constants.H4, new Square(Constants.H4, null));

        //linia 5
        squaresMap.put(Constants.A5, new Square(Constants.A5, null));
        squaresMap.put(Constants.B5, new Square(Constants.B5, null));
        squaresMap.put(Constants.C5, new Square(Constants.C5, null));
        squaresMap.put(Constants.D5, new Square(Constants.D5, null));
        squaresMap.put(Constants.E5, new Square(Constants.E5, null));
        squaresMap.put(Constants.F5, new Square(Constants.F5, null));
        squaresMap.put(Constants.G5, new Square(Constants.G5, null));
        squaresMap.put(Constants.H5, new Square(Constants.H5, null));

        //linia 6
        squaresMap.put(Constants.A6, new Square(Constants.A6, null));
        squaresMap.put(Constants.B6, new Square(Constants.B6, null));
        squaresMap.put(Constants.C6, new Square(Constants.C6, null));
        squaresMap.put(Constants.D6, new Square(Constants.D6, null));
        squaresMap.put(Constants.E6, new Square(Constants.E6, null));
        squaresMap.put(Constants.F6, new Square(Constants.F6, null));
        squaresMap.put(Constants.G6, new Square(Constants.G6, null));
        squaresMap.put(Constants.H6, new Square(Constants.H6, null));

        //linia 7
        squaresMap.put(Constants.A7, new Square(Constants.A7, null));
        squaresMap.put(Constants.B7, new Square(Constants.B7, null));
        squaresMap.put(Constants.C7, new Square(Constants.C7, null));
        squaresMap.put(Constants.D7, new Square(Constants.D7, null));
        squaresMap.put(Constants.E7, new Square(Constants.E7, null));
        squaresMap.put(Constants.F7, new Square(Constants.F7, null));
        squaresMap.put(Constants.G7, new Square(Constants.G7, null));
        squaresMap.put(Constants.H7, new Square(Constants.H7, null));

        //linia 8
        squaresMap.put(Constants.A8, new Square(Constants.A8, null));
        squaresMap.put(Constants.B8, new Square(Constants.B8, null));
        squaresMap.put(Constants.C8, new Square(Constants.C8, null));
        squaresMap.put(Constants.D8, new Square(Constants.D8, null));
        squaresMap.put(Constants.E8, new Square(Constants.E8, null));
        squaresMap.put(Constants.F8, new Square(Constants.F8, null));
        squaresMap.put(Constants.G8, new Square(Constants.G8, null));
        squaresMap.put(Constants.H8, new Square(Constants.H8, null));


    }

  
    public HashMap<Integer,Square> getSquares(){
        return this.squaresMap;
    }

    public boolean isKingBinded(int srcPiece, Color pieceColor){
        return false;
    }

    public boolean isKingChecked(){
        return false;
    }


/*
    
    }*/
}
