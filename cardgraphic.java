public class cardgraphic {
    private static final int CARD_WIDTH = 11;
    private String faceValue;
    private String suit;
    private int points;

    public cardgraphic(String f, String s, int p) {
        faceValue = f;
        suit = s;
        points = p;
    }

    public String makeGraphic() {
        String[][] graphic = makeGraphicArray();
        String result = "";
        for (int row = 0; row < graphic.length; row++) {
            result += graphic[row][0];
            if (row < graphic.length - 1) {
                result += "\n";
            }
        }
        return result;
    }

    public String[][] makeGraphicArray() {
        String[] lines = makeGraphicLines();
        String[][] graphic = new String[lines.length][1];
        for (int row = 0; row < lines.length; row++) {
            graphic[row][0] = String.format("%-" + CARD_WIDTH + "s", lines[row]);
        }
        return graphic;
    }

    public static void printHand(cardgraphic[] hand) {
        if (hand.length == 0) {
            return;
        }

        String[][] handGraphic = new String[7][hand.length];
        for (int cardNumber = 0; cardNumber < hand.length; cardNumber++) {
            String[][] cardGraphic = hand[cardNumber].makeGraphicArray();
            for (int row = 0; row < handGraphic.length; row++) {
                handGraphic[row][cardNumber] = row < cardGraphic.length
                        ? cardGraphic[row][0]
                    : "          ";
            }
        }

        for (int row = 0; row < handGraphic.length; row++) {
            for (int cardNumber = 0; cardNumber < handGraphic[row].length; cardNumber++) {
                System.out.print(handGraphic[row][cardNumber]);
                if (cardNumber < handGraphic[row].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private String[] makeGraphicLines() {
        if (faceValue.equals("Ace")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |A       |", " |v       |", " |  (\\/)  |",
                    " |   \\/   |", " |       ^|", " |_______V|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |A       |", " |*   ^   |", " |  <   > |",
                    " |    v   |", " |       *|", " |_______V|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |A       |", " |+   ^   |", " |   < >  |",
                    " |    |   |", " |       +|", " |_______V|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |A       |", " |^   ^   |", " |   ( )  |",
                    " |    |   |", " |       v|", " |_______V|"
                };
            } else {
                return new String[0];
            }
        }

        if (faceValue.equals("2")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |2       |", " |v (\\/)  |", " |   \\/   |",
                    " |  (\\/)  |", " |   \\/  ^|", " |_______2|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |2       |", " |*   *   |", " |        |",
                    " |    *   |", " |       *|", " |_______2|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |2       |", " |+   +   |", " |        |",
                    " |    +   |", " |       +|", " |_______2|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |2       |", " |o   o   |", " |        |",
                    " |    o   |", " |       o|", " |_______2|"
                };
            }
        } else if (faceValue.equals("3")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |3       |", " |v   v   |", " |    v   |",
                    " |    v   |", " |       ^|", " |_______3|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |3       |", " |*   *   |", " |    *   |",
                    " |    *   |", " |       *|", " |_______3|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |3       |", " |+   +   |", " |    +   |",
                    " |    +   |", " |       +|", " |_______3|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |3       |", " |o   o   |", " |    o   |",
                    " |    o   |", " |       o|", " |_______3|"
                };
            }
        } else if (faceValue.equals("4")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |4       |", " |v v  v  |", " |        |",
                    " |        |", " |  v  v ^|", " |_______4|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |4       |", " |* *  *  |", " |        |",
                    " |        |", " |  *  * *|", " |_______4|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |4       |", " |+ +  +  |", " |        |",
                    " |        |", " |  +  + +|", " |_______4|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |4       |", " |o o  o  |", " |        |",
                    " |        |", " |  o  o o|", " |_______4|"
                };
            }
        } else if (faceValue.equals("5")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |5       |", " |v v  v  |", " |    v   |",
                    " |  v  v  |", " |       ^|", " |_______5|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |5       |", " |* *  *  |", " |    *   |",
                    " |  *  *  |", " |       *|", " |_______5|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |5       |", " |+ +  +  |", " |    +   |",
                    " |  +  +  |", " |       +|", " |_______5|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |5       |", " |o o  o  |", " |    o   |",
                    " |  o  o  |", " |       o|", " |_______5|"
                };
            }
        } else if (faceValue.equals("6")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |6       |", " |v v  v  |", " |        |",
                    " |  v  v  |", " |  v  v ^|", " |_______6|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |6       |", " |* *  *  |", " |        |",
                    " |  *  *  |", " |  *  * *|", " |_______6|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |6       |", " |+ +  +  |", " |        |",
                    " |  +  +  |", " |  +  + +|", " |_______6|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |6       |", " |o o  o  |", " |        |",
                    " |  o  o  |", " |  o  o o|", " |_______6|"
                };
            }
        } else if (faceValue.equals("7")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |7       |", " |v v  v  |", " |    v   |",
                    " |  v  v  |", " |  v  v ^|", " |_______7|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |7       |", " |* *  *  |", " |    *   |",
                    " |  *  *  |", " |  *  * *|", " |_______7|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |7       |", " |+ +  +  |", " |    +   |",
                    " |  +  +  |", " |  +  + +|", " |_______7|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |7       |", " |o o  o  |", " |    o   |",
                    " |  o  o  |", " |  o  o o|", " |_______7|"
                };
            }
        } else if (faceValue.equals("8")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |8       |", " |v v  v  |", " |  v  v  |",
                    " |  v  v  |", " |  v  v ^|", " |_______8|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |8       |", " |* *  *  |", " |  *  *  |",
                    " |  *  *  |", " |  *  * *|", " |_______8|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |8       |", " |+ +  +  |", " |  +  +  |",
                    " |  +  +  |", " |  +  + +|", " |_______8|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |8       |", " |o o  o  |", " |  o  o  |",
                    " |  o  o  |", " |  o  o o|", " |_______8|"
                };
            }
        } else if (faceValue.equals("9")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |9       |", " |v v v v |", " |  v  v  |",
                    " |  v  v  |", " |  v  v ^|", " |_______9|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |9       |", " |* * * * |", " |  *  *  |",
                    " |  *  *  |", " |  *  * *|", " |_______9|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |9       |", " |+ + + + |", " |  +  +  |",
                    " |  +  +  |", " |  +  + +|", " |_______9|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |9       |", " |o o o o |", " |  o  o  |",
                    " |  o  o  |", " |  o  o o|", " |_______9|"
                };
            }
        } else if (faceValue.equals("10")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |10      |", " |v v v v |", " |  v  v  |",
                    " |  v  v  |", " | v v v ^|", " |______10|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |10      |", " |* * * * |", " |  *  *  |",
                    " |  *  *  |", " | * * * *|", " |______10|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |10      |", " |+ + + + |", " |  +  +  |",
                    " |  +  +  |", " | + + + +|", " |______10|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |10      |", " |o o o o |", " |  o  o  |",
                    " |  o  o  |", " | o o o o|", " |______10|"
                };
            }
        } else if (faceValue.equals("Jack")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |J       |", " |v  J    |", " |   /|   |",
                    " |  / v   |", " |    J  v|", " |_______J|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |J       |", " |*  J    |", " |   /|   |",
                    " |  / *   |", " |    J  *|", " |_______J|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |J       |", " |+  J    |", " |   /|   |",
                    " |  / +   |", " |    J  +|", " |_______J|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |J       |", " |o  J    |", " |   /|   |",
                    " |  / o   |", " |    J  o|", " |_______J|"
                };
            }
        } else if (faceValue.equals("Queen")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |Q       |", " |v  Q    |", " |  /v\\   |",
                    " |  \\_/   |", " |    Q  v|", " |_______Q|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |Q       |", " |*  Q    |", " |  / *\\  |",
                    " |  \\_/   |", " |    Q  *|", " |_______Q|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |Q       |", " |+  Q    |", " |  / +\\  |",
                    " |  \\_/   |", " |    Q  +|", " |_______Q|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |Q       |", " |o  Q    |", " |  / o\\  |",
                    " |  \\_/   |", " |    Q  o|", " |_______Q|"
                };
            }
        } else if (faceValue.equals("King")) {
            if (suit.equals("Hearts")) {
                return new String[] {
                    "  ________", " |K       |", " |v  K    |", " |  /|\\   |",
                    " |   | v  |", " |    K  v|", " |_______K|"
                };
            } else if (suit.equals("Diamonds")) {
                return new String[] {
                    "  ________", " |K       |", " |*  K    |", " |  /|\\   |",
                    " |   | *  |", " |    K  *|", " |_______K|"
                };
            } else if (suit.equals("Clubs")) {
                return new String[] {
                    "  ________", " |K       |", " |+  K    |", " |  /|\\   |",
                    " |   | +  |", " |    K  +|", " |_______K|"
                };
            } else if (suit.equals("Spades")) {
                return new String[] {
                    "  ________", " |K       |", " |o  K    |", " |  /|\\   |",
                    " |   | o  |", " |    K  o|", " |_______K|"
                };
            }
        }

        return new String[0];
    }


}
