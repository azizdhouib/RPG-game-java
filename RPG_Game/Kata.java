//
// ETNA PROJECT, 19/10/2018 by dhouib_a
// chest
// File description:
//      chest
//
import java.util.*;


public class Kata implements Tangible{
    
    public Kata(){


    }
    
    @Override
    public char showAs(){
        return 'K';
    }
    @Override
    public void action(Player player){
        for(int i = 0; i < 40; i++)
            System.out.println("\n");
        player.putWeapon(new Katana("Katana", 100));
        System.out.println("PlayerOne gets the Katana and gets 100 Attack points");
        System.out.println("Press Enter to continue");
        new java.util.Scanner(System.in).nextLine();
        
    }
}
