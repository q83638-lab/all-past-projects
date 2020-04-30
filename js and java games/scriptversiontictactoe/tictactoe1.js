var canvas,context;
function setup()
{  canvas=document.getElementById('myCanvas');
  context=canvas.getContext('2d');
  canvas.addEventListener('click',handleClick);//can set specifically the canvas or the whole document
}

function drawRectangle(){
  context.fillStyle="#FF0000" ;
  context.fillRect(10,20,300,200);

}
window.onload=function(){
  setup();
  drawRectangle();
  drawLine();
  drawCircle();

}
function handleClick(event){
  console.log(event.x);//get x coordinate
  console.log(event.y);

}
function drawCircle(){
  context.beginPath();
  context.arc(200,200,30,0,2*Math.PI);
}
function drawLine(){
  context.beginPath();
  context.moveTo(50,5);
  context.lineTo(600,250);
  context.stroke();

}
function handleClick(e){
  var rectLeft=canvas.getBoundingClientRect().left+10,
  rectRight=rectLeft+300,
  rectTop=canvas.getBoundingClientRect().top+20,
  rectBottom=rectTop+200;
  if(e.x>rectLeft&&e.x<rectRight&&e.y>rectTop&&e.y<rectBottom){
    alert("ahahahha");

  }else{
    console.log("No rect for you.");
  }
//  console.log(canvas.getBoundingClientRect().left);
//  console.log(canvas.getBoundingClientRect().right);

}
