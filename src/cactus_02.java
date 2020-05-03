
public class cactus_02 extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public cactus_02(int x, int y) {
		super(x, y, "cactus02", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}