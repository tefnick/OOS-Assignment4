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
	private static Movie movie = new Movie(" ",0," "," ",1);;
	private static MovieObserver observer = new MovieObserver();
	private static MovieController controller;
	
	public AppMain() {
	}
	
	public static void main(String[] args) {

		launch(args);
	}
	public void createMovieView(int viewX, int viewY) throws IOException {
		Stage stage = new Stage();
		MovieObserver observer = MovieObserver.getInstanceSingleThread();
		MovieController controller = new MovieController(movie);
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
        observer.detailchanges("", 0,"","",1);
	}
	
	
	public void start(Stage primaryStage) throws Exception {
		
		//create first view
		createMovieView(50, 100);
		
		//create second view
		createMovieView(460, 100);

	}
}