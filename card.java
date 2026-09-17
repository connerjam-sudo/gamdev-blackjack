public class card {
    private String faceValue;
    private String suit;
    private int points;
    
    public card(String value, String suits) {
        faceValue = value;
        suit = suits;
        if (value.equals("Ace")) {
            points = 11;
        } else if (value.equals("Jack") || value.equals("Queen") || value.equals("King")) {
            points = 10;
        } else {
            points = Integer.parseInt(value);
        }

    }

    public String getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoints() {
        return points;
    }

    public void setFaceValue(String value) {
        faceValue = value;
    }

    public void setSuit(String suits) {
        suit = suits;
    }

    public void setPoints(int point) {
        points = point;
    }

    public String toString() {
        return faceValue + " of " + suit + " [ " + points + " ]";
    }
}
