//
// ETNA PROJECT, 25/10/2018 by dhouib_a
// question
// File description:
//      question
//
public class Question{

    private String question;
    private String answer;
    private String response1;
    private String response2;
    private String response3;
    private String response4;

    public void getrep(){
        System.out.println(response1);
        System.out.println(response2);
        System.out.println(response3);
        System.out.println(response4);
    }
    public Question(String question, String response1, String response2, String response3, String response4, String answer){
        this.question = question;
        this.answer = answer;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
    }
    public String getQuestion(){
        return this.question;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
}
