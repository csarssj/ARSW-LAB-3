import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.cinema.filter.AvailabilityFilter;
import edu.eci.arsw.cinema.filter.GenreFilter;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.services.CinemaServices;

public class FilterTest {
	private AvailabilityFilter avaFilter = new AvailabilityFilter();
	private GenreFilter genreFilter = new GenreFilter();
	
	@Test
    public void deberiaFiltrarPorGenero() throws CinemaPersistenceException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices cs = ac.getBean(CinemaServices.class);
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("Movies Bogotá",functions);
        cs.addNewCinema(c);
        assertEquals(genreFilter.Cfilter(functions, "Action").get(0),functions.get(0));
    }


    @Test
    public void deberiaFiltrarPorDisponibilidad() {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices cs = ac.getBean(CinemaServices.class);
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("Movies Bogotá",functions);
        cs.addNewCinema(c);
        for(int i = 0; i <5 ;i++) {
        	for(int j = 0; j <5 ;j++) {
        		cs.buyTicket(i, j, "Movies Bogotá", functionDate, "SuperHeroes Movie 2");
            }
        }
        System.out.print(avaFilter.Cfilter(functions, "85"));
        System.out.print(functions.get(0).getSeats());
        assertEquals(avaFilter.Cfilter(functions, "85").get(0),functions.get(0));
        
    }

}
