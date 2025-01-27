package mastermind;

public class Mastermind {
    public static void main(String[] args) {
        Mastermind_functie function = new Mastermind_functie();
        
        // Generate the computer's code
        String computerCode = function.computerColor();
        
        System.out.println("Guess the code using the following colors: Yellow, Red, Blue, Green, Purple, and Orange.");
        System.out.println("You get 10 attempts before you lose.");
        System.out.println("The colour input is case-sensitive so start with capital letters.");
        
        // Main game loop
        for (int attempt = 1; attempt <= 10; attempt++) {
            System.out.println("\nAttempt " + attempt + " of 10:");
            
            // Get user's guess
            function.getUserColors();
            
            // Check the colors and display result
            String result = function.checkColors();
            System.out.println("\nResults:");
            System.out.println(result);
            
            // Check if user won
            if (result.contains("You win!")) {
                System.out.println("Congratulations! You solved it in " + attempt + " attempts!");
                return;
            }
        }
        
        // If we get here, the user has used all 10 attempts without winning
        System.out.println("\nGame Over! You've used all 10 attempts.");
        System.out.println("The correct code was: " + computerCode);
    }
}