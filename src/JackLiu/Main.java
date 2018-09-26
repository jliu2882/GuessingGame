package JackLiu;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner nameScan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = nameScan.nextLine();
        Scanner game = new Scanner(System.in);
        System.out.println("Hey, " + name + ", who should be guessing the number? Type in computer or player.");
        String player = game.nextLine();
        int guesses = 0;
        if(player.toUpperCase().equals("COMPUTER")){
            boolean victory = false;
            int lower = 0;
            int higher = 100;
            int guess = 50;
            while(victory != true){
                guess = (lower + higher)/2;
                System.out.println("Hey," + name + " , is your number greater than, less than, or equal to " + guess + "? Type in greater, less, or correct to indciate your response!");
                Scanner test = new Scanner(System.in);
                String str = test.nextLine();
                if(str.toUpperCase().equals("GREATER")){
                    lower = (lower + higher)/2;
                    if(lower%2 == 1){
                        lower++;
                    }
                }
                else if(str.toUpperCase().equals("LESS")){
                    higher = guess;
                }
                else if(str.toUpperCase().equals("CORRECT")){
                    System.out.println("AI wins!");
                    victory = true;
                }
                else{
                    guesses--;
                }
                guesses++;
            }
        }
        else if(player.toUpperCase().equals("PLAYER")){
            Scanner difficulty = new Scanner(System.in);
            System.out.println(name + ",please choose a difficulty(1,2,3 or 4)");
            int difficultyNum = difficulty.nextInt();
            double x = Math.pow(10,difficultyNum);
            Scanner test = new Scanner(System.in);
            int randomNumber = (int)(x*Math.random())+1;
            System.out.println("Pick a number between 1 and " + (int)x);
            int guess = test.nextInt();
            while(guess != randomNumber){
                System.out.println("Wrong");
                guesses++;
                guess = test.nextInt();
            }
            guesses++;
            System.out.println(name + " wins!");
        }
        else{
            System.out.println("That is not a valid choice!, please choose again " + name);
        }
        System.out.println("The game ended in " + guesses + " amount of guesses");
    }
}
