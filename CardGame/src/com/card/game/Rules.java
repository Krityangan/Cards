package com.card.game;

import java.util.logging.Logger;

public class Rules {
	static Logger logger = Logger.getLogger(Cards.class.getName());
    public int checkForTrail(Player p1,Player p2) {
        if(p1.hasTrail() && p2.hasTrail()) {
            if(p1.getTrailValue() > p2.getTrailValue()) {
            	logger.info("\nRule : 1" );
                return 1;
                }
            else if(p1.getTrailValue()==p2.getTrailValue()) {
            	logger.info("\nRule : 0" );
            	return 0;
            }
            else
            {
            	logger.info("\nRule : 2" );
                return 2;
            }
        }
        if(p1.hasTrail()) {
            return 1;
        }
        if(p2.hasTrail())
            return 2;
        return -1;
    }
    
    public int checkForSequence(Player p1,Player p2) {
        if(p1.hasSequence() && p2.hasSequence()) {
            if(p1.getSequMaxValue() > p2.getSequMaxValue())
                return 1;
            else if(p1.getSequMaxValue()==p2.getSequMaxValue()) {
                return 0;
            }
            else 
                return 2;
        }
        if(p1.hasSequence())
            return 1;
        if(p2.hasSequence())
            return 2;
        return -1;
    }
    
    public int checkForPair(Player p1,Player p2) {
        if(p1.hasPair() && p2.hasPair()) {
            if(p1.getPairValue() > p2.getPairValue())
                return 1;
            else if(p1.getPairValue()==p2.getPairValue()) {
                return 0;
            }
            else 
                return 2;
        }
        if(p1.hasPair())
            return 1;
        if(p2.hasPair())
            return 2;
        return -1;
    }

}
