package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import movie.model.Movie;
import movie.view.MovieController;
import movie.view.MovieObserver;

public class AppMain extends Application {
	private Movie movie;
	public AppMain() {
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("null")
	public void createMovieView(int viewX, int viewY) throws IOException {
		Stage stage = new Stage();
		MovieObserver observer = new MovieObserver();
		MovieController controller = new MovieController();
		movie = new Movie(" ",0,"","",0);
		movie.setMovieObserver(observer);
		observer.addObserver(controller);
	
	
		FXMLLoader loader = new FXMLLoader(controller.getClass().getResource("MovieView.fxml"));
		loader.setController(controller);
		Parent pane = loader.load();
		stage.setScene(new Scene(pane, 400, 300));
		stage.setTitle("CS 4773 Assignment 4 Movie View");
		stage.setX(viewX);
		stage.setY(viewY);
        stage.show();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create first view
		createMovieView(50, 100);
		
		//create second view
		createMovieView(460, 100);
	}
}