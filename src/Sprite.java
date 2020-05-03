import java.awt.*;

public class Sprite
{
	int x;
	int y;
	
	double vx = 0;
	double vy = 0;
	
	double ax = 0;
	double ay = 0;

	
	
	Animation[] animation = new Animation[4];
	
	
	int pose = 0;
	
	boolean moving = false;
	
	boolean alive = true;
	
	
	public Sprite(int x, int y, String name, String[] pose, int count, String exe, int duration)
	{
		this.x = x;
		this.y = y;
		
	
		
		for(int i = 0; i < pose.length; i++)
		{
			animation[i] = new Animation(name + "_" + pose[i] + "_", count, exe, duration);
		}
	}

	

	public void draw(Graphics g)
	{

		
		if(moving)

			g.drawImage(animation[pose].getImage(), x, y, null);
		
		else
			
			g.drawImage(animation[pose].getStillImage(), x, y, null);	
		
		
		moving = false;	
	}
	
	
	public void moveUp(int dy)
	{
		y -= dy;
			
		moving = true;
	}
	
	public void moveDown(int dy)
	{
		y += dy;
		
		moving = false;
	}
	
	public void moveLeft(int dx)
	{
		x -= dx;
		
		moving = false;
	}
	
	public void moveRight(int dx)
	{
		x += dx;
		
		moving = false;
	}
	
	
	public void setPosition(int px, int py)
	{
		x = px;
		y = py;
	}
	
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	public void setAccelaration(double ax, double ay)
	{
		this.ax = ax;
		this.ay = ay;
	}
	
	public void move()
	{
		x += vx;
		y += vy;
	
		moving = false;
	}
	
	public void accelarate()
	{
		vx += ax;
		vy += ay;
		
	}
	
//	public void bounceV()
//	{
//		vx = -.9*vx;
//		
//		moving = true;
//	}
//	
//	public void bounceH()
//	{
//		vy = -.20 *vy;
//		
//		moving = true;
//	}
	
	
	public Rect getBounds() {
		return new Rect (x, y,  20, 50);
	}
	
	

}
	
	
	
	
	
