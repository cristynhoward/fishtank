import java.awt.Color;

/**
 * A piece of seaweed in the tank.
 */
public class Seaweed extends Item {
	
	/** The number of seaweed segments. */
	protected int len;
	
	/** Indicates whether the bottom segment is leaning right. */
	protected boolean leanRight;

	
	/**
	 * Constructs a new seaweed that is len segments tall.
	 * 
	 * @param len the number of segments this seaweed is tall.
	 */
	protected Seaweed(int col, int row, int len) {
		super(col, row);
	    this.len = len;
	    colour = Color.green.darker().darker();
	    this.leanRight = true;
	  }
	
	
	/** 25% chance the piece of seaweed wiggles in place. */
	@Override
	protected void move() {	
		double chance = Math.random() * 100;
		if (chance < 25) {
			leanRight = !leanRight;
			
			appearance.clear();
			
			int counter = len;
			int index = 0;
			if (!leanRight) {
				index = 1;
			}
			while (counter > 0) {
				if (index % 2 == 0) {
					appearance.add("//");
				} else {
					appearance.add("\\");
				}
				index++;
				counter--;
			}
		}
	}
	
	
}
