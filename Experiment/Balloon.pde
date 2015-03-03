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

  		balloonOpacity = int(random(50, 250));

  		speedX = random(-0.5,0.5);
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