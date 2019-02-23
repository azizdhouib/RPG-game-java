//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// reaction
// File description:
//      reaction
//
//package day7.day7_4;

public interface Reaction {

    ReactionType getTypeReaction();

    void action(Player player);
    
    String getTextOfReaction();
}
