//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// player
// File description:
//      player
//
//package day7.day7_1;
import java.util.*;

public class Player implements Tangible{

    private char symbol;
    private Position position;
    private String name;
    private int point;
    private HealthBar healthBar;
    private Stats stats;
    private List<Item> bag;
    private Hat hat;
    private Boots boots;
    private Dress dress;
    private Key key;
    private Weapon weapon;

    
    public void removeHat(){
        if(this.hat != null){
            this.hat.remove(this);
            this.bag.add(this.hat);
            this.hat = null;
        }
    }
    public void attack(World world){
        if (world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].getMonster() == null){
            System.out.println("No monsters");
            System.out.println("Press Enter to continue");
            new java.util.Scanner(System.in).nextLine();
            
        }
        else {
            
            
            ((Monster)world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].getMonster()).getHealthBar().removeCurrentPoint(this.stats.getAttack());
            if( ((Monster)world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].getMonster()).getHealthBar().isDead()){
                this.point += ((Monster)world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].getMonster()).getScore();
                System.out.println("Monster killed");
                world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].removeMonster();
                System.out.println("Press Enter to continue");
                
                new java.util.Scanner(System.in).nextLine();
                return ;
            }
            else{
                System.out.println("Monster not killed");
                System.out.println("Monster Health left :" + ((Monster)world.getAreaByName(this.position.getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].getMonster()).getHealthBar().getCurrentPoint());
                System.out.println("Press Enter to continue");
                
                new java.util.Scanner(System.in).nextLine();
            }
                
        }
    }

    @Override
    public void action(Player player){
        
    }
    public void setKey(Key key){
        this.key = key;
    }
    public Key getKey(){
        return this.key;
    }
    public void heal(int healPoint){
        this.healthBar.addCurrentPoint(healPoint);
    }

    public void takeDamage(int damagePoint){
        this.healthBar.removeCurrentPoint(damagePoint);
    }
    
    public void putHat(Hat hat){
        if (this.hat != null)
            this.removeHat();
        this.hat = hat;
        this.hat.put(this);
    }

    public void removeDress(){
        if(this.dress != null){
            this.dress.remove(this);
            this.bag.add(this.dress);
            this.dress = null;
        }
    }

    public void putDress(Dress dress){
        if(this.dress != null)
            this.removeDress();
        this.dress = dress;
        this.dress.put(this);
    }
    
    public void removeBoots(){
        if (this.boots != null){
            this.boots.remove(this);
            this.bag.add(this.boots);
            this.boots = null;
        }
    }

    public void putBoots(Boots boots){
        if (this.boots != null)
            this.removeBoots();
        this.boots = boots;
        this.boots.put(this);
    }

    public void printBag(){
        if (this.bag.isEmpty()){
            for(int i = 0; i < 40; i++)
                System.out.println("\n");
            System.out.println("Bag Empty");
            System.out.println("Press Enter to continue");
            new java.util.Scanner(System.in).nextLine();
            
        }
        else {
            for(int i = 0; i < 40; i++)
                System.out.println("\n");
            
            for (int i = 0; i < this.bag.size(); i++){
                System.out.print("" + (i + 1) + " -> ");
                if (this.bag.get(i) instanceof Hat)
                    System.out.println("Hat");
                if (this.bag.get(i) instanceof Dress)
                    System.out.println("Dress");
                if (this.bag.get(i) instanceof Boots)
                    System.out.println("Boots");
                if (this.bag.get(i) instanceof Katana)
                    System.out.println("Katana");
            }
            System.out.println("Press Enter to continue");
            new java.util.Scanner(System.in).nextLine();
            
        }
    }
    public void putWeapon(Weapon weapon){
        if (this.weapon != null)
            this.removeWeapon();
        this.weapon = weapon;
        this.weapon.put(this);
    }
    public void removeWeapon(){
        if(this.weapon != null){
            this.weapon.remove(this);
            this.bag.add(this.weapon);
            this.weapon = null;
        }
    }
    public Player(String name, int point, Stats stats, HealthBar healthBar, List<Item> listItem, char symbol, Position position) {
        this.name = name;
        this.point = point;
        this.stats = stats;
        this.healthBar = healthBar;
        this.bag = listItem;
        this.symbol = symbol;
        this.position = position;
        this.key = new Key();
    }
    
    public Position getPosition(){
        return this.position;
    }
    public char getSymbol(){
        return this.symbol;
    }
        @Override
        public char showAs(){
            return this.symbol;
        }
    public void movePlayer(World world, Direction direction){

        if ((direction == Direction.NORTH && this.getPosition().getY() == 0) || (direction == Direction.NORTH && world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getTagible() instanceof Wall)|| 
            (direction == Direction.WEST  && this.getPosition().getX() == 0) || (direction == Direction.WEST && world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getTagible() instanceof Wall) ||
            (direction == Direction.SOUTH && this.getPosition().getY() == world.getAreaByName(this.getPosition().getCurrentMap()).getArea().length -1) || (direction == Direction.SOUTH && world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getTagible() instanceof Wall) ||
            (direction == Direction.EAST  && this.getPosition().getX() == world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getY()].length - 1) || (direction == Direction.EAST && world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getTagible() instanceof Wall))
            System.out.println("Player didn't move!");
        else {


            if(direction == Direction.NORTH){
                if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].isEmptyReaction() == false)
                   world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getReaction(this);
                for(int i = 0;i< world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().size(); i++)
                    if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof Acid || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof HolyWater || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof Chest || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof Kata || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof Dress1 || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i) instanceof Boots1)
                        world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].getListTangible().get(i).action(this);
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() - 1].addTagible(this);
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].removeTangible(this);
                this.position.setY(this.position.getY() - 1);
               
                
            }
            if(direction == Direction.WEST){
                if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].isEmptyReaction() == false)
                    world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getReaction(this);
                for(int i = 0;i< world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().size(); i++)
                    if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof Acid || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof HolyWater || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof Chest || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof Kata || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof Dress1 || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i) instanceof Boots1)
                        world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].getListTangible().get(i).action(this);
                
                
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() - 1][this.getPosition().getY()].addTagible(this);
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].removeTangible(this);
                this.position.setX(this.position.getX() - 1);
               
            }
            if(direction == Direction.SOUTH){
                if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].isEmptyReaction() == false)
                    world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getReaction(this);
                
                for(int i = 0;i< world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().size(); i++)
                    if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof Acid || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof HolyWater || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof Chest || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof Kata || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof Dress1 || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i) instanceof Boots1)
                        world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].getListTangible().get(i).action(this);
                
                
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY() + 1].addTagible(this);
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].removeTangible(this);
                this.position.setY(this.position.getY() + 1);
                
            }
            if(direction == Direction.EAST){
                if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].isEmptyReaction() == false)
                    world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getReaction(this);
                
                for(int i = 0;i< world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().size(); i++)
                    if (world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof Acid || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof HolyWater || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof Chest || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof Kata || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof Dress1 || world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i) instanceof Boots1)
                        world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].getListTangible().get(i).action(this);
                
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX() + 1][this.getPosition().getY()].addTagible(this);
                world.getAreaByName(this.getPosition().getCurrentMap()).getArea()[this.getPosition().getX()][this.getPosition().getY()].removeTangible(this);
                this.position.setX(this.position.getX() + 1);
               
            }
            
            System.out.println("Player moved!");
        }
    }
    public void attack(Player player){
        if (this.stats.getAttack() > player.getStats().getDefence()){
            int i = stats.getAttack() - player.getStats().getDefence();
            if (i < 0){
                i = 0;
            }
            player.getHealthBar().removeCurrentPoint(i);
        }
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(HealthBar healthBar) {
        this.healthBar = healthBar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void resetScore() {
        this.point = 0;
    }

    public void addScore(int point) {
        this.point += point;
    }

    public void removeScore(int point) {
        this.point -= point;
    }

    public String toString() {
        return "Name : " + name + ", Point : " + point;
    }

    public Stats getStats() {
        return stats;
    }

}
