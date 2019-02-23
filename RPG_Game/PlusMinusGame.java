

import java.util.*;
public class PlusMinusGame extends Game{
    private int findValue;
    
    public PlusMinusGame(String name, Key keyCondition, Key keyReward, int findValue){
        super(name, keyCondition, keyReward);
        this.findValue = findValue;
    }

    @Override
    public boolean play(Key k,String input){

        boolean play = canPlay(k);
        if (play == false){
            System.out.println("Key required");
            return false;
        }
        else {
           
            int num = 0;
            int win = 0;
            List<Integer> ary = new ArrayList<>();

            
            Scanner scan = new Scanner(input);
            while(scan.hasNextInt()){
                ary.add(scan.nextInt());
            }
                
            for (int i = 0; (i < 10 && i < ary.size()) && win == 0; i++){
                num =  ary.get(i);
                if(num > this.findValue)
                    System.out.println("Minus");
                if(num < this.findValue)
                    System.out.println("Plus");
                if(num == this.findValue){
                    System.out.println("Win");
                    win = 1;
                    return true;
                }
               
                    
                
            }
        }
        System.out.println("Lose");
        return false;
    }
    public void getQuest(){
        System.out.println("Find the number between 1 and 100!");
        System.out.println("YOU HAVE ONLY 10 ATTEMPTS !");
    }
    @Override
    public boolean canPlay(Key k){
        if (getKeyCondition() == null){
            return true;
        }

        if (k != null && k.equals(getKeyCondition()) ){
            return true;
        }
        return false;
    }
    @Override
    public Key reward(){
        return this.keyReward;
    }

}
