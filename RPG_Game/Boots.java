//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// boot
// File description:
//      boot
//
public class Boots implements Item{
    private String name;
    private int lifePoints;
    private int attackPoints;

    @Override
    public String getName(){
        return this.name;
    }
    public int getLifePoints(){
        return this.lifePoints;
    }
    public int getAttackPoints(){
        return this.attackPoints;
    }
    public void setLifePoints(int lifePoints){
        this.lifePoints = lifePoints;
    }
    public void setAttackPoints(int attackPoints){
        this.attackPoints = attackPoints;
    }
    public Boots(int lifePoints, int attackPoints,String name){
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.name = name;
    }
    @Override
    public void put(Player player){
        player.getHealthBar().addMaxPoint(this.lifePoints);
        player.getStats().addAttack(this.attackPoints);
    }
    @Override
    public void remove(Player player){
        player.getHealthBar().removeMaxPoint(this.lifePoints);
        player.getStats().removeAttack(this.attackPoints);
        
    }
}
