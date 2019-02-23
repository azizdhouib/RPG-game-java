//
// ETNA PROJECT, 25/10/2018 by dhouib_a
// quiz
// File description:
//      quiz
//
import java.util.*;
public class Quiz extends Game{
    private List<Question> listQuestion;
    
    public Quiz(String name, Key keyCondition, Key keyReward, List listQuestion){
        super(name, keyCondition, keyReward);
        this.listQuestion = listQuestion;
    }

    @Override
    public boolean play(Key k,String input){
        boolean play = canPlay(k);
        if (play == false){
            System.out.println("Key required");
            return false;
        }
        else {
            System.out.println("Welcome to the quiz");
            
            String[] ary = input.split(" ");
            
            for(int i = 0; i < ary.length; i++){
                System.out.println(this.listQuestion.get(i).getQuestion());
                this.listQuestion.get(i).getrep();
                if(this.listQuestion.get(i).getAnswer().equals(ary[i]))
                    System.out.println("Correct");
                else{
                    
                    System.out.println("Wrong");
                    return false;
                }
            }
        }
        System.out.println("Win");
        return true;
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
    public void getQuest(){
        for(int i = 0; i < this.listQuestion.size(); i++){
            System.out.println(this.listQuestion.get(i).getQuestion());
            this.listQuestion.get(i).getrep();
            System.out.println("\n");
        }
    }
    @Override
    public Key reward(){
        return this.keyReward;
    }
    
    
    
    
    
    
}
