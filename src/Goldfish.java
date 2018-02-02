import java.awt.Color;

class Goldfish extends Fish {

	Goldfish(int minX, int maxX, int minY, int maxY) {
		super(minX, maxX, minY, maxY);
		swimSpeed = 4;
		colour = Color.orange;
		bubbleProbability = 0.8;
		bodyLength = 12;

		shapeRight.clear();
		shapeRight.add("     .-~^^k");
		shapeRight.add(";`, /   ( o)");
		shapeRight.add("`> ;    `, }");
		shapeRight.add(";_/'`.__.-'");

		shapeLeft.clear();
		shapeLeft.add(" _J`~-.");
		shapeLeft.add("(o )   `,,';");
		shapeLeft.add("{ ,'    ; <");
		shapeLeft.add(" `-.__.''-_;");
	}
}