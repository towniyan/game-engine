package io.github.towniyan.main;

import java.util.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.event.*;

public abstract class GameBase extends Helper {
	private GraphicsContext gc;
	private ArrayList<GameObject> playground = new ArrayList<GameObject>();
	private ArrayList<GameObject> keypress = new ArrayList<GameObject>();
	private static GameBase gb;

	public static GameBase get () {
		return GameBase.gb;
	}

	public static void set (GameBase gb) {
		GameBase.gb = gb;
	}

	public abstract void init ();
	public abstract void step ();

	public void subscribe (String event, GameObject object) {
		switch (event) {
			case "keypress":
				this.keypress.add(object);
		}
		
	}

	public void onKeyPress (KeyCode code) {

	}

	public void onMouseMoved (double x, double y) {

	}

	public GameBase (GraphicsContext gc) {
		GameBase.set(this);
		this.gc = gc;

		init();

		gc.getCanvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
	        public void handle(KeyEvent event) {
	            onKeyPress(event.getCode());

	            for (int i = 0; i < keypress.size(); i++) {
	            	keypress.get(i).onKeyPress(event.getCode());
	            }
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

	public GraphicsContext getGc () {
		return this.gc;
	}
}