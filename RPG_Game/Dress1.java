//
// ETNA PROJECT, 19/10/2018 by dhouib_a
// chest
// File description:
//      chest
//
import java.util.*;


public class Dress1 implements Tangible{
    
    public Dress1(){


    }
    
    @Override
    public char showAs(){
        return 'D';
    }
    @Override
    public void action(Player player){
        for(int i = 0; i < 40; i++)
            System.out.println("\n");
        player.putDress(new Dress(50,50,"Dress"));
        System.out.println("PlayerOne gets the Dress and gets 50 life points and 50 defence points");
        System.out.println("Press Enter to continue");
        new java.util.Scanner(System.in).nextLine();
        
    }
}
