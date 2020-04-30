function Food(){
  this.x;
  this.y;
  this.show=function(){
    rect(this.x,this.y,blockSize,blockSize);
  };
  this.pickLocation=function()
    {
      var col=floor(width/blockSize);
      var row=floor(height/blockSize);
      this.x=floor(random(col))*blockSize;
      this.y=floor(random(row))*blockSize;
    };


}
