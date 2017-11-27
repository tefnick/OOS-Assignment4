package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import movie.model.Movie;
import javafx.fxml.Initializable;

/**Observer**/
public class MovieController implements Initializable, Observer {

    @FXML
    private TextField movieTitle;
    
    private MovieObserver movieobserver;
    
    @FXML
    private TextField director;

    @FXML
    private TextField releaseYear;

    @FXML
    private TextField writer;

    @FXML
    private Label ratingText;

    @FXML
    private Slider ratingSlider;

    private Movie movie;


    public MovieController(Movie movie) {
    	this.movie = movie;
    }
	
	public void initialize(URL location, ResourceBundle resources) {	
		initializeMovieTitleField();
		initializeDirectorField();
		initializeReleaseYearField();
		initializeWriterField();
		initializeRatingSlider();	
	}
	
	private void initializeMovieTitleField() {
		movieTitle.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastmovieTitle(newValue);
			}
		});
	}
	
	private void initializeDirectorField() {
		director.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastdirector(newValue);
			}
		});
	}
	
	private void initializeReleaseYearField() {
		releaseYear.setText("");
		releaseYear.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {			
				try{
					if (!newValue.matches("\\d*")) {
			            releaseYear.setText(newValue.replaceAll("\\D", "")); //strip non-digits
			        }else{
			        	Integer.parseInt(newValue);
			        	movieobserver.setLastreleaseYear(Integer.parseInt(newValue));
			        }
				}catch (NumberFormatException e){
					e.getMessage();
				}				
			}
		});
	}
	
	private void initializeWriterField() {
		writer.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastwriter(newValue);
			}
		});
	}

	private void initializeRatingSlider() {
		ratingSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				newValue = (int) ratingSlider.getValue();
				movieobserver.setLastrating(newValue.intValue());			
			}
		});
	}

	public void update(Observable o, Object arg) {
		movieobserver = (MovieObserver) o;
		movieTitle.setText(movieobserver.getLastMovieTitle());
		director.setText(movieobserver.getLastdirector());
		releaseYear.setText(movieobserver.getLastreleaseYear());
		writer.setText(movieobserver.getLastwriter());
		ratingText.setText(movieobserver.getLastrating());
		ratingSlider.setValue(Double.valueOf(movieobserver.getLastrating()));
		}
	
}
