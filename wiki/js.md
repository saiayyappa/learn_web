https://app.pluralsight.com/library/courses/javascript-from-fundamentals-to-functional-js/table-of-contents

    var Animal = /** @class */ (function () {
      function Animal(name) {
        this.name = name;
      }
      Animal.prototype.speak = function () {
        console.log("Hi I'm a " + this.name);
      };
      Animal.eat = function () {
        console.log("I eat grass");
      }
      return Animal;
    }());
    var sheep = new Animal('Sheep');
    let speak = sheep.speak;
    speak(); // global object

    let eat = Animal.eat;
    eat(); // global object

/* ======================================================================== */

    function Animal (name) {
      this.name = name;  
    }

    Animal.prototype.speak = function () {
      console.log(`${this.name} makes a meheme.`);
    }

    var sheep = new Animal('sheep');
    sheep.speak();

/* ======================================================================== */

    class Animal { 
      speak() {
        return console.log(this);
      }
      static eat() {
        return console.log(this);
      }
    }

    let obj = new Animal();
    obj.speak(); // Animal {}
    let speak = obj.speak;
    speak(); // undefined

    Animal.eat() // class Animal
    let eat = Animal.eat;
    eat(); // undefined

/* ======================================================================== */

    function Animal() { }

    Animal.prototype.speak = function () {
      return console.dir();
    }

    Animal.eat = function () {
      return console.dir('eat');
    }

    let obj = new Animal();
    let speak = obj.speak;
    speak(); // global object

    let eat = Animal.eat;
    eat(); // global object

/* ======================================================================== */

    var box = {};

    box['innerbox'] = {};
    box['innerbox'].full = true;

    console.log(box);

    box.innerbox2 = {};
    innerbox2 = "innerbox2"
    box[innerbox2].full = false
    console.log(box)

/* ======================================================================== */

    this.local1='hello';
    var func1 =  () => { // using this notation for fn uses the global this
      this.local1 = true;
    }
    func1()
    console.log(this.local1) // true

    this.local2='hello';
    var func2 =  function () { // using this notation for fn uses the local this
      this.local2 = true;
    }
    func2()
    console.log(this.local2) // hello

/* ======================================================================== */

    function blender(fruit) {
      // var and fn inside parent scope
      var b = fruit;
      var y = 'yogurt';

      function blend() {
        // child fn can access parent scope
        x = 'isGlobalScope'
        var child = 'isChildScope';
        console.log('mixing ' + y)
        console.log(b + ' swirl');
      }
      // but parent cannot access chile scope
      // console.log(child); throws error
      blend();
    }

    blender('apple');

So inner scope can have access to outer scope same as
any function can have access to global scope

/* ======================================================================== */

    var g = 'global'

    function go() {
      var l = 'local'
      var g = ' in here' 
      console.log(l + g); // local in here
    }

    go(); // g defined inside fn go takes precedence 
    console.log(g)

/* ======================================================================== */

    var inBlock = false;
    console.log(inBlock + ' global')

    for (var i = 0; i < 5; i++) {
      var inBlock = true;
      console.log(inBlock + ' inside for');
    }

    if (inBlock) {
      console.log(inBlock + ' inside if');
    }

/* ======================================================================== */

    var fn = (function func1() {
      var a =20;
      var func2 = () => {
        console.log('hey from func2 ' + a + ' is from func1');
      }
      return func2
    })();

    fn();

/* ======================================================================== */

    var closureAlert = function(){
      var x ='var stuck in closure';
      var alerter = function(){
        console.log(x);
      }
      setTimeout(alerter, 0);
      console.log('will still run right after');
    }

    closureAlert();

/* ======================================================================== */

    var x = 0;
    var closureAlert = function(){
      var x = 0;
      var alerter = function(){
        console.log(++x);
      }
      return alerter;
    }

the fn1 is a closure because even though the parent fn scope(environment)
is being on the verge of closure fn1 can still access the parent fn's scope.
x is initialized in different scope, but the closureAlert() itself has
returned, we think that scope is destroyed, but its not so. The scope that
contains x is still there and is still used by the alerter() whose
reference has been returned to the variable fn1. Thus fn1() can access
just as alerter() can access x.

fn1 = closureAlert(); // closure is a fn that can be called later
fn2 = closureAlert();
fn1(); // similar to closureAler()();
fn2();
fn2();


this shows that each invocation of closureAlert() creates a separate
scope and that scope is different for fn1 and fn1
thus closure is analogous to creating objects for classes
each object has its own set of the class instanace variable
similarly each var (that holds onto closure function returned by//
closureAlert()) can have its own scope thus two different copies of x
Thus in a way closure funtion's can remember the parent function scope
even though it has returned from the scope. But at the same time, they
also rememeber that two different closures have two different scopes.
IN ES6, CLOSURES ARE USED TO BUILD CLASSES ALONG WITH USING IIFE PATTERNS.

 fn1's copy of closureAlert          remains same
          =============                 =============
          |    x=0    |                 |    x=0    |
          |           |         =>      |           |
          |           |                 |           |
          |           |                 |           |
          =============                 =============

    fn2's copy of closureAlert          increments
          =============                 =============
          |    x=0    |                 |    x=1    | because fn2
          |           |         =>      |           | has been called
          |           |                 |           | called
          |           |                 |           |
          =============                 =============



/* ======================================================================== */

## Closures are fns are returns another fns 
### Example 1

    var add = function (num) {
      var num1 = num;
      var args = Array.prototype.slice.call(arguments, 1);
      var addToNum1 = function () {
        var sum = 0;
        args.forEach(element => {
          sum += element;
        });
        console.log(sum + num1);
      };

      return addToNum1;
    }

    var partialResult = add(10);
    var finalResult = partialResult(20);

    var addMany = add(10, 5, 10, 4, 5, 6, 7);
    addMany();

### Example 2

    var makeStopWatch = function () {
      console.log('initialized');
      var elapsed = 0;

      var stopwatch = function () {
        clearInterval(watchID);
        console.log('stopwatch');
        return elapsed;
      }

      var increase = function () {
        console.log(elapsed++);
      }

      watchID = setInterval(increase, 1000);

      return stopwatch;
    }

    var watch1 = makeStopWatch();
    setTimeout(() => {
      watch1();
    }, Math.random() * 10000);

/* ======================================================================== */

## Instead of returning a function we can return an Object

    function counter() {
      var n = 0;
      return {
        count: function () { return ++n },
        reset: function () { n = 0; }
      }
    }

    // initialize counter
    var c1 = counter();
    c1.count();
    c1.count();
    var countValue = c1.count();
    console.log(countValue);
    c1.reset();

/* ======================================================================== */


## Steps to create closure:
- create parent function
- define some variables in the parent's local scope
- define a function(child) inside parent function
- return child function reference from the parent function

## Steps to execute closure:
- run parent function and save to a variable this variable will
  hold whatever the parent function returns
- run the child function using the previous variable



function parent() {
  var dummy = "This is from parent fn's scope";
  function child() {
    return dummy;
  }
  return child;
}

var test = parent();
test();

/* ======================================================================== */

## Module Pattern -- Class/Interface like pattern

    var Car = function () {
      var gasolineLevel = 10;

      function useGas(amt) {
        if ((gasolineLevel - amt) < 0) {
          console.log(gasolineLevel)
          console.log('out of gas :(');
        } else {
          gasolineLevel -= amt;
          console.log('gasoline left', gasolineLevel);
        }
      }

      return {
        radioStation: '93.5',
        changeStation: function (station) {
          this.station = station;
        },
        go: function (speed) { useGas(speed); }
      };
    };

    var audi = Car();
    audi.changeStation('99.8');
    audi.go(1);
    audi.go(2);
    audi.changeStation = function(){
      console.log('I changed the implementation YEY!');
    }
    console.log(audi.changeStation)
    audi.changeStation();

/* ======================================================================== */

## Callbacks -- fns that accept functions as parameter

    var ifElse = function (condition, isTrue, isFalse) {
      if (condition) {
        isTrue();
      } else {
        isFalse();
      }
    };

    ifElse(
      true, 
      function () { console.log(true) }, 
      function () { console.log(false) }
      );

/* ======================================================================== */

## Passing arguments to callbacks

    var increment = function (n) {
      return n + 1;
    };
    var square = function (n) {
      return n * n;
    };
    var doMath = function (n, func) {
      return func(n);
    };
    var print = function (value) {
      console.log(value);
    }
    var m1 = doMath(5, square);
    var m2 = doMath(1, increment);

    print(m1);
    print(m2);

/* ======================================================================== */

    var obj = {
      'one' : 'hey',
      'two' : 'you cool'
    }
    var obj1  = Object.keys(obj);
    obj1.forEach(element => {
      console.log(obj[element]);
    });

/* ======================================================================== */

    var _ = require('underscore/underscore');

    var val1 = _.each([1, 2, 3], (value) => { value++; return value; });
    console.log(val1)

    var val2 = _.each([1, 2, 3], (value) => { value++; console.log(value); });
    console.log(val2)

    var val3 = _.map([1, 2, 3], (value) => { value++; return value; });
    console.log(val3)

/* ======================================================================== */



