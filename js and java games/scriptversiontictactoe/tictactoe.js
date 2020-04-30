/*decide wheither you are  or o
 decide which of the two players are going first
 draw board
 pick where to place x or o
 draw that player to the screen at the particular position in the tic tac toe
 draw board again
 mark the locations as full(that particular position on the board)
 set the criteria for which a player wins, losses, or draws
 - check wheter the player wins or has lost or tied.
 prompt("place your X!")
 |_0_|_1_|_2_|
 |_3_|_4_|_5_|
 |_6_|_7_|_8_|
 */
//var used= [];

var board=[
  "0", //0
  "1", //1
  "2", //2
  "3", //3
  "4", //4
  "5", //5
  "6", //6
  "7", //7
  "8"//8
];
var winner="none";
function drawBoard(board)
{
  var print="";
  for (var i=0; i<9; i++)
  {
    if ((i+1)%3==0)
      print=print+"|_"+board[i]+"_|\n";
    else
      print=print+"|_"+board[i]+"_|";
  }
  console.log(print);
}

function placeChar()
{
  var x, y;
  while(availableSpace()==true&&winner=="none") {

      x=parseInt(prompt("x player, provide a num between 0-8"));
      if (board[x]!="o"&&(x>=0&&x<9))
        board[x]="x";
      else {
        while (board[x]=="o"||(x<0||x>=9)) {
          x=parseInt(prompt("number is used, x player, provide a num between 0-8"));
          if (board[x]!="o")
            board[x]="x";
        }

      }
      drawBoard(board);

      y=parseInt(prompt("o player, provide a num between 0-8"));
      if (board[y]!="x"&&(y>=0&&y<9))
        board[y]="o";
      else {
        while (board[y]=="x"||(y<0||y>=9)) {
          y=parseInt(prompt("number is used, o player, provide a num between 0-8"));
          if (board[y]!="x")
            board[y]="o";
        }
        //function prompt(){}
      }
      drawBoard(board);
      winning();
    }


}
//drawBoard(board);
placeChar();
if (winner=="none"&&availableSpace()==false)
console.log("tied!");
else
console.log(winner+" won!");

function availableSpace() {
  for (var i=0; i<9; i++)
    {if (board[i]==i)
      return true;
}
return false;
}
function winning()
{

    if(board[0]==board[1]&&board[1]==board[2])
    winner=board[0];
    if (board[3]==board[4]&&board[4]==board[5])
    winner=board[3];
    if (board[6]==board[7]&&board[7]==board[8])
    winner=board[6];
    if (board[0]==board[3]&&board[3]==board[6])
    winner=board[0];
    if (board[1]==board[4]&&board[4]==board[7])
    winner=board[1];
    if (board[2]==board[5]&&board[5]==board[8])
    winner=board[2];
    if (board[6]==board[4]&&board[4]==board[2])
    winner=board[6];
    if (board[0]==board[4]&&board[4]==board[8])
    winner=board[0];


}
