import java.util.HashMap;


public final class PhaseScores {

    public static HashMap<Integer,StorageValue> startValueMap =
        new HashMap<>();
    
    public static HashMap<Integer,StorageValue> middleValueMap = 
        new HashMap<>();

    public static HashMap<Integer,StorageValue> lateValueMap = 
        new HashMap<>();


    /*-------------------START PHASE ----------------------------*/
    public static void feedStart(){

        startValueMap.put(Constants.A1,new StorageValue(-30,0,0,-50,-20,-20,20,0,0,-50,-20,-20));
        startValueMap.put(Constants.A2,new StorageValue(-30,50,5,-40,-10,-10,20,5,-5,-40,-10,-10));
        startValueMap.put(Constants.A3,new StorageValue(-30,10,-5,-30,-10,-10,-10,5,-5,-30,-10,-10));
        startValueMap.put(Constants.A4,new StorageValue(-30,5,-5,-30,-5,-10,-20,0,-5,-30,0,-10));
        startValueMap.put(Constants.A5,new StorageValue(-20,0,-5,-30,0,-10,-30,5,-5,-30,-5,-10));
        startValueMap.put(Constants.A6,new StorageValue(-10,5,-5,-30,-10,-10,-30,10,-5,-30,-10,-10));
        startValueMap.put(Constants.A7,new StorageValue(20,5,-5,-40,-10,-10,-30,50,5,-40,-10,-10));
        startValueMap.put(Constants.A8,new StorageValue(20,0,0,-50,-20,-20,-30,0,0,-50,-20,-20));

        startValueMap.put(Constants.B1,new StorageValue(-40,0,0,-40,-10,-10,30,0,0,-40,-10,-10));
        startValueMap.put(Constants.B2,new StorageValue(-40,50,10,-20,0,0,20,10,0,-20,0,5));
        startValueMap.put(Constants.B3,new StorageValue(-40,10,0,0,0,0,-20,-5,0,5,5,10));
        startValueMap.put(Constants.B4,new StorageValue(-40,5,0,5,0,5,-30,0,0,0,0,0));
        startValueMap.put(Constants.B5,new StorageValue(-30,0,0,0,0,0,-40,5,0,5,0,5));
        startValueMap.put(Constants.B6,new StorageValue(-20,-5,0,5,5,10,-40,10,0,0,0,0));
        startValueMap.put(Constants.B7,new StorageValue(20,10,0,-20,0,5,-40,50,10,-20,0,0));
        startValueMap.put(Constants.B8,new StorageValue(30,0,0,-40,-10,-10,-40,0,0,-40,-10,-10));

        startValueMap.put(Constants.C1,new StorageValue(-40,0,0,-30,-10,-10,10,0,0,-30,-10,-10));
        startValueMap.put(Constants.C2,new StorageValue(-40,50,10,0,0,0,0,10,0,0,5,0));
        startValueMap.put(Constants.C3,new StorageValue(-40,20,0,10,5,5,-20,-10,0,10,5,10));
        startValueMap.put(Constants.C4,new StorageValue(-40,10,0,15,5,5,-30,0,0,15,5,10));
        startValueMap.put(Constants.C5,new StorageValue(-30,0,0,15,5,10,-40,10,0,15,5,5));
        startValueMap.put(Constants.C6,new StorageValue(-20,-10,0,10,5,10,-40,20,0,10,5,5));
        startValueMap.put(Constants.C7,new StorageValue(0,10,0,0,5,0,-40,50,10,0,0,0));
        startValueMap.put(Constants.C8,new StorageValue(10,0,0,-30,-10,-10,-40,0,0,-30,-10,-10));

        startValueMap.put(Constants.D1,new StorageValue(-50,0,5,-30,-5,-10,0,0,5,-30,-5,-10));
        startValueMap.put(Constants.D2,new StorageValue(-50,50,10,0,0,0,0,-20,0,5,0,0));
        startValueMap.put(Constants.D3,new StorageValue(-50,30,0,15,5,10,-20,0,0,15,5,10));
        startValueMap.put(Constants.D4,new StorageValue(-50,25,0,20,5,10,-40,20,0,20,5,10));
        startValueMap.put(Constants.D5,new StorageValue(-40,20,0,20,5,10,-50,25,0,20,5,10));
        startValueMap.put(Constants.D6,new StorageValue(-20,0,0,15,5,10,-50,30,0,15,5,10));
        startValueMap.put(Constants.D7,new StorageValue(0,-20,0,5,0,0,-50,50,10,0,0,0));
        startValueMap.put(Constants.D8,new StorageValue(0,0,5,-30,-5,-10,-50,0,5,-30,-5,-10));

        startValueMap.put(Constants.E1,new StorageValue(-50,0,5,-30,-5,-10,0,0,5,-30,-5,-10));
        startValueMap.put(Constants.E2,new StorageValue(-50,50,10,0,0,0,0,-20,0,5,0,0));
        startValueMap.put(Constants.E3,new StorageValue(-50,30,0,15,5,10,-20,0,0,15,5,10));
        startValueMap.put(Constants.E4,new StorageValue(-50,25,0,20,5,10,-40,20,0,20,5,10));
        startValueMap.put(Constants.E5,new StorageValue(-40,20,0,20,5,10,-50,25,0,20,5,10));
        startValueMap.put(Constants.E6,new StorageValue(-20,0,0,15,5,10,-50,30,0,15,5,10));
        startValueMap.put(Constants.E7,new StorageValue(0,-20,0,5,0,0,-50,50,10,0,0,0));
        startValueMap.put(Constants.E8,new StorageValue(0,0,5,-30,-5,-10,-50,0,5,-30,-5,-10));

        startValueMap.put(Constants.F1,new StorageValue(-40,0,0,-30,-10,-10,10,0,0,-30,-10,-10));
        startValueMap.put(Constants.F2,new StorageValue(-40,50,10,0,0,0,0,10,0,0,0,0));
        startValueMap.put(Constants.F3,new StorageValue(-40,20,0,10,5,5,-20,-10,0,10,5,10));
        startValueMap.put(Constants.F4,new StorageValue(-40,10,0,15,5,5,-30,0,0,15,5,10));
        startValueMap.put(Constants.F5,new StorageValue(-30,0,0,15,5,10,-40,10,0,15,5,5));
        startValueMap.put(Constants.F6,new StorageValue(-20,-10,0,10,5,10,-40,20,0,10,5,5));
        startValueMap.put(Constants.F7,new StorageValue(0,10,0,0,0,0,-40,50,10,0,0,0));
        startValueMap.put(Constants.F8,new StorageValue(10,0,0,-30,-10,-10,-40,0,0,-30,-10,-10));

        startValueMap.put(Constants.G1,new StorageValue(-40,0,0,-40,-10,-10,30,0,0,-40,-10,-10));
        startValueMap.put(Constants.G2,new StorageValue(-40,50,10,-20,0,0,20,10,0,-20,0,5));
        startValueMap.put(Constants.G3,new StorageValue(-40,10,0,0,0,0,-20,-5,0,5,0,10));
        startValueMap.put(Constants.G4,new StorageValue(-40,5,0,5,0,5,-30,0,0,0,0,0));
        startValueMap.put(Constants.G5,new StorageValue(-30,0,0,0,0,0,-40,5,0,5,0,5));
        startValueMap.put(Constants.G6,new StorageValue(-20,-5,0,5,0,10,-40,10,0,0,0,0));
        startValueMap.put(Constants.G7,new StorageValue(20,10,0,-20,0,5,-40,50,10,-20,0,0));
        startValueMap.put(Constants.G8,new StorageValue(30,0,0,-40,-10,-10,-40,0,0,-40,-10,-10));

        startValueMap.put(Constants.H1,new StorageValue(-30,0,0,-50,-20,-20,20,0,0,-50,-20,-20));
        startValueMap.put(Constants.H2,new StorageValue(-30,50,5,-40,-10,-10,20,5,-5,-40,-10,-10));
        startValueMap.put(Constants.H3,new StorageValue(-30,10,-5,-30,-10,-10,-10,5,-5,-30,-10,-10));
        startValueMap.put(Constants.H4,new StorageValue(-30,5,-5,-30,-5,-10,-20,0,-5,-30,-5,-10));
        startValueMap.put(Constants.H5,new StorageValue(-20,0,-5,-30,-5,-10,-30,5,-5,-30,-5,-10));
        startValueMap.put(Constants.H6,new StorageValue(-10,5,-5,-30,-10,-10,-30,10,-5,-30,-10,-10));
        startValueMap.put(Constants.H7,new StorageValue(20,5,-5,-40,-10,-10,-30,50,5,-40,-10,-10));
        startValueMap.put(Constants.H8,new StorageValue(20,0,0,-50,-20,-20,-30,0,0,-50,-20,-20));


    }

    //KingN, PawnN, RookN, KnightN, QueenN, BishopN, 
    //King, Pawn, Rook, Knight, Queen, Bishop


    /*------------------MIDDLE PHASE-----------------------------*/ 
    public static void feedMiddle(){


        middleValueMap.put(Constants.A8, new StorageValue( 30, 0, 10, -50, -20, -20, -30, 0, 0, -30, -20, -20 ));
        middleValueMap.put(Constants.B8, new StorageValue( 40, 0, 10, -40, -10, -10, -40, 0, 0, -10, -10, -10 ));
        middleValueMap.put(Constants.C8, new StorageValue( 20, 0, 10, -30, -10, -10, -40, 0, 0, 0, 5, -10 ));
        middleValueMap.put(Constants.D8, new StorageValue( 0, 0, 20, -30, 5, -10, -50, 0, 0, 0, 5, -10 ));
        middleValueMap.put(Constants.E8, new StorageValue( 0, 0, 20, -30, 5, -10, -50, 0, 0, 0, 5, -10 ));
        middleValueMap.put(Constants.F8, new StorageValue( 20, 0, 10, -30, -10, -10, -40, 0, 0, 0, 5, -10 ));
        middleValueMap.put(Constants.G8, new StorageValue( 40, 0, 10, -40, -10, -10, -40, 0, 0, -10, -10, -10 ));
        middleValueMap.put(Constants.H8, new StorageValue( 30, 0, 10, -50, -20, -20, -30, 0, 0, -30, -20, -20 ));

        middleValueMap.put(Constants.A7, new StorageValue( 20, 5, 0, -40, -10, -10, -30, 50, 10, -30, -5, -10 ));
        middleValueMap.put(Constants.B7, new StorageValue( 20, 10, 5, -20, 5, 5, -40, 50, 15, 10, 5, 5 ));
        middleValueMap.put(Constants.C7, new StorageValue( 0, 10, 5, 0, 10, 5, -40, 50, 15, 10, 5, 5 ));
        middleValueMap.put(Constants.D7, new StorageValue( 0, -20, 5, 5, 5, 5, -50, 50, 15, 10, 10, 5 ));
        middleValueMap.put(Constants.E7, new StorageValue( 0, -20, 5, 5, 5, 5, -50, 50, 15, 10, 10, 5 ));
        middleValueMap.put(Constants.F7, new StorageValue( 0, 10, 5, 0, 10, 5, -40, 50, 15, 10, 5, 5 ));
        middleValueMap.put(Constants.G7, new StorageValue( 20, 10, 5, -20, 5, 5, -40, 50, 15, 10, 5, 5 ));
        middleValueMap.put(Constants.H7, new StorageValue( 20, 5, 0, -40, -10, -10, -30, 50, 10, -30, -5, -10 ));

        middleValueMap.put(Constants.A6, new StorageValue( -10, 5, 0, -30, -5, -10, -30, 10, 0, -30, -5, -10 ));
        middleValueMap.put(Constants.B6, new StorageValue( -20, -5, 0, 10, 10, 10, -40, 10, 0, 15, 10, 10 ));
        middleValueMap.put(Constants.C6, new StorageValue( -20, -10, 0, 15, 10, 10, -40, 20, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.D6, new StorageValue( -20, 0, 5, 20, 10, 10, -50, 30, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.E6, new StorageValue( -20, 0, 5, 20, 10, 10, -50, 30, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.F6, new StorageValue( -20, -10, 0, 15, 10, 10, -40, 20, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.G6, new StorageValue( -20, -5, 0, 10, 10, 10, -40, 10, 0, 15, 10, 10 ));
        middleValueMap.put(Constants.H6, new StorageValue( -10, 5, 0, -30, -5, -10, -30, 10, 0, -30, -5, -10 ));

        middleValueMap.put(Constants.A5, new StorageValue( -20, 0, 0, -20, 0, -10, -30, 5, 0, -20, 10, -10 ));
        middleValueMap.put(Constants.B5, new StorageValue( -30, 0, 0, 10, 10, 10, -40, 5, 0, 15, 15, 15 ));
        middleValueMap.put(Constants.C5, new StorageValue( -30, 0, 0, 20, 15, 15, -40, 10, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.D5, new StorageValue( -40, 20, 0, 25, 15, 15, -50, 25, 0, 25, 20, 15 ));
        middleValueMap.put(Constants.E5, new StorageValue( -40, 20, 0, 25, 15, 15, -50, 25, 0, 25, 20, 15 ));
        middleValueMap.put(Constants.F5, new StorageValue( -30, 0, 0, 20, 15, 15, -40, 10, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.G5, new StorageValue( -30, 0, 0, 10, 10, 10, -40, 5, 0, 15, 15, 15 ));
        middleValueMap.put(Constants.H5, new StorageValue( -20, 0, 0, -20, 0, -10, -30, 5, 0, -20, 10, 10 ));

        middleValueMap.put(Constants.A4, new StorageValue( -30, 5, 0, -20, 10, -10, -20, 0, 0, -20, 0, -10 ));
        middleValueMap.put(Constants.B4, new StorageValue( -40, 5, 0, 15, 15, 15, -30, 0, 0, 10, 10, 10 ));
        middleValueMap.put(Constants.C4, new StorageValue( -40, 10, 0, 20, 15, 15, -30, 0, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.D4, new StorageValue( -50, 25, 0, 25, 20, 15, -40, 20, 0, 25, 15, 15 ));
        middleValueMap.put(Constants.E4, new StorageValue( -50, 25, 0, 25, 20, 15, -40, 20, 0, 25, 15, 15 ));
        middleValueMap.put(Constants.F4, new StorageValue( -40, 10, 0, 20, 15, 15, -30, 0, 0, 20, 15, 15 ));
        middleValueMap.put(Constants.G4, new StorageValue( -40, 5, 0, 15, 15, 15, -30, 0, 0, 10, 10, 10 ));
        middleValueMap.put(Constants.H4, new StorageValue( -30, 5, 0, -20, 10, -10, -20, 0, 0, -20, 0, -10 ));

        middleValueMap.put(Constants.A3, new StorageValue( -30, 10, 0, -30, -5, -10, -10, 5, 0, -30, -5, -10 ));
        middleValueMap.put(Constants.B3, new StorageValue( -40, 10, 0, 15, 10, 10, -20, -5, 0, 10, 10, 10 ));
        middleValueMap.put(Constants.C3, new StorageValue( -40, 20, 0, 20, 15, 15, -20, -10, 0, 15, 10, 10 ));
        middleValueMap.put(Constants.D3, new StorageValue( -50, 30, 0, 20, 15, 15, -20, 0, 5, 20, 10, 10 ));
        middleValueMap.put(Constants.E3, new StorageValue( -50, 30, 0, 20, 15, 15, -20, 0, 5, 20, 10, 10 ));
        middleValueMap.put(Constants.F3, new StorageValue( -40, 20, 0, 20, 15, 15, -20, -10, 0, 15, 10, 10 ));
        middleValueMap.put(Constants.G3, new StorageValue( -40, 10, 0, 15, 10, 10, -20, -5, 0, 10, 10, 10 ));
        middleValueMap.put(Constants.H3, new StorageValue( -30, 10, 0, -30, -5, -10, -10, 5, 0, -30, -5, -10 ));

        middleValueMap.put(Constants.A2, new StorageValue( -30, 50, 10, -30, -5, -10, 20, 5, 0, -40, -10, -10 ));
        middleValueMap.put(Constants.B2, new StorageValue( -40, 50, 15, 10, 5, 5, 20, 10, 5, -20, 5, 5 ));
        middleValueMap.put(Constants.C2, new StorageValue( -40, 50, 15, 10, 5, 5, 0, 10, 5, 0, 10, 5 ));
        middleValueMap.put(Constants.D2, new StorageValue( -50, 50, 15, 10, 10, 5, 0, -20, 5, 5, 5, 5 ));
        middleValueMap.put(Constants.E2, new StorageValue( -50, 50, 15, 10, 10, 5, 0, -20, 5, 5, 5, 5 ));
        middleValueMap.put(Constants.F2, new StorageValue( -40, 50, 15, 10, 5, 5, 0, 10, 5, 0, 10, 5 ));
        middleValueMap.put(Constants.G2, new StorageValue( -40, 50, 15, 10, 5, 5, 20, 10, 5, -20, 5, 5 ));
        middleValueMap.put(Constants.H2, new StorageValue( -30, 50, 10, -30, -5, -10, 20, 5, 0, -40, -10, -10 ));

        middleValueMap.put(Constants.A1, new StorageValue( -30, 0, 0, -30, -20, -20, 30, 0, 10, -50, -20, -20 ));
        middleValueMap.put(Constants.B1, new StorageValue( -40, 0, 0, -10, -10, -10, 40, 0, 10, -40, -10, -10 ));
        middleValueMap.put(Constants.C1, new StorageValue( -40, 0, 0, 0, 5, -10, 20, 0, 10, -30, -10, -10 ));
        middleValueMap.put(Constants.D1, new StorageValue( -50, 0, 0, 0, 5, -10, 0, 0, 20, -30, 5, -10 ));
        middleValueMap.put(Constants.E1, new StorageValue( -50, 0, 0, 0, 5, -10, 0, 0, 20, -30, 5, -10 ));
        middleValueMap.put(Constants.F1, new StorageValue( -40, 0, 0, 0, 5, -10, 20, 0, 10, -30, -10, -10 ));
        middleValueMap.put(Constants.G1, new StorageValue( -40, 0, 0, -10, -10, -10, 40, 0, 10, -40, -10, -10 ));
        middleValueMap.put(Constants.H1, new StorageValue( -30, 0, 0, -30, -20, -20, 30, 0, 10, -50, -20, -20 ));
    }




    /*--------------------LATE PHASE-----------------------------*/ 
    public static void feedLate(){

        lateValueMap.put(Constants.A8, new StorageValue( 20, 0, 10, -60, -20, -10, -30, 60, 10, -30, 5, -10 ));
        lateValueMap.put(Constants.B8, new StorageValue( 10, 0, 20, -40, -5, -10, -20, 60, 20, -10, 10, -10 ));
        lateValueMap.put(Constants.C8, new StorageValue( 10, 0, 30, -30, -5, 0, -20, 60, 30, 5, 10, 5 ));
        lateValueMap.put(Constants.D8, new StorageValue( 10, 0, 30, -20, 5, 5, -20, 60, 30, 5, 10, 5 ));
        lateValueMap.put(Constants.E8, new StorageValue( 10, 0, 30, -20, 5, 5, -20, 60, 30, 5, 10, 5 ));
        lateValueMap.put(Constants.F8, new StorageValue( 10, 0, 30, -30, -5, 0, -20, 60, 30, 5, 10, 5 ));
        lateValueMap.put(Constants.G8, new StorageValue( 10, 0, 20, -40, -5, -10, -20, 60, 20, -10, 10, -10 ));
        lateValueMap.put(Constants.H8, new StorageValue( 20, 0, 10, -60, -20, -10, -30, 60, 10, -30, 5, -10 ));
        
        lateValueMap.put(Constants.A7, new StorageValue( 20, 0, 10, -40, 0, -5, -20, 90, 10, -20, 10, -5 ));
        lateValueMap.put(Constants.B7, new StorageValue( 20, 5, 20, -20, 15, 10, -5, 90, 20, 10, 25, 10 ));
        lateValueMap.put(Constants.C7, new StorageValue( 20, 5, 30, 5, 20, 10, -5, 90, 30, 10, 25, 10 ));
        lateValueMap.put(Constants.D7, new StorageValue( 10, -25, 30, 10, 20, 10, -5, 90, 30, 15, 25, 10 ));
        lateValueMap.put(Constants.E7, new StorageValue( 10, -25, 30, 10, 20, 10, -5, 90, 30, 15, 25, 10 ));
        lateValueMap.put(Constants.F7, new StorageValue( 20, 5, 30, 5, 20, 10, -5, 90, 30, 10, 25, 10 ));
        lateValueMap.put(Constants.G7, new StorageValue( 20, 5, 20, -20, 15, 10, -5, 90, 20, 10, 25, 10 ));
        lateValueMap.put(Constants.H7, new StorageValue( 20, 0, 10, -40, 0, -5, -20, 90, 10, -20, 10, -5 ));
        
        lateValueMap.put(Constants.A6, new StorageValue( 10, 5, 15, -20, 10, -5, -10, 50, 15, -20, 15, -5 ));
        lateValueMap.put(Constants.B6, new StorageValue( 15, 5, 25, 10, 25, 10, 0, 50, 25, 10, 25, 10 ));
        lateValueMap.put(Constants.C6, new StorageValue( 15, 10, 30, 20, 35, 15, 0, 60, 30, 20, 35, 15 ));
        lateValueMap.put(Constants.D6, new StorageValue( 10, 15, 30, 25, 35, 15, 5, 60, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.E6, new StorageValue( 10, 15, 30, 25, 35, 15, 5, 60, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.F6, new StorageValue( 15, 10, 30, 20, 35, 15, 0, 60, 30, 20, 35, 15 ));
        lateValueMap.put(Constants.G6, new StorageValue( 15, 5, 25, 10, 25, 10, 0, 50, 25, 10, 25, 10 ));
        lateValueMap.put(Constants.H6, new StorageValue( 10, 5, 15, -20, 10, -5, -10, 50, 15, -20, 15, -5 ));
        
        lateValueMap.put(Constants.A5, new StorageValue( 10, 5, 15, -20, 15, -5, 0, 30, 15, -20, 20, -5 ));
        lateValueMap.put(Constants.B5, new StorageValue( 10, 5, 25, 10, 25, 15, 5, 30, 25, 10, 25, 15 ));
        lateValueMap.put(Constants.C5, new StorageValue( 10, 10, 30, 25, 35, 20, 5, 40, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.D5, new StorageValue( 5, 20, 40, 30, 40, 25, 5, 40, 40, 30, 40, 25 ));
        lateValueMap.put(Constants.E5, new StorageValue( 5, 20, 40, 30, 40, 25, 5, 40, 40, 30, 40, 25 ));
        lateValueMap.put(Constants.F5, new StorageValue( 10, 10, 30, 25, 35, 20, 5, 40, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.G5, new StorageValue( 10, 5, 25, 10, 25, 15, 5, 30, 25, 10, 25, 15 ));
        lateValueMap.put(Constants.H5, new StorageValue( 10, 5, 15, -20, 15, -5, 0, 30, 15, -20, 20, -5 ));
        
        lateValueMap.put(Constants.A4, new StorageValue( 0, 30, 15, -20, 20, -5, 10, 5, 15, -20, 15, -5 ));
        lateValueMap.put(Constants.B4, new StorageValue( 5, 30, 25, 10, 25, 15, 10, 5, 25, 10, 25, 15 ));
        lateValueMap.put(Constants.C4, new StorageValue( 5, 40, 30, 25, 35, 20, 10, 10, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.D4, new StorageValue( 5, 40, 40, 30, 40, 25, 5, 20, 40, 30, 40, 25 ));
        lateValueMap.put(Constants.E4, new StorageValue( 5, 40, 40, 30, 40, 25, 5, 20, 40, 30, 40, 25 ));
        lateValueMap.put(Constants.F4, new StorageValue( 5, 40, 30, 25, 35, 20, 10, 10, 30, 25, 35, 20 ));
        lateValueMap.put(Constants.G4, new StorageValue( 5, 30, 25, 10, 25, 15, 10, 5, 25, 10, 25, 15 ));
        lateValueMap.put(Constants.H4, new StorageValue( 0, 30, 15, -20, 20, -5, 10, 5, 15, -20, 15, -5 ));
        
        lateValueMap.put(Constants.A3, new StorageValue( -10, 50, 15, -20, 15, -5, 10, 5, 15, -20, 10, -5 ));
        lateValueMap.put(Constants.B3, new StorageValue( 0, 50, 25, 10, 25, 10, 15, 5, 25, 10, 25, 10 ));
        lateValueMap.put(Constants.C3, new StorageValue( 0, 60, 30, 20, 35, 15, 15, 10, 30, 20, 35, 15 ));
        lateValueMap.put(Constants.D3, new StorageValue( 5, 60, 30, 25, 35, 20, 10, 15, 30, 25, 35, 15 ));
        lateValueMap.put(Constants.E3, new StorageValue( 5, 60, 30, 25, 35, 20, 10, 15, 30, 25, 35, 15 ));
        lateValueMap.put(Constants.F3, new StorageValue( 0, 60, 30, 20, 35, 15, 15, 10, 30, 20, 35, 15 ));
        lateValueMap.put(Constants.G3, new StorageValue( 0, 50, 25, 10, 25, 10, 15, 5, 25, 10, 25, 10 ));
        lateValueMap.put(Constants.H3, new StorageValue( -10, 50, 15, -20, 15, -5, 10, 5, 15, -20, 10, -5 ));
        
        lateValueMap.put(Constants.A2, new StorageValue( -20, 90, 10, -20, 10, -5, 20, 0, 10, -40, 0, -5 ));
        lateValueMap.put(Constants.B2, new StorageValue( -5, 90, 20, 10, 25, 10, 20, 5, 20, -20, 15, 10 ));
        lateValueMap.put(Constants.C2, new StorageValue( -5, 90, 30, 10, 25, 10, 20, 5, 30, 5, 20, 10 ));
        lateValueMap.put(Constants.D2, new StorageValue( -5, 90, 30, 15, 25, 10, 10, -25, 30, 10, 20, 10 ));
        lateValueMap.put(Constants.E2, new StorageValue( -5, 90, 30, 15, 25, 10, 10, -25, 30, 10, 20, 10 ));
        lateValueMap.put(Constants.F2, new StorageValue( -5, 90, 30, 10, 25, 10, 20, 5, 30, 5, 20, 10 ));
        lateValueMap.put(Constants.G2, new StorageValue( -5, 90, 20, 10, 25, 10, 20, 5, 20, -20, 15, 10 ));
        lateValueMap.put(Constants.H2, new StorageValue( -20, 90, 10, -20, 10, -5, 20, 0, 10, -40, 0, -5 ));
        
        lateValueMap.put(Constants.A1, new StorageValue( -30, 60, 10, -30, 5, -10, 20, 0, 10, -60, -20, -10 ));
        lateValueMap.put(Constants.B1, new StorageValue( -20, 60, 20, -10, 10, -10, 10, 0, 20, -40, -5, -10 ));
        lateValueMap.put(Constants.C1, new StorageValue( -20, 60, 30, 5, 10, 5, 10, 0, 30, -30, -5, 0 ));
        lateValueMap.put(Constants.D1, new StorageValue( -20, 60, 30, 5, 10, 5, 10, 0, 30, -20, 5, 5 ));
        lateValueMap.put(Constants.E1, new StorageValue( -20, 60, 30, 5, 10, 5, 10, 0, 30, -20, 5, 5 ));
        lateValueMap.put(Constants.F1, new StorageValue( -20, 60, 30, 5, 10, 5, 10, 0, 30, -30, -5, 0 ));
        lateValueMap.put(Constants.G1, new StorageValue( -20, 60, 20, -10, 10, -10, 10, 0, 20, -40, -5, -10 ));
        lateValueMap.put(Constants.H1, new StorageValue( -30, 60, 10, -30, 5, -10, 20, 0, 10, -60, -20, -10 ));


    }



}
