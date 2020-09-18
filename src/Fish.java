import java.awt.Color;
import java.util.ArrayList;

public class Fish extends Item {

	/** Lower boundary of horizontal swim range. */
	protected int minX;

	/** Upper boundary of horizontal swim range. */
	protected int maxX;

	/** Lower boundary of vertical swim range. */
	protected int minY;

	/** Upper boundary of vertical swim range. */
	protected int maxY;

	/** Number of chars in longest string of appearance.*/
	protected int bodyLength;

	/** Likelihood of blowing a bubble on a given turn, from 0 to 1. */
	protected double bubbleProbability = 0.1;

	/** Likelihood of changing direction on a given turn, from 0 to 1. */
	protected double dirChangeProb = 0.02;

	/** Factor by which distance moved each turn is multiplied. */
	protected int swimSpeed = 2;

	/** Direction of horizontal movement. 1 = right, -1 = left. */
	protected int horizMove;

	/** Direction of vertical movement. 1 = down, 0 = still, -1 = up. */
	int vertMove = 0;

	/** Appearance of fish when it is facing right. */
	protected ArrayList<String> shapeRight = new ArrayList<String>();

	/** Appearance of fish when it is facing left. */
	protected ArrayList<String> shapeLeft = new ArrayList<String>();


	/**
	 * Constructs a default Fish at a random location within given range.
	 *
	 * @param minX
	 *            lower boundary of horizontal range
	 *
	 * @param maxX
	 *            upper boundary of horizontal range
	 *
	 * @param minY
	 *            lower boundary of vertical range
	 *
	 * @param maxY
	 *            upper boundary of vertical range
	 *
	 */
	protected Fish(int minX, int maxX, int minY, int maxY) {

		// random co-ord within range = random * (max - min) + min
		// X co-ord = Math.random() * (maxX - minX) + minX
		// Y co-ord = Math.random() * (maxY - minY) + minY

		// Generate random co-ordinate within range for Item constructor.
		super((int) (Math.random() * (maxX - minX) + minX),
				(int) (Math.random() * (maxY - minY) + minY));

		horizMove = Math.random() < 0.5 ? 1 : -1 ;

		shapeRight.add("       |``~,");		// 12
		shapeRight.add("l`-..:-`    '-,");	// 15
		shapeRight.add(" )  _      ( o :");	// 16
		shapeRight.add("/.-` ;--,....-`'");	// 16
		shapeRight.add("          '`");		// 12

		shapeLeft.add("    _/``/");		// 9
		shapeLeft.add(" ,-'    `-:..-'/");	// 16
		shapeLeft.add(": o )      _  (");	// 15
		shapeLeft.add("'`-....,--; `-.|");	// 16
		shapeLeft.add("    `'");			// 6

		setAppearanceForDirection();

		colour = Color.cyan.darker().darker();
		bodyLength = 16;

		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	/** Sets appearance based on indicated swimming direction. */
	protected void setAppearanceForDirection() {
		appearance = (horizMove == 1) ? shapeRight : shapeLeft;
	}

	/** Make fish swim, change direction, and blow bubbles. */
	protected void move() {

		// Chance of blowing a bubble.
		if (Math.random() < bubbleProbability) {
			Tank.tankList.add(new Bubble(col, row));
		}

		// If next move will take fish out of bounds, turn.
		int nextX = col + (horizMove * swimSpeed);
		int nextY = row + (vertMove * swimSpeed);

		if (nextX > (maxX - bodyLength)) {
			horizMove = -1;	
			setAppearanceForDirection();
		} else if (nextX < minX) { 	
			horizMove = 1;
			setAppearanceForDirection();
		}

		if (nextY > (maxY - appearance.size())) {	
			vertMove = -1;
		} else if (nextY < minY) {
			vertMove = 1;
		}

		// Move horizontally & vertically.
		col += horizMove * swimSpeed;
		row += vertMove * swimSpeed;

		// Possible reset of horizonal direction.
		if (Math.random() < dirChangeProb) {
			horizMove = Math.random() < 0.5 ? 1 : -1 ;
			setAppearanceForDirection();
		}

		// Possible reset of vertical direction.
		if (Math.random() < dirChangeProb*0.5) {
			double newVertDir = Math.random();
			if (newVertDir < 0.2) { // 20% chance
				vertMove = -1; //
			} else if (newVertDir < 0.8) { // 60% chance
				vertMove = 0;
			} else {
				vertMove = 1; // 20% chance
			}
		}
	}
}