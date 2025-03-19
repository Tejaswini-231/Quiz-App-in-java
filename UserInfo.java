package ProjectData;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        String name = null;
        
        try {
            System.out.println("  >> Welcome to the Console-Based Quiz Application <<");
            System.out.print(" Enter your Name: ");
            name = sc.next();
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println(" Invalid name..[Symbols detected]");
                System.exit(0);
            }
            System.out.print(" Enter your Age: ");
            int age = sc.nextInt();
            if(age<0 && age>100) {
            	System.out.println(" Invalid age..[Symbols detected]");
            	System.exit(0);
            }
            sc.nextLine(); 
            System.out.print(" Enter your Location: ");
            String location = sc.nextLine();
            if (!location.matches("[a-zA-Z]+")) {
                System.out.println(" Invalid location..[Symbols detected]");
                System.exit(0);
            }
 
            System.out.println(" We are happy to have you, " + name + ", in the game!");
        } catch (Exception e) {
            System.out.println(" Invalid input. Please check again.");
            sc.nextLine(); 
            System.exit(0);
        }

        System.out.println(" Would you like to play the game?");
        System.out.println(" 1. Yes                         2. No");

        int opt = sc.nextInt();
        if (opt == 1) {
            System.out.println(" You entered the game!");
            System.out.println("----------->>RULES OF THE GAME<<--------------");
            System.out.println(" 1.Enter the option for the question correctly to win the game..");
            System.out.println(" 2.There are two lifelines provided [ A.50-50    B.Audience Poll ]");
            System.out.println(" 3.If you use the lifeline once, it cannot be used again ,so choose wisely..");
            System.out.println(" 4.If you don't know the answer, you can quit the game with money earned..");
            System.out.println(" 5.Invalid options also choose to quit the game, so be cautious..");
            ArrayList<Questions> quiz = new ArrayList<>();
            quiz.add(new Questions(" Color of WaterMelon?", "Green", "Yellow", "Red", "White", 3));
            quiz.add(new Questions(" Portions in orange?", "12", "13", "14", "11", 2));
            quiz.add(new Questions(" Seeds in Chikoo?", "Two", "One", "Three", "No seed", 1));
            quiz.add(new Questions(" Lichi has ?", "Water", "Vitamins", "Minerals", "Proteins", 4));
            quiz.add(new Questions(" Fruit with no seed ?", "Apple", "Pine Apple", "Guava", "Melon", 2));
            quiz.add(new Questions(" Fruits are brought with [UNITS] ?", "Kg", "Grams", "Liters", "Dozens", 1));
            quiz.add(new Questions(" Fruit that helps in cooking?", "Bitter guard", "Bottle guard", "Mosambi", "Tomato", 4));
            quiz.add(new Questions(" Pappaya gives us ?", "Fat", "Acidity", "Body coolness", "Energy", 3));
            quiz.add(new Questions(" Fruit that doctors suggest ?", "Apple", "Banana", "Mango", "Orange", 1));
            quiz.add(new Questions(" Fruit with more seeds ?", "PineApple", "Custerd apple", "Apple", "Promoganate", 2));

            boolean[] lifelinesUsed = {false, false};

            for (int i = 0; i < quiz.size(); i++) {
                Questions q = quiz.get(i);
                q.display();
                System.out.println(" 5. Lifeline");
                System.out.println(" 6. Quit Game");

                try {
                    System.out.print(" Enter your choice : ");
                    int choice = sc.nextInt();

                    if (choice == 5) {
                        if (!lifelinesUsed[0] || !lifelinesUsed[1]) {
                            System.out.println(" Choose a Lifeline:");
                            if (!lifelinesUsed[0]) {
                            	System.out.println(" 1. 50-50");
                            	}
                            if (!lifelinesUsed[1]) {
                            	System.out.println(" 2. Audience Poll");
                            	}
                            if (lifelinesUsed[0] && lifelinesUsed[1]) { 
                            	System.out.println(" No lifelines left.");
                            	System.out.print(" Enter your choice:");
                                choice=sc.nextInt();
                                if (q.check(choice)) {
                                    score += 100;
                                    System.out.println(" Correct answer! Your score is now: " + score);
                                } else {
                                    System.out.println(" Wrong answer. Game over!");
                                    System.out.println(" Your total score is: " + score);
                                    sc.close();
                                    System.exit(0);
                                }
                            	}

                            int lifelineChoice = sc.nextInt();
                            if (lifelineChoice == 1 && !lifelinesUsed[0]) {
                                lifelinesUsed[0] = true;
                                FiftyFifty ff = new FiftyFifty(i + 1,score);
                                score=ff.questionFF(sc); 
                            } else if (lifelineChoice == 2 && !lifelinesUsed[1]) {
                                lifelinesUsed[1] = true;
                                AudiencePoll ap = new AudiencePoll(i + 1,score); 
                                score=ap.questionAp(sc);
                            } else {
                                System.out.println(" Invalid lifeline choice or lifeline already used.");
                                System.exit(0);
                            }
                        } else {
                            System.out.println(" No lifelines left.");
                            System.out.print(" Enter your choice:");
                            choice=sc.nextInt();
                            if (q.check(choice)) {
                                score += 100;
                                System.out.println(" Correct answer! Your score is now: " + score);
                            } else {
                                System.out.println(" Wrong answer. Game over!");
                                System.out.println(" Your total score is: " + score);
                                sc.close();
                                System.exit(0);
                            }
                        }
                    } else if (choice == 6) {
                        System.out.println(" You chose to quit the game. Goodbye!");
                        System.out.println(" Your total score is: " + score);
                        sc.close(); 
                        System.exit(0);
                    } else if (choice >= 1 && choice <= 4) {
                        if (q.check(choice)) {
                            score += 100;
                            System.out.println(" Correct answer! Your score is now: " + score);
                        } else {
                            System.out.println(" Wrong answer. Game over!");
                            System.out.println(" Your total score is: " + score);
                            sc.close();
                            System.exit(0);
                        }
                    } else {
                        System.out.println(" Invalid choice.Game Over!!");
                        System.out.println(" Your total score is: " + score); 
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(" Invalid input.Game Over!!");
                    System.out.println(" Your total score is: " + score);
                    sc.nextLine(); 
                    System.exit(0);
                }
            }

            System.out.println("               Congratulations! to the Winner on Victory !!");
            System.out.println("***********************************************************************************");
            System.out.println("       				Console-Based Quiz Application");
            System.out.println("");
            System.out.println("            			 THE WINNER : "+name);
            System.out.println("");
            System.out.println("      			  ON WINNING THE PRICE MONEY OF 1000");
            System.out.println("");
            System.out.println("***********************************************************************************");
            System.out.println("Your total score is: " + score);
            System.exit(0);
        } else if (opt == 2) {
            System.out.println(" You exited the game.");
        } else {
            System.out.println(" Invalid input.Game Over!!");
            System.out.println(" Your total score is: " + score);
            System.exit(0);
        }

        sc.close();
    }
}