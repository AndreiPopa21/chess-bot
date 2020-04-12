enum MoveType{
    CAPTURE,
    NORMAL,
    CHECKS
}

public class Move{
    public int source;
    public int dest;
    public MoveType moveType;

    public Move(int source, int dest, MoveType moveType){
        this.source = source;
        this.dest = dest;
        this.moveType = moveType;
    }

   
}