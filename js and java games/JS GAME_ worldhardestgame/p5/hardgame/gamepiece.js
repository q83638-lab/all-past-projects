function GamePiece(){
  this.x=20;
  this.y=0;
  this.dirx=0;
  this.diry=0;

  /*this.movement=function(xDir,yDir){
  this.dirx=xDir;
  this.diry=yDir;
};*/
  this.move=function(){
    this.x=constrain(this.x,20,width-blockSize-20);//***
    this.y=constrain(this.y,0,height-blockSize);
    if(leftPressed){
      console.log("left");
      this.x-=3;
    }
    if(rightPressed){
      this.x+=3;
    }
    if(upPressed)
     this.y-=3;
    if (downPressed)
    this.y+=3;
  //this.x+=this.dirx;
  //this.y+=this.diry;
  };
  this.show=function(){
  fill("#DAF7A6");
  rect(this.x,this.y,blockSize,blockSize);
};
}
