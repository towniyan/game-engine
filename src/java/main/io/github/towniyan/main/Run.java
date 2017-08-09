package io.github.towniyan.main;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import io.github.towniyan.threads.*;

public class Run extends Application {
	public void start (Stage stage) {
		Group items = new Group();

		Canvas canvas = new Canvas(Settings.WIDTH, Settings.HEIGHT);
		canvas.setFocusTraversable(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Gc.set(gc);

		items.getChildren().add(canvas);

		stage.setScene(new Scene(items, Settings.WIDTH, Settings.HEIGHT, Settings.BACKGROUND));
		stage.show();

		new GameThread(gc).start();
	}

	public void stop () {
		System.exit(0);
	}
}