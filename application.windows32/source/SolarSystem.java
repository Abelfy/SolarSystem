import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SolarSystem extends PApplet {



PeasyCam cam;
PImage bg;
Celestial sun ;
Celestial mercury;
Celestial venus;
Celestial earth;
Celestial mars;
Celestial jupiter;
Celestial saturn;
Celestial uranus;
Celestial neptune;



PImage sunTexture;
PImage neptuneTexture;
PImage venusTexture;
PImage earthTexture;
PImage marsTexture;
PImage jupiterTexture;
PImage saturnTexture;
PImage uranusTexture;
PImage mercuryTexture; 
PImage[] textures = new PImage[7];

public void setup (){
  

  cam=new PeasyCam(this,500);
  
  float fov = PI/3.0f;
  float cameraZ = (height/2.0f) / tan(fov/2.0f);
  perspective(fov, PApplet.parseFloat(width)/PApplet.parseFloat(height), 
            cameraZ/200.0f, cameraZ*200.0f);
            
  sunTexture = loadImage("./data/sun1.jpg");
  mercuryTexture = loadImage("./data/planet6.jpg");
  venusTexture = loadImage("./data/planet5.jpg");
  earthTexture = loadImage("./data/planet1.jpg");
  marsTexture = loadImage("./data/mars.jpg");
  jupiterTexture = loadImage("./data/planet7.jpg");
  saturnTexture = loadImage("./data/saturn.jpg");
  neptuneTexture = loadImage("./data/neptune.jpg");
  uranusTexture = loadImage("./data/uranus.jpg");
  
  
  sun = new Celestial(0,0,1550,0,sunTexture);
  //7.0049
  //3.3947
  //0
  //1.8506
  //1.3053
  //2.4845
  //0.7699
  //1.7699
  
  mercury = new Celestial(1,
  1550+380,
  24,
  0.018f,
  mercuryTexture);
  
  venus = new Celestial(1,
  1550+720,
  60,
  0.015f,
  venusTexture);
  
  earth = new Celestial(1,
  1550+1000,
  63,
  0.01f,
  earthTexture);
  
  mars = new Celestial(1,
  1550+1526,
  39,
  0.0018f,
  sunTexture);
  
  jupiter = new Celestial(1,
  1550+5203,
  714,
  0.0004f,
  jupiterTexture);
  
  saturn = new Celestial(1,
  1550+9537,
  602,
  0.00029f,
  saturnTexture);
  
  uranus = new Celestial(1,
  1550+19191,
  250,
  0.00084f,
  uranusTexture);
  
  neptune = new Celestial(1,
  1550+30000,
  247,
  0.00042f,
  neptuneTexture);
  
  bg = loadImage("./data/background.jpg");
}

public void draw(){
  background(bg);
  lights();
  //pointLight(255,255,255,0,0,0);
  /*fill(255,100);
  circle(0,0,10000);
  noFill();*/
  sun.show();
  mercury.show();
  venus.show();
  earth.show();
  mars.show();
  jupiter.show();
  saturn.show();
  uranus.show();
  neptune.show();
  
  sun.orbit();
  mercury.orbit();
  venus.orbit();
  earth.orbit();
  mars.orbit();
  jupiter.orbit();
  saturn.orbit();
  uranus.orbit();
  neptune.orbit();

}
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
    
  public void orbit(){
      arc = arc + orbitSpeed;
  }
  
  public void show(){ 
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
  public void settings() {  size(1000,604,P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SolarSystem" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
