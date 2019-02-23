import java.util.Scanner;


public class Hang extends Game{


    
    private static String word = "PISCINE";
    private static int score, guesses;
    private static Scanner scanner;


    public Hang(String name, Key keyCondition, Key keyReward){
        super(name, keyCondition, keyReward);
        
    }
    @Override
    public Key reward(){
        return this.keyReward;
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
    
   

    public static void print() {
        
        System.out.println("Welcome to Hangman!\n" + "You have 15 guesses to guess the word.\n" +
                           "The word is " + word.length() + " characters long.\n" +
                           "Get " + word.length() + " points before you run out of turns to win!\n");
    }
    @Override
    public boolean play(Key k, String input) {

        boolean play = canPlay(k);
        if (play == false){
            System.out.println("Key required");
            return false;
        }
        else{
            
            
            for (int i = 0; i < 15; i++) {
                
                System.out.println("-----------------------------------------\n");
                String answer= "";
                char car = getInput(answer);
                System.out.println("You guessed: " + car + "\n");
                
                check(car);
                if (score == word.length()) {
                    
                    System.out.println("Congratulations! You win!");
                    System.out.println("The word was: " + word + "\nThank you for playing!");
                    return true;
                    
                } else if (i == 14 && score != word.length()){
                    
                    System.out.println("too bad! you did not guess the word!");
                    System.out.println("The word was: " + word + "\nThank you for playing!");
                    break;
                }
                
                guesses++;
                
                System.out.println("Number of guesses: " + guesses +
                                   "\nScore: " + score + "\n");
            }
            
        }
        return false;
    }

    public static char getInput(String answer) {

        System.out.println("guess a letter please, ONLY  THE FIRST LETTER WILL BE USED !");
        Scanner scan = new Scanner(System.in);
        answer = scan.nextLine();
        
        return answer.charAt(0);
        
       
    }

    public static void check(char car) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == car) {
                score++;
            }
            
        }
    }

   

        

    
}
