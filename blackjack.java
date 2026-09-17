import java.util.Scanner;

public class blackjack {
    
    private boolean gameOver = false;
    private final Scanner sc;

    public blackjack(Scanner sc) {
        this.sc = sc;
        System.out.println("Welcome to Blackjack!");
    }

    public void play() {
        int numberOfPlayers = 0;
        while (numberOfPlayers != 1 && numberOfPlayers != 2) {
            System.out.println("How many players? (1/2)");
            String playerInput = sc.nextLine();
            if (playerInput.equals("1") || playerInput.equals("2")) {
                numberOfPlayers = Integer.parseInt(playerInput);
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }

        if (numberOfPlayers == 2) {
            playTwoPlayerGame();
            return;
        }
        
        deck Deck1 = new deck();
        Deck1.makeDeck();
        for (int i = 0; i < 50; i++) {
            Deck1.shuffleDeck();
        }
        
        hand Hand1 = new hand();
        hand Hand2 = new hand();
        // hand hand2 = new hand();
        
        Deck1.dealCards(Hand1, 2);
        Deck1.dealCards(Hand2, 2);

        boolean playerHitting = true;
        boolean dealerHitting = true;
        while (!gameOver) {
            System.out.println("-----------------------------------");
            System.out.println("Player's Hand:");
            Hand1.printGraphicHand();
            System.out.println("Dealer's Hand:");
            Hand2.printGraphicHand();
            System.out.println("-----------------------------------");
            
            if (playerHitting) {
                playerHitting = PlayerTurn(Deck1, Hand1);
            }
            if (Hand1.getTotalPoints() > 21) {
                if (!gameOver) {
                    System.out.println("Player busts! Dealer wins.");
                    gameOver = true;
                }
                continue;
            }
            if (!gameOver && dealerHitting) {
                dealerHitting = DealerTurn(Deck1, Hand2, Hand1, playerHitting);
            }

            if (playerHitting == false && dealerHitting == false && !gameOver) {
                if (Hand1.getTotalPoints() > Hand2.getTotalPoints()) {
                    System.out.println("Player wins with " + Hand1.getTotalPoints() + " points!");
                } else if (Hand1.getTotalPoints() < Hand2.getTotalPoints()) {
                    System.out.println("Dealer wins with " + Hand2.getTotalPoints() + " points!");
                } else {
                    System.out.println("It's a tie! Both player and dealer have " + Hand1.getTotalPoints() + " points.");
                }
                gameOver = true;
            }
        }

        System.out.println("Game Over!");

    }

    public void playTwoPlayerGame() {
        deck Deck1 = new deck();
        Deck1.makeDeck();
        for (int i = 0; i < 50; i++) {
            Deck1.shuffleDeck();
        }
        hand Player1Hand = new hand();
        hand Player2Hand = new hand();

        Deck1.dealCards(Player1Hand, 2);
        Deck1.dealCards(Player2Hand, 2);

        boolean player1Hitting = true;
        boolean player2Hitting = true;
        while (!gameOver && (player1Hitting || player2Hitting)) {
            System.out.println("-----------------------------------");
            System.out.println("Player 1's Hand:");
            Player1Hand.printGraphicHand();
            System.out.println("Player 2's Hand:");
            Player2Hand.printGraphicHand();
            System.out.println("-----------------------------------");

            if (player1Hitting) {
                System.out.println("Player 1's Hand:");
                Player1Hand.printGraphicHand();
                player1Hitting = PlayerTurn(Deck1, Player1Hand, "Player 1", false);
            }
            if (player2Hitting) {
                System.out.println("Player 2's Hand:");
                Player2Hand.printGraphicHand();
                player2Hitting = PlayerTurn(Deck1, Player2Hand, "Player 2", false);
            }
        }

        if (!gameOver) {
            announceHeadToHeadWinner(Player1Hand, Player2Hand);
            gameOver = true;
        }

        System.out.println("Game Over!");
    }

    public boolean PlayerTurn(deck Deck1, hand Hand1) {
        return PlayerTurn(Deck1, Hand1, "Player");
    }

    public boolean PlayerTurn(deck Deck1, hand Hand1, String playerName) {
        return PlayerTurn(Deck1, Hand1, playerName, true);
    }

    public boolean PlayerTurn(deck Deck1, hand Hand1, String playerName, boolean endGameOnTerminal) {
        boolean willContinue = true;

        System.out.println(playerName + "'s Turn");
        System.out.println("Do you want to deal another card? (hit/stand)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("hit")) {
                Deck1.dealCards(Hand1, 1);
                if (Hand1.getTotalPoints() > 21) {
                    System.out.println(playerName + "'s Hand:");
                    Hand1.printGraphicHand();
                    if (endGameOnTerminal) {
                        System.out.println(playerName + " busts! Dealer wins.");
                        gameOver = true;
                    } else {
                        System.out.println(playerName + " busts.");
                    }
                    return false;
                }
                System.out.println(playerName + "'s Hand:");
                Hand1.printGraphicHand();
            } else if (input.equalsIgnoreCase("stand")) {
                System.out.println(playerName + " stands with " + Hand1.getTotalPoints() + " points.");
                willContinue = false;
            }   else {
                System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
            }
            
            boolean handIsFinished = endGameOnTerminal
                    ? checkHandLogic(Hand1, playerName)
                    : checkTwoPlayerHandLogic(Hand1, playerName);
            if (handIsFinished) {
                return false;
            }

        if (willContinue) {
                return true;
            } else {
                return false;
            }
    }

    public boolean DealerTurn(deck Deck1, hand Hand2, hand Hand1, boolean playerHitting) {
        if (Hand1.getTotalPoints() > 21) {
            return false;
        }

        System.out.println("Dealer's Turn");
        if (Hand2.getTotalPoints() < 17
                && (playerHitting || Hand2.getTotalPoints() <= Hand1.getTotalPoints())) {
            Deck1.dealCards(Hand2, 1);
            System.out.println("Dealer hits and draws a card.");
            System.out.println("Dealer's Hand:");
            Hand2.printGraphicHand();
        }
        if (checkDealerLogic(Hand2)) {
            return false;
        } else if (!playerHitting && Hand2.getTotalPoints() > Hand1.getTotalPoints()) {
            System.out.println("Dealer stands with " + Hand2.getTotalPoints() + " points.");
            return false;
        } else if (Hand2.getTotalPoints() >= 17) {
            System.out.println("Dealer stands with " + Hand2.getTotalPoints() + " points.");
            return false;
        } else {
            return true;
        }
    }

    public void announceHeadToHeadWinner(hand Player1Hand, hand Player2Hand) {
        int player1Points = Player1Hand.getTotalPoints();
        int player2Points = Player2Hand.getTotalPoints();
        if (player1Points > 21 && player2Points > 21) {
            System.out.println("Both players busted.");
        } else if (player1Points > 21 || (player2Points <= 21 && player1Points < player2Points)) {
            System.out.println("Player 2 wins with " + player2Points + " points!");
        } else if (player2Points > 21 || player1Points > player2Points) {
            System.out.println("Player 1 wins with " + player1Points + " points!");
        } else {
            System.out.println("It's a tie! Both players have " + player1Points + " points.");
        }
    }

    public boolean checkTwoPlayerHandLogic(hand Hand1, String playerName) {
        if (Hand1.getTotalPoints() > 21) {
            System.out.println(playerName + " busts.");
            return true;
        } else if (Hand1.getTotalPoints() == 21) {
            System.out.println(playerName + " has Blackjack and stands.");
            return true;
        } else if (Hand1.getHandSize() >= 5) {
            System.out.println(playerName + " has reached the maximum hand size of 5 cards.");
            return true;
        }
        return false;
    }

    public boolean checkHandLogic(hand Hand1) {
        return checkHandLogic(Hand1, "Player");
    }

    public boolean checkHandLogic(hand Hand1, String playerName) {
        if (Hand1.getTotalPoints() > 21) {
                System.out.println(playerName + " busts! Dealer wins.");
                gameOver = true;
                return true;
            } else if (Hand1.getTotalPoints() == 21) {
                System.out.println(playerName + " has Blackjack!");
                gameOver = true;
                return true;
            } else
            if (Hand1.getHandSize() >= 5) {
                System.out.println(playerName + " has reached the maximum hand size of 5 cards.");
                return true;
            }
        return false;
    }

    public boolean checkDealerLogic(hand Hand2) {
        if (Hand2.getTotalPoints() > 21) {
                System.out.println("Dealer busts! Player wins.");
                gameOver = true;
                return true;
            } else if (Hand2.getTotalPoints() == 21) {
                System.out.println("Dealer has Blackjack! Dealer wins.");
                gameOver = true;
                return true;
            } else
            if (Hand2.getHandSize() >= 5) {
                System.out.println("Dealer has reached the maximum hand size of 5 cards.");
                return true;
            }
        return false;
    }

}
