//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// ah
// File description:
//      ah
//
public class ActionHeal implements Reaction{
    
    private int healPoint;

    public ActionHeal(){

    }
    
    public ActionHeal(int healPoint){
        this.healPoint = healPoint;
    }
    @Override
    public ReactionType getTypeReaction() {
        return ReactionType.Heal;
    }
    @Override
    public void action(Player player){
        player.heal(this.healPoint);
    }
    
    @Override
    public String getTextOfReaction() {

        return "Player gets health";
    }

}
