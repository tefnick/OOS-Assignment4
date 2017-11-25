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
import javafx.scene.input.InputMethodEvent;
import movie.model.Movie;
import javafx.fxml.Initializable;

//observer
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
		
		releaseYear.setText("");
		movieTitle.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastmovieTitle(newValue);
			}
		});
		
		director.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastdirector(newValue);
			}
		});
		
		releaseYear.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try{
					Integer.parseInt(newValue);
					movieobserver.setLastreleaseYear(Integer.parseInt(newValue));
				}
				catch(NumberFormatException e){
					releaseYear.setText(newValue);
				}
			}
		});
		
		writer.textProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				movieobserver.setLastwriter(newValue);
			}
		});
		
	}

	/**
	 * Implement this method from the Observer Interface
	 * Note: I think we implement Observer in this class?
	 */
	public void update(Observable o, Object arg) {
		movieobserver = (MovieObserver) o;
		movieTitle.setText(movieobserver.getLastMovieTitle());
		director.setText(movieobserver.getLastdirector());
		releaseYear.setText(movieobserver.getLastreleaseYear());
		writer.setText(movieobserver.getLastwriter());
		ratingText.setText(movieobserver.getLastrating());
		ratingSlider.adjustValue(Double.valueOf(movieobserver.getLastrating()));
		}
	}


