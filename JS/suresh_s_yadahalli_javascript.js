//parent function  
function Employee(){
      //var this={};
	  this.Ename;
	  this.Eid;
	  this.adharNo;
  
}

//using prototype adding one more function in main function Employee
//always function have prototype and object have __proto__
//so using proto we are adding function or method to parent
Employee.prototype.myFunc=function()
{
console.log("Employee Name:"+this.Ename);
console.log("Employee ID:"+this.Eid);
console.log("Employee Adhar Number:"+this.EadharNo);
}

//creating first object
var manager = new Employee();
manager.Ename="raman";
manager.Eid="acco@e1";
manager.EadharNo="432576872341";


//adding property specific to object one only,using dunter proto because every objects have __proto__
//manager.myFunc();
manager.__proto__.experience="30";
console.log("manager details:"+manager.Ename+" "+manager.experience+" "+manager.Eid+manager.myFunc());//


//creating second object
var developer = new Employee();
developer.Ename= "shivam";
developer.Eid="acco@e2";
developer.EadharNo="432165439876"

//adding property specific to object one only,using dunter proto because every objects have __proto__
developer.__proto__.previous_company="Amazon";
console.log("developer details:"+developer.Ename+" "+developer.previous_company+" "+developer.Eid+developer.myFunc());

//only once we are calling
var manager_myFunc=manager.myFunc;
manager_myFunc.call(manager);

//here we are binding object so we can multiple times
var developer_myFunc=developer.myFunc;
var developer_myFunc2=developer_myFunc.bind(developer);
developer_myFunc2();

//similarly apply can be used but apply can take array of parameters
S