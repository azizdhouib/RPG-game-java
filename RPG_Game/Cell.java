//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// cell
// File description:
//      cel
//
import java.util.*;

public class Cell {
    private List<Tangible> tangibles;
    private List<Reaction> reactions;

    public Cell(Tangible tangible) {
        this.tangibles = new ArrayList<>();
        this.tangibles.add(tangible);
        this.reactions = new ArrayList<>();
    }

    public Cell(List<Tangible> listTangible) {
        this.tangibles = new ArrayList<>(listTangible);
        this.reactions = new ArrayList<>();
    }

    public void addTagible(Tangible tangible) {
        this.tangibles.add(tangible);
    }

    public boolean isEmptyTangible() {
        if (this.tangibles != null) {
            return (this.tangibles.isEmpty());
        }
        return (true);
    }
    public Tangible getTagible(){
        if(this.tangibles.isEmpty())
            return new Ground();
        return this.tangibles.get(this.tangibles.size() - 1);
    }
    public Tangible getMonster(){
         if(!(this.tangibles.isEmpty()))
             for(int i = 0; i < this.tangibles.size(); i++)
                 if (this.tangibles.get(i) instanceof Monster)
                     return this.tangibles.get(i);
        return null;
    }

    public void removeMonster(){
         if(!(this.tangibles.isEmpty()))
             for(int i = 0; i < this.tangibles.size(); i++)
                 if (this.tangibles.get(i) instanceof Monster)
                     this.tangibles.remove(this.tangibles.get(i));
        
    }
    public void getReaction(Player player){
        if(!(this.reactions.isEmpty()))
            for(int i = 0; i < this.reactions.size(); i++) 
                this.reactions.get(i).action(player);
    }
    public void addReaction(Reaction reaction) {
        this.reactions.add(reaction);
    }
    public void removeTangible(Tangible tangible) {
        this.tangibles.remove(tangible);
    }
    
    public boolean isEmptyReaction() {
        if (this.reactions != null) {
            return (this.reactions.isEmpty());
        }
        return (true);
    }

    public char showAs() {
        for (Tangible t: this.tangibles) {
            if (t instanceof Player) {
                return (t.showAs());
            }
        }
        if (this.tangibles.isEmpty())
            return '.';
        return (tangibles.get(tangibles.size() -1)).showAs();
    }
    public List<Tangible> getListTangible(){
        return this.tangibles;
    }
    public List<Reaction> getListReaction(){
        return this.reactions;
    }
}
