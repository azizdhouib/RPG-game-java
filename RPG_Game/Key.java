//
// ETNA PROJECT, 25/10/2018 by dhouib_a
// key
// File description:
//      key
//
public class Key{

    private String name;
    private int score;
    public Key(){
        this.name = "";
        
    }
    public Key(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){
        return this.name;
    }
    public void action(Player player){
        player.addScore(this.score);
        
        

    }

    public int getScore(){
        return this.score;
    }
}
