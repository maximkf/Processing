import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class homework_2_13 extends PApplet {

ball[] balls;

public void setup() {
  size(400,400);
  smooth();
  frameRate(30);
  balls = new ball[100];
  for(int i = 0; i < balls.length; i ++) {
     balls[i] = new ball();
  }
}

public void draw () {
  background(255);
//    for (int i = 0; i < balls.length; i++){
    for (ball b : balls) {
        PVector center = new PVector(width/2,height/2);     
        
        //create new random vector, give it a magnitude and apply it
        PVector rand = PVector.random2D();
        rand.mult(0.25f);
        b.applyForce(rand);
        
        
        float diff = width-b.location.x;
        if (diff < 50) {
          PVector left = new PVector(-0.5f,0);
          b.applyForce(left); 
        }
        
        float diff2 = 0+b.location.x;
        if (diff2 < 50) {
          PVector right = new PVector(0.5f,0);
          b.applyForce(right); 
        }
        
        float diff3 = height-b.location.y;
        if (diff3 < 50) {
          PVector up = new PVector(0,-0.5f);
          b.applyForce(up); 
        }
        
        float diff4 = 0+b.location.y;
        if (diff4 < 50) {
          PVector down = new PVector(0,0.5f);
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
class ball{
  
  PVector location;
  PVector velocity;
  PVector accel;
  float mass;
  
  ball() {
   location = new PVector(random(width),random(height));
   velocity = new PVector(0,0);
   accel = new PVector(0,0);
   mass = random(0.5f, 2);
  }
  
  public void applyForce(PVector force) {
    PVector f = PVector.div(force,mass);
      accel.add(f);
  }
  
  public void update() {
    velocity.add(accel);
    location.add(velocity);
    accel.mult(0);
    
  }
  
  public void display() {
    smooth();
    stroke(0);
    fill(128);
    ellipse(location.x, location.y, mass*25, mass*25);
  }
  
  
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "homework_2_13" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
