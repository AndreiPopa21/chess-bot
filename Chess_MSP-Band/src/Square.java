 public class Square{
   
    private Piece piece;
    private int position;
    
    public Square(int position, Piece piece){
        this.piece = piece;
        this.position = position;
    }
    
    public boolean hasPiece(){
        return (piece == null)? false: true;
    }
    public void setPiece(Piece piece){this.piece = piece;}
    public Piece getPiece(){return this.piece;} 
    public int getPosition() {return this.position;}
}