//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// katana
// File description:
//      katana
//
public class Katana extends Weapon{
    private int damagePoint;

    public Katana(String name, int damagePoint){
        super(name);
        this.damagePoint = damagePoint;
    }
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public void put(Player player){
        player.getStats().addAttack(damagePoint);
    }
    @Override
    public void remove(Player player){
        player.getStats().removeAttack(damagePoint);
    }
}
