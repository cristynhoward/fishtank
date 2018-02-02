import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Tank {

	/** The list of items in the fishtank. */
	public static ArrayList<Item> tankList = new ArrayList<Item>();

	protected static Font FONT = new Font("Monospaced", Font.PLAIN, 10);

	/** Create the tank and it's contents, then animate the ensemble. */
	public static void main(String[] args) {

		// Instantiate & set up tankFrame.
		
		TankFrame tankFrame = new TankFrame(Color.white);
		tankFrame.setSize(640, 480);
		tankFrame.setLocation(10, 10);
		tankFrame.setVisible(true);
		tankFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});

		// Establish tank dimensions.
		
		FontMetrics fm = tankFrame.getFontMetrics(FONT);
		int xunit = fm.charWidth('W');
		int yunit = fm.getAscent();
		int maxX = Math.floorDiv(tankFrame.getWidth(), xunit); // maxX = 106
		int maxY = Math.floorDiv(tankFrame.getHeight(), yunit); // maxY = 48

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
		for (int i = 0; i < 7; i++) {
			tankList.add(new FishKrill(0, maxX, maxY));
		}

		int limit = (int) Math.ceil(Math.random()*75);
		for (int i = 0; i < limit; i++) {
			int len = (int) Math.floor(Math.random()*10) + 3;
			int col = (int) Math.floor(Math.random()*maxX);
			int row = (int) (Math.floor(Math.random()*maxY* 0.5) + maxY*0.5);

			System.out.println("i = " + Integer.toString(i) + "; (c, r, l) = (" +
					Integer.toString(col) + ", " + Integer.toString(row) + ", " +
					Integer.toString(len) + ")");
			tankList.add(new Seaweed(col, row, len));
		}
		
		// Run the tank.
		
		while (true) {
			
			if (Math.random() < 0.5) {
				// tankList.add(new Jelly(0, maxX, maxY));
			}
			
			for (int i = 0; i < tankList.size(); i++) {
				tankList.get(i).move();
			}
			
			tankFrame.repaint();
			
			try {
				Thread.sleep(200);
			} catch (Exception close) {
				System.exit(0);
			}
		}
	}

}
