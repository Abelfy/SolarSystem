import peasy.*;

int width = 900 , height = 900;
Celestial sun ;
PImage bg;
PImage sunTexture;
PImage[] textures = new PImage[7];
PeasyCam cam;

void setup (){
  size(1000,604,P3D);
  cam=new PeasyCam(this,500);
  
  int num = int(random(1,3));
  sunTexture = loadImage("./data/sun"+num+".jpg");
  
  for(int i = 1 ; i <8 ; i++){
    textures[i-1] =loadImage("./data/planet"+i+".jpg");
  }
  sun = new Celestial(0,0,50,0,sunTexture);
  sun.spawnSatelits(4,1);
  bg = loadImage("./data/background.jpg");
}

void draw(){
  background(bg);
  lights();
  sun.orbit();
  sun.show();
}
