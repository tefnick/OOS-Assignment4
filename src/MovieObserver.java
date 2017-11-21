import java.util.Observable;
public class MovieObserver extends Observable {
	private String lastmovieTitle;
	private int lastreleaseYear;
	private String lastdirector;
	private String lastwriter;
	private int lastrating;
	public MovieObserver(){
	lastmovieTitle = "";
	lastreleaseYear = 0;
	lastdirector = "";
	lastwriter = "";
	lastrating = 1;	
	}
	public void detailchanges(String movieTitle, int releaseYear, String director, String writer, int rating){
		lastmovieTitle = movieTitle;
		lastreleaseYear = releaseYear;
		lastdirector = director;
		lastwriter = writer;
		lastrating = rating;
		this.setChanged();
		this.notifyObservers();
	}
	public String getLastmovieTitle() {
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
	public int getLastrating() {
		return lastrating;
	}
	

}
