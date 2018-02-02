import java.awt.Color;

class FishBass extends Fish {

	FishBass(int minX, int maxX, int minY, int maxY) {
		super(minX, maxX, minY, maxY);
		swimSpeed = 1;
		colour = Color.orange.darker();
		bodyLength = 23;

		shapeRight.clear();
		shapeRight.add("          .----.");
		shapeRight.add(" ____    __\\\\\\__");
		shapeRight.add(" `___'--'          .-.");
		shapeRight.add(" /___<             '0'");
		shapeRight.add("/____,--.       y    ,B"); // 23
		shapeRight.add("        `.____  ___-'");
		shapeRight.add("        //   / /");
		shapeRight.add("             ]/");

		shapeLeft.clear();
		shapeLeft.add("        ,----,");
		shapeLeft.add("    ___//////__    ____");
		shapeLeft.add(" .-.           '-~'___/");
		shapeLeft.add(" '0'              >___`");
		shapeLeft.add("8    q        ,--.____)");
		shapeLeft.add(" '-___  ____,~`");
		shapeLeft.add("      | |   ||");
		shapeLeft.add("       V");
	}
}