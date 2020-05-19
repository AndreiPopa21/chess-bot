import java.util.ArrayList;

//enum cu toate culorile folosite in joc
enum Color{
    WHITE,
    BLACK,
    NOCOLOR
}


//clasa abstracta pentru orice tip de piesa de pe tabla
//metodele principale abstracte sunt searchMoves si isChecking
public abstract class Piece {
    private Color color;
    private Character name;
    private Table table;
    private int value;

    public Color getColor(){return this.color;}
    public Character getName(){return this.name;}
    public Table getTable(){return this.table;}
    public int getValue(){return this.value;}

    public void setColor(Color color){this.color = color;}
    public void setName(Character name){this.name = name;}
    public void setValue(int value){this.value = value;}
    public void setTable(Table table){this.table = table;}


    //metoda care apelata pe o anumita piesa, intoarce o lista cu toate mutarile
    //valide pentru acea piesa pe configuratia curenta din GameManager
    //o piesa nu isi stie niciodata pozitai actuala, de aceea e pasata ca argument
    public abstract ArrayList<Move> searchMoves(int src);


    //metoda care verifica daca piesa pune regele advers in sah
    //folosita cu precadere atunci cand se filtreaza mutarile pe piese
    public abstract boolean isChecking(int src, int king);


    //metoda care spune despre piesa curenta daca este rege, indiferent de culoare
    public boolean isKing(Piece piece){
        if(piece == null) {
            return false;
        }
        if(piece.getName().equals('K')) {
            return true;
        }
        if(piece.getName().equals('k')) {
            return true;
        }
        return false;
    }
}
