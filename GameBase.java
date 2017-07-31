import java.util.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.event.*;

public abstract class GameBase extends Helper {
	private GraphicsContext gc;
	private ArrayList<GameObject> playground = new ArrayList<GameObject>();

	public abstract void init ();
	public abstract void step ();

	public void onKeyPress (KeyCode code) {

	}

	public void onMouseMoved (double x, double y) {

	}

	public GameBase (GraphicsContext gc) {
		this.gc = gc;

		init();

		gc.getCanvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
	        public void handle(KeyEvent event) {
	            onKeyPress(event.getCode());
	        }
	    });

	    gc.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
	            onMouseMoved(event.getX(), event.getY());
	        }
	    });
	    
	    new StepperThread(this).start();
	}

	public ArrayList<GameObject> getPlayground () {
		return this.playground;
	}

	public void render () {
		this.gc.clearRect(0, 0, Settings.WIDTH, Settings.HEIGHT);

		for (int i = 0; i < this.playground.size(); i++) {
			this.playground.get(i).step(this.gc);
		}
	}

	public GraphicsContext getGc () {
		return this.gc;
	}
}