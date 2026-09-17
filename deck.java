import java.util.ArrayList;

public class deck {
    private ArrayList<card> deck1;

    public deck() {
        deck1 = new ArrayList<card>();
    }

    public void printDeck() {
        for (int i = 0; i < deck1.size(); i++) {
            System.out.println(deck1.get(i).toString());
        }
    }

    public void makeDeck() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String faceValue = figureFaceValue(j);
                String suit = figureSuit(i);
                deck1.add(new card(faceValue, suit));
            }
        }
    }
    
    public String figureFaceValue(int i) {
        switch(i) {
            case 1:     return "Ace";
            case 2:     return "2";
            case 3:     return "3";
            case 4:     return "4";
            case 5:     return "5";
            case 6:     return "6";
            case 7:     return "7";
            case 8:     return "8";
            case 9:     return "9";
            case 10:    return "10";
            case 11:    return "Jack";
            case 12:    return "Queen";
            case 13:    return "King";
        }
        return null;
    }

    public String figureSuit(int i) {
        switch(i) {
            case 1: return "Hearts";
            case 2: return "Diamonds";
            case 3: return "Clubs";
            case 4: return "Spades";
        }
        return null;
    }

    public void shuffleDeck() {
        for (int i = 0; i < deck1.size(); i++) {
            int randomIndex = (int)(Math.random() * deck1.size());
            card temp = deck1.get(i);
            deck1.set(i, deck1.get(randomIndex));
            deck1.set(randomIndex, temp);
        }
    }

    public card getCard(int index) {
        return deck1.get(index);
    }

    public void removeCard(int index) {
        deck1.remove(index);
    }

    public void dealCards(hand h1, hand h2, int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (i >= deck1.size() / 2) {
                System.out.println("Not enough cards in the deck to deal " + numCards + " cards to each hand.");
                return;
            }
            h1.drawCard(getCard(i), i, deck1);
            h2.drawCard(getCard(i + numCards), i + numCards, deck1);
        }
    }

    public void dealCards(hand h, int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (i >= deck1.size() / 2) {
                System.out.println("Not enough cards in the deck to deal " + numCards + " cards to each hand.");
                return;
            }
            h.drawCard(getCard(i), i, deck1);
        }
    }
}
