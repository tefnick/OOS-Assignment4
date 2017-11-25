package movie.model;

import java.util.Observable;


public class Movie extends Observable{
	private String movieTitle;
	private int releaseYear;
	private String director;
	private String writer;
	private int rating;
	
    //need an arbitrary object to manage the concurrency lock in getInstanceMultiThread2
  	private static final Object lock = new Object();

  //use volatile if multi-threaded access to singleton 
    private static volatile Movie movie = null;
	
	private Movie(){
	}
	
	private Movie(String title, int releaseYear, String director, String writer, int rating) {
		this.movieTitle = title;
		this.releaseYear = releaseYear;
		this.director = director;
		this.writer = writer;
		this.rating = rating;
	}
	
	/**
	 * nice and simple when app is single-threaded
	 * 
	 * @return
	 */
	public static Movie getInstanceSingleThread() {
		if(movie == null) {
			movie = new Movie();
		}

		return movie;
	}
	
	/**
	 * if app is multi-threaded, use double-check lock to avoid most calls having to synchronize
	 * from:
	 * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
	 * 
	 * @return
	 */
	public static Movie getInstanceMultiThread2() {
		//most calls will be after singleton already initialized
		//so this unsynchronized if will bypass the synchronize for MOST calls
		if(movie == null) {
			//here is where we need to synchronize and only allow 1 thread to init the singleton
			synchronized (lock) {
				//2nd check to make sure another thread didn't already initialize it
				if(movie == null) {
					movie = new Movie();
				}
			}
		}
		
		return movie;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
		this.setChanged();
		this.notifyObservers();
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
		this.setChanged();
		this.notifyObservers();
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
		this.setChanged();
		this.notifyObservers();
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
		this.setChanged();
		this.notifyObservers();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
		this.setChanged();
		this.notifyObservers();
	}
}
