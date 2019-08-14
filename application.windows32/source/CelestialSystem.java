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

public class CelestialSystem extends PApplet {



int width = 900 , height = 900;
Celestial sun ;
PImage bg;
PImage sunTexture;
PImage[] textures = new PImage[7];
PeasyCam cam;

public void setup (){
  
  cam=new PeasyCam(this,500);
  
  int num = PApplet.parseInt(random(1,3));
  sunTexture = loadImage("./data/sun"+num+".jpg");
  
  for(int i = 1 ; i <8 ; i++){
    textures[i-1] =loadImage("./data/planet"+i+".jpg");
  }
  sun = new Celestial(0,0,50,0,sunTexture);
  sun.spawnSatelits(4,1);
  bg = loadImage("./data/background.jpg");
}

public void draw(){
  background(bg);
  lights();
  sun.orbit();
  sun.show();
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
  
  public void spawnSatelits(int total , int level){
      satelits = new Celestial[total];
      for(int i=0 ; i < satelits.length ; i++)
      {
        float a = random(TWO_PI);
        float r = radius / random (1.5f,2);
        float d = random((radius + r), (radius + r)*6);
        int textureIndex = PApplet.parseInt(random(1,7));
        println("TextureIndex "+ textureIndex);
        satelits[i] = new Celestial(a, d ,r ,random(-0.006f,0.006f),textures[textureIndex]);
        if (level < 4 ){
          int numSatelits = PApplet.parseInt(random(0,4));
          satelits[i].spawnSatelits(numSatelits,level +1);
        }
      } 
  }
  
  public void orbit(){
      arc = arc + orbitSpeed;
      if(satelits != null){
        for(int i=0 ; i < satelits.length ; i++)
        {
          satelits[i].orbit();
        }
      }
  }
  
  public void show(){ 
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
  public void settings() {  size(1000,604,P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "CelestialSystem" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
