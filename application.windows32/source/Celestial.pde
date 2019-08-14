class Celestial {
 
  float arc = 0;
  float distance = 0;
  float radius = 0;
  float orbitSpeed;
  PVector v;
  Celestial[] satelits; 
  PShape globe;
  
  Celestial (float a, float d, float r, float o,PImage img){
    v = PVector.random3D();
    
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
  
  void spawnSatelits(int total , int level){
      satelits = new Celestial[total];
      for(int i=0 ; i < satelits.length ; i++)
      {
        float a = random(TWO_PI);
        float r = radius / random (1.5,2);
        float d = random((radius + r), (radius + r)*6);
        int textureIndex = int(random(1,7));
        println("TextureIndex "+ textureIndex);
        satelits[i] = new Celestial(a, d ,r ,random(-0.006,0.006),textures[textureIndex]);
        if (level < 4 ){
          int numSatelits = int(random(0,4));
          satelits[i].spawnSatelits(numSatelits,level +1);
        }
      } 
  }
  
  void orbit(){
      arc = arc + orbitSpeed;
      if(satelits != null){
        for(int i=0 ; i < satelits.length ; i++)
        {
          satelits[i].orbit();
        }
      }
  }
  
  void show(){ 
    pushMatrix();
    noStroke();
    fill(255);
    
    PVector v2 = new PVector(1,0,1);
    PVector p = v.cross(v2);
    rotate(arc,p.x,p.y,p.z);
    
    translate(v.x,v.y,v.z);
    //sphere(radius);
    shape(globe);
    if(satelits != null){
     for(int i=0 ; i < satelits.length - 1  ; i++)
      {
        satelits[i].show();
      }
    }
    popMatrix();
  }
  
}
