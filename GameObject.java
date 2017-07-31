import javafx.scene.canvas.*;

public abstract class GameObject extends Helper {
	private int x = 0, y = 0;
	private int[] speed = {0, 0};
	private int[] destination = {0, 0};
	private boolean moveBlindly = false;

	public GameObject (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public GameObject () {
		
	}

	public abstract void step (GraphicsContext gc);

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

	public void move (int x, int y, int[] speed) {
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

	public void move () {
		move(this.destination[0], this.destination[1], this.speed);
	}

	public void moveBlindly () {
		push(this.speed[0], this.speed[1]);
	}

	public void stop () {
		this.speed = new int[]{0, 0};
		this.destination = new int[]{0, 0};
	}

	public void bounceX () {
		this.speed[0] *= -1;
		println("Bounced X");
	}
	public void bounceY () {
		this.speed[1] *= -1;
		println("Bounced Y");
	}
}