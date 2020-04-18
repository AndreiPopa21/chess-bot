public class HistoryPairs {
    int startPosition;
    int finishPosition;
    char piece;

    //TODO Adauga un camp pentru un obiect de tip Move, ajuta la Minimax

    HistoryPairs(int startPosition, int finishPosition, char piece) {
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;


        this.piece = piece;
    }

}
