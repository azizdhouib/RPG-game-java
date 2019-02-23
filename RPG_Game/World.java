//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// world
// File description:
//      world
//

import java.util.*;

public class World{
    private List<Area> areas = new ArrayList<Area>();

    public World(Area area){
        this.areas.add(area);
    }
    public List<Area> getAreas(){
        return this.areas;
    }
    public Area getAreaByName(String name){
        for(int i = 0; i < this.areas.size(); i++)
            if (this.areas.get(i).getName() == name)
                return this.areas.get(i);
        return null;
    }
    public World(List<Area> areas){
        this.areas.addAll(areas);
    }

    public void addArea(Area area){
        this.areas.add(area);
    }
    
    public void print(){
        for(int i = 0; i < this.areas.size(); i++){
            this.areas.get(i).print();
            System.out.println("");
        }
        
    }
}
