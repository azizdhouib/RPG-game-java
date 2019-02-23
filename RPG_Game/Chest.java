//
// ETNA PROJECT, 19/10/2018 by dhouib_a
// chest
// File description:
//      chest
//
import java.util.*;


public class Chest implements Tangible{
    private Key key;
    public Chest(){


    }
    public Chest(Key key){
        this.key = key;
    }
    @Override
    public char showAs(){
        return 'C';
    }
    @Override
    public void action(Player player){
        for(int i = 0; i < 40; i++)
            System.out.println("\n");
        player.setKey(this.key);
        this.key.action(player);
        System.out.println("PlayerOne gets the key and gets "+ this.key.getScore()+" points of score");
        System.out.println("Press Enter to continue");
        new java.util.Scanner(System.in).nextLine();
        
    }
}
