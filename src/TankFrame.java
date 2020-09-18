import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Displays the fish tank.
 */
public class TankFrame extends JFrame {

	/** My Serializable id. */
	private static final long serialVersionUID = 1409191926708912242L;
	
	/** The font used to render the items in the fish tank.*/
	private static Font FONT = new Font("Monospaced", Font.PLAIN, 10);
	
	/** Background colour. */
	private Color colour = Color.white;
	
	/** 
	 * Creates a new TankFrame.
	 * */
	TankFrame() {
		super();
		
		this.setVisible(true);
		this.setSize(640, 480);
		this.setLocation(10, 10);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}
	
	/** 
	 * Returns maximum value in the X dimension.
	 * */
	protected int getMaxX() {
		int xunit = getFontMetrics(FONT).charWidth('W');
		return Math.floorDiv(this.getWidth(), xunit);
	}
	
	/** 
	 * Returns maximum value in the Y dimension.
	 * */
	protected int getMaxY() {
		int yunit = getFontMetrics(FONT).getAscent();
		return Math.floorDiv(this.getHeight(), yunit);
	}

	/**
 	 * Paints this tank.
	 *
	 * @param graphic
	 *          	the graphics context to use for painting.
	 */
	public void paint(Graphics graphic) {

		// Paint the window the background colour.
		graphic.setColor(colour);
		graphic.fillRect(0, 0, getBounds().width, getBounds().height);
		
		// Tell all the fishtank items to draw themselves.
		for (Item thing : Tank.tankList) {
			thing.draw(graphic);
		}
	}

}
