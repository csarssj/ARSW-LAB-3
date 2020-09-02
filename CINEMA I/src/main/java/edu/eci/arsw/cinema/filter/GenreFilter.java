package edu.eci.arsw.cinema.filter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.arsw.cinema.model.CinemaFunction;

@Component("Genre")
public class GenreFilter implements CFilter {

	@Override
	public List<CinemaFunction> Cfilter(List<CinemaFunction> functions, String genre) {
		List<CinemaFunction> f = new ArrayList<CinemaFunction>();
		for(CinemaFunction c : functions) {
			if(genre.equals(c.getMovie().getGenre()) ) {
				f.add(c);
			}
		}
		return f;
	}

}
