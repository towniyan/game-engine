package io.github.towniyan.objects;

import javafx.scene.canvas.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.input.*;
import io.github.towniyan.main.*;

public abstract class GameObject extends Helper {
	private int x = 0, y = 0;
	private int[] speed = {0, 0}, destination = {0, 0};
	private boolean moveBlindly = false;
	private BoundingBox boundingBox;
	protected GameBase gb = GameBase.get();
	protected GraphicsContext gc = Gc.get();

	public GameObject (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public GameObject () {
		
	}

	public abstract void step ();

	public int getX () {
		return this.x;
	}
	public int getY () {
		return this.y;
	}

	public boolean getMoveBlindly () {
		return this.moveBlindly;
	}

	public void setMoveBlindly (boolean moveBlindly) {
		this.moveBlindly = moveBlindly;
	}

	public int[] getSpeed () {
		return this.speed;
	}

	public void setDestination (int x, int y) {
		this.destination = new int[]{x, y};
	}

	public void setSpeed (int x, int y) {
		this.speed = new int[]{x, y};
	}

	public void push (int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void place (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveTowards (int x, int y, int[] speed) {
		// println(this.speedX + ", " + this.speedY);
		this.speed[0] = speed[0];
		this.speed[1] = speed[1];
		this.destination[0] = x;
		this.destination[1] = y;

		if (this.x > x)
			this.x -= this.speed[0];
		if (this.x < x)
			this.x += this.speed[0];

		if (this.y > y)
			this.y -= this.speed[1];
		if (this.y < y)
			this.y += this.speed[1];
	}

	public void moveTowards () {
		moveTowards(this.destination[0], this.destination[1], this.speed);
	}

	public void moveBlindly () {
		// for (int i = 0; i < speed[0]; i++) {
			
		// }
		push(this.speed[0], this.speed[1]);
	}

	public void stop () {
		this.speed = new int[]{0, 0};
		this.destination = new int[]{0, 0};
	}

	public void bounceX () {
		this.speed[0] *= -1;
		push(getSpeed()[0] * 5, 0);
	}
	public void bounceY () {
		this.speed[1] *= -1;
		push(0, getSpeed()[1] * 5);
	}

	public void setBoundingBox(int x, int y, int width, int height) {
		this.boundingBox = new BoundingBox(x, y, width, height);
	}

	public BoundingBox getBoundingBox () {
		return this.boundingBox;
	}

	public boolean collidesWith (GameObject o) {
		return this.boundingBox.intersects(o.getBoundingBox());
	}

	public void onKeyPress (KeyCode code) {

	}
}