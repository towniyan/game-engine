package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Text extends GameObject {
	private String text;
	private int x, y;

	public Text (String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}

	public void step (GraphicsContext gc) {
		gc.setFill(Color.web("gray"));
		gc.fillText(this.text, this.x, this.y);
	}

	public void setText(String text) {
		this.text = text;
	}
}