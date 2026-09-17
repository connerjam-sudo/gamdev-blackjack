import java.util.ArrayList;

public class hand {
    private ArrayList<card> hand;

    public hand() {
        hand = new ArrayList<card>();
    }

    public void drawCard(card c, int index) {
        hand.add(c);
    }

    public void drawCard(card c, int index, ArrayList<card> deck) {
        hand.add(c);
        deck.remove(index);
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        int numAces = 0;

        for (card c : hand) {
            totalPoints += c.getPoints();
            if (c.getFaceValue().equals("Ace")) {
                numAces++;
            }
        }

        while (totalPoints > 21 && numAces > 0) {
            totalPoints -= 10;
            numAces--;
        }

        return totalPoints;
    }

    public void printHand() {
        int totalPoints = 0;
        int aceCount = 0;
        for (card c : hand) {
            totalPoints += c.getPoints();
            if (c.getFaceValue().equals("Ace")) {
                aceCount++;
            }
        }

        int acesAsOne = 0;
        while (totalPoints > 21 && acesAsOne < aceCount) {
            totalPoints -= 10;
            acesAsOne++;
        }

        int aceNumber = 0;
        for (int i = 0; i < hand.size(); i++) {
            card currentCard = hand.get(i);
            int points = currentCard.getPoints();
            if (currentCard.getFaceValue().equals("Ace")) {
                points = aceNumber < aceCount - acesAsOne ? 11 : 1;
                aceNumber++;
            }
            System.out.println(currentCard.getFaceValue() + " of "
                    + currentCard.getSuit() + " [ " + points + " ]");
        }
    }

    public void printGraphicHand() {
        cardgraphic[] graphicHand = new cardgraphic[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            card currentCard = hand.get(i);
            graphicHand[i] = new cardgraphic(
                    currentCard.getFaceValue(),
                    currentCard.getSuit(),
                    currentCard.getPoints());
        }
        cardgraphic.printHand(graphicHand);
        System.out.println("Total points: " + getTotalPoints());
    }

    public int getHandSize() {
        return hand.size();
    }

    public String toString() {
        String handString = "";
        for (int i = 0; i < hand.size(); i++) {
            handString += hand.get(i).toString() + "\n";
        }
        return hand + handString;
    }
}
