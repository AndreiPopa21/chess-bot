enum MoveType{
    CAPTURE,
    NORMAL,
    CHECKS
}

public class Move {
    public int source;
    public int dest;
    public MoveType moveType;

    public Move(int source, int dest, MoveType moveType){
        this.source = source;
        this.dest = dest;
        this.moveType = moveType;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int srcRow = source % 10;
        int srcCol = source / 10;
        int destRow = dest % 10;
        int destCol = dest / 10;

        sb.append((char)srcCol);
        sb.append(srcRow);
        sb.append((char)destCol);
        sb.append(destRow);

        return sb.toString();
    }
}