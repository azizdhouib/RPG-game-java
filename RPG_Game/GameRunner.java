//
// ETNA PROJECT, 25/10/2018 by dhouib_a
// game runner
// File description:
//      game runner
//
public class GameRunner{
    private Key keyToPlay;
    private String input;

    public GameRunner(Key key,String input){
        
        this.keyToPlay = key;
        this.input = input;

    }
    public boolean playGame(Game game){
        return game.play(this.keyToPlay, input);
    }

}
