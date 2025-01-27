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
       

        String[] codeArray = new String[4];
        codeArray[0] = getRandomColor(c);
        codeArray[1] = getRandomColor(c);
        codeArray[2] = getRandomColor(c);
        codeArray[3] = getRandomColor(c);

        int colorsright = 0;
        int rowloop;

        System.out.println("Guess the code using the following colors: Yellow, Red, Blue, Green, Purple, and Orange. You get 10 attempts before you lose. The colour input is case-sensitive so start with capital letters.");
        for (rowloop = 1; rowloop <= 10; rowloop++) {
        	  String[] userColor = new String[4];

            System.out.println("Color one");
            userColor[0] = input.nextLine();
            System.out.println("Color two");
            userColor[1] = input.nextLine();
            System.out.println("Color three");
            userColor[2] = input.nextLine();
            System.out.println("Color four");
            userColor[3] = input.nextLine();

            colorsright = 0;

            if (userColor[0].equals(codeArray[0] )) {
                System.out.println("black");
                colorsright++;
            } else if (userColor[1].equals(codeArray[0]) || userColor[0].equals(codeArray[2]) || userColor[0].equals(codeArray[3])) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor[1].equals(codeArray[1])) {
                System.out.println("black");
                colorsright++;
            } else if (userColor[1].equals(codeArray[0] ) || userColor[1].equals(codeArray[2]) || userColor[1].equals(codeArray[3])) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor[2].equals(codeArray[2])) {
                System.out.println("black");
                colorsright++;
            } else if (userColor[2].equals(codeArray[0] ) || userColor[2].equals(codeArray[1]) || userColor[2].equals(codeArray[3])) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (userColor[3].equals(codeArray[3])) {
                System.out.println("black");
                colorsright++;
            } else if (userColor[3].equals(codeArray[0] ) || userColor[3].equals(codeArray[1]) || userColor[3].equals(codeArray[2])) {
                System.out.println("white");
            } else {
                System.out.println("false");
            }

            if (colorsright == 4) {
                break;
            }
        }

        if (colorsright == 4) {
            System.out.println("you win!");
        } else {
            System.out.println("You lost");
        }
    }

    private static String getRandomColor(String[] colors) {
        int index = random.nextInt(colors.length - 2) + 2; 
        return colors[index];
    }
}