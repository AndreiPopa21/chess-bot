 public class Square{
    public int row;
    public int column;
    private Piece piece;
    
    public Square(int row, int column){
        piece = null;
        this.row = row;
        this.column = column;
    }
    
    public boolean hasPiece(){
        return (piece == null)? false: true;
    }
    public void setPiece(Piece piece){this.piece = piece;}
    public Piece getPiece(){return this.piece;} 
}