package edu.ntnu.idatt2001.trym.cardgame.backend;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class outlines the information and methods that are intrinsic to a hand of cards. Therefore, the hand of cards
 * has been represented using an arrayList of PlayingCards.
 */
public class HandOfCards {
    private List<PlayingCard> handOfCards;

    public HandOfCards(List<PlayingCard> handOfCards) {
        this.handOfCards = handOfCards;
    }


    public int sumFaceValueOfHand(){
        return this.handOfCards.stream().map(playingCard -> playingCard.getFace())
                .reduce(0, Integer::sum);
    }

    public List<PlayingCard> filterHandBySuit(char suit){
        return this.handOfCards.stream().filter(playingCard -> playingCard.getSuit() == suit).toList();
    }

    public String printHandInfo(char suit){
        List<String> filteredList = filterHandBySuit(suit).stream().map(playingCard -> playingCard.toString()).toList();
        if(filteredList.size() < 1){
            return "No " + suit;
        }
        else{
            return String.join(" ", filteredList);
        }
    }

    public boolean doesCardExistOnHand(char suit, int face){
        return this.handOfCards.stream()
                .anyMatch(playingCard -> suit == playingCard.getSuit() && face == playingCard.getFace());
    }

    public boolean checkForFlush(){
        return filterHandBySuit('S').size() == 5 || filterHandBySuit('H').size() == 5
                || filterHandBySuit('D').size() == 5 || filterHandBySuit('C').size() == 5;
    }
}


//TODO: create a button to see if queen of spades exists on the hand