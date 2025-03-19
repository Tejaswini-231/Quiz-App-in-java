package ProjectData;

import java.util.Scanner;

public class AudiencePoll {
    private int questionNumber;
    private int score;
    AudiencePoll(int questionNumber,int score) {
        this.questionNumber = questionNumber;
        this.score=score;
    }

    public int questionAp(Scanner sc) {
        System.out.println("\nAudience Poll Lifeline:");

        switch (questionNumber) {
            case 1:
                System.out.println("1. Green - 45%");
                System.out.println("2. Yellow - 12%");
                System.out.println("3. Red - 35%");
                System.out.println("4. White - 8%");
                break;
            case 2:
                System.out.println("1. 12 - 10%");
                System.out.println("2. 13 - 70%");
                System.out.println("3. 14 - 15%");
                System.out.println("4. 11 - 5%");
                break;
            case 3:
                System.out.println("1. Two - 80%");
                System.out.println("2. One - 10%");
                System.out.println("3. Three - 5%");
                System.out.println("4. No seed - 5%");
                break;
            case 4:
                System.out.println("1. Water - 20%");
                System.out.println("2. Vitamins - 30%");
                System.out.println("3. Minerals - 10%");
                System.out.println("4. Proteins - 40%");
                break;
            case 5:
                System.out.println("1. Apple - 10%");
                System.out.println("2. PineApple - 70%");
                System.out.println("3. Guava - 15%");
                System.out.println("4. Melon - 5%");
                break;
            case 6:
                System.out.println("1. Kg - 45%");
                System.out.println("2. Grams - 12%");
                System.out.println("3. Liters - 35%");
                System.out.println("4. Dozens - 8%");
                break;
            case 7:
                System.out.println("1. Bitter Guard - 10%");
                System.out.println("2. Bottle Gurad - 20%");
                System.out.println("3. Mosambi - 15%");
                System.out.println("4. Tomato - 85%");
                break;
            case 8:
                System.out.println("1. Fat - 20%");
                System.out.println("2. Acidity - 10%");
                System.out.println("3. Body Coolness - 75%");
                System.out.println("4. Energy - 55%");
                break;
            case 9:
                System.out.println("1. Apple - 60%");
                System.out.println("2. Banana - 34%");
                System.out.println("3. Mango - 10%");
                System.out.println("4. Orange - 50%");
                break;
            case 10:
                System.out.println("1. Pine Apple - 20%");
                System.out.println("2. Custard Apple - 70%");
                System.out.println("3. Apple - 15%");
                System.out.println("4. Promoganate - 5%");
                break;
            default:
                System.out.println("Invalid question number.");
                return -1;
        }

        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        if ((questionNumber == 1 && ch == 3) ||
            (questionNumber == 2 && ch == 2) ||
            (questionNumber == 3 && ch == 1) ||
            (questionNumber == 4 && ch == 4) ||
            (questionNumber == 5 && ch == 2) ||
            (questionNumber == 6 && ch == 1) ||
            (questionNumber == 7 && ch == 4) ||
            (questionNumber == 8 && ch == 3) ||
            (questionNumber == 9 && ch == 1) ||
            (questionNumber == 10 && ch == 2)){
        	score+=100;
            System.out.println("Correct answer! score is :"+score);
            return score;
        } else {
            System.out.println("Wrong answer. Game over!");
            System.out.println("Your score is : "+score);
            return score;
        }
    }
}