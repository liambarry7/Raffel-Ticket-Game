package treasurehunt;
import java.util.Scanner;
import java.util.Random;


public class TreasureHunt {
    
    private static String[][] board = new String[10][10];
    private static int totalPoints = 0;
    
    public static void setupBoard() {
        Random rand = new Random();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "[ ]";
            }
        }
        
         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }        
        
        for (int i = 0; i < 20; i++) {
            int X = rand.nextInt(10);
            int Y = rand.nextInt(10);
            board[X][Y] = ("[X]");

        }      
       
    }
    
    
    public static void coordinates(){
        int guesses = 0;
        
        boolean valid = false;
        while (valid == false) {
            try {
                Scanner input = new Scanner(System.in);
                Random rand = new Random();

                for (int j = 0; j < 20; j++) {
                    System.out.println("Enter X coordinate");
                    int xCoord = input.nextInt();
                    System.out.println("Enter Y coordinate");
                    int yCoord = input.nextInt();
                    
                    guesses++;

                    if (board[xCoord][yCoord] != "[ ]") {
                        int coins = rand.nextInt(9 - 1) + 1;
                        totalPoints = totalPoints + coins;
                        System.out.println("You just found " + coins + " Coins!");
                    } else if (board[xCoord][yCoord] == "[ ]") {
                        System.out.println("\nHAHA! \nThere is no treasure!\nGuess again.");
                    }
                    
                    System.out.println("Guesses: " + guesses + "\n");
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Exception occured:" + e);
            }
            
        }
    }
    
    private static void weAreInTheEndGameNow(){
        if (totalPoints < 20) {
            System.out.println("HAHA!\nYou're not very good at this game!");
        } else if (totalPoints > 20 && totalPoints < 50) {
            System.out.println("With a bit of practice, you could become quite the hunter!");
        } else if (totalPoints > 50){
            System.out.println("Oi! You stole all my MONEY!\nYOU'LL PAY FOR THIS!!!!!");
        }
        System.out.println("You found " + totalPoints + " Coins!");
    }

    
    public static void main(String[] args) {
        System.out.println("There are 20 pieces of hidden loot on this square island.\nCan you find them all?\n");
        
        setupBoard();    
        coordinates();
        weAreInTheEndGameNow();
        

    }
    
    
}

