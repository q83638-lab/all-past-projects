function Snake(){
//function is lower case n class is upper case
this.x=0;
this.y=0;
this.xSpeed=3;
this.ySpeed=0;
this.total=0;
this.tail=[];
this.movement=function(xDir,yDir){
this.xSpeed=xDir;
this.ySpeed=yDir;
};
this.update=function(){

/*  for(var c=0;c<this.tail.length-1;c++){

}*/
for(var c=0; c<this.tail.length-1;c++){
  this.tail[c]=this.tail[c+1];
}
  if(this.total>=1)
  {this.tail[this.total-1]=createVector(this.x,this.y);}//***
  this.x=this.x+this.xSpeed * blockSize;
  this.y+=this.ySpeed * blockSize;
  this.x=constrain(this.x,0,width-blockSize);//***
  this.y=constrain(this.y,0,height-blockSize);

//for(var c=0;c<this.total)
};
this.eatFood=function(food){
  if(dist(this.x,this.y,food.x,food.y)<2)//**
  food.pickLocation();
  this.total=this.total+1;

};
this.show=function(){
  //console.log(this.tail);
fill(255,156,30);
//if(this.total>0){
rect(this.x,this.y,blockSize,blockSize);
for(var c=0;c<this.tail.length;c++){
  console.log("ugh");
  rect(this.tail[c].x,this.tail[c].y,blockSize,blockSize);
}

};


}
