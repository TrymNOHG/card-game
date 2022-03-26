package edu.ntnu.idatt2001.trym.cardgame.backend;

import java.util.List;

/**
 * This class outlines the information and methods that are intrinsic to a hand of cards. Therefore, the hand of cards
 * has been represented using an arrayList of PlayingCards.
 */
public class HandOfCards {
    private List<PlayingCard> handOfCards;

    /**
     * This is constructor allows for an object representing a hand of cards to be initialized. It, therefore,
     * takes in a List of playing cards and defines the handOfCards list.
     * @param handOfCards A hand of cards, represented by a List of PlayingCard objects
     */
    public HandOfCards(List<PlayingCard> handOfCards) {
        this.handOfCards = handOfCards;
    }

    /**
     * This method gets the sum of all the face values of a hand.
     * @return Sum of face values, represented as an int
     */
    public int sumFaceValueOfHand(){
        return this.handOfCards.stream().map(playingCard -> playingCard.getFace())
                .reduce(0, Integer::sum);
    }

    /**
     * This method filters a hand for a certain suit and creates a list of PlayingCard objects with that suit.
     * @param suit Desired suit, represented as a char
     * @return     All the cards with the desired suit, represented as a list of PlayingCard objects
     */
    public List<PlayingCard> filterHandBySuit(char suit){
        return this.handOfCards.stream().filter(playingCard -> playingCard.getSuit() == suit).toList();
    }

    /**
     * This method prints the information of a given suit by using {@link #filterHandBySuit(char)}.
     * @param suit Desired suit, represented by a char
     * @return     String of cards, if there are any, with suit. If there are none, then No (suit) string is returned
     */
    public String printHandInfoBySuit(char suit){
        List<String> filteredList = filterHandBySuit(suit).stream().map(playingCard -> playingCard.getAsString()).toList();
        if(filteredList.size() < 1){
            return "No " + suit;
        }
        else{
            return String.join(" ", filteredList);
        }
    }

    /**
     * This method checks if a given card exists on the hand, done by checking both suit and face of the hand.
     * @param suit Suit of the card, represented by a char
     * @param face Face value of the card, represented by int
     * @return     Status of the hand {@code true} if card exists on hand, if it doesn't {@code false}
     */
    public boolean doesCardExistOnHand(char suit, int face){
        return this.handOfCards.stream()
                .anyMatch(playingCard -> suit == playingCard.getSuit() && face == playingCard.getFace());
    }

    /**
     * This method checks the hand for a flush.
     * @return Status of the hand. {@code true} if hand contains a flush. If it doesn't {@code false}.
     */
    public boolean checkForFlush(){
        return filterHandBySuit('S').size() == 5 || filterHandBySuit('H').size() == 5
                || filterHandBySuit('D').size() == 5 || filterHandBySuit('C').size() == 5;
    }
}


//TODO: create a button to see if queen of spades exists on the hand