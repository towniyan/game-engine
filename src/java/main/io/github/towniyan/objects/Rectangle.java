package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import io.github.towniyan.main.*;

public class Rectangle extends GameObject {
	private int width, height;
	private Color color = Color.web("yellow");
	private boolean vertical;
	
	public Rectangle (int x, int y, int width, int height) {
		super(x, y);
		super.setBoundingBox(x, y, width, height);
		
		this.width = width;
		this.height = height;

		this.vertical = (this.width > this.height) ? false : true;
	}

	public void step () {
		setBoundingBox(getX(), getY(), width, height);
		gc.setFill(this.color);

		GameObject ball = gb.getPlayground().get(0);
		if (collidesWith(ball)) {
			if (isVertical())
				ball.bounceX();
			else
				ball.bounceY();
		}

		gc.fillRect(getX(), getY(), this.width, this.height);
	}

	public void setColor (Color color) {
		this.color = color;
	}

	public boolean isVertical () {
		return this.vertical;
	}
}