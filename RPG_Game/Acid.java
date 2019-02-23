//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// acid
// File description:
//      acid
//
public class Acid implements Tangible{
    private int damagePoint;

    public Acid(){
        
    }
    public Acid(int damagePoint){
        this.damagePoint = damagePoint;
    }
    @Override
    public void action(Player player){
        player.getHealthBar().removeCurrentPoint(this.damagePoint);
    }
    @Override
    public char showAs(){
        return 'A';
    }
}
