
public class cactus_01 extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public cactus_01(int x, int y) {
		super(x, y, "cactus01", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}