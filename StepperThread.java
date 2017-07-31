public class StepperThread extends Thread {
	private GameBase gb;

	public StepperThread (GameBase gb) {
		this.gb = gb;
	}

	public void run () {
		while (true) {
	    	try {
	    		this.gb.step();
	    		Thread.sleep(10);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}
}