
public class pin2 extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public pin2(int x, int y) {
		super(x, y, "pin2", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}