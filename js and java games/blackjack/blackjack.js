var userInput;
var testDiv= document.getElementById('testDiv')
var anotherDiv=document.getElementById('anotherDiv')
//testDiv.innerHTML=("Did this work?");
//anotherDiv.innerHTML="<h1>it did work</h1>";//use html in javascript
var pcard1, pcard2, dcard1,dcard2;
pcard1=(parseInt(Math.random()*10))+1;
console.log(pcard1);
function buttonClick(){
  userInput = prompt("give me some text");
testDiv.innerHTML= userInput;
anotherDiv.innerHTML="<h1>it did work</h1>";


}
