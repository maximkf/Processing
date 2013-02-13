class ball{
  
  PVector location;
  PVector velocity;
  PVector accel;
  float mass;
  
  ball() {
   location = new PVector(random(width),random(height));
   velocity = new PVector(0,0);
   accel = new PVector(0,0);
   mass = random(0.5, 2);
  }
  
  void applyForce(PVector force) {
    PVector f = PVector.div(force,mass);
      accel.add(f);
  }
  
  void update() {
    velocity.add(accel);
    location.add(velocity);
    accel.mult(0);
    
  }
  
  void display() {
    smooth();
    stroke(0);
    fill(128);
    ellipse(location.x, location.y, mass*25, mass*25);
  }
  
  
}

