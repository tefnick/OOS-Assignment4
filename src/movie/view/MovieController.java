package movie.view;

import java.net.URL;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
    
    Movie movie = null;
    
    public MovieController(Movie movie){
    	movie = Movie.getInstanceMultiThread2();
    }

    /**
     * Initialize the view with default field values
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		this.movieTitle.setText("");
//		this.releaseYear.setText("");
//		this.director.setText("");
//		this.writer.setText("");
//		this.ratingText.setText("0");
//		this.ratingSlider.adjustValue(0);
		
	}
	
	/**
	 * Implement this method from the Observer Interface
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.movieTitle.setText(movie.getMovieTitle());
		this.releaseYear.setText(Integer.toString(movie.getReleaseYear()));
		this.director.setText(movie.getDirector());
		this.writer.setText(movie.getWriter());
		this.ratingText.setText(Integer.toString(movie.getRating()));
		this.ratingSlider.adjustValue(movie.getRating());
	}
	
	@FXML
	void changeMovieTitle(ActionEvent event){
		//parse String from UI
		movie.setMovieTitle(movieTitle.getText());
		
	}
}


