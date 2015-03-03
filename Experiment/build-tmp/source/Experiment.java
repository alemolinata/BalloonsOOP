import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Experiment extends PApplet {

float balloonHeight = 120;
float balloonWidth = 100;

ArrayList<Balloon> balloons = new ArrayList<Balloon>();

public void setup() {  
	size(displayWidth, displayHeight);
	background(255);
}

public void draw() {
	background(255);

	for ( int i = 0; i < balloons.size(); i++ ){
		balloons.get(i).drawThing();
		balloons.get(i).fly();
	}
}

public void mousePressed(){
	balloons.add(new Balloon(mouseX, mouseY));
}
class Balloon{
	float x;
	float y;

	int balloonOpacity;

	float swing = 0;
	float swingSpeed = 2;

	float speedX;
	float speedY;

	// constructor (with arguments)
  	public Balloon(float positionX, float positionY) {
  		x = positionX;
  		y = positionY;

  		balloonOpacity = PApplet.parseInt(random(50, 250));

  		speedX = random(-0.5f,0.5f);
  		speedY = random(1, 2);
  	}

  	public void drawThing(){
  		fill(230, 10, 10, balloonOpacity);
		noStroke();
		ellipse(x, y, balloonWidth, balloonHeight);
		beginShape();
			vertex(x, y + balloonHeight/2);
			vertex(x - balloonWidth/8, y + balloonHeight/2 + balloonHeight/8);
			vertex(x + balloonWidth/8, y + balloonHeight/2 + balloonHeight/8);
		endShape(CLOSE);
		noFill();
		stroke(40);
		bezier( x, y + balloonHeight/2 + balloonHeight/8,
			 	x - swing, y + balloonHeight/2 + balloonHeight/8 + balloonHeight/2, 
			  	x + swing, y + balloonHeight/8 + balloonHeight*2,
			 	x, y + balloonHeight/2 + balloonHeight/8 + balloonHeight*2);
  	}

  	public void fly(){
  		y -= speedY;
  		x += speedX;

  		if( swing > balloonWidth/2 ){
  			swingSpeed = -2;
  		}
  		else if( swing < balloonWidth/2 * -1 ){
  			swingSpeed = 2;
  		}
  		swing = swing + swingSpeed;
  	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Experiment" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
