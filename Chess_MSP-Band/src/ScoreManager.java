import jdk.jfr.StackTrace;

import java.io.*;
import java.util.*;


public final class ScoreManager{

    static HashMap<Integer,StorageValue> valueMap = new HashMap<Integer,StorageValue>();

    //startValueMap, middleMap, lateM

    public static void readValue() {
        valueMap.put(Constants.A1,new StorageValue(-30,0,0,-50,-20,-20,20,0,0,-50,-20,-20));
        valueMap.put(Constants.A2,new StorageValue(-30,50,5,-40,-10,-10,20,5,-5,-40,-10,-10));
        valueMap.put(Constants.A3,new StorageValue(-30,10,-5,-30,-10,-10,-10,5,-5,-30,-10,-10));
        valueMap.put(Constants.A4,new StorageValue(-30,5,-5,-30,-5,-10,-20,0,-5,-30,0,-10));
        valueMap.put(Constants.A5,new StorageValue(-20,0,-5,-30,0,-10,-30,5,-5,-30,-5,-10));
        valueMap.put(Constants.A6,new StorageValue(-10,5,-5,-30,-10,-10,-30,10,-5,-30,-10,-10));
        valueMap.put(Constants.A7,new StorageValue(20,5,-5,-40,-10,-10,-30,50,5,-40,-10,-10));
        valueMap.put(Constants.A8,new StorageValue(20,0,0,-50,-20,-20,-30,0,0,-50,-20,-20));

        valueMap.put(Constants.B1,new StorageValue(-40,0,0,-40,-10,-10,30,0,0,-40,-10,-10));
        valueMap.put(Constants.B2,new StorageValue(-40,50,10,-20,0,0,20,10,0,-20,0,5));
        valueMap.put(Constants.B3,new StorageValue(-40,10,0,0,0,0,-20,-5,0,5,5,10));
        valueMap.put(Constants.B4,new StorageValue(-40,5,0,5,0,5,-30,0,0,0,0,0));
        valueMap.put(Constants.B5,new StorageValue(-30,0,0,0,0,0,-40,5,0,5,0,5));
        valueMap.put(Constants.B6,new StorageValue(-20,-5,0,5,5,10,-40,10,0,0,0,0));
        valueMap.put(Constants.B7,new StorageValue(20,10,0,-20,0,5,-40,50,10,-20,0,0));
        valueMap.put(Constants.B8,new StorageValue(30,0,0,-40,-10,-10,-40,0,0,-40,-10,-10));

        valueMap.put(Constants.C1,new StorageValue(-40,0,0,-30,-10,-10,10,0,0,-30,-10,-10));
        valueMap.put(Constants.C2,new StorageValue(-40,50,10,0,0,0,0,10,0,0,5,0));
        valueMap.put(Constants.C3,new StorageValue(-40,20,0,10,5,5,-20,-10,0,10,5,10));
        valueMap.put(Constants.C4,new StorageValue(-40,10,0,15,5,5,-30,0,0,15,5,10));
        valueMap.put(Constants.C5,new StorageValue(-30,0,0,15,5,10,-40,10,0,15,5,5));
        valueMap.put(Constants.C6,new StorageValue(-20,-10,0,10,5,10,-40,20,0,10,5,5));
        valueMap.put(Constants.C7,new StorageValue(0,10,0,0,5,0,-40,50,10,0,0,0));
        valueMap.put(Constants.C8,new StorageValue(10,0,0,-30,-10,-10,-40,0,0,-30,-10,-10));

        valueMap.put(Constants.D1,new StorageValue(-50,0,5,-30,-5,-10,0,0,5,-30,-5,-10));
        valueMap.put(Constants.D2,new StorageValue(-50,50,10,0,0,0,0,-20,0,5,0,0));
        valueMap.put(Constants.D3,new StorageValue(-50,30,0,15,5,10,-20,0,0,15,5,10));
        valueMap.put(Constants.D4,new StorageValue(-50,25,0,20,5,10,-40,20,0,20,5,10));
        valueMap.put(Constants.D5,new StorageValue(-40,20,0,20,5,10,-50,25,0,20,5,10));
        valueMap.put(Constants.D6,new StorageValue(-20,0,0,15,5,10,-50,30,0,15,5,10));
        valueMap.put(Constants.D7,new StorageValue(0,-20,0,5,0,0,-50,50,10,0,0,0));
        valueMap.put(Constants.D8,new StorageValue(0,0,5,-30,-5,-10,-50,0,5,-30,-5,-10));

        valueMap.put(Constants.E1,new StorageValue(-50,0,5,-30,-5,-10,0,0,5,-30,-5,-10));
        valueMap.put(Constants.E2,new StorageValue(-50,50,10,0,0,0,0,-20,0,5,0,0));
        valueMap.put(Constants.E3,new StorageValue(-50,30,0,15,5,10,-20,0,0,15,5,10));
        valueMap.put(Constants.E4,new StorageValue(-50,25,0,20,5,10,-40,20,0,20,5,10));
        valueMap.put(Constants.E5,new StorageValue(-40,20,0,20,5,10,-50,25,0,20,5,10));
        valueMap.put(Constants.E6,new StorageValue(-20,0,0,15,5,10,-50,30,0,15,5,10));
        valueMap.put(Constants.E7,new StorageValue(0,-20,0,5,0,0,-50,50,10,0,0,0));
        valueMap.put(Constants.E8,new StorageValue(0,0,5,-30,-5,-10,-50,0,5,-30,-5,-10));

        valueMap.put(Constants.F1,new StorageValue(-40,0,0,-30,-10,-10,10,0,0,-30,-10,-10));
        valueMap.put(Constants.F2,new StorageValue(-40,50,10,0,0,0,0,10,0,0,0,0));
        valueMap.put(Constants.F3,new StorageValue(-40,20,0,10,5,5,-20,-10,0,10,5,10));
        valueMap.put(Constants.F4,new StorageValue(-40,10,0,15,5,5,-30,0,0,15,5,10));
        valueMap.put(Constants.F5,new StorageValue(-30,0,0,15,5,10,-40,10,0,15,5,5));
        valueMap.put(Constants.F6,new StorageValue(-20,-10,0,10,5,10,-40,20,0,10,5,5));
        valueMap.put(Constants.F7,new StorageValue(0,10,0,0,0,0,-40,50,10,0,0,0));
        valueMap.put(Constants.F8,new StorageValue(10,0,0,-30,-10,-10,-40,0,0,-30,-10,-10));

        valueMap.put(Constants.G1,new StorageValue(-40,0,0,-40,-10,-10,30,0,0,-40,-10,-10));
        valueMap.put(Constants.G2,new StorageValue(-40,50,10,-20,0,0,20,10,0,-20,0,5));
        valueMap.put(Constants.G3,new StorageValue(-40,10,0,0,0,0,-20,-5,0,5,0,10));
        valueMap.put(Constants.G4,new StorageValue(-40,5,0,5,0,5,-30,0,0,0,0,0));
        valueMap.put(Constants.G5,new StorageValue(-30,0,0,0,0,0,-40,5,0,5,0,5));
        valueMap.put(Constants.G6,new StorageValue(-20,-5,0,5,0,10,-40,10,0,0,0,0));
        valueMap.put(Constants.G7,new StorageValue(20,10,0,-20,0,5,-40,50,10,-20,0,0));
        valueMap.put(Constants.G8,new StorageValue(30,0,0,-40,-10,-10,-40,0,0,-40,-10,-10));

        valueMap.put(Constants.H1,new StorageValue(-30,0,0,-50,-20,-20,20,0,0,-50,-20,-20));
        valueMap.put(Constants.H2,new StorageValue(-30,50,5,-40,-10,-10,20,5,-5,-40,-10,-10));
        valueMap.put(Constants.H3,new StorageValue(-30,10,-5,-30,-10,-10,-10,5,-5,-30,-10,-10));
        valueMap.put(Constants.H4,new StorageValue(-30,5,-5,-30,-5,-10,-20,0,-5,-30,-5,-10));
        valueMap.put(Constants.H5,new StorageValue(-20,0,-5,-30,-5,-10,-30,5,-5,-30,-5,-10));
        valueMap.put(Constants.H6,new StorageValue(-10,5,-5,-30,-10,-10,-30,10,-5,-30,-10,-10));
        valueMap.put(Constants.H7,new StorageValue(20,5,-5,-40,-10,-10,-30,50,5,-40,-10,-10));
        valueMap.put(Constants.H8,new StorageValue(20,0,0,-50,-20,-20,-30,0,0,-50,-20,-20));
    }


    public static int kingSaftey(HashMap<Integer,Square> h, int kingSpace, Color color){
        int score = 0;
        if (kingSpace != 0 ) {
            try {
                if (color == Color.BLACK) {
                    if (h.get(kingSpace - 1) != null){
                        if (h.get(kingSpace - 1).hasPiece()) {
                            if (h.get(kingSpace - 1).getPiece().getName() == 'p')
                                score += 20;
                            else
                                score -= 20;
                        }
                }
                    if (h.get((kingSpace - 10) - 1) != null) {
                        if  (h.get((kingSpace - 10) - 1).hasPiece()) {
                            if (h.get((kingSpace - 10) - 1).getPiece().getName() == 'p')
                                score += 20;
                            else
                                score -= 20;
                        }
                    }
                    if (h.get((kingSpace + 10) - 1) != null) {
                        if  (h.get((kingSpace + 10) - 1).hasPiece()) {
                            if ((h.get((kingSpace + 10) - 1) != null) && (h.get((kingSpace + 10) - 1).getPiece().getName() == 'p'))
                                score += 20;
                            else
                                score -= 20;
                        }
                    }
                } else {
                    if (h.get(kingSpace + 1)!= null) {
                        if (h.get(kingSpace + 1).hasPiece()) {
                            if (h.get(kingSpace + 1).getPiece().getName() == 'P')
                                score += 20;
                            else
                                score -= 20;
                        }
                    }
                    if (h.get((kingSpace - 10) + 1) != null){
                        if  (h.get((kingSpace - 10) + 1).hasPiece()) {
                            if (h.get((kingSpace - 10) + 1).getPiece().getName() == 'P')
                                score += 20;
                            else
                                score -= 20;
                        }
                    }
                    if (h.get((kingSpace + 10) + 1) != null) {
                        if  (h.get((kingSpace + 10) + 1).hasPiece()) {
                            if ((h.get((kingSpace + 10) + 1) != null) && (h.get((kingSpace + 10) + 1).getPiece().getName() == 'P'))
                                score += 20;
                            else
                                score -= 20;
                        }
                    }
                }
            } catch (Exception out) {
                System.out.println("Eroare: " + out);

            }
        }
        return score;
    }

    public static int greatEvaluate(Table h, Color maxi, Color mini){

        //TODO: phase game - inca 2 mape de scoruri
        // King Safety +10, +10, -10 | + 10 + phase_factor
        // Bishops  - daca are amandoi nebuni +bonus
        // ? Q-search
        // three-fold move

        //int late_score = getScore(pozitie) + phase

       // int[] pawnsSpace = new int[8]; //pozitiile pionilor
       // int kingSpace; //pozitia regelui
        //->King Safety
        //981 991 1021
        //ArrayList<Integer> myPieces
       
        //score_curent += kingSafty()

       // int[] bishops  = new int[2];
            //int[] knights = new int[2];
       // int score = //functie scor in functie de pozitie
       // score = //functie kong-safety (score)

        int kingSpaceBlk = 0, kingSpaceWhi = 0;
        int scoremaxi = 0, scoremini = 0 ;

        ArrayList<Integer> pons_pozition = new ArrayList<Integer>();
        ArrayList<Integer> bishop_pozition = new ArrayList<Integer>();
        ArrayList<Integer> queen_pozition = new ArrayList<Integer>();
        ArrayList<Integer> knight_pozition = new ArrayList<Integer>();
        ArrayList<Integer> rook_pozition = new ArrayList<Integer>();

        ArrayList<Integer> pons_pozition_whi = new ArrayList<Integer>();
        ArrayList<Integer> bishop_pozition_whi = new ArrayList<Integer>();
        ArrayList<Integer> queen_pozition_whi = new ArrayList<Integer>();
        ArrayList<Integer> knight_pozition_whi = new ArrayList<Integer>();
        ArrayList<Integer> rook_pozition_whi = new ArrayList<Integer>();


        int nrblk = 0, nrwhi = 0;
        int tablePozition;
        for (Map.Entry<Integer,Square> i : h.getSquares().entrySet()) {
            Square elem = i.getValue();
            if (elem.hasPiece()) {
                tablePozition = i.getKey();
                if (elem.getPiece().getColor() == maxi){
                  //  System.out.println("QWERTYUIO");
                    if (maxi == Color.BLACK) {
                        if (elem.getPiece().getName() == 'k') {

                            kingSpaceBlk = elem.getPosition();
                            //  System.out.println("Rege NEGRU gasit pe ==="+kingSpaceWhi);

                        } else if (elem.getPiece().getName() == 'p') {
                            pons_pozition.add(elem.getPosition());
                        } else if (elem.getPiece().getName() == 'b') {
                            bishop_pozition.add(elem.getPosition());
                        }
                    } else {
                        if (elem.getPiece().getName() == 'K') {

                            kingSpaceWhi = elem.getPosition();
                            //  System.out.println("Rege NEGRU gasit pe ==="+kingSpaceWhi);

                        } else if (elem.getPiece().getName() == 'P') {
                            pons_pozition_whi.add(elem.getPosition());
                        } else if (elem.getPiece().getName() == 'B') {
                            bishop_pozition_whi.add(elem.getPosition());
                        }
                    }
                    nrblk++;
                    scoremaxi += ScoreManager.getScore(elem.getPiece(),tablePozition,h.getRemainingBlack()+h.getRemainingWhite());
                } else if (elem.getPiece().getColor() == mini) {
                  //  System.out.println("QWERTYUIO");
                    if (mini == Color.BLACK) {
                        if (elem.getPiece().getName() == 'k') {

                            kingSpaceBlk = elem.getPosition();
                            //  System.out.println("Rege NEGRU gasit pe ==="+kingSpaceWhi);

                        } else if (elem.getPiece().getName() == 'p') {
                            pons_pozition.add(elem.getPosition());
                        } else if (elem.getPiece().getName() == 'b') {
                            bishop_pozition.add(elem.getPosition());
                        }
                    } else {
                        if (elem.getPiece().getName() == 'K') {

                            kingSpaceWhi = elem.getPosition();
                            //  System.out.println("Rege NEGRU gasit pe ==="+kingSpaceWhi);

                        } else if (elem.getPiece().getName() == 'P') {
                            pons_pozition_whi.add(elem.getPosition());
                        } else if (elem.getPiece().getName() == 'B') {
                            bishop_pozition_whi.add(elem.getPosition());
                        }
                    }
                    scoremini += ScoreManager.getScore(elem.getPiece(),tablePozition,h.getRemainingBlack()+h.getRemainingWhite());
                    nrwhi++;
                }
            }
        }

        //System.out.println("nr alb nr negru"+nrblk+"---"+nrblk);
          //  System.out.println(kingSpaceBlk+"   "+"Rege negru");
        if (maxi == Color.BLACK) {
            scoremaxi += kingSaftey(h.getSquares(), kingSpaceBlk, maxi);
            if (bishop_pozition.size() == 2) {
                scoremaxi += 10;
            }else if (bishop_pozition.size() == 1)
                scoremaxi += 5;

        } else {
            scoremaxi += kingSaftey(h.getSquares(), kingSpaceWhi, maxi);
            if (bishop_pozition_whi.size() == 2) {
                scoremaxi += 10;
            }else if (bishop_pozition_whi.size() == 1)
                scoremaxi += 5;

        }


        if (mini == Color.BLACK) {
            scoremini += kingSaftey(h.getSquares(), kingSpaceBlk, maxi);
            if (bishop_pozition.size() == 2) {
                scoremini += 10;
            }else if (bishop_pozition.size() == 1)
                scoremini += 5;

        } else {
            scoremini += kingSaftey(h.getSquares(), kingSpaceWhi, maxi);
            if (bishop_pozition_whi.size() == 2) {
                scoremini += 10;
            }else if (bishop_pozition_whi.size() == 1)
                scoremini += 5;

        }

        return scoremaxi - scoremini ;
    }

    //int king-Safety(int kingSpace, int[] pawnSpaces)



    public static int getScore(Piece p, int pozition, int nrpiese){

       int factor = 20 - new Random().nextInt(40);
        //int factor = 0;
        int start = 28,middle = 18 ;

        if (nrpiese > start) {
            if (p.getName() == 'p') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).pawnValN + factor;
            } else if (p.getName() == 'n') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).KnightValN + factor;
            } else if (p.getName() == 'k') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).KingValN + factor;
            } else if (p.getName() == 'b') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).BishopValN + factor;
            } else if (p.getName() == 'q') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).QueenValN + factor;
            } else if (p.getName() == 'r') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).RookValN + factor;
            } else if (p.getName() == 'P') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).pawnVal + factor;
            } else if (p.getName() == 'N') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).KnightVal + factor;
            } else if (p.getName() == 'K') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).KingVal + factor;
            } else if (p.getName() == 'B') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).BishopVal + factor;
            } else if (p.getName() == 'Q') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).QueenVal + factor;
            } else if (p.getName() == 'R') {
                return p.getValue() + PhaseScores.startValueMap.get(pozition).RookVal + factor;
            }
        } else if ((nrpiese <=start )&& (nrpiese >middle)) {
            if (p.getName() == 'p') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).pawnValN + factor;
            } else if (p.getName() == 'n') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).KnightValN + factor;
            } else if (p.getName() == 'k') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).KingValN + factor;
            } else if (p.getName() == 'b') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).BishopValN + factor;
            } else if (p.getName() == 'q') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).QueenValN + factor;
            } else if (p.getName() == 'r') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).RookValN + factor;
            } else if (p.getName() == 'P') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).pawnVal + factor;
            } else if (p.getName() == 'N') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).KnightVal + factor;
            } else if (p.getName() == 'K') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).KingVal + factor;
            } else if (p.getName() == 'B') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).BishopVal + factor;
            } else if (p.getName() == 'Q') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).QueenVal + factor;
            } else if (p.getName() == 'R') {
                return p.getValue() + PhaseScores.middleValueMap.get(pozition).RookVal + factor;
            }
        } else if (nrpiese <= middle){
            if (p.getName() == 'p') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).pawnValN + factor;
            } else if (p.getName() == 'n') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).KnightValN + factor;
            } else if (p.getName() == 'k') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).KingValN + factor;
            } else if (p.getName() == 'b') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).BishopValN + factor;
            } else if (p.getName() == 'q') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).QueenValN + factor;
            } else if (p.getName() == 'r') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).RookValN + factor;
            } else if (p.getName() == 'P') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).pawnVal + factor;
            } else if (p.getName() == 'N') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).KnightVal + factor;
            } else if (p.getName() == 'K') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).KingVal + factor;
            } else if (p.getName() == 'B') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).BishopVal + factor;
            } else if (p.getName() == 'Q') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).QueenVal + factor;
            } else if (p.getName() == 'R') {
                return p.getValue() + PhaseScores.lateValueMap.get(pozition).RookVal + factor;
            }
        }
        return 0;

    }

    //table


} 