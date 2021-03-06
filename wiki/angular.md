## @Component main properties
- selector - use to define html tag for your component
- templateUrl - to link external html file for component
- styleUrls - to link external css file for component
- providers - to register service

## Creating a new component
- create a file test.component.ts
```javascript
import { Component } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  
})
export class TestComponent {
  constructor() {
  }
}
```

- register the component in the app.module.ts
- bootstrap the component in the app.modules.ts

## Install Bootstrap CSS Lib using NPM (We can also include include CDN link and skip this)
- npm install bootstrap --save
- include/change in angular.json ==> 
```javascript
"styles": [
              "src/styles.css",
              "node_modules/bootstrap/dist/css/bootstrap.min.css" // add this line
            ]
"scripts": [
              "node_modules/popper.js/dist/umd/popper.min.js",
              "node_modules/jquery/dist/jquery.min.js",
              "node_modules/bootstrap/dist/js/bootstrap.min.js"
            ]
```

## Data-Binding
- One way data binding - where data will flow from component class to template
- One way data binding - where data will flow from template class to component
- Two way data binding - where data will flow is bi-directional

## One Way Data Binding (from component to template)
- Interpolation
- Property Binding

## Interpolation
- we can use interpolation for executing any expression
- {{ }}
- we can also use all JS functions and properties

## Property Binding
- slight difference from interpolation
- syntax 
- [] enclose the property name with a pair of square bracket which you wish to bind

## Difference
- Interpolation is a special syntax that angular convert into property binding
- to concatenate any string we must interpolation instead of property binding
- to set an element property to a non string data value you must use property binding

## Event Binding
- template(HTML) to component
- $event to send entire information of event as object to the called function

## Class Binding
- variant of property binding
- dynamically/conditionally apply any css class on the html element use [] for class binding
- [ngClass] special directive to apply multiple classes conditionally

## Style Binding
- variant of property binding
- same as class binding except styles are applied instead of class
- [ngStyle] special directive to apply multiple styles conditionally

## Drive Link for Angular Exercises by Varun

##### https://1drv.ms/u/s!ApB28GeA42u8hmOpOy0L0VxJWAGu?e=SyzD0c


ngForm & ngSubmit

## Template Reference Variables
- used to refer any particular HTML element
- In form its very useful to get the value of the form element
- "#" is used to create these variables

```javascript
<input type="text" #myInput />
myInput.value
```

## Two way binding
- when data flow in both directions from component to view and from view to component
- when declared a variable and the value keep on updating whenever we change the value
  in component or in template

### syntax
1. [] - property binding -  component to template
2. () - event binding - template to component
3. [()] - two way binding - bi-directional -- BANANA in a BOX

## Structural Directives
- When we want to add or remove HTML elements

1. *ngIf
2. *ngSwitch
3. *ngFor

## ngIf
- take decision and basis of that html element can be added or removed

## ngFor
- to display a dynamic list (an array of elements on the screen)
- performs poorly with large data set
- small change to the list trigger a cascade of DOM Manipulation
- index, first, last, odd, even are special variables in ngFor
- trackBy - to recognize the changes made in the array list and can reuse the existing DOM
  element and re-create only the additional element

## Steps to use trackBy
- create one on our component
- function gets the index of the element and element itself then we have to return the 
  unique value of the element like code

## Pipes
- transform data before display
- built-in pipes eg. lowercase, uppercase, decimal etc.
- custom pipe (user-defined)
- Syntax: 
```javascript{{ anyData | <name of pipe>:<parameter or option> }}```
- multiple pipes can be used also known as chaining of pipe

## @Input()
- used to data from parent to child
- data from parent can be accessed in its template(html). So we can use property-binding (in which data is sent from template(html) to component(ts)) to send data from parent template(html) to    child component(ts)
- @Input() decorator allows the "parent data" to be initialized to the variable(property) present in the child component.
- hence create a var in child component with @Input() decorator and use this syntax ```[createdVarInChild] = "dataFromParent"``` ==> in parent template

## @Output()
- used to data from child to parent
- data from child can be accessed only in its template(html). So we can use event-binding to push data from child component to parent template. Once the "child data" is presented to parent html   then it can be initialized to variable in the parent component.
- @Output() decorator allows to create a custom event(by creating a instance of EventEmitter from angular/core package) in the child component which is going to emit the data from the child to    parent template.
- after creating custom event, access the event from parent template and on triggering the event we can access the even object ($event) and assign it to variable in parent component.

## Services
- Duplication of same data into multiple component we are violating software principal
- DRY (Do not Repeat yourself)
- Single Responisibility for a component
- Hence Angular services are singleton object by default which get instantiated only once during the lifetime of an application
- Contain methods that maintain data throughout the life-cycle of an application i.e. data does not get refreshed and is visible/available all the time
- to organize and share business logic, methods and function with different components of an angular application.

## Uses
- Share data across application (among all the components)
- Implement application or business logic
- External interaction or consume any third party REST API services

## Steps to create service
- define a service
- register a service
- consume a service

## To register a service
- @Injectable() -> provideIn
- app module -> provider[]
- component -> provider[]

## DI (constructor dependency)
- to handle dependency efficiently eg. services in angular
- in order to avoid clashes when a dependency changes (which affects the component which is consuming that changed dependency which in turn breaks the component)
- this happens when the component which is dependent and dependencies are tightly coupled
- for loose coupling we can create a separate layer which maintains dependencies(create the objects of dependencies and inject it to classes which want to consume the dependencies).

## DI as Framework
- define a service
- register with injectable
- declare as dependency for component

## Observables
- used to make HTTP get request from Service
- receive the observable and cast it into the object it can be consumed by components
- subscribe to the observable from component
- assign the employee array to a local variable
- Observables come from RxJS(Reactive eXtension JavaSrcipt)

## Angular Forms
- Template Driver Forms - heavy work is done in the template
- Reactive Forms / Model Driven Forms - heavy work is done in the component

## TDF
- Easy to use and similar to Angular JS
- two way binding can be achieved by ngModel
- bulky HTML(template)
- Unit testing is bit challenging
- readability decreases with complex form and validation
- suitable for simple forms

## Step for TDF
- add the html in the component
- binding data
- track state and validations
- display error message
- submit the forms

## form state
- untouched - after the form load on the browser
- touched - after form loads we touched the form element
- pristine - we never modify the value
- dirty - we modified the value
- valid - all the values are valid in form
- invalid - any invalid values in form
					 
|                                  | True       | False        |
|----------------------------------|------------|--------------|
| The control has been visited.    | ng-touched | ng-untouched |
| The control's value has changed. | ng-dirty   | ng-pristine  |
| The control's value is valid.    | ng-valid   | ng-invalid   |

## Reactive forms or Model Driven Forms

- Code and logic resides in the component class
- No two way binding
- Well suited for complex scenarios
- Dynamic form fields
- Dynamic form validation
- easy for unit testing

## Routing

- Routing is an essential part for any application
- it allows us to navigate from one page to another by changing the URL

## Two way in routing
- add routing module at the time of creation of project in angular/cli
- manually creat a routing module

## Topics: RoutingModule, Routes and Navigation, router-outlet, routerLink, routerLinkActive

## Manually adding the routing
- app-routing.module.ts
```javascript
import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    { path: 'employee', component: 'EmployeeComponent'}
];

@NgModule({
    imports:[RouterModule.forRoutes(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{

}```
