package mastermind;

import java.util.*;

public class Mastermind {
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        String[] c = new String[8];

        c[0] = "Black";  
        c[1] = "White";   
        c[2] = "Yellow"; 
        c[3] = "Red";    
        c[4] = "Blue";    
        c[5] = "Green";   
        c[6] = "Purple";  
        c[7] = "Orange"; 

        // Randomly select 4 colors from the array, excluding values 0 and 1
        String computerColor1 = getRandomColor(c);
        String computerColor2 = getRandomColor(c);
        String computerColor3 = getRandomColor(c);
        String computerColor4 = getRandomColor(c);

        int colorsright = 0;
        int rowloop;

        System.out.println("Guess the code using the following colors: Yellow, Red, Blue, Green, Purple, and Orange. You get 10 attempts before you lose. The colour input is case-sensitive so start with capital letters.");
        for (rowloop = 1; rowloop <= 10; rowloop++) {
            String userColor1, userColor2, userColor3, userColor4;

            System.out.println("Color one");
            userColor1 = input.nextLine();
            System.out.println("Color two");
            userColor2 = input.nextLine();
            System.out.println("Color three");
            userColor3 = input.nextLine();
            System.out.println("Color four");
            userColor4 = input.nextLine();

            colorsright = 0; // Reset colorsright for each guess

            // Check each user's color against the computer's colors
            if (userColor1.equals(computerColor1)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor1.equals(computerColor2) || userColor1.equals(computerColor3) || userColor1.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor2.equals(computerColor2)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor2.equals(computerColor1) || userColor2.equals(computerColor3) || userColor2.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor3.equals(computerColor3)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor3.equals(computerColor1) || userColor3.equals(computerColor2) || userColor3.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor4.equals(computerColor4)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor4.equals(computerColor1) || userColor4.equals(computerColor2) || userColor4.equals(computerColor3)) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (colorsright == 4) {
                break; // Exit the loop if the user has guessed all colors correctly
            }
        }

        if (colorsright == 4) {
            System.out.println("you win!");
        } else {
            System.out.println("You lost");
        }
    }

    // Method to get a random color from the array excluding values 0 and 1
    private static String getRandomColor(String[] colors) {
        int index = random.nextInt(colors.length - 2) + 2; // Generates a random index from 2 to 7
        return colors[index];
    }
}