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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.movieTitle.setText("myMovie");
		this.releaseYear.setText("1988");
		this.director.setText("director");
		this.writer.setText("writer");
		this.ratingText.setText("9");
		this.ratingSlider.adjustValue(9);
	}

	/**
	 * Implement this method from the Observer Interface
	 */
	@Override
	public void update(Observable o, Object arg) {
		Movie movie = (Movie) o;
		this.director.setText(movie.getDirector());
		//this.releaseYear.setText(movie.getReleaseYear());
		this.writer.setText(movie.getWriter());
		//this.ratingText.setText(movie.getRating());	
	}	
}


