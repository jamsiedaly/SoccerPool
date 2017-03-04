/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerpool.gamesimulation;

/**
 *
 * @author Kieran
 */
public class goalsLessThanShots extends GameResultDecorator{
    
    public goalsLessThanShots(GameResult g) {
        super(g);
    }
    
    @Override
    public int getHomeShots(){
        if(super.getHomeShots()<super.getHomeScore()){
            homeShots = homeScore + 2;
            super.setHomeShots(homeShots);  
        }
        return homeShots;
    }
    
    @Override
    public int getAwayShots(){
        if(super.getAwayShots()<super.getAwayScore()){
             awayShots = awayScore + 2; 
             super.setAwayShots(awayShots);
             
        }
        return awayShots;
    }
    
}
