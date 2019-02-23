//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// rf
// File description:
//      rf
//
public class ReactionFactory {

    public Reaction getReaction(ReactionType reactionType){
        Reaction tmp;
        if (reactionType == ReactionType.Heal) {
            tmp = new ActionHeal();
            return tmp;
        }
        if (reactionType == ReactionType.Damage) {
            tmp = new ActionDamage();
            return tmp;
        }
        if (reactionType == ReactionType.ChangeMap) {
            tmp = new ActionChangeMap();
            return tmp;
        }
        return null;
    }
}
