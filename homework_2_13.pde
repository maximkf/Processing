ball[] balls;

void setup() {
  size(400,400);
  smooth();
  frameRate(30);
  balls = new ball[100];
  for(int i = 0; i < balls.length; i ++) {
     balls[i] = new ball();
  }
}

void draw () {
  background(255);
//    for (int i = 0; i < balls.length; i++){
    for (ball b : balls) {
        PVector center = new PVector(width/2,height/2);     
        
        //create new random vector, give it a magnitude and apply it
        PVector rand = PVector.random2D();
        rand.mult(0.25);
        b.applyForce(rand);
        
        
        float diff = width-b.location.x;
        if (diff < 50) {
          PVector left = new PVector(-0.5,0);
          b.applyForce(left); 
        }
        
        float diff2 = 0+b.location.x;
        if (diff2 < 50) {
          PVector right = new PVector(0.5,0);
          b.applyForce(right); 
        }
        
        float diff3 = height-b.location.y;
        if (diff3 < 50) {
          PVector up = new PVector(0,-0.5);
          b.applyForce(up); 
        }
        
        float diff4 = 0+b.location.y;
        if (diff4 < 50) {
          PVector down = new PVector(0,0.5);
          b.applyForce(down); 
        }
        
        b.update();
        b.display();
    
    }
// }
}

// void mousePressed(){
//      ball b = new ball();
//      
//      balls = (ball[]) append(balls,b);
//   }
