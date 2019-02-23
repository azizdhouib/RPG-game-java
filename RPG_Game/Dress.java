//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// dress
// File description:
//      dress
//
public class Dress implements Item{
    private String name;
    private int lifePoints;
    private int defencePoints;

    @Override
    public String getName(){
        return this.name;
    }
    public int getLifePoints(){
        return this.lifePoints;
    }
    public int getDefencePoints(){
        return this.defencePoints;
    }
    public void setLifePoints(int lifePoints){
        this.lifePoints = lifePoints;
    }
    public void setDefencePoints(int defencePoints){
        this.defencePoints = defencePoints;
    }
    public Dress(int lifePoints, int defencePoints,String name){
        this.lifePoints = lifePoints;
        this.defencePoints = defencePoints;
        this.name = name;
    }
    @Override
    public void put(Player player){
        player.getHealthBar().addMaxPoint(this.lifePoints);
        player.getStats().addDefence(this.defencePoints);
    }
    @Override
    public void remove(Player player){
        player.getHealthBar().removeMaxPoint(this.lifePoints);
        player.getStats().removeDefence(this.defencePoints);
        
    }
}
