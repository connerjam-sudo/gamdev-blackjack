import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What game would you like to play? (blackjack)");

        String input = sc.nextLine();
        if (input.equalsIgnoreCase("blackjack")) {
            blackjack game = new blackjack(sc);
            game.play();
            while (true) {
                System.out.println("\nNew game? (yes/no)");
                String newGameInput = sc.nextLine();
                if (newGameInput.equalsIgnoreCase("yes")) {
                    game = new blackjack(sc);
                    game.play();
                } else if (newGameInput.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            
        } else if (input.equalsIgnoreCase("test")) {
            // Run test code here
            cardgraphic testCard = new cardgraphic("Ace", "Diamonds", 11);
            cardgraphic.printHand(new cardgraphic[] {
                new cardgraphic("13", "Hearts", 10),
                new cardgraphic("13", "Spades", 10),
                new cardgraphic("13", "Diamonds", 10),
                new cardgraphic("13", "Clubs", 10)
            });
        }
        
        sc.close();
    }

}
