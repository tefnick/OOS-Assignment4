//package movie.view;
//import java.util.Observable;
//
//import movie.model.Movie;
////observable
//public class MovieObserver extends Observable {
//	private String lastmovieTitle;
//	private int lastreleaseYear;
//	private String lastdirector;
//	private String lastwriter;
//	private int lastrating;
//	Movie movie = new Movie(lastmovieTitle,lastreleaseYear,lastdirector,lastwriter,lastrating);
//	public MovieObserver(){
//	lastmovieTitle = "";
//	lastreleaseYear = 0;
//	lastdirector = "";
//	lastwriter = "";
//	lastrating = 1;	
//	}
//	public void detailchanges(String movieTitle, int releaseYear,String director,String writer,int rating){
//		lastmovieTitle = movieTitle;
//		lastreleaseYear = releaseYear;
//		lastdirector = director;
//		lastwriter = writer;
//		lastrating = rating;
//		this.setChanged();
//		//this.notifyObservers();
//		
//	}
//	public String getLastMovieTitle(){
//		return lastmovieTitle;
//	}
//	public void setLastmovieTitle(String lastmovieTitle) {
//		this.lastmovieTitle = lastmovieTitle;
//		this.setChanged();
//		this.notifyObservers();
//	}
//	public void setLastreleaseYear(int lastreleaseYear) {
//		this.lastreleaseYear = lastreleaseYear;
//	}
//	public void setLastdirector(String lastdirector) {
//		this.lastdirector = lastdirector;
//	}
//	public void setLastwriter(String lastwriter) {
//		this.lastwriter = lastwriter;
//	}
//	public void setLastrating(int lastrating) {
//		this.lastrating = lastrating;
//	}
//	public String getLastreleaseYear() {
//		return Integer.toString(lastreleaseYear);
//	}
//	public String getLastdirector() {
//		return lastdirector;
//	}
//	public String getLastwriter() {
//		return lastwriter;
//	}
//	public String getLastrating() {
//		return Integer.toString(lastrating);
//	}
//	
//
//}
