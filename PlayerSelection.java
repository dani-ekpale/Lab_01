/*  
    Filename: PlayerSelection.java
    Name: Daniel Ekpale
    Student ID: 26372028
    Course: Object-Oriented Programming ( CS213 )
    Lab: 1 
    Date: 22nd September 2025
    Description: This code takes player input for registration for the ashesi premier league. It checks for player eligibility, status, jersey number and other key details.
*/
import java.util.Scanner;  // Required for Scanner class

public class PlayerSelection {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

    double Height, Weight;
    int age;
    int JerseyNumber;
    String PlayerName;
    double HeightInCm;
    double WeightInKg;


    final double PoundConverter = 0.45359237;
    final double HeightConverter = 100;


    // The following lines of code fetch key input from the user to aid with registration like name, height, age and others.

        System.out.println("Welcome to the Player Selection Program \n");
        System.out.print("Enter the player's name: ");
        PlayerName = scanner.nextLine();
        System.out.print("Enter the player's Age: ");
        age = scanner.nextInt();
        System.out.print("Enter the player's Height (in Meters): ");
        Height = scanner.nextDouble();
        System.out.print("Enter the player's Weight (in Pounds): ");
        Weight = scanner.nextDouble();
        System.out.print("Enter the player's Jersey Number: ");
        JerseyNumber = scanner.nextInt();

        WeightInKg = Weight * PoundConverter;
        HeightInCm = Height * HeightConverter;

        System.out.println("\nPlayer Details: \n");
        System.out.println("Name: " + PlayerName);
        System.out.println("Age: " + age + " years");  
        System.out.println("Height: " + HeightInCm+ " meters");
        System.out.println("Weight: " + WeightInKg + " kgs");


        System.out.println("Increment \n");
        System.out.println("Current age: " + age);
        age++; // Increased age
        System.out.println("Age after season: " + age);
        System.out.println("Current jersey number: " + JerseyNumber);
        JerseyNumber--; // Penalty 
        System.out.println("Jersey number after penalty: " + JerseyNumber);

        System.out.println("Eligibility Check \n");

        boolean isEligible = (age >= 18) && (age <= 35) && (WeightInKg < 90);
        System.out.println("Player eligibility: " + (isEligible ? "Eligible" : "Not Eligible"));

        boolean ineligibility = (age < 18) || (WeightInKg >= 90);
        if (ineligibility) {
            System.out.println("Player is not eligible (either too young or too heavy)"); 
        }

        boolean notEligible = !isEligible;
        if (notEligible) {
            System.out.println("Not Eligible (using NOT operator)");
        }
         System.out.println(" Player Categorization \n");
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }
         System.out.println("Player Category: " + category);

         System.out.println("\n  Position Assignment ");
         String position;
         switch (JerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position not known";
         }
         System.out.println("\n Player is a " + position);




        System.out.println("\n Task 7A: Unwanted Fall-through ");
        System.out.println("This shows what happens without proper breaks:");
        switch (JerseyNumber) {
            case 2:
                System.out.println("Defender");
                // Missing break - will fall through
            case 6:
                System.out.println("Midfielder");
                // Missing break - will fall through
            case 7:
                System.out.println("Winger");
                break;
            case 9:
                System.out.println("Striker");
                break;
            default:
                System.out.println("Unknown position");
        }
        
        // Task 7B: Grouped cases (useful fall-through)
        System.out.println("\n Grouped Cases ");
        switch (JerseyNumber) {
            case 2:
            case 5:
                System.out.println("Position: Defender");
                break;
            case 6:
            case 8:
                System.out.println("Position: Midfielder");
                break;
            case 7:
            case 11:
                System.out.println("Position: Winger");
                break;
            case 1:
                System.out.println("Position: Goalkeeper");
                break;
            case 9:
                System.out.println("Position: Striker");
                break;
            case 10:
                System.out.println("Position: Playmaker");
                break;
            default:
                System.out.println("Position: Unknown");
        }
        
        // Check if player is an attacker (jersey numbers 7, 9, 10, 11)
        boolean isAttacker = (JerseyNumber == 7 || JerseyNumber == 9 || JerseyNumber == 10 || JerseyNumber == 11);
        System.out.println("Attacker jersey: " + (isAttacker ? "Yes" : "No"));

        System.out.println("\n Lineup Decision \n");
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (WeightInKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }
        } else {
            lineupDecision = "Bench";
        }
        System.out.println("Lineup Decision: " + lineupDecision);
        
        //Final decision
        System.out.println("\n Final Decision?");
        String finalDecision = isEligible ? "Play" : "Rest";
        System.out.println("Final Decision: " + finalDecision);

         
       System.out.println("\n Final  Player Report ");
        System.out.println("Player: " + PlayerName);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + HeightInCm + "cm");
        System.out.println("Weight: " + WeightInKg + "kg");
        System.out.println("Jersey: " + JerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + (isAttacker ? "Yes" : "No"));
        System.out.println("Eligibility: " + (isEligible ? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);
        

        scanner.close();
    }
}                 
