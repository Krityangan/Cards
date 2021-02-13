package com.card.game;

import java.util.logging.Logger;

public class Player {

	static Logger logger = Logger.getLogger(Cards.class.getName());
        private Cards[] playerCards;
        
        //player metaData
        private boolean hasTrail;
        private int trailValue;
        private boolean hasSequence;
        private int sequMaxValue;
        private boolean hasPair;
        private int pairValue;
        
        private String playerName;
    
        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public Player() {
            super();
            this.playerCards = new Cards[3];
            
        }
        
        public Player(String playerName) {
            //super();
            this.playerName = playerName;
            this.playerCards = new Cards[3];
            
        }

        public Cards[] getPlayerCards() {
            return playerCards;
        }
    
        public void setPlayerCards(Cards[] playerCards) {
            this.playerCards = playerCards;
        }
    
       
    
        public void dealPlayersCard(Deck curDeck) {
           // curDeck.setCardAtIndexDealt(13, true);
            System.out.println("Dealing "+this.getPlayerName()+" cards");
            for(int i=0;i<3;i++) {
                Cards card ;//= new Cards();
                card = curDeck.drawCard();
                playerCards[i] = card;
                card.printCard();
            }
            
        }
        
        
        
        public int getPlayerCard(int index) {
            return playerCards[index].getValue();
        }

        public boolean hasTrail() {
            return hasTrail;
        }

        public void setHasTrail(boolean containTrial) {
            this.hasTrail = containTrial;
        }
        

        public int getTrailValue() {
            return trailValue;
        }

        public void setTrailValue(int trialValue) {
            this.trailValue = trialValue;
        }

        public boolean hasSequence() {
            return hasSequence;
        }

        public void setHasSequence(boolean containSequence) {
            this.hasSequence = containSequence;
        }

        public int getSequMaxValue() {
            return sequMaxValue;
        }

        public void setSequMaxValue(int sequMaxValue) {
            this.sequMaxValue = sequMaxValue;
        }

        public boolean hasPair() {
            return hasPair;
        }

        public void setHasPair(boolean containPair) {
            this.hasPair = containPair;
        }

        public int getPairValue() {
            return pairValue;
        }

        public void setPairValue(int pairValue) {
            this.pairValue = pairValue;
        }

       
        
        public void checkForTrail() {
            
            if(playerCards[0].getValue()==playerCards[1].getValue() && playerCards[1].getValue()==playerCards[2].getValue()) {
                this.hasTrail = true;
                this.trailValue = playerCards[1].getValue();
            }
            else {
                this.hasTrail=false;
                this.trailValue =-1;
            }
            
        }
        
        public void checkForSequence() {
            int min = Math.min(playerCards[0].getValue(), Math.min(playerCards[1].getValue(), playerCards[2].getValue()));
            int max = Math.max(playerCards[0].getValue(), Math.max(playerCards[1].getValue(), playerCards[2].getValue()));
            if(max-min ==2 && playerCards[0].getValue()!=playerCards[1].getValue() && 
            playerCards[1].getValue()!=playerCards[2].getValue() && 
                    playerCards[0].getValue()!=playerCards[2].getValue()) 
            {
                this.hasSequence = true;
                this.sequMaxValue = max;
            }
            else {
                this.hasSequence = false;
                this.sequMaxValue = -1;
            }
           
        }
        
        
        public void havePair() {
            if(playerCards[0].getValue()==playerCards[1].getValue()) {
                this.hasPair=true;
                this.pairValue = playerCards[0].getValue();
            }
                
            else if(playerCards[1].getValue()==playerCards[2].getValue() ) {
                this.hasPair = true;
                this.pairValue = playerCards[1].getValue();
            }
            else if(playerCards[0].getValue()==playerCards[2].getValue()) {
                this.hasPair=true;
                this.pairValue = playerCards[0].getValue();
            }
            else {
                this.hasPair = false;
                this.pairValue = -1;
            }
        }
      
        public void createPlayerMetaData() {
            
            if(this.playerCards[0].getValue()==14) 
                this.playerCards[0].setValue(1);
            if(this.playerCards[1].getValue()==14) 
                this.playerCards[1].setValue(1);
            if(this.playerCards[2].getValue()==14) 
                this.playerCards[2].setValue(1);
            
            checkForSequence();
            
            if(this.playerCards[0].getValue()==1) 
                this.playerCards[0].setValue(14);
            if(this.playerCards[1].getValue()==1) 
                this.playerCards[1].setValue(14);
            if(this.playerCards[2].getValue()==1) 
                this.playerCards[2].setValue(14);
            
            checkForTrail();
            havePair();
        }
      
}
