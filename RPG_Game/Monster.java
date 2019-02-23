//
// ETNA PROJECT, 19/10/2018 by dhouib_a
// chest
// File description:
//      chest
//
import java.util.*;


public class Monster implements Tangible{
    private int score;
    private HealthBar healthBar;
    public Monster(){
        

    }
    public HealthBar getHealthBar(){
        return this.healthBar;
    }
    public Monster(HealthBar healthBar, int score){
        this.score = score;
        this.healthBar=healthBar;
    }
    @Override
    public char showAs(){
        return 'M';
    }
    @Override
    public void action(Player player){
        
        
    }
    public int getScore(){
        return this.score;
    }
}
