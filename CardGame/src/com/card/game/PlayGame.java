package com.card.game;

import java.util.*;
import java.util.logging.Logger;

public class PlayGame {

	static Logger logger = Logger.getLogger(Cards.class.getName());
    public static void checkForTrailWinners(ArrayList<Player> winnerList,ArrayList<Player> playersArray,Rules ruleBook) {
        
        for(int i=0;i<playersArray.size()-1;i++) {
            int res = ruleBook.checkForTrail(playersArray.get(i),playersArray.get(i+1));
            if(winnerList.size()==0) {
                if(res==0) {
                    System.out.println("This case should never arise");
                    winnerList.add(playersArray.get(i));
                    winnerList.add(playersArray.get(i+1));
                }
                else if(res==1) {
                    winnerList.add(playersArray.get(i));
                }
                else if(res==2) {
                    winnerList.add(playersArray.get(i+1));
                }
                continue;
            }
            if(res==1) {
                int winnerScore = winnerList.get(winnerList.size()-1).getTrailValue();
                if(playersArray.get(i).getTrailValue() > winnerScore) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i));
                }
            }
            else if(res==2) {
                int winnerScore = winnerList.get(winnerList.size()-1).getTrailValue();
                if(playersArray.get(i+1).getTrailValue() > winnerScore) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i+1));
                }
            } 
        }
    }
    
    
    
    public static void checkForSequenceWinner(ArrayList<Player> winnerList,ArrayList<Player> playersArray,Rules ruleBook) {
        
        for(int i=0;i<playersArray.size()-1;i++) {
            int res = ruleBook.checkForSequence(playersArray.get(i), playersArray.get(i+1));
            if(winnerList.size()==0) {
                if(res==0) {
                    winnerList.add(playersArray.get(i));
                    winnerList.add(playersArray.get(i+1));
                }
                else if(res==1) {
                    winnerList.add(playersArray.get(i));
                }
                else if(res==2) {
                    winnerList.add(playersArray.get(i+1));
                }
                continue;
            }
            int winnerScore = winnerList.get(winnerList.size()-1).getSequMaxValue();
            String winnerName = winnerList.get(winnerList.size()-1).getPlayerName();
            if(res==0) {
                
                if(winnerScore == playersArray.get(i).getSequMaxValue()) {
                    if(winnerName.equals(playersArray.get(i).getPlayerName())) { //Player is already in winnerList
                        winnerList.add(playersArray.get(i));
                    }
                    else {
                        winnerList.add(playersArray.get(i));
                        winnerList.add(playersArray.get(i+1));
                    }
                }
                else if(winnerScore < playersArray.get(i).getSequMaxValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i));
                    winnerList.add(playersArray.get(i+1));
                }
            }
            
            if(res==1) {
                
                if(winnerScore < playersArray.get(i).getSequMaxValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i));
                }
                else if(winnerScore == playersArray.get(i).getSequMaxValue() && 
                        !winnerName.equals(playersArray.get(i).getPlayerName())) {
                    winnerList.add(playersArray.get(i));
                }
            }
            
            if(res==2) {
                if(winnerScore < playersArray.get(i+1).getSequMaxValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i+1));
                }
                else if(winnerScore == playersArray.get(i+1).getSequMaxValue()) {
                    winnerList.add(playersArray.get(i+1));
                }
            }
            
        }
        
    }
    
    
    
    
    public static void checkForPairWinner(ArrayList<Player> winnerList,ArrayList<Player> playersArray,Rules ruleBook) {
        
        for(int i=0;i<playersArray.size()-1;i++) {
            int res = ruleBook.checkForPair(playersArray.get(i), playersArray.get(i+1));
            if(winnerList.size()==0) {
                if(res==0) {
                    winnerList.add(playersArray.get(i));
                    winnerList.add(playersArray.get(i+1));
                }
                else if(res==1) {
                    winnerList.add(playersArray.get(i));
                }
                else if(res==2) {
                    winnerList.add(playersArray.get(i+1));
                }
                continue;
            }
            int winnerScore = winnerList.get(winnerList.size()-1).getPairValue();
            String winnerName = winnerList.get(winnerList.size()-1).getPlayerName();
            if(res==0) {
    
               if(winnerScore < playersArray.get(i).getPairValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i));
                    winnerList.add(playersArray.get(i+1));
                }
            }
            
            if(res==1) {

                if(winnerScore < playersArray.get(i).getPairValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i));
                }
                else if(winnerScore == playersArray.get(i).getPairValue() &&
                        !winnerName.equals(playersArray.get(i).getPlayerName())) {
                    winnerList.add(playersArray.get(i));
                }
            }

            if(res==2) {
                if(winnerScore < playersArray.get(i+1).getPairValue()) {
                    winnerList.clear();
                    winnerList.add(playersArray.get(i+1));
                }
                else if(winnerScore == playersArray.get(i+1).getPairValue()) {
                    winnerList.add(playersArray.get(i+1));
                }
            }
            
        }
    }
    
    
    public static void drawCardsAndDeclareWinner(ArrayList<Player> playerList,Deck curDeck) {
        
        int flag=0;
        while(true) {
            ArrayList<Integer> drawnCards = new ArrayList<Integer>();
            
            for(int i=0;i<playerList.size();i++) {
                
                Cards tempCard = curDeck.drawCard();
                if(tempCard!=null) {
                    drawnCards.add(tempCard.getValue());
                    logger.info("\n Winner List "+ playerList.get(i).getPlayerName() + " has drawn ");
                    System.out.print(playerList.get(i).getPlayerName() + " has drawn ");
                    tempCard.printCard();
                }
                else {
                    flag=1;
                    break;
                } 
            }
            if(flag==1) {
                if(playerList.size()==0) {
                	logger.info("Game resulted in a Draw");
                    System.out.println("Game resulted in a Draw");
                }
                if(playerList.size()==1) {
                	logger.info("\n Winner List "+ playerList.get(0).getPlayerName()+"wins!");
                    System.out.println( playerList.get(0).getPlayerName()+" wins!");
                }
                else {
                    System.out.println("Draw between following players");
                    for(int j=0;j<playerList.size();j++) {
                    	logger.info("\nDraw between following players "+ playerList.get(j).getPlayerName());
                        System.out.print(playerList.get(j).getPlayerName()+"  ");
                    }
                }
                return;
            }
            checkForWinner(playerList,drawnCards);
            if(playerList.size()==1) {
                return;
            }
        }
    }
    
    public static void copy(ArrayList<Player> list1, ArrayList<Player>list2) {
        list1.clear();
        for(int i=0;i<list2.size();i++) {
            list1.add(list2.get(i));
        }
    }
    
    public static void checkForWinner(ArrayList<Player> winnerList,ArrayList<Integer> scoreOfPlayers) {
//       ArrayList<Integer> scoreOfPlayers = new ArrayList<Integer>();
//       for(int i=0;i<winnerList.size();i++) {
//           scoreOfPlayers.add(winnerList.get(i).getPlayerCard(0));
//       }
       
       int maxVal=-1;
       ArrayList<Player> finalWinnerList = new ArrayList<Player>();
       
       for(int i=0;i<winnerList.size();i++) {
           if(maxVal<=scoreOfPlayers.get(i)) {
               maxVal = scoreOfPlayers.get(i);
               if(finalWinnerList.size()==0) {
                   finalWinnerList.add(winnerList.get(i));
                   continue;
               }
               else {
                   if(finalWinnerList.get(finalWinnerList.size()-1).getPlayerCard(0) < maxVal) {
                       finalWinnerList.clear();
                       finalWinnerList.add(winnerList.get(i));
                   }
                   else if(finalWinnerList.get(finalWinnerList.size()-1).getPlayerCard(0) == maxVal) {
                       finalWinnerList.add(winnerList.get(i));
                   }
               }
           }
       }
       copy(winnerList,finalWinnerList);
       
       if(finalWinnerList.size()==1) {
    	   logger.info(finalWinnerList.get(0).getPlayerName()+" wins!");
           System.out.println(finalWinnerList.get(0).getPlayerName()+" wins!");
           return;
       }
       
        
        
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] players = {"Player1","Player2","Player3","Player4"};
        int numPlayers = players.length;
        
        System.out.println("Generating Deck and shuffling...");
        Deck curDeck = new Deck();
        curDeck.generateDeck();
        //curDeck.showDeck();
        curDeck.shuffleDeck();
        
        System.out.println();
        
        Rules ruleBook = new Rules();
        
        ArrayList<Player> playersArray = new ArrayList<Player>();
        System.out.println("Creating Players...");
        for(int i=0;i<numPlayers;i++) {
            playersArray.add(new Player(players[i]));
            playersArray.get(i).dealPlayersCard(curDeck);
            playersArray.get(i).createPlayerMetaData();
        }
        
        
        ArrayList<Player> winnerList = new ArrayList<Player>();
        
        checkForTrailWinners(winnerList,playersArray,ruleBook);
        
        if(winnerList.size()==1) {
            System.out.println(winnerList.get(0).getPlayerName() + " wins!");
            return;
        }
        
        checkForSequenceWinner(winnerList,playersArray,ruleBook);
        
        if(winnerList.size()==1) {
            System.out.println(winnerList.get(0).getPlayerName() + " wins!");
            return;
        }
        
        checkForPairWinner(winnerList,playersArray,ruleBook);
        
        if(winnerList.size()==1) {
            System.out.println(winnerList.get(0).getPlayerName() + " wins!");
            return;
        }
        if(winnerList.size()==0)
            winnerList=playersArray;
        
        ArrayList<Integer> scoreOfPlayers = new ArrayList<Integer>();
        for(int i=0;i<winnerList.size();i++) {
            scoreOfPlayers.add(winnerList.get(i).getPlayerCard(0));
        }
        
        checkForWinner(winnerList,scoreOfPlayers);
        if(winnerList.size()==1)
            return;
        
     // Each player in consideration picks up a card from the deck till winner is declared or deck has no cards
        
        drawCardsAndDeclareWinner(winnerList,curDeck);
       
        
        
    }

}
