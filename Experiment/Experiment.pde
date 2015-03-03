float balloonHeight = 120;
float balloonWidth = 100;

ArrayList<Balloon> balloons = new ArrayList<Balloon>();

void setup() {  
	size(displayWidth, displayHeight);
	background(255);
}

void draw() {
	background(255);

	for ( int i = 0; i < balloons.size(); i++ ){
		balloons.get(i).drawThing();
		balloons.get(i).fly();
	}
}

void mousePressed(){
	balloons.add(new Balloon(mouseX, mouseY));
}
