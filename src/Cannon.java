
public class Cannon extends Sprite {
	
	final static String [] Action = {"up"};
	
	int angle = 90;
	
	final static int UP = 0;

	public Cannon(int x, int y) {
		super(x, y, "c", Action, 4, ".png", 10);
		// TODO Auto-generated constructor stub
	}
	
	public void up(int dy) {
		super.moveUp(dy);
		
		pose = UP;
	}
	
	public void left(int dx) {
		super.moveLeft(dx);
		
		pose = UP;
		
	}
	
	public void moveright(int dx) {
		
		super.moveRight(dx);
		
		pose = UP;
	}
	
	public void Shoot (Bullet b) 
	{
		b.setPosition(x+ 10 ,y + 25);
		
		b.setVelocity(10*LookUp.cos[angle],-10*LookUp.sin[angle]);
		
	}
	
	public Rect cannonBody() {
		
		return new Rect(x - 10, y, 50, 60);
	}

}
