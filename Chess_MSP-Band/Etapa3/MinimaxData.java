    //clasa MinimaxData este utilizata de Minimax pentru encapsula informatii
    //clasa retine o mutare si scorul obtinut aplicandu-se acea mutare
    public class MinimaxData{
        public Move move;
        public int score;
        public MinimaxData(Move move, int score){
            this.move = move;
            this.score = score;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(move.toString());
            sb.append(" - ");
            sb.append(score);
            return sb.toString();
        }
    }