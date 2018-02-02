import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Displays the fish tank.
 */
public class TankFrame extends JFrame {

	/** My Serializable id. */
	private static final long serialVersionUID = 1409191926708912242L;
	
	/** Background colour. */
	private Color colour;
	
	/** 
	 * Creates a new TankFrame.
	 * 
	 * @param color
	 * 				the background colour of the frame.
	 * */
	TankFrame(Color color) {
		super();
		colour = color;
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
