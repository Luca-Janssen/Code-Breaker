package mastermind;

public class Mastermind {
    public static void main(String[] args) {
        Mastermind_functie function = new Mastermind_functie();
        
        // genereer de code
        String computerCode = function.computerColor();
        
        System.out.println("Guess the code using the following colors: Yellow, Red, Blue, Green, Purple, and Orange.");
        System.out.println("You get 10 attempts before you lose.");
        System.out.println("The colour input is case-sensitive so start with capital letters.");
        
        // loop voor de pogingen
        for (int attempt = 1; attempt <= 10; attempt++) {
            System.out.println("\nAttempt " + attempt + " of 10:");
            
            // verzamel de inputs
            function.getUserColors();
            
            // check de kleuren en resultaten
            String result = function.checkColors();
            System.out.println("Results:");
            System.out.println(result);
            
            // check voor een win
            if (result.contains("You win!")) {
                System.out.println("Congratulations! You solved it in " + attempt + " attempts!");
                return;
            }
        }
        
        // alle pogingen zijn op
        System.out.println("Game Over! You've used all 10 attempts.");
        System.out.println("The correct code was: " + computerCode);
    }
}