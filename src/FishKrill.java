import java.awt.Color;

class FishKrill extends Fish {

	FishKrill(int minX, int maxX, int maxY) {
		super(minX, maxX, (int) Math.floor(0.8*maxY), maxY);
		swimSpeed = 1;
		colour = Color.pink.darker();
		bubbleProbability = 0;
		bodyLength = 9;

		shapeRight.clear();
		shapeRight.add("    ,,, /");
		shapeRight.add(")<<<(#)8");
		shapeRight.add("    ``` \\");

		shapeLeft.clear();
		shapeLeft.add("\\ ,,,");
		shapeLeft.add(" 8(#)>>>(");
		shapeLeft.add("/ ```");
	}
}