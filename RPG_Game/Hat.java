//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// dress
// File description:
//      dress
//
public class Hat implements Item{
    private String name;
    private int defencePoints;

    @Override
    public String getName(){
        return this.name;
    }
    
    public int getDefencePoints(){
        return this.defencePoints;
    }
    
    public void setDefencePoints(int defencePoints){
        this.defencePoints = defencePoints;
    }
    public Hat(int defencePoints,String name){
        
        this.defencePoints = defencePoints;
        this.name = name;
    }
    @Override
    public void put(Player player){
        
        player.getStats().addDefence(this.defencePoints);
    }
    @Override
    public void remove(Player player){
        
        player.getStats().removeDefence(this.defencePoints);
        
    }
}
