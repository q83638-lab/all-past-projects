var rect=[];
var end=[];
var blockSize=50;
var leftPressed=false;
var rightPressed=false;
var upPressed=false;
var downPressed=false;
var xDir=1;
var count1=0;
var count2=0;
//randomcolor
//multiplayer
//coliding setthe velocity seperately
//count n timer?
document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyleft", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);
document.addEventListener("mousemove", mouseMovementHandler, false);
document.addEventListener("keyright", keyUpHandler, false);
var c,d,e,f,g,h,i;
function setup() {
createCanvas(400,400);
piece=new GamePiece();
borders = new Group();
var a = createSprite(10, 0, 20, 800);
var b =createSprite(390,0, 20, 800);
borders.add(a);
borders.add(b);
obsticles=new Group();
pieces= new Group();
ends=new Group();
g=createSprite(40,20,blockSize,blockSize);
pieces.add(g);
var k=random(10);
 c= (createSprite(20-k,230+k,30,50));
c.setSpeed(5,0);
 d= (createSprite(20-k,360+k,30,50));
d.setSpeed(5,0);
e=(createSprite(380-k,150+k,30,50));
e.setSpeed(-5,0);
f= (createSprite(380-k,280+k,30,50));
f.setSpeed(-5,0);
obsticles.add(c);
obsticles.add(d);
obsticles.add(e);
obsticles.add(f);
borders.add(createSprite(201.5,80,20,100));
h=(createSprite(random(60,350),random(100,350),blockSize+20,blockSize));
ends.add(h);
var ran=random(255);
var ran2=random(255);
var ran3=random(255);
i=createSprite(360,20,blockSize,blockSize);
for(var t=0;t<obsticles.length;t++){
obsticles[t].shapeColor=(color(ran,ran2,ran3));
}
for(var j=0;j<borders.length;j++){
  borders[j].shapeColor=(color("#40798C"));
}
pieces.add(i);
}

function draw() {
background(color("#F6F1D1"));
fill(200);
  textAlign(CENTER);
  text("Player1 Score: "+count1+"  Player2 Score: "+count2, width/2, 20);
g.position.x=constrain(g.position.x,0,width);//***
g.position.y=constrain(g.position.y,20,height-20);
i.position.x=constrain(i.position.x,0,width);//***
i.position.y=constrain(i.position.y,20,height-20);
//piece.show();
//piece.move();
drawSprites(borders);
drawSprites(obsticles);
drawSprites(pieces);
drawSprites(ends);
//obsticles.position.x+=xDir;
if(obsticles.collide(borders)){
//console.log("yup");
d.velocity.x=-d.velocity.x;
c.velocity.x=-c.velocity.x;
e.velocity.x=-e.velocity.x;
f.velocity.x=-f.velocity.x;
}
if(g.collide(borders)){
//console.log("yup");
g.velocity.x=-g.velocity.x;
g.velocity.y=-g.velocity.y;

}
if(i.collide(borders)){
  i.velocity.x=-i.velocity.x;
  i.velocity.y=-i.velocity.y;
}
if(g.collide(obsticles))
{  g.position.x=40;
  g.position.y=20;

}
if(i.collide(obsticles))
{i.position.x=360;
 i.position.y=20;}
if(pieces[0].overlap(ends))
{//background(0);
  count1++;
  //console.log(count);
  ends[0]=(createSprite(random(60,350),random(100,350),blockSize+20,blockSize));
  //ends.add(h);
//location.reload();
}
if(pieces[1].overlap(ends))
{//background(0);
  count2++;
  //console.log(count);
  ends[0]=(createSprite(random(60,350),random(100,350),blockSize+20,blockSize));
  //ends.add(h);
//location.reload();
}
move();

}
function mouseMovementHandler(e)
{//console.log(event);

}
function keyDownHandler(e) {
    if(e.keyCode == 39) {
      console.log("hey");
        rightPressed = true;

    }
    else if(e.keyCode == 37) {
        leftPressed = true;

    }
    else if(e.keyCode == 38) {
        upPressed = true;

    }
    else if(e.keyCode == 40) {
        downPressed = true;

    }
}

function keyUpHandler(e) {// give you information of the keys
    if(e.keyCode == 39) {
        rightPressed = false;
    }
    else if(e.keyCode == 37) {
        leftPressed = false;
    }
    else if(e.keyCode == 38) {
        upPressed = false;
    }
    else if(e.keyCode == 40) {
        downPressed = false;
    }
}
function move(){
  if(keyDown(LEFT)){
    console.log("left");
    g.position.x+=-3;
  }
  if(keyDown(RIGHT)){
    g.position.x+=3;
  }
  if(keyDown(38))
   g.position.y+=-3;
  if (keyDown(40))
  g.position.y+=3;
  /*if((leftPressed==false&&rightPressed==false)&&(upPressed==true||downPressed==true))
  g.velocity.x=0;
  if((upPressed==false&&downPressed==false)&&(leftPressed==true||rightPressed==true))
  g.velocity.y=0;
  if((upPressed==false&&downPressed==false)&&(leftPressed==false&&rightPressed==false))
  {
  g.velocity.x=0;
  g.velocity.y=0;
}*/
  if(keyDown("s"))
  i.position.y+=3;
  if(keyDown("w"))
  i.position.y-=3;
  if(keyDown("a"))
    i.position.x-=3;
  if(keyDown("d"))
  i.position.x+=3;
}
