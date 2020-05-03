import java.awt.*;

public class Animation
{
	private Image[] image;
	
	private int current = 0;
	
	int delay;
	int duration; 
	// ANIMATION CONSTRUCTOR BASED ON FILE NAME, COUNT FOR ARRAY SIZE, STRIG EXTENTION OF FILE AND DURATION ON SCREEN.
	public Animation(String name, int count, String ext, int duration)
	{
		image = new Image[count];
		//LOOP TO LOAD EVERY IMAGE INTO THE ANIMATION ARRAY.
		for(int i = 0; i < count; i++)
			
			image[i] = loadImage(name + i + ext);
	
		this.duration = duration;
		delay = duration;
	}
	
	//CHANGE THE INDEX OF THE CURRENT ANIMATION POSE.
	public Image getImage()
	{
		if(delay == 0)
		{	
		   current++;
		
	   	if(current == image.length)  current = 1;
	   	
	   	delay = duration;
		}
		
		delay--;
		
	   return image[current];
	}
	// SPRITE IS NOT MOVING THEN GET IMAGE AT ANIMATION ARRAY INDEX 0.
	public Image getStillImage()
	{
		return image[0];
	}
	
	// LOAD IMMAGE METHOH FOR THE ANIMATION ARRAY.
	public Image loadImage(String filename)
	{
		return Toolkit.getDefaultToolkit().getImage(filename);
	}

}