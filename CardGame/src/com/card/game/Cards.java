package com.card.game;

import java.util.logging.Logger;

public class Cards {
	
	static Logger logger = Logger.getLogger(Cards.class.getName());
    private int value;
    private char color;
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Cards() {
        super();
        this.value=-1;
        this.color='u';
    }
    public Cards(int value,char color) {
        this.value = value;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Cards [value=" + value + ", color=" + color +  "]";
    }
    
    public char getColor() {
        return color;
    }
    
    public void setColor(char color) {
        this.color = color;
    }
    
    public void printCard() {
        if(this.value>=2 && this.value<=10) {
            System.out.print("Card: "+this.value);
            logger.info("\nCard: "+this.value);
            }
        else if(this.value==11) {
            System.out.print("Card: "+" Jack");
            logger.info("\nCard: Jack");
            }
        else if(this.value==12) {
            System.out.print("Card: Queen");
            logger.info("\nCard:  Queen");
            }
        else if(this.value==13) {
            System.out.print("Card: King");
            logger.info("\nCard: King");
            }
        else if(this.value==14) {
            System.out.print("Card: Ace");
            logger.info("\nCard: Ace");
            }
        else {
            System.out.print("Wrong Card");
            logger.info("\nCard: Wrong Card");
            }
        
        
        if(this.color=='s') {
            System.out.println(" of Spade");
            }
        else if(this.color=='c') {
            System.out.println(" of Club");
            }
        else if(this.color=='h') {
            System.out.println(" of Hearts");
            }
        else if(this.color=='d') {
            System.out.println(" of Diamond");
            }
        else {
            System.out.println("wrong card");
            
            }
    }
    
}
