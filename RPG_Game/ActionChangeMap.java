//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// ac
// File description:
//      ac
//
public class ActionChangeMap implements Reaction {


    public ActionChangeMap(){
        
    }
    
    @Override
    public ReactionType getTypeReaction() {
        return ReactionType.ChangeMap;
    }
    @Override
    public void action(Player player){

    }
    
    @Override
    public String getTextOfReaction() {
        return "Player changes map";
    }
}
