package edu.smith.cs.csc212.aquarium;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;

public class Fish {
	 int x,y;
	 Color color;
	 boolean facingLeft;
	 boolean isLittle; 
	
	 //Construct fish at position with color
	public Fish(Color c ,int startX, int startY, boolean dir, boolean size) {
		this.x=startX;
		this.y=startY;
		this.color= c;
		this.facingLeft= dir;
		this.isLittle=size; 
	}	
		
	
	public void swim () {
		
		Random location = new Random ();
		Random location2 = new Random ();
		int corX= location.nextInt(100);
		int corY= location2.nextInt(100);
		if (x-corX >0) 
		{
			this.facingLeft =true;
		} else 
		{
			this.facingLeft= false; 
		}
		while (x< corX) 
		{
			x++; 
		}
		while (x> corX)
		{
			x--;
		}
		while (y< corY)
		{
			y++;
		}
		while (y> corY)
		{
			y--;
		}
		
	}

	public void draw(Graphics2D window) {
		if (this.facingLeft==true && this.isLittle==true) 
		{
			DrawFish.smallFacingLeft(window, this.color,this.x,this.y);
			
		} else if (this.facingLeft==true && this.isLittle==false)
		{
			DrawFish.facingLeft(window, this.color,this.x,this.y);
			DrawFish.smallFacingLeft(window, this.color,this.x,this.y);
		}
		else if (this.facingLeft=false && this.isLittle==true) 
		{
			DrawFish.smallFacingRight(window, this.color,this.x,this.y);
		} else 
		{
			DrawFish.facingRight(window, this.color,this.x,this.y);
		}
		this.swim();
		
		
		
		DrawFish.smallFacingRight(window, this.color,this.x,this.y);
	}
	

}
