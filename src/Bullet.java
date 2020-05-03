import java.awt.Rectangle;

public class Bullet extends Sprite {
	final static String[] action = {"up"};
	
	final static int UP = 0;
	
	int imageWidth = 10;
	int imageHeight = 10;
	
	public Bullet(int x, int y) {
		super(x, y, "p", action, 5, ".png", 10);
		
	}
	
	
	public void setPosition(int px, int py)
	{
		super.setPosition(px, py);
	}
	
	public void setVelocity(double vx, double vy)
	{
		super.setVelocity(vx, vy);
	}
	
	public void setAccelaration(double ax, double ay)
	{
		super.setAccelaration(ax, ay);
	}
	
	
	public void move()
	{
		super.move();
		
		pose = UP;
	}
	
	public void accelarate()
	{
		super.accelarate();
		
	}
	
	public void update()
	{
		move();
		
		accelarate();
	}
	
	public Rect getBounds() {
		return new Rect( x, y, 20, 20 );
	}

		
	}


