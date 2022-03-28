package edu.ntnu.idatt2001.trym.cardgame.controller;

import edu.ntnu.idatt2001.trym.cardgame.backend.DealerTable;
import edu.ntnu.idatt2001.trym.cardgame.backend.HandOfCards;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ObligGameController implements Initializable {

    DealerTable dealerTable;

    @FXML
    private ImageView cardFive;

    @FXML
    private ImageView cardFour;

    @FXML
    private ImageView cardThree;

    @FXML
    private ImageView cardTwo;

    @FXML
    private ImageView cardOne;

    @FXML
    private TextField cardsOfHeartText;

    @FXML
    private TextField flushText;

    @FXML
    private TextField queenOfSpadesText;

    @FXML
    private TextField sumFacesText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dealerTable = new DealerTable();
    }

    @FXML
    public void pressCheckHand(ActionEvent event) {
        if(dealerTable.getCurrentHandList().size() == 0) return;
        printSumOfFaces();
        printFlushStatus();
        printCardsOfHearts();
        printQueenOfHeartsCheck();
    }

    @FXML
    public void pressDealHand(ActionEvent event) {
        dealerTable.newTable();
        //Pre-set to five, as per poker rules.
        dealerTable.dealHand(5);
        resetHandInfo();
        linkCardPictures();
    }

    /**
     * This method checks the sum of all the faces on the hand {@link HandOfCards#sumFaceValueOfHand()}. It, thereafter,
     * sets the text of the sumFacesText field to say the value.
     */
    public void printSumOfFaces(){
        //Since in this game there will only be one hand, the index is hard-coded to be 0.
        sumFacesText.setText(String.valueOf(dealerTable.getCurrentHandList().get(0).sumFaceValueOfHand()));
    }

    /**
     * This method checks whether the hand contains a flush {@link HandOfCards#checkForFlush()}. It, thereafter,
     * sets the text of the flushText field to say the Yes!!! {@code true} and No {@code false}.
     */
    public void printFlushStatus(){
        if(dealerTable.getCurrentHandList().get(0).checkForFlush()) flushText.setText("Yes!!!");
        else flushText.setText("No");
    }

    /**
     * This method checks for hearts cards on the hand {@link HandOfCards#printHandInfoBySuit(char)}. It, thereafter,
     * sets the text of the cardsOfHeartText field to state the cards.
     */
    public void printCardsOfHearts(){
        cardsOfHeartText.setText(dealerTable.getCurrentHandList().get(0).printHandInfoBySuit('H'));
    }

    /**
     * This method checks whether the hand contains a queen of hearts {@link HandOfCards#doesCardExistOnHand(char, int)}.
     * It, thereafter, sets the text of the queenOfSpadesText field to say the Yes!!! {@code true} and No {@code false}.
     */
    public void printQueenOfHeartsCheck(){
        if(dealerTable.getCurrentHandList().get(0).doesCardExistOnHand('H', 12))
            queenOfSpadesText.setText("Yes!!!");
        else queenOfSpadesText.setText("No");
    }

    /**
     * This method clears all the text fields.
     */
    private void resetHandInfo(){
        sumFacesText.clear();
        flushText.clear();
        cardsOfHeartText.clear();
        queenOfSpadesText.clear();
    }

    private void linkCardPictures(){
        cardOne.setImage(new Image(getPicturePath(dealerTable.getCurrentHandList().get(0).getHandOfCards().get(0).getAsString())));
        cardTwo.setImage(new Image(getPicturePath(dealerTable.getCurrentHandList().get(0).getHandOfCards().get(1).getAsString())));
        cardThree.setImage(new Image(getPicturePath(dealerTable.getCurrentHandList().get(0).getHandOfCards().get(2).getAsString())));
        cardFour.setImage(new Image(getPicturePath(dealerTable.getCurrentHandList().get(0).getHandOfCards().get(3).getAsString())));
        cardFive.setImage(new Image(getPicturePath(dealerTable.getCurrentHandList().get(0).getHandOfCards().get(4).getAsString())));
    }

    private String getPicturePath(String pictureName){
        return "edu/ntnu/idatt2001/trym/cardgame/cardpictures/" + pictureName + ".png";
    }

}

