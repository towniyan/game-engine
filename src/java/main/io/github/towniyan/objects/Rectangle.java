package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class Rectangle extends GameObject {
	private int width, height;
	
	public Rectangle (int x, int y, int width, int height) {
		super(x, y);
		super.setBoundingBox(x, y, width, height);
		
		this.width = width;
		this.height = height;
	}

	public void step (GraphicsContext gc) {
		GameBase gb = GameBase.get();
		if (collidesWith(gb.getPlayground().get(4)))
			gc.setFill(Color.web("red"));
		else
			gc.setFill(Color.web("yellow"));
		gc.fillRect(getX(), getY(), this.width, this.height);
	}
}