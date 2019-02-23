//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// area
// File description:
//      area
//
import java.util.*;

public class Area {
    private Cell[][] area;
    private String name;

    public Area(int width, int height, String name) {
        this.area = new Cell[width][height];
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    
    public Area(Cell[][] area, String name) {
        this.area = area;
        this.name = name;
    }

    public Cell[][] getArea() {
        return (this.area);
    }

    public void registerCellAt(int row, int column, Cell cell) {
        area[row][column] = cell;
    }

    public void registerTangibleAt(int row, int column, Tangible tangible) {
        area[row][column].addTagible(tangible);
    }

    public void registerReactionAt(int row, int column, Reaction reaction) {
        area[row][column].addReaction(reaction);
    }

    public void print() {
        System.out.println(this.name);
        for (int i = 0; i < area[0].length; i++) {
            for (int j = 0; j < area.length; j++) {
                if(area[j][i].showAs() == '#')
                    System.out.print("\033[45m\033[45m"+area[j][i].showAs()+"\033[0m");
                else
                    System.out.print(area[j][i].showAs());
            }
            System.out.println();
        }
    }
}
