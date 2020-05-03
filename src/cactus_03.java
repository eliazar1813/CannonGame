
public class cactus_03 extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public cactus_03(int x, int y) {
		super(x, y, "cactus03", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}