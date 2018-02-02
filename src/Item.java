import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

/** */
public class Item {

	/** The font used to draw instances of this class. */
	protected static Font FONT = new Font("Monospaced", Font.PLAIN, 10);

	/** This item's row coordinate. */
	protected int row;

	/** This item's column coordinate. */
	protected int col;

	/** The colour of this item. */
	protected Color colour;

	/** The appearance of this item; string at index 0 is top layer. */
	protected ArrayList<String> appearance = new ArrayList<>();

	/**
	 * Constructs a new item.
	 * 
	 */
	protected Item(int col, int row) {
		this.col = col;
		this.row = row;
	}

	/**
	 * Set this item's location.
	 * 
	 * @param row
	 *            the row coordinate.
	 * @param col
	 *            the column coordinate.
	 */
	protected void setLocation(int col, int row) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Draws this item.
	 *
	 * @param g
	 *            the graphics context in which to draw this item.
	 */
	protected void draw(Graphics g) {
		g.setColor(colour);
		g.setFont(FONT);
		FontMetrics fm = g.getFontMetrics(FONT);

		int xunit = fm.charWidth('W');
		int yunit = fm.getAscent();
		int i = row;

		for (String layer : appearance) {
			g.drawString(layer, col * xunit, i * yunit);
			i++;
		}
	}

	protected void move() {
		// To be overridden by subclasses.
	}

}
