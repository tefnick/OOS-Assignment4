package movie.view;

import java.util.Observable;
import movie.model.Movie;

/**
 * This is a  delegate of the movie model
 * it implements the observable pattern and connects with the observer in the controller
 * it also implements singleton
 */

public class MovieObserver extends Observable {
	
	private String lastmovieTitle;
	private int lastreleaseYear;
	private String lastdirector;
	private String lastwriter;
	private int lastrating;
	Movie movie = new Movie(lastmovieTitle,lastreleaseYear,lastdirector,lastwriter,lastrating);
	private static volatile MovieObserver singleton = null;
	
	public MovieObserver(){
		lastmovieTitle = " ";
		lastreleaseYear = 0;
		lastdirector = " ";
		lastwriter = " ";
		lastrating = 1;	
	}
	
	public void detailchanges(String movieTitle, int releaseYear,String director,String writer,int rating){
		lastmovieTitle = movieTitle;
		lastreleaseYear = releaseYear;
		lastdirector = director;
		lastwriter = writer;
		lastrating = rating;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setLastmovieTitle(String lastmovieTitle) {
		this.lastmovieTitle = lastmovieTitle;
		movie.setMovieTitle(this.lastmovieTitle);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setLastreleaseYear(int lastreleaseYear) {
		this.lastreleaseYear = lastreleaseYear;
		movie.setReleaseYear(this.lastreleaseYear);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setLastdirector(String lastdirector) {
		this.lastdirector = lastdirector;
		movie.setDirector(this.lastdirector);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setLastwriter(String lastwriter) {
		this.lastwriter = lastwriter;
		movie.setWriter(this.lastwriter);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setLastrating(int lastrating) {
		this.lastrating = lastrating;
		movie.setRating(this.lastrating);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getLastMovieTitle(){
		return lastmovieTitle;
	}
	
	public String getLastreleaseYear() {
		return Integer.toString(lastreleaseYear);
	}
	
	public String getLastdirector() {
		return lastdirector;
	}
	
	public String getLastwriter() {
		return lastwriter;
	}
	
	public String getLastrating() {
		return Integer.toString(lastrating);
	}
	
	public static MovieObserver getInstanceSingleThread() {
		if(singleton == null) {
			singleton = new MovieObserver();
		}
		return singleton;
	}
}
