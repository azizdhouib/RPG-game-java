//
// ETNA PROJECT, 25/10/2018 by dhouib_a
// game
// File description:
//      game
//
public abstract class Game{

    protected String name;
    protected Key keyCondition;
    protected Key keyReward;

    public Game(String name, Key keyCondition, Key keyReward){
        this.name = name;
        this.keyCondition = keyCondition;
        this.keyReward = keyReward;
    }

    public String getName(){
        return this.name;
    }
    public Key getKeyCondition(){
        return this.keyCondition;
    }
    public Key getKeyReward(){
        return this.keyReward;
    }
    public abstract boolean play(Key k,String input);

    public abstract boolean canPlay(Key k);
    
    public abstract Key reward();




}
