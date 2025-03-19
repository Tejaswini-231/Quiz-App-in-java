package ProjectData;

import java.util.Scanner;

public class FiftyFifty {
    private int questionNumber;
    private int score;
    FiftyFifty(int questionNumber,int score) {
        this.questionNumber = questionNumber;
        this.score=score;
    }

    public int questionFF(Scanner sc) {
        System.out.println("\n50-50 Lifeline:");

        switch (questionNumber) {
            case 1:
                System.out.println("1. Green");
                System.out.println("3. Red");
                break;
            case 2:
                System.out.println("2. 13");
                System.out.println("4. 11");
                break;
            case 3:
                System.out.println("1. Two");
                System.out.println("3. Three");
                break;
            case 4:
                System.out.println("1. Water");
                System.out.println("4. Proteins");
                break;
            case 5:
                System.out.println("2. PineApple");
                System.out.println("4. Melon");
                break;
            case 6:
                System.out.println("1. Kg");
                System.out.println("3. Liters");
                break;
            case 7:
                System.out.println("3. Mosambi");
                System.out.println("4. Tomato");
                break;
            case 8:
                System.out.println("3. Body Coolness");
                System.out.println("4. Energy");
                break;
            case 9:
                System.out.println("1. Apple");
                System.out.println("4. Orange");
                break;
            case 10:
                System.out.println("2. Custard Apple");
                System.out.println("4. Orange");
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
            (questionNumber == 10 && ch == 2)) {
        	score+=100;
            System.out.println("Correct answer! your score is : "+score);
            return score;
            
        } else {
            System.out.println("Wrong answer. Game over! with score "+score);
            return score;
        }
    }
}