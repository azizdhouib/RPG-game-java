//
// ETNA PROJECT, 19/10/2018 by dhouib_a
// chest
// File description:
//      chest
//
import java.util.*;


public class Boots1 implements Tangible{
    
    public Boots1(){


    }
    
    @Override
    public char showAs(){
        return 'B';
    }
    @Override
    public void action(Player player){
        for(int i = 0; i < 40; i++)
            System.out.println("\n");
        player.putBoots(new Boots(20,20,"Boots"));
        System.out.println("PlayerOne gets the Boots and gets 20 life points and 20 attack points");
        System.out.println("Press Enter to continue");
        new java.util.Scanner(System.in).nextLine();
        
    }
}
