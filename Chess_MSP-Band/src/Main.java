public class Main {

    public static void main(String[] args) {
        
       //se asculta in while-ul infinit comenzile venite de la Xboard
       PhaseScores.feedStart();
       PhaseScores.feedMiddle();
       PhaseScores.feedLate();

       ReceiverXboard.receive();

    }
}
