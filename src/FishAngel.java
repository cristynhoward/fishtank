import java.awt.Color;

class FishAngel extends Fish {

	FishAngel(int minX, int maxX, int minY, int maxY) {
		super(minX, maxX, minY, maxY);
		swimSpeed = 5;
		colour = Color.MAGENTA;
		bubbleProbability = 0.1;
		bodyLength = 11;

		shapeRight.clear();
		shapeRight.add("      \\");
		shapeRight.add("      }\\");
		shapeRight.add("`\\  .'  \\");
		shapeRight.add(" }\\/ ~~ o\\");
		shapeRight.add(" }/\\  )) _}");
		shapeRight.add(",/ /`.  /`");
		shapeRight.add("      }/");
		shapeRight.add("      /");

		shapeLeft.clear();
		shapeLeft.add("    /");
		shapeLeft.add("   /[");
		shapeLeft.add("  /  '.  /'");
		shapeLeft.add(" /o ~~ \\/{");
		shapeLeft.add("{_ ((  /\\{");
		shapeLeft.add(" `\\  .`\\ \\,");
		shapeLeft.add("   \\{");
		shapeLeft.add("    \\");
	}
}