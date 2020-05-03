
public class pin extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public pin(int x, int y) {
		super(x, y, "pin", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}