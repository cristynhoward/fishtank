import java.util.ArrayList;

public class Tank {
	
	/** The list of items in the fishtank. */
	public static ArrayList<Item> tankList = new ArrayList<Item>();

	/** Create the tank and it's contents, then animate the ensemble. */
	public static void main(String[] args) {
		
		TankFrame tankFrame = new TankFrame();
		int maxX = tankFrame.getMaxX();
		int maxY = tankFrame.getMaxY();
		
		// Add items to tank.
		
		for (int i = 0; i < 2; i++) {
			tankList.add(new Fish(0, maxX, 3, maxY));
		}
		for (int i = 0; i < 1; i++) {
			tankList.add(new FishBass(0, maxX, 3, maxY));
		}
		for (int i = 0; i < 4; i++) {
			tankList.add(new Goldfish(0, maxX, 3, maxY));
		}
		for (int i = 0; i < 1; i++) {
			tankList.add(new FishScaly(0, maxX, 3, maxY));
		}
		for (int i = 0; i < 2; i++) {
			tankList.add(new FishAngel(0, maxX, 3, maxY));
		}
		for (int i = 0; i < 8; i++) {
			tankList.add(new FishKrill(0, maxX, maxY));
		}

		int buffer = (int)  Math.ceil(Math.random()*75);
		for (int i = 0; i < buffer+13; i++) {
			int len = (int) Math.floor(Math.random()*10) + 3;
			int col = (int) Math.floor(Math.random()*maxX);
			int row = (int) (Math.floor(Math.random()*maxY* 0.5) + maxY*0.5);
			tankList.add(new Seaweed(col, row, len));
		}
		
		// Run.
		
		while (true) {

		    for (int i = 0; i<tankList.size(); i++) {
		        tankList.get(i).move();
            }
			
			tankFrame.repaint();
			
			try {
				Thread.sleep(100);
			} catch (Exception close) {
				System.exit(0);
			}
		}
	}

}