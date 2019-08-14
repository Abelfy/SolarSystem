class Celestial {
 
  float arc = 0;
  float distance = 0;
  float radius = 0;
  float orbitSpeed;
  PVector v;
  Celestial[] satelits; 
  PShape globe;
  
  Celestial (float a, float d, float r, float o,PImage img){
    v = new PVector(a,1,0);
    
    distance = d;
    radius = r;
    v.mult(distance);
    
    arc = a ;
    orbitSpeed = o;
    
    noStroke();
    noFill();
    globe = createShape(SPHERE,radius);
    globe.setTexture(img);
  }
    
  void orbit(){
      arc = arc + orbitSpeed;
  }
  
  void show(){ 
    pushMatrix();
      noStroke();    
      PVector v2 = new PVector(1,0,1);
      PVector p = v.cross(v2);
      rotate(arc,p.x,p.y,p.z);
      translate(v.x,v.y,v.z);
      shape(globe);
    popMatrix();
  }
  
}
