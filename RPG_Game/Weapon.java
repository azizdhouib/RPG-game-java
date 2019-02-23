//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// weapon
// File description:
//      weapon
//
public abstract class Weapon implements Item{
    protected String name;
    
    @Override
    public abstract String getName();
    @Override
    public abstract void put(Player player);
    @Override
    public abstract void remove(Player player);
    
    public Weapon(String name){
        this.name = name;
    }
}
