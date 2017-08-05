package io.github.towniyan.main;

import javafx.scene.canvas.*;

public class GC {
	private static GraphicsContext gc;

	public static void set (GraphicsContext gc) {
		GC.gc = gc;
	}

	public static GraphicsContext get () {
		return GC.gc;
	}
}