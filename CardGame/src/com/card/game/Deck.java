package com.card.game;

import java.util.Random;
import java.util.logging.Logger;

public class Deck {
	static Logger logger = Logger.getLogger(Cards.class.getName());
    private Cards[] deck;
    private static int remainingDeck;
    static {
        remainingDeck=51;
    }
   
    public Deck() {
        super();
        this.deck = new Cards[52];
    }

    private static char[] cardColor;

    static {
        cardColor = new char[4];
        cardColor[0] = 's';
        cardColor[1] = 'c';
        cardColor[2] = 'h';
        cardColor[3] = 'd';
    }
    
    public Cards[] getDeck() {
        return this.deck;
    }

    public void setDeck(Cards[] deck) {
        this.deck = deck;
    }
    
  
    public void generateDeck() {
        int k=0;
        for(int j=0;j<4;j++) {
            for(int i=2;i<=14;i++) {
                Cards card=new Cards();
                card.setColor(cardColor[j]);
                card.setValue(i);
                
                this.deck[k]=card;
                k++;
                logger.info("\nGenerate Deck "+ card);
            }
        }
    }
    
    public void shuffleDeck() {
        Random rand = new Random();
        for(int i=0;i<52;i++) {
            int r = i+ rand.nextInt(52-i);
            
            Cards tempCard = this.deck[r];
            this.deck[r] = this.deck[i];
            this.deck[i]= tempCard;
            logger.info("\nShuffle Deck Cards"+ tempCard);
        }
        
    }
    
    public Cards drawCard() {
        if(remainingDeck!=-1) {
            Cards tempCard = deck[remainingDeck];
            remainingDeck--;
            logger.info("\nDraw Deck Cards"+ tempCard.toString());
            return tempCard;
            
        }
        else {
            return null;
        }
    }
    
    public void showDeck() {
        for(int i=0;i<52;i++) {
        	 logger.info("\nShow Deck Cards"+ deck[i]);
            System.out.println(deck[i]);
        }
    }
    
   
}
