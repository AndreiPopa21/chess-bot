import java.util.Collection;
import java.util.Vector;

enum EngineColor{
    WHITE,
    BLACK,
    NOSET,
}

public class ReceiverXboard implements Utilizator_Engine {
    Table table;
    private EngineColor e_color ;

    public ReceiverXboard(Table table){
        this.table=table;
        e_color=EngineColor.NOSET;
    }

    public EngineColor getE_color(){
        return e_color;
    }

    @Override
    public void xboard() {

    }

    @Override
    public void New() {
        System.out.println("feature sigint=0 sigterm=0 done=1 colors=0");
        System.out.flush();
        //this.e_color=EngineColor.WHITE;
    }

    @Override
    public void force() {

    }

    @Override
    public void go() {
        System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);
        if(this.e_color == EngineColor.BLACK)
            this.e_color = EngineColor.WHITE;
        else
            this.e_color = EngineColor.BLACK;
        System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);

    }

    @Override
    public void white() {
        System.out.println("Am ajuns in white"+this.e_color);
        e_color=EngineColor.BLACK;
    }

    @Override
    public void black()
    {
        System.out.println("Am ajuns in black "+this.e_color);
        e_color=EngineColor.WHITE;
    }

    @Override
    public void quit() {

    }

    @Override
    public void resign() {
        if (this.e_color==EngineColor.BLACK)
        {
            System.out.println("0-1 {White resigns}");
        }else
            System.out.println("1-0 {Black resigns}");
    }

    @Override
    public boolean move() {
        return true;
    }



    public boolean comandComparer(String command){


        Vector<String> coloane = new Vector<String>();
        coloane.add("a");
        coloane.add("b");
        coloane.add("c");
        coloane.add("d");
        coloane.add("e");
        coloane.add("f");
        coloane.add("g");
        coloane.add("h");

        if (command.equals(".")) {
            return false;
        }

        if ("xboard".equals(command))
        {
            this.xboard();
        }else if ("new".equals(command))
        {
            this.New();
        }else if ("force".equals(command))
        {
            this.force();
        }else if ("go".equals(command))
        {
            this.go();
        }else if ("white".equals(command))
        {
            this.white();
        }else if ("black".equals(command))
        {
            this.black();
        }else if ("quit".equals(command))
        {
            this.quit();
        }else if ("resign".equals(command))
        {
            this.resign();
        }else
        {
            String str = String.valueOf(command.charAt(0));
            String str2= String.valueOf(command.charAt(2));
            if ((command.length() == 4)&&(coloane.contains(str))&&(coloane.contains(str2)))
                return this.move();
        }
        return false;
    }

}
