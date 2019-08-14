import peasy.*;

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

void setup (){
  size(1000,604,P3D);

  cam=new PeasyCam(this,500);
  
  float fov = PI/3.0;
  float cameraZ = (height/2.0) / tan(fov/2.0);
  perspective(fov, float(width)/float(height), 
            cameraZ/200.0, cameraZ*200.0);
            
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
  0.018,
  mercuryTexture);
  
  venus = new Celestial(1,
  1550+720,
  60,
  0.015,
  venusTexture);
  
  earth = new Celestial(1,
  1550+1000,
  63,
  0.01,
  earthTexture);
  
  mars = new Celestial(1,
  1550+1526,
  39,
  0.0018,
  sunTexture);
  
  jupiter = new Celestial(1,
  1550+5203,
  714,
  0.0004,
  jupiterTexture);
  
  saturn = new Celestial(1,
  1550+9537,
  602,
  0.00029,
  saturnTexture);
  
  uranus = new Celestial(1,
  1550+19191,
  250,
  0.00084,
  uranusTexture);
  
  neptune = new Celestial(1,
  1550+30000,
  247,
  0.00042,
  neptuneTexture);
  
  bg = loadImage("./data/background.jpg");
}

void draw(){
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
