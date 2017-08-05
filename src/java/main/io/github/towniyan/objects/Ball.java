package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Ball extends GameObject {
	private Color color = Color.web("orange");
	private int width, height;

	public Ball (int x, int y, int width, int height) {
		super(x, y);

		this.width = width;
		this.height = height;
	}

	public void step (GraphicsContext gc) {
		super.setBoundingBox(getX(), getY(), width, height);

		if (super.getMoveBlindly())
			moveBlindly();
		else
			moveTowards();

		gc.setFill(this.color);
		gc.fillOval(getX(), getY(), this.width, this.height);
	}

	public void setColor (Color color) {
		this.color = color;
	}
}