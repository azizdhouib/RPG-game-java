//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// ad
// File description:
//      ad
//
public class ActionDamage implements Reaction{

    private int damagePoint;
    
    public ActionDamage(){

    }
    
    public ActionDamage(int damagePoint){
        this.damagePoint = damagePoint;
    }
    
    @Override
    public ReactionType getTypeReaction() {
        return ReactionType.Damage;
    }
    @Override
    public void action(Player player){
        player.takeDamage(this.damagePoint);
    }
    @Override
    public String getTextOfReaction() {
        return "Player takes damage";
    }
}
