//alert("hello"); test
document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);
document.addEventListener("mousemove", mouseMovementHandler, false);
var canvas= document.getElementById("BestCanvas");
//console.log(canvas);//test
var ctx= canvas.getContext("2d");
var x=canvas.width/2;
var y=canvas.height/2;
var xDir=1;
var yDir=1;
var paddlew=90;
var paddleh=30;
var paddleX=canvas.width/2-paddlew/2;
var rightPressed = false;
var leftPressed = false;
var brickWidth=60;
var brickHeight=20;
var bricks=[];
var brickGapX=25;
var brickGapY=65;
var brickX=30;
var brickY=20;
var numRows=3;
var numCols=4;
for(var col=0;col<numCols;col++)
{ bricks[col]=[];
  for(var row=0;row<numRows;row++){
  bricks[col][row]=new brick(col*(brickWidth+brickGapX)+brickX,row*(brickHeight+brickGapY)+brickY,brickWidth,brickHeight,"#FFEFD5","#FFEFD5",1);
  }
}
function drawBall()
{
  ctx.beginPath();
  ctx.arc(x,y,15,0,Math.PI*2);
  ctx.fillStyle="#E6E6FA";
  ctx.fill();
  ctx.closePath();
}

function makebricks(){

  for( var j=0;j<numCols;j++)
  {
    for( var k=0;k<numRows;k++){
if( bricks[j][k].status==1){
console.log(bricks[j][k].status);
bricks[j][k].draw();

}
}

}
  /*for(var j=0;j<130;j+=30){
  for(var i=0;i<260;i+=70){
  myBrick.x+=i;
  myBrick.y+=j;
  //myBrick.draw();
}*/
}
function newLife(){
  x=canvas.width/2;
  y=canvas.height/2;
  paddlex=canvas.width/2-paddlew/2;
  rightPressed=leftPressed=false;
}
function brick(xi,yi,width,height,outerColor,innerColor,status)
{ this.x=xi;
  this.y=yi;
  this.width=width;
  this.height=height;
  this.outerColor=outerColor;
  this.innerColor=innerColor;
  this.status=status;
    this.draw=function()
    {
    ctx.beginPath();
    ctx.fillRect(this.x,this.y,this.width,this.height);
    ctx.fillStyle=this.innerColor;
    ctx.strokeStyle=this.outerColor;
    ctx.fill();
    ctx.closePath();
  };
}
//var myBrick=new brick(20,60,60,20,"#FFFACD","#FFFACD",1);
function reverseDir(){
  if(y+15>=canvas.height)
  yDir=-yDir;
  if(y-15<=0)
  yDir=-yDir;
  if(x+15>=canvas.width)
  xDir=-xDir;
  if(x-15<=0)
    xDir=-xDir;
  drawbricks();
  }
function drawbricks(){
  ctx.beginPath();
  ctx.rect(paddleX,canvas.height-paddleh-10,paddlew,paddleh);
  ctx.fillStyle="#FFEFD5";
  ctx.fill();
  ctx.closePath();
//  ctx.fillRect(10,20,30,80);
}
function movebricks(){
  if(rightPressed && paddleX < canvas.width-paddlew) {
      paddleX ++;
  }
  else if(leftPressed && paddleX > 0) {
      paddleX --;
  }
}
function collisionDetection(){

}
function keyDownHandler(e) {
    if(e.keyCode == 39) {
      //console.log(e);
        rightPressed = true;
    }
    else if(e.keyCode == 37) {
        leftPressed = true;
    }
}

function keyUpHandler(e) {// give you information of the keys
    if(e.keyCode == 39) {
        rightPressed = false;
    }
    else if(e.keyCode == 37) {
        leftPressed = false;
    }
}
function mouseMovementHandler(e)
{//console.log(event);

}
setInterval(render, 10);//if calling it use ();
//render();

function bounceOffthePaddle()
{ if(RectCircleColliding()==true)
  { console.log("truee!");
    xDir=-1;
    yDir=-1;
  }
}

function RectCircleColliding(){
    var distX = Math.abs(x - paddleX-paddlew/2);
    var distY = Math.abs(y - (canvas.height-paddleh-10)-paddleh/2);

    if (distX > (paddlew/2 + 15)) { return false; }
    if (distY > (paddleh/2 + 15)) { return false; }

    if (distX <= (paddleX/2)) { return true; }
    if (distY <= (paddleh/2)) { return true; }

    var dx=distX-paddlew/2;
    var dy=distY-paddleh/2;
    return (dx*dx+dy*dy<=(15*15));
}
function render(){
  ctx.clearRect(0,0,canvas.width,canvas.height);
  drawBall();
  y=y+yDir;
  x=x+xDir;
  reverseDir();
  movebricks();
  bounceOffthePaddle();
  makebricks();
  for(var i=0;i<3;i++){
  for(var j=0;j<4;j++){
    console.log("hey");
    //var distX = Math.abs(x - bricks[i][j].x-brickWidth/2);
    //var distY = Math.abs(y - bricks[i][j].y-brickHeight/2);

    if(bricks[j][i].status==1&&x >= bricks[j][i].x && x <= bricks[j][i].x+brickWidth && y >= bricks[j][i].y && y <=bricks[j][i].y+brickHeight) {
                    //dy = -dy;
  //if( Math.abs(x-bricks[i][j].x-brickWidth/2) > (brickWidth/2 + 15) ||Math.abs(y - bricks[i][j].y-brickHeight/2 )> (brickWidth/2 + 15)) {
                //xDir =-xDir;
                yDir=-yDir;
              xDir=-xDir;
                bricks[j][i].status=0;
                //ctx.clearRect(bricks[j][i].x,bricks[j][i].y,brickWidth,brickHeight);
                //console.log(bricks[j][i].status);

            }
            }
}
  //collisionDetection();
if(y>=canvas.height||y+15>=canvas.height)
{ alert("oops, click to restart!");
 newLife();

//  yDir=0;
  //xDir=0;
  clearInterval();
}
// myBrick.draw();
}
/*function drawBrick(x,y)
{
ctx.beginPath();
ctx.rect(x,y,brickWidth,brickHeight);
ctx.fillStyle="#FFFACD";
ctx.fill();
ctx.closePath();
}*/




//https://developer.mozilla.org/en-US/docs/Games/Tutorials/2D_Breakout_game_pure_JavaScript/Paddle_and_keyboard_controls
