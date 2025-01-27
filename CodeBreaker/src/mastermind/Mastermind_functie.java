package mastermind;

import java.util.Random;
import java.util.Scanner;

public class Mastermind_functie {
    public String[] c = {"Black", "White", "Yellow", "Red", "Blue", "Green", "Purple", "Orange"};
    public String[] codeArray = new String[4];
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();
    private String[] userColors = new String[4];

    public String getRandomColor(String[] colors) {
        int index = random.nextInt(colors.length - 2) + 2;
        return colors[index];
    }

    public String computerColor() {
        String colorString = "";
        for (int i = 0; i < 4; i++) {
            codeArray[i] = getRandomColor(c);
            colorString += codeArray[i] + " ";
        }
        return colorString.trim();
    }

    public String getUserColors() {
        String userColorString = "";
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter color " + (i + 1) + ": ");
            userColors[i] = input.nextLine();
            userColorString += userColors[i] + " ";
        }
        return userColorString.trim();
    }

    public String checkColors() {
        String result = "";
        int colorsRight = 0;

        for (int i = 0; i < 4; i++) {
            if (userColors[i].equalsIgnoreCase(codeArray[i])) {
                result += "Black\n";  // juiste kleur juiste plek
                colorsRight++;
            } else if (hasColorInOtherPosition(userColors[i], i)) {
                result += "White\n";  // juiste kleur maar verkeerde positie
            } else {
                result += "None\n";   // kleur niet in de code
            }
        }

        if (colorsRight == 4) {
            result += "You win!";
        } else {
            result += "Try again!";
        }

        return result;
    }

    public boolean hasColorInOtherPosition(String userColor, int currentPos) {
        for (int i = 0; i < codeArray.length; i++) {
            if (i != currentPos && userColor.equalsIgnoreCase(codeArray[i])) {
                return true;
            }
        }
        return false;
    }
}