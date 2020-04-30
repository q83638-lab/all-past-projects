
//this is a call to the console.log function
//javascript dont have to declare data types
  //console.log; //reference to the function
  console.log("String of Characters");//prints to the String
  //this is what we call defining or creating a function
  function add2NumnPrint(){
        //iCreatedaFunction - Camel Casing(first letter lowercase)
    var num1=parseInt(prompt("Give me your first num"));//prompt returns String, thats why we need to cast it
    var num2=parseInt(prompt("Give me your second num"));
    var sum= Number(num1) +Number(num2);//locally scoped
    return demoLogics(num1,num2);
    //console.log(sum);//inside brakets are input
    //alert(typeof(sum));
  }
  function demoLogics(val1, val2){
    //console.log(typeof(val1)); type is a num when it is called
    //console.log(val1+val2);
    return val1+val2;
  }
  //var temp= add2NumnPrint();
//  demoLogics(3,4);
  //demoLogics(3,3.8);
  //console.log(temp);//globalvariable
  console.log(add2NumnPrint());
  function workMyIf(number1, number2){
    if(number1==number2){
      console.log("yo these nums are the same.");
    }

    else if (number1<number2){
      console.log("yo, one is less than another");
    }

    else {
      console.log("yup second greater than 1");
    }
  }
  function workMyWhileLoop(upperLimit){
    var me=0;
    while(me<upperLimit){
      console.log(me);
      ++me;
      }
  }
workMyIf(3,4);
workMyIf("laver","laves");//upper precedes lower case
workMyWhileLoop(5);
function workMyForLoop(lowerLimit){
  for(var i=10;i>lowerLimit;i--)
  console.log(i);
}
//RAM- random access memory， cache- faster ram 缓存

workMyForLoop(-1);
//  alert("Dave hates alerts");
//javascript,expecting javascript not html
