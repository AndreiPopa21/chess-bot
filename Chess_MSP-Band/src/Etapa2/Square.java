 
//clasa care abstractizeaza un patratel de pe tabla
//el detine pozitia pe care o reprezinta si piesa curenta de pe el
//cand se muta/captureaza piesa, setPiece() este metoda apelata frecvent 
public class Square{
   
    private Piece piece;
    private int position;
    
    public Square(int position, Piece piece){
        this.piece = piece;
        this.position = position;
    }
    
    //metoda care verifica existenta unei piese pe patratul de joc
    //intoarce NULL in cazul in care patratul nu are nicio piesa
    //risc mare de NullPointerException
    public boolean hasPiece(){
        return (piece == null)? false: true;
    }

    //metoda cae updateaza noua piesa de pe patratel
    public void setPiece(Piece piece){this.piece = piece;}
    public Piece getPiece(){return this.piece;} 
    public int getPosition() {return this.position;}
}