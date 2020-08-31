/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.List;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */

@Service("CinemaServices")
public class CinemaServices {
	
	@Qualifier("InMemoryCinemaPersistence")
    @Autowired
    CinemaPersitence cps=null;
    
    public void addNewCinema(Cinema c){
        
    }
    
    public Set<Cinema> getAllCinemas(){
        return null;
    }
    
    /**
     * 
     * @param name cinema's name
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     */
    public Cinema getCinemaByName(String name) throws CinemaException{
    	try {
			return cps.getCinema(name);
		} catch (CinemaPersistenceException e) {
	        throw new UnsupportedOperationException("Not supported yet."); 
		}
    }
    
    
    public void buyTicket(int row, int col, String cinema, String date, String movieName){
    	try {
			cps.buyTicket(row, col, cinema, date, movieName);
		} catch (CinemaException e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
         
    }
    
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
    	return cps.getFunctionsbyCinemaAndDate(cinema, date);
    }


}
