
public class spiky_ball extends Sprite {

	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	public spiky_ball(int x, int y) {
		super(x, y, "spikyball", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}