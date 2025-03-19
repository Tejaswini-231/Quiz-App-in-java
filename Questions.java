package ProjectData;

public class Questions {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int correctAnswer;

    public Questions(String question, String option1, String option2, String option3, String option4, int correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println("\n  Question: " + question);
        System.out.println(" 1. " + option1);
        System.out.println(" 2. " + option2);
        System.out.println(" 3. " + option3);
        System.out.println(" 4. " + option4);
    }

    public boolean check(int choice) {
        if (choice == correctAnswer) {
            return true; 
        } else {
            return false; 
        }
    }
}