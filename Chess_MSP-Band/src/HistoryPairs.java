//clasa care reprezinta un entry in istoricul din GameManager
//detine toate informatiile despre o mutare
public class HistoryPairs {
    int startPosition;
    int finishPosition;
    char piece;
    Move mv;

    HistoryPairs(int startPosition, int finishPosition, char piece, Move mv) {
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
        this.piece = piece;
        this.mv = mv;
    }

}
