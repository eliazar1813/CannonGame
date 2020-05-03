
public class knife extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public knife(int x, int y) {
		super(x, y, "knife", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}