import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class CannoF10 extends GameBase {

	//CANNON BASE IMAGE.
	Image CannonBase;
	
	//CANNON OBJECT.
	Cannon cannon;
	
	//BACKGROUND IMAGE.
	Image Background;
	Image BackgroundBack;
	
	//IMAGE OF CANNON HEALTH-BAR AND SCORE.
	Image HealthBar;
	Image ScoreBar;
	int Score;
	int CurrentRecord = 1000;
	int Health = 95;
	
	//CREATING FALLING OBJECTS Array.
	broken_bottle [] bottle = new broken_bottle[10];
	cactus_01 []cactus_01 = new cactus_01 [10] ;
	cactus_02 []cactus_02 = new cactus_02 [10];
	cactus_03 []cactus_03 = new cactus_03[10];
	knife []knife = new knife [10];
	nail []nail = new nail [10];
	pin []pin = new pin [10];
	pin2 []pin2 = new pin2 [10];
	spiky_ball [] spiky_ball = new spiky_ball[10] ;
	
	
	//ARRAY CREATES 100 BULLETS OBJECTS.
	Bullet [] b = new Bullet [100];
	int j;
	
	Random rnd = new Random();
	
	//World Limits
	
	Rect LeftLimit = new Rect (-10, 10, 10, 800);
	Rect Rightlimit = new Rect (780, 10, 10, 800);
	Rect Ground = new Rect (0, 600, 800, 30);
	
	int speed = 0;
	
	public void SetScreen() {
		this.setSize(800, 600);
	}
	
	@Override
	public void initialize() {
		// INITIALIZING ALL THE OBJECTS.
		
		CannonBase = Toolkit.getDefaultToolkit().getImage("base.png");
		cannon = new Cannon(370,530);
		
		Background = Toolkit.getDefaultToolkit().getImage("Background.png");
	
		HealthBar = Toolkit.getDefaultToolkit().getImage("CannonHealth.png");
		
		ScoreBar = Toolkit.getDefaultToolkit().getImage("ScoreBar.png");
		
				
		for(int i = 0; i < b.length; i++) 
		{
			b[i]= new Bullet (-1000,-1000);
			b[i].setAccelaration(0, 0.1);
		}
		
		//SETTING A LOCATION FOR EACH ITEM FALLING OBJECTS (Initializing).
		for( int i = 0; i < bottle.length ; i++) {
		
			bottle[i] = new broken_bottle (rnd.nextInt(700),rnd.nextInt(20) - 50);
			cactus_01[i] = new cactus_01(rnd.nextInt(700),rnd.nextInt(20)-1000);
			cactus_02[i] = new cactus_02(rnd.nextInt(700),rnd.nextInt(20)-3500);
			cactus_03[i] = new cactus_03(rnd.nextInt(700),rnd.nextInt(10)-1150);
			knife[i] = new knife(rnd.nextInt(700),rnd.nextInt(5)-3500);
			nail[i] = new nail(rnd.nextInt(700),rnd.nextInt(5)-4000);
			pin[i] = new pin(rnd.nextInt(700),rnd.nextInt(5)-5500);
			pin2[i] = new pin2(rnd.nextInt(700),rnd.nextInt(30)-6000);
			spiky_ball[i] = new spiky_ball(rnd.nextInt(700),rnd.nextInt(20) - 7500);
			
	}
		
		j = 0;
		
		
	}

	@Override
	public void inTheGameLoop() {
		
		//CANNON MOVEMENTS.
		if(pressed[LT]) cannon.moveLeft(5); 
		if(pressed[RT]) cannon.moveRight(5);
		if(pressed[SPACE]) cannon.moveUp(0);
		
//		 SHOOT BULLET WHEN SPACE IS PRESSED.
		if(pressed[SPACE])  cannon.Shoot(b[j]);
		j = (j + 1) % b.length;
		
		
		
		
		SetScreen();
		//UPATED EVERY BULLET.
		for(int i = 0; i < b.length; i++) 
		    {
		        b[i].update();
		    }
		
		//SPEED FOR FALLING ITEMS.
		
		if(CurrentRecord < Score) {
			CurrentRecord += 1100;
			speed ++;
		}
		
		
		// LOOP FOR EVERY FALLING ITEM TO MOVE DOWN!
		for(int i = 0; i < bottle.length ; i ++) {
				
			bottle[i].moveDown(1 + speed);
				
			cactus_01[i].moveDown(1 + speed);
				
			cactus_02[i].moveDown(1 + speed);
				
			cactus_03[i].moveDown(1 + speed);
				
			knife[i].moveDown(2 + speed); 
				
			nail[i].moveDown(2 + speed);
				
			pin[i].moveDown(2 + speed);
				
			pin2[i].moveDown(2 + speed);
				
			spiky_ball[i].moveDown(3 + speed);
			}
			
		Impact();
		WorldLimit();
	}
	// MEHTOD FOR COLLETION DETECTION.
	public void Impact() {
		
		for(int i = 0; i < b.length; i ++) {
			
			Rect Bullet = b[i].getBounds();
			
										//Bottle Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
		for(int j = 0; j < bottle.length; j ++) {
			
			Rect Bottle = bottle[j].getBounds();
			
			if( Bullet.overlaps(Bottle))
			{
				
				bottle[j].setPosition(rnd.nextInt(700),rnd.nextInt(20) - 200);
				Score += 5;
			}
		}
									//Cactus01 Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			for(int j = 0; j < cactus_01.length; j ++) {
			
			Rect Cactus01 = cactus_01[j].getBounds();
			
			if( Bullet.overlaps(Cactus01))
			{
				
				cactus_01[j].setPosition(rnd.nextInt(700),rnd.nextInt(20)-1000);
				Score += 10;
			}
		}
									//Cactus02 Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < cactus_02.length; j ++) {
				
				Rect Cactus02 = cactus_02[j].getBounds();
				
				if( Bullet.overlaps(Cactus02))
				{
					
					cactus_02[j].setPosition(rnd.nextInt(700),rnd.nextInt(20)-3500);
					Score += 15;
				}
			}
			
			          				//Cactus03 Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < cactus_03.length; j ++) {
				
				Rect Cactus03 = cactus_03[j].getBounds();
				
				if( Bullet.overlaps(Cactus03))
				{
					
					cactus_03[j].setPosition(rnd.nextInt(700),rnd.nextInt(10)-1150);
					Score += 20;
				}
			}
			
								//knife Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < knife.length; j ++) {
				
				Rect Knife = knife[j].getBounds();
				
				if( Bullet.overlaps(Knife))
				{
					
					knife[j].setPosition(rnd.nextInt(700),rnd.nextInt(5)-4000);
					Score += 25;
				}
			}
			
									//nail Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < nail.length; j ++) {
				
				Rect Nail = nail[j].getBounds();
				
				if( Bullet.overlaps(Nail))
				{
					
					nail[j].setPosition(rnd.nextInt(700),rnd.nextInt(5)-3500);
					Score += 30;
				}
			}
			
							//pin Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			
			for(int j = 0; j < pin.length; j ++) {
				
				Rect Pin = pin[j].getBounds();
				
				if( Bullet.overlaps(Pin))
				{
					
					pin[j].setPosition(rnd.nextInt(700),rnd.nextInt(5)-4000);
					Score += 35;
				}
			}
			
			    				//pin2 Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < pin2.length; j ++) {
				
				Rect Pin2 = pin2[j].getBounds();
				
				if( Bullet.overlaps(Pin2))
				{
					
					pin2[j].setPosition(rnd.nextInt(700),rnd.nextInt(30)-6000);
					Score += 40;
				}
			}
			
								//spiky_ball Bounds (Collection).
//-------------------------------------------------------------------------------------------------------------------//
			
			for(int j = 0; j < spiky_ball.length; j ++) {
				
				Rect Spiky_ball = spiky_ball[j].getBounds();
				
				if( Bullet.overlaps(Spiky_ball))
				{
					
					spiky_ball[j].setPosition(rnd.nextInt(700),rnd.nextInt(20) - 7500);
					Score += 45;
				}
			}
		
		}
		
		
		
	}
	
	public void WorldLimit() {
		
		if(LeftLimit.contains(cannon.x, cannon.y)) {
			cannon.x += 10;
		}
		
		if(Rightlimit.contains(cannon.x, cannon.y)) {
			cannon.x -=10;
		}
								//CREATES NEW BOTTLE OBJECT WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		for(int i = 0; i < bottle.length;i++) {
			if(Ground.contains(bottle[i].x, bottle[i].y)) {
				bottle[i] = new broken_bottle (rnd.nextInt(700),rnd.nextInt(20) - 50);
				Health -= 1;
			}
		}
		
									//CREATES NEW  CACTUS01 OBJECT WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//	
		
		for(int i = 0; i < cactus_01.length;i++) {
			if(Ground.contains(cactus_01[i].x, cactus_01[i].y)) {
				cactus_01[i] = new cactus_01 (rnd.nextInt(700),rnd.nextInt(20)-1000);
				Health -= 1;
			}
		}
		
								//CREATES NEW  CACTUS02 OBJECTS WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//	
		
		for(int i = 0; i < cactus_02.length;i++) {
			if(Ground.contains(cactus_02[i].x, cactus_02[i].y)) {
				cactus_02[i] = new cactus_02 (rnd.nextInt(700),rnd.nextInt(20)-3500);
				Health -= 1;
			}
		}
		
							//CREATES NEW  CACTUS03 OBJECTS WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < cactus_03.length;i++) {
			if(Ground.contains(cactus_03[i].x, cactus_03[i].y)) {
				cactus_03[i] = new cactus_03 (rnd.nextInt(700),rnd.nextInt(10)-1150);
				Health -= 1;
			}
		}
		
		              //CREATES NEW  KNIFE OBJECTS WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < knife.length;i++) {
			if(Ground.contains(knife[i].x, knife[i].y)) {
				knife[i] = new knife (rnd.nextInt(700),rnd.nextInt(5)-3500);
				Health -= 1;
			}
		}
		
							//CREATES NEW  KNIFE OBJECTS WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < nail.length;i++) {
			if(Ground.contains(nail[i].x, nail[i].y)) {
				nail[i] = new nail (rnd.nextInt(700),rnd.nextInt(5)-4000);
				Health -= 1;
			}
		}
		
						//CREATES NEW  NAIL OBJECTS WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < nail.length;i++) {
			if(Ground.contains(nail[i].x, nail[i].y)) {
				nail[i] = new nail (rnd.nextInt(700),rnd.nextInt(5)-5500);
				Health -= 1;
			}
		}
		
							//CREATES NEW  OBJECTS PIN POSITION WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		for(int i = 0; i < pin.length;i++) {
			if(Ground.contains(pin[i].x, pin[i].y)) {
				pin[i] = new pin (rnd.nextInt(700),rnd.nextInt(5)-5500);
				Health -= 1;
			}
		}
		
							//CREATES NEW  OBJECTS PIN2 WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < pin2.length;i++) {
			if(Ground.contains(pin2[i].x, pin2[i].y)) {
				pin2[i] = new pin2 (rnd.nextInt(700),rnd.nextInt(30)-6000);
				Health -= 1;
			}
		}
		
		                  //CREATES NEW  OBJECT SPIKY_BALL POSITION WHEN HITS THE GROUND.
//-------------------------------------------------------------------------------------------------------------------//
		
		for(int i = 0; i < spiky_ball.length;i++) {
			if(Ground.contains(spiky_ball[i].x, spiky_ball[i].y)) {
				spiky_ball[i] = new spiky_ball (rnd.nextInt(700),rnd.nextInt(20) - 7500);
				Health -= 1;
			}
		}
		
	}
	
	
	public void paint (Graphics g) {
		
		//CAST G TO A 2D COMPONENT.
		Graphics2D g2d = (Graphics2D) g;
		//BACKGROUND IMAGE.
		g.drawImage(Background,0, 0 , null);
		
		//DRAW EVERY BULLET FROM THE BULLET ARRAY.
		for(int i = 0; i < b.length; i++) {
			
			b[i].draw(g);
		}
		
		//Draw the Cannon and Base.
		cannon.draw(g);
		g.drawImage(CannonBase, cannon.x - 20, 550, null);
		
		//LOOP TO DRAW EVERY FALLING OBJECT.
		for( int i = 0; i < bottle.length ; i++) {
			
			bottle[i].draw(g);
			
			cactus_01[i].draw(g);
			
			cactus_02[i].draw(g);
				
			cactus_03[i].draw(g);
				
			knife[i].draw(g); 
				
			nail[i].draw(g);
				
			pin[i].draw(g);
				
			pin2[i].draw(g);
				
			spiky_ball[i].draw(g);
	}
		//DRAW HEALTH STATUS AND HEALTH BAR.	
		g.drawImage(HealthBar, 0, 0, null);
		
		g.setColor(Color.red);
		g.fillRect(45, 12, 190, 10);
		g.setColor(Color.blue);
		g.fillRect(45, 12, Health * 2, 10);
		g.setColor(Color.black);
		g.drawRect(45, 12, 190, 10);
		
		//SCORE LABEL.
		g.drawImage(ScoreBar, 700, 0, null);
		g2d.setColor(Color.white);
		g2d.setFont(new Font("sansserif", Font.BOLD, 19));
		g2d.drawString("   " + Score, 700, 20);
		
		
		//GAME OVER!
		
		if(Health < -5) {
			cannon.setPosition(-1000, -1000);
			g2d.setColor(Color.white);
			g2d.setFont(new Font("sansserif", Font.BOLD, 70));
			g2d.drawString("Game Over", 200, 250);
		}
		
//		Magic Testing Collection.
		/*/
		for(int i = 0; i < bottle.length; i ++) {
			
			Rect Bottle = bottle[i].getBounds();
			
			Bottle.draw(g);
		}
		
		for(int i = 0; i < b.length; i ++)
		{
		
		Rect Ball = b[i].getBounds();
		
		Ball.draw(g);
		
		}
		
		for(int i = 0; i < cactus_01.length; i ++) 
		{
			
			Rect Cactus_01 = cactus_01[i].getBounds();
			
			Cactus_01.draw(g);
		}
		
		for(int i = 0; i < cactus_02.length; i ++) 
		{
			
			Rect Cactus_02 = cactus_02[i].getBounds();
			
			Cactus_02.draw(g);
		}
		
		for(int i = 0; i < cactus_03.length; i ++) 
		{
			
			Rect Cactus_03 = cactus_03[i].getBounds();
			
			Cactus_03.draw(g);
		}
		
		for(int i = 0; i < knife.length; i ++) 
		{
			
			Rect Knife = knife[i].getBounds();
			
			Knife.draw(g);
		}
		
		for(int i = 0; i < nail.length; i ++) 
		{
			
			Rect Nail = nail[i].getBounds();
			
			Nail.draw(g);
		}
		
		for(int i = 0; i < pin.length; i ++) 
		{
			
			Rect Pin = pin[i].getBounds();
			
			Pin.draw(g);
		}
		
		for(int i = 0; i < pin2.length; i ++) 
		{
			
			Rect Pin2 = pin2[i].getBounds();
			
			Pin2.draw(g);
		}
		
		for(int i = 0; i < spiky_ball.length; i ++) 
		{
			
			Rect Spiky_ball = spiky_ball[i].getBounds();
			
			Spiky_ball.draw(g);
		}
		
		LeftLimit.draw(g);
		Rightlimit.draw(g);
		Ground.draw(g);
		

		//*/
		
	
		
	}

}
