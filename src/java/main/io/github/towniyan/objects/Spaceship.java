package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.scene.input.*;
import io.github.towniyan.main.*;

public class Spaceship extends GameObject {
	public Spaceship (int x, int y) {
		super(x, y);

		GameBase.get().subscribe("keypress", this);
		GameBase.get().subscribe("collision", this);
	}

	public void step (GraphicsContext gc) {
		super.setBoundingBox(getX(), getY(), 150, 132);

		if (super.getMoveBlindly())
			moveBlindly();
		else
			moveTowards();

		gc.drawImage(new Image("/resources/sprites/spaceship1.png"), getX(), getY());
	}

	public void onKeyPress (KeyCode code) {
		switch (code) {
			case UP:
				this.push(0, -10);
				break;
			case DOWN:
				this.push(0, 10);
				break;
			case LEFT:
				this.push(-10, 0);
				break;
			case RIGHT:
				this.push(10, 0);
				break;
		}
	}
}