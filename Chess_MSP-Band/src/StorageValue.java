
class StorageValue{
    int KingValN;
    int pawnValN;
    int RookValN;
    int KnightValN;
    int QueenValN;
    int BishopValN;
    int KingVal;
    int pawnVal;
    int RookVal;
    int KnightVal;
    int QueenVal;
    int BishopVal;

   /* Vector<Pair> whitePair = new Vector<Pair>();
    Vector<Pair> balckPair = new Vector<Pair>();*/

    StorageValue( int KingValN,
                  int pawnValN,
                  int RookValN,
                  int KnightValN,
                  int QueenValN,
                  int BishopValN,
                  int KingVal,
                  int pawnVal,
                  int RookVal,
                  int KnightVal,
                  int QueenVal,
                  int BishopVal){

        this.KingVal = KingVal;
        this.pawnVal = pawnVal;
        this.RookVal = RookVal;
        this.KnightVal = KnightVal;
        this.QueenVal = QueenVal;
        this.BishopVal = BishopVal;
        this.KingValN = KingValN;
        this.pawnValN = pawnValN;
        this.RookValN = RookValN;
        this.KnightValN = KnightValN;
        this.QueenValN = QueenValN;
        this.BishopValN = BishopValN;
    }

}