
// BOTTLE OBJECT EXTENDS SPRITE CLASS.
public class broken_bottle extends Sprite {
	
	// THE POSE OF THE SPRITE.
	final static String [] Action = {"dn"};
	
	final static int DN = 0;
	
	//CONSTRUCTOR WHEN CREATING A NEW BOTTLE OBJECT.
	public broken_bottle(int x, int y) {
		super(x, y, "broken", Action, 4, ".png", 10);
		
	}
	
	public void Down(int dy) {
		super.moveDown(dy);
		
		pose = DN;
	}

}
