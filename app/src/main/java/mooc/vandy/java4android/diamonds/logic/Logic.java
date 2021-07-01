package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        int hightofthebox = (size*2)+1;
        int widthofthebox = (size*2)+2;
        boxhightandwidth(size,hightofthebox,widthofthebox);
    }

    private void boxhightandwidth(int size, int hightofthebox, int widthofthebox) {
        int inside = -(size+1);
        for (int i = 1 ; i<=hightofthebox; i++){
            inside += 1;
            for (int j = 1; j <= widthofthebox; j++){
                if((i==1||i==hightofthebox)&&(j==1 || j== widthofthebox)){
                    mOut.print("+");
                }
                else if ((i==1||i==hightofthebox)&&!(j==1 || j== widthofthebox)){
                    mOut.print("-");
                }
                else if(!(i==1||i==hightofthebox)&&(j==1 || j== widthofthebox)){
                    mOut.print("|");
                }
                else{
                    DiamondInside(size,i,j,inside);
                }
            }
            mOut.println("");
        }
    }

    private void DiamondInside(int size, int i, int j, int inside) {
        int DiamondRow;
        if(inside <= 0){
            DiamondRow = i*2-2;
        }
        else{
            DiamondRow = (i-inside*2)*2-2;
        }
        int diamondMidle = size + 1;
        int diamondleft = diamondMidle - (DiamondRow/2-1);
        int diamondright = diamondMidle + (DiamondRow/2);
        int diamondtop = 1;
        int diamondbottom = size*2+1;
        if(j >= diamondleft && j <= diamondright){
            if(j == diamondleft || j == diamondright){
                if(i < diamondMidle && i > diamondtop){
                    if(j == diamondleft){
                        mOut.print("/");
                    }
                    else{
                        mOut.print("\\");
                    }
                }
                else if (i == diamondMidle){
                    if (j == diamondleft){
                        mOut.print("<");
                    }
                    else{
                        mOut.print(">");
                    }
                }
                else if (i > diamondMidle && i < diamondbottom) {
                    if (j == diamondleft) {
                        mOut.print("\\");
                    } else {
                        mOut.print("/");
                    }
                }
            }
            else {
                if (i % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
        } else {
            mOut.print(" ");
        }
    }
}
