package io.github.towniyan.main;

import javafx.scene.canvas.*;

public class Gc {
	private static GraphicsContext gc;

	public static void set (GraphicsContext gc) {
		Gc.gc = gc;
	}

	public static GraphicsContext get () {
		return Gc.gc;
	}
}