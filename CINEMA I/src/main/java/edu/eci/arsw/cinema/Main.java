/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.services.CinemaServices;

/**
 *
 * @author Ceseg
 */
public class Main {

    public static void main(String a[]) throws CinemaException, CinemaPersistenceException {
    	
    	//Creando cine y funciones
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices cs = ac.getBean(CinemaServices.class);
 	   	String functionDate = "2020-08-31 20:30";
 	   	String functionDate2 = "2020-09-1 20:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("Constantine","Drama"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("Superbad","Comedy"),functionDate2);
        functions.add(funct1);
        functions.add(funct2);
        cs.addNewCinema(new Cinema("Cinemark",functions));
        
        //Imprimiendo cinemas
        for (Cinema c :cs.getAllCinemas()) {
        	System.out.println(c.getName());
        	System.out.println(c.getFunctionsByDate("2020-08-31 20:30"));
        }
        System.out.println(cs.getCinemaByName("Cinemark").getName());
        
     	//Buy
        cs.buyTicket(2, 4, "Cinemark", functionDate, "Constantine");
        cs.buyTicket(2, 4, "Cinemark", functionDate2, "Superbad");
        
       
     }
}
