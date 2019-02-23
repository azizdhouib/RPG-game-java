//
// ETNA PROJECT, 20/10/2018 by dhouib_a
// pos
// File description:
//      pos
//
public class Position{
    private int x;
    private int y;
    private String currentMap;

    public String getCurrentMap(){
        return this.currentMap;
    }

    public void setCurrentMap(String currentMap){
        this.currentMap = currentMap;
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public Position(int x, int y, String currentMap){
        this.x = x;
        this.y = y;
        this.currentMap = currentMap;
    }
}
