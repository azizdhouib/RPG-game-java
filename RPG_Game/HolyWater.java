//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// holy
// File description:
//      holy
//
public class HolyWater implements Tangible{
    private int lifeToAdd;

    public HolyWater(){
        
    }
    
    public HolyWater(int lifes){
        this.lifeToAdd = lifes;
    }
    
    @Override
    public void action(Player player){
        player.getHealthBar().addCurrentPoint(this.lifeToAdd);
    }
    @Override
    public char showAs(){
        return 'H';
    }
}
