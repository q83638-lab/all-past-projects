var sillySnake;
var blockSize=20;
var food;
var count;

function setup() {
createCanvas(400,400);
frameRate(10);
food=new Food();
sillySnake=new Snake();
food.pickLocation();
}

function draw() {
background("#FFA07A");
sillySnake.update();
sillySnake.show();
sillySnake.eatFood(food);
food.show();
//
}
function keyPressed(){
if(keyCode==DOWN_ARROW)
sillySnake.movement(0,1);
else if(keyCode==LEFT_ARROW)
sillySnake.movement(-1,0);
else if(keyCode==RIGHT_ARROW)
sillySnake.movement(1,0);
else if(keyCode==UP_ARROW)
sillySnake.movement(0,-1);
}
