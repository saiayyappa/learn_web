JAVA 
High Level Object Oriented Programming Lang

Low Level/Machine Level
Medium/ Assembly Level
High Level Programming Lang (JAVA)

Assembler/Compiler/Interpreter  - Translators

Mnemonics ADD. SUB, MUL, PC, MOV,

Syntax - Set of Rules 

1) Header File Inclusion
2) main method
2.1 - Variable and function Declaration
3) Compile, Link & Execute


# include <stdio.h>
void main() {
 printf("Welcome to C.");
}


1) Package Declaration
2) Importing necessary packages
3) Declaring a Class
4) defining the class (writing code inside class properties & methods)

JAVA is Case Sensitive

JAVA is Compiled as well as Interpreted Lang

package com.rdec;
import java.lang; //optional
//single line comment
/* Multi Line
   Comment */

class Test { //Opening Curly brace
 private int i;
 public static void main(String args[]) {
  System.out.println("Welcome to JAVA");
 }
} //closing curly brace


Types of Classes 
1) Simple/ POJO - Class neither extending any class nor implementing any interface
2) Bean - Representing a DB Table (with properties and getter & setter methods)
3) static 
4) Abstract (Incomplete/non concrete/partial class)
5) Starter (class with main method)
6) Inner (class defined inside another class)
7) Concrete (complete class)
8) Non-Concrete
9) Built-in (Predefined) [developer provided classes]
10) User defined class [developed by users]


Basic components of JAVA

1) Keywords (reserved words - all small)
2) Operators
3) Literals or variables
4) Statements
5) collections framework
6) special symbols

data types 
 1) built-in/predefined/primitives (boolean,byte,char,int, float,double,long)
2) user defined data type (class, arrays,enum)


int a =5; // declaring & initializing a integer variable.

Test t = new Test(); // creating an object of a clss

1) variable name should start with letter or underscore only
2) special symbols except underscore are not allowed
3) keywords can't be used
4) camelCasing
5) variable name should start with lowercase letters
5)

int Int=10;
int a; //--- variable declaration; (un initialized variable)
a=8; //variable initialization;
int b =4 ; // variable declaration & initialization

int numberOfYears = 5;//camel casing
String firstName;
String lastName;
Date dateOfBirth;
Date joiningDate;


Coding Standards && Best practices



Eclipse Workspace - Folder in your system where you are going to store all your java projects.



package name should be reverse of your domain name

rdec.com  ---com.rdec

google.com  --- com.google


only one public class is allowed in a single java file.

you can have n no of classes in a single java file.

the name of Java file should be the name of public class


ctrl + f11 = To compile & execute your java program


Control Statements 

   1) Decision Making Statements (if, if else, nested if, else if ladder, switch)
   2) Repetetive or Looping Statements ( Entry Control - for, while, exit control -do while)





 Trouble shooting - resolving problems of Installation or execution of programs
 Debugging  -  removing/resolving errors from your code

JDK and Eclipse Installation Problems

If you have 32 bit Operating System
32 bit JDK
32 bit Eclipse(IDE)
path settings are proper

if you have 64 bit OS
64 bit jdk
64 bit Eclipse 
path settings are proper

path setting JAVA_HOME is optional
path is compulsory 

C:\Program Files\Java\jdk1.8.0_25\bin

Oracle 



D:\RDEC_Java_WS\DAY4\src\com\rdec


Ctrl+Shift+F -- Formatting the Code


Scanner  (java.util) -- builtin/predefined  (developer provided)


If you want to use a non-static class,

first create object of that class
and call methods by using that object


Scanner class is used to get input from the user.

javatpoint.com   -- website to learn java 



Class - blue print of object

Object - instance of a class

class - (State & Behaviour)

State represents the properties
behaviour represents the methods

state is used to hold the property
behaviour is used to change the property


get methods are used to get object's property

set methods are used to set the property of object.


for automatic getter/setter generation
Right click - (select ) source - generate getter and setters

1) Stand-alone Application (Core -JAVA)
2) Web-based Application (Adv JAVA - Servlet & JSP)
3) Enterprise Application

MS-Office


We have special method in each class

Constructor - spl method used to initialize instance varaible.
constructor name should be same as class name


1) No Argument / Default constructor
2) Parameterized Constructor

Abstraction -  Showing relevant details and hiding irrelevant details


with the help of abstract keyword we are achieving abstraction in java

abstract keyword is applicable for
1) methods
2) class


for each user defined class JVM will automatically add Default/No Argument Constructor


constructor will initialize all the member variables (properties/state) of the class
 for all primitives default value is zero
for boolean default value is false,
for objects default value is null,


abstract methods can be defined in abstract class only.


you can add abstract keyword to class even though there is no abstract methods in it.


you can't directly create object of abstract class (But by providing overridden abstract method you can create)


String is a predefined final class in JAVA

in java char - 2 Bytes (16 bits) UNICODE
in c    char - 1 Byte (8 bits)  ASCII


In java Strings are immutable - Constants

Mutable String -  StringBuilder /StringBuffer

(object Oriented Representation of Primitive data type)

Wrapper Classes (Boolean,Byte, Character, Short, Long, Integer, Float, Double)
Primitive types  -   Object Representation
boolean 	- Boolean
byte		- Byte
char		- Character
short		- Short
int		- Integer
float		- Float
long		- Long
double		- Double


Boxing - Converting from primitive to Object


Unboxing - Object to Primitive Conversion.


Explicit conversion - Manual Boxing

Implicit /JVM Conversion - Auto Boxing/Unboxing


This Auto Boxing/Unboxing is used in Collection framework.


Day 6 (Forenoon)

Inheritance -  one class Getting Public attributes and methods of other class

Base Class/Parent class/ Supper class

Derived /Child/ Sub class



1) Simple Inheritance
2) Multi-level Inheritance

Java doesn't support Multiple Inheritance

class C extends A,B  --- Is not supported in JAVA

class A {
}

class B extends A {
}

class C extends B {
}

Date  (java.util,  java.sql)

Create a Class called Car, with two methods 
accelerate() and break;

add one attribute called speed whose initial value is zero.

the accelerate method should increase the speed and brake method should reduce speed.

ctrl + / (select the code to comment)

this - it is a keyword which represents current object.

super - it is a keyword which represents parent/base class


Day 7 ( Polymorphism -  Method Overloading & Method Overriding)
Poly means Many
Morphing - Showing different face

 1) Method Overloading / static or compile time polymorphism
 2) Method Overriding / dynamic or run-time polymorphism

Overloading - having same name and different purpose/signature


(the signature of the method changes by number of arguments or data type of arguments or position of arguments)


NANR - void draw() (No Argument & No Return)

NAWR - String display() (No Argument with return)

WANR  - void add(int a,int b) (With argument & no return)

WAWR - String reverseString(String str) (With Argument with return)

Signature of method consist of
1) Name of the method
2) Return type of the method
3) Access modifier
4) Arguments list and its data type


OverLoading means Inside a single class same method name with different signature.


Overriding between parent & child class.
Overriding a method means 
redefining a method in the child class without changing the signature


create a class called Design  with draw method.

create another class called Circle and redefine (Override) the draw method.

create antoher class called Rectangle and redefine (Override)the draw method.



Interface
1) by default all the methods in interface are abstract;
2) Public or package is the only supported access modifiers for interface
3) you can't create private & protected interface
4) inheritance is applicable to interface also
5) multiple inheritance is supported for interfaces in JAVA

class C extends A,B -- Invalid in JAVA
interface C extends A,B -- Valid in JAVA

class Child implements Interface1,Interface2 -- valid in JAVA

constructor is a special method which is having same name as the class.
it will not return anything and not even void is added to constructor.
constructor should always be public.
It is used to initialize member variables to default values.
All primitives are initialized to 0, boolean to false, char to '\0',
objects to null.


Automatic Memory handling is done by garbage collector of JVM.


default /No Argument/ system defined/Implicit Constructor.
parameterized/Explicit or user defined constructor.


JVM will automatically add default constructor  only when no parameterized constructor is declared.

Access Modifiers 

1) private (Single File access)
2) default/package -- no keyword (single folder access)
3) protected (Same package, as well as child which is available in different package)
4) public (accessed anywhere)

behaviour modifiers
1) final  - represents constants
2) abstract - represents incomplete/partial
3) transient - represents secured
4) static  - represents class level access
5) volatile - represents memory access

final - variables, methods and class
abstract - methods and class
transient - variables 
static - variable, methods and class (But no user defined static class)
volatile - variables only



final 
 final float PI = 3.14f; (Constant) (can't be modified)
 final methods (can't be overridden)
 final class (can't be extended)  (String)

static (Thread)

1) Local variable (Block level)
variables declared inside method, passed as a parameter or as a 


public void display(int a){ //argument
 sysout("a="+a);
}

display(5); //parameter - values supplied to argument

Interface will not have non abstract methods (Methods with body)

interface can't have private members 
interface can have public, static and final variables
interface can have public, abstract, static and final methods
2) Instance Variable(class member variable)
3) Static/Class variable 

importing packages 

core java project can be exported as JAR files ( Java Archieve) - stand alone

Adv. Java project can be exported as WAR file (Web Archieve) - web based

EAR (Enterprise Archieve) = JAR + WAR - Enterprise project



Day 8

String is a special System defined(Built-in & non-primitive) data type (Class)

String is a final class

String objects created once can't be modified - so it is called immutable.

different ways of creating string object.

1) primitive declaration method

 int a = 10;
 String str1 = "Hello"; //primitive declaration

2) Object creation method

  Employee emp = new Employee();

  String str2 = new String("Welcome");
  // Object creation declaration



demonstrate the use of substring and index  of method.

String will create immutable objects
StringBuffer/StringBuilder will create mutable(editable/modifiable) objects

StringBuffer (ThreadSafe) - slow     StringBuilder(Non-ThreadSafe) - fast

Typecasting - Changing data type 
1) Implicit Type casting (Automatic/System)


2) Explicit Type casting (Manual)


1 1*1 = 1
2 2*2 = 4

.
.
.
100 100*100= 10000


1+2+3+.... +99+100=?
n*(n+1)/2

sum_formula = result
sum_logic = result


1*2*3*.... *99*100=?


1) Pre -Assessment Test (Done)
2) Base-line
3) Mid-line
4) End-line
5) Final Assessment (External body)- After completing the training.

Every friday online test for one hour.
25 MCQ + 5 Descriptive Qns. Total Score 100.



Day 9
Arrays
Arrays are user defined data type.


1) It can hold both primitive as well as objects
2) One dimensional& multi dimensional
3) It can be homogeneous or heterogeneous
4) It allocates continuous memory space for its content.
5) Arrays are fixed in size. (Non-growing)


*
* *
* * *
* * * *
* * * * *

array1
5 5 5
8 8 8
4 4 4


array2
4 4 4
1 1 1
5 5 5

calculate array1+array2 and display the result




Exceptions (Way of handling problems/errors in your code)

At what time it is captured
1) Compile Time Exception
2) RunTime Exception
(ArrayIndexOutofBound,DivisiblebyZero)

Exceptions handling compulsory or not
1)Checked Exceptions 
2)UnChecked Exceptions (ArrayIndexOutofBound,DivisiblebyZero)

There are two ways of handling exception
1) using try/catch & finally block (writing the code to manage exception)
2) using throws keyword (JVM will take care)

try block should be followed by either catch block or finally block.

more than one catch block is allowed.


Arithmetic

finally block is used to release the resources.


Abstract class - Incomplete/Non-concrete/Partial class

Interface - interface (keyword)


access modifiers - private,default/package,protected, public

behaviour or non-access modifier -
final, abstract, static, transient and volatile


multiple inheritance is not supported in java for classes.
class C extends A,B - invalid in java

multiple inheritance is supported in java for interfaces.

interface I3 extends I1,I2 - valid in java


Inheritance - getting access to the protected & public members of parent class


A class can extend only one class but can implement many interfaces

class B extends A implements I1,I2,I3  


relationship in JAVA 
1) Is A (Parent & child class)
2) has A (Interface)


Polymorphism
1)static - compile time - method overload
2)dynamic - runtime - method override


encapsulation - information/data hiding (Maps. Global & India Map) Binding code & data together (properties are bound with methods)
abstraction - hiding implementation  (Car, Dash board of the Car)

String, StringBuffer & StringBuilder


String are immutable in JAVA (Non-modifiable/editable)

subString(), charAt(), length(), toUpperCase(), toLowerCase(),isEmpty(), replace(),startsWith(),endsWith()

Arrays (Fixed in size)
1) 1 or single dimensional
2) 2 or more dimensional 

homo / heterogeneous array 

primitive/Object array 


wrapper classes - primitive to object conversion

int i=10; //primitive integer
Integer  I = new Integer(i); //Integer Object

Boxing & Unboxing  
Auto Boxing & Unboxing (Object Arrays, Collections)


Exception Handling
1)using try/catch block
2)using throws keyword (modifying the signature)


depending upon the handling mechanism
1) compile time/checked exceptions
2) runtime/ unchecked exceptions


depending upon the creation
1) built-in /system defined 
2) user-defined/custom exception


class AccountNumberInvalidException extends Exception {

}




(Threads)

Multi Tasking - Different program running simultaneously (Word,Excel,Ppt, Audio Player,IDE)

Multi Threading - Inside a single process different threads are running or executing simultaneously (Autosave, spell check, grammer check in side word application)

Thread - Light weight sub process

Creating Threads

1) Extending Thread class
2) implementing Runnable interface

Thread is a static class (Built-in System defined)

Life Cycle of Thread
1) New
2) Runnable
3) Running
4) Blocked (Non-Runnable)
5) Terminated



Collections Framework

(Set of API [classes & Interfaces] to handle group of objects)

collection represents group of objects.

it is available in java.util package

dynamically modifiable 

1) List (Allows duplicate, Maintains Insertion Order, Allows null)
 [ArrayList, LinkedList, Vector]
2) Queue (FIFO- First In First Out)
3) Set

collections will always work with objects not with primitives.


1) ArrayList - Allows duplicate & null
Maintains insertion order

Frequent operation is insertion then it is not suitable.
Easily retrive data by using index.

suitable for search
not suitable for insert in middle

2) Linked List  -- Allows duplicate & null.
Maintains insertion order

suitable for insertion operation
not suitable for search operation


3) Vector - synchronized 


SET - No duplicates, Allow null once
Willnot maintain insertion order

1) HashSet
2) TreeSet (Wont allow null)
3) SortedSet


retrieving date from collection
1) using normal for loop
2) using enhanced for loop
3) using iterator
4) using enumerator


Map (Key,value)

TreeMap
HashMap
LinkedHashMap

key should be unique, it can be null only one time. 
you can have duplicate for values


insertion order is not maintained



RDBMS

 - Relational Database Mgmt System

Data base - Collection of Entities


Entity - Table, View, Query, Procedure, Function, Trigger, Materialized View ....


Flat File System - Notepad, Word , all the files you are storing to the operating system are flat files.


Database - Organised form of Data mainly stored in table.

Data - Set of related information 

DBMS - Data Base Mgmt System Software 

Lotus, Foxpro, MS-Access

RDBMS -  Oracle, MySQL, SQL Server etc.,

1) One to One (Primary Key)
2) One to Many (Foreign Key)
3) Many to Many (Foreign Key)


P@ssw0rd123
P@ssw0rd
Manager

accessing mysql using command line
(Open Mysql Command Line)
mysql -u root -p

show databases;

show tables;

select * from <table_name>; --displaying content of the table


accessing oracle through command line
_____________________________________
Oracle XE (Express Edition) - Free & provides Minimal features of Oracle 
Open SQL Command Line

conn sys as dba;
No need to give password just press enter button

select * from tab; -- display all the tables in particular schema.


alter user hr identified by hr;


SQL/PL-SQL

SQL - Structured Query Language.
PL - Programming Language.


Different ways of accessing RDBMS (Oracle/MySQL)

1)Using Command Line Tool /CUI (Character /command line user Interface)
2) Using Browser/ Interface provided by Developer/ GUI (Graphical user Interface)
3) Using Programming Language (JAVA, PHP, Python etc.,)



JDBC - Java DataBase Connectivity

Requirements
1) JDK
2) Oracle/MySQL (Any RDBMS)
3) IDE (optional)


Installing Oracle11g XE (Express Edition)
System
oracle

HTTP Listener Port 8080
Database Listener Port 1521


Users
Workspace
Table
View
Procedure


1) connecting oracle thro command line tool
connect system/oracle;


select SYSDATE from dual; -- display current date


select * from all_tables;--display all the tables in all workspace

select * from tab;  --display all the tables in current workspace


http://localhost:8080/apex   -- url to access oracle through browser


localhost ip address 127.0.0.1 -- same for all pc

port no 8080 http listener port

apex -  application express


http://127.0.0.1:8080/apex/f?p=4950 


//p=4950:1:257383096822675

schema 


New Printer
Steps
1) driver software installation
2) physical connection establishment
3) power on the printer
4) printing test page


RDBMS Interaction

1) Loading & registering Driver 
2) Create and establish connection
3) Create & Execute query
4) Processing result
5) Close resources


Inside Eclipse
1) Adding driver to buildpath



Important classes & Interfaces in sql package

1) Driver 
2) Connection
3) Statement
4) ResultSet
5) PreparedStatement
6) CallableStatement
7) DatabaseMetaData
8) ResultSetMetaData
9) DriverManager(Class)




Flavours of Java
1) JDK (Java Development Kit) - For Developers
2) JRE (Java Runtime Environment) - For Java Application Users


PATH=C:\oraclexe\app\oracle\product\11.2.0\server\bin;
C:\Program Files (x86)\Common Files\Oracle\Java\javapath;
C:\WINDOWS\system32;
C:\WINDOWS;
C:\WINDOWS\System32\Wbem;
C:\WINDOWS\System32\WindowsPowerShell\v1.0\;
C:\Program Files (x86)\HP\Unified Functional Testing\bin;
C:\Program Files\Microsoft\Web Platform Installer\;
C:\Program Files (x86)\Microsoft ASP.NET\ASP.NET Web Pages\v1.0\;
C:\Program Files (x86)\Windows Kits\8.0\Windows Performance Toolkit\;
C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;
C:\Program Files (x86)\MySQL\MySQL Server 6.0\bin;
C:\Program Files\nodejs\;C:\apache-maven-3.5.3\bin;
C:\Users\t-sivakumar1\AppData\Local\Microsoft\WindowsApps;
C:\Users\t-sivakumar1\AppData\Roaming\npm;
C:\Users\t-sivakumar1\AppData\Local\Programs\Git\cmd



path = %path%;C:\Program Files\Java\jdk1.8.0_151\bin

path = %path%;%JAVA_HOME%\bin


Editions of JAVA
1) Java SE (Standard Edition) - Core Java
2) Java EE (Enterprise Edition) - Adv Java
3) Java ME (Micro/Mobile Edition) 
4) Java CARD (Java used in Small Chips) - 



Collections API (Set of Classes & Interfaces)
API - Application Programming Interface

Types of Classes
1) Simple/ POJO (Plain Old Java Object) Class / Concrete(Complete) Class
2) Utility classes (Scanner, Date, StringTokenizer, Time, Collections etc.,)
3) Bean Class (Class with Property and Getter, Setter Methods)
4) Abstract Class - Incomplete/ Non - concrete class
5) Inner Class
6) Annonymous Class
7) Sub/Derived/ Child Class
8) Parent/Base/ Super Class
9) Wrapper Class
10) Static Class
11) Final Class
12) In-Built Class
13) User Defined Class (Custom class)


IDE - Integrated Development Environment

Eclipse/ NetBeans (Intellij IDEA, Atom, VS Code, Notepad++, etc.,)

Eclipse 2018

Collections API


class Car {

---
}

Car c1 = new Car();


int a = 5;



Constructor
  It is a special method with the same name as your class name.
  It is used to initialize the class members
  - 	1)  No Argument/Default Constructor
	2)  Parameterized Constructor

 JVM will automatically add Default constructor when there is no custom parameterized constructor.



Explicit(External) Pointer manipulation is not available in JAVA

Multiple Inheritance 
1) Multiple Inheritance is supported in JAVA for Interfaces only





Adv JAVA
1) Building the code - Compiling all the source code and creating byte code. (WAR (Web Archieve)/EAR (Enterprise Archieve))
2) Deploying the project - Loaind the WAR/EAR file to the server
3) Executing the Project - sending request to the server using their context root.




Servlets
1) Generic Servlet (Protocol Independant Servlet)
2) Http Servlet (Protocol Specific)



Web Server (Tomcat) is also called as Servlet Container/Servlet Host/Processor
Life Cycle Methods

1) init() - Initializer method which gets called only one time, when the servlets is loaded into the server

2) service() - This is the method which gets called everytime when you are requesting it.

3) destroy() - All the cleanup activities and closing resources will be done in this method. This method also will be called only one time before shutting down the server or removing the project/application from the server.






Web.xml - Deployment Descriptor

WebContent/WEB-INF


Session Management
1) using hidden form fields
2) cookies
3) using URL Rewriting
4) HttpSession API



XML - Extensible Markup Language
1) XML is a platform/language independant way of storing/representing the data.
2) Widely used in configuration files
3) XML is a case & space sensitive Language
4) In XML tags are user defined.
5) Parser in an application which is used to extract/parse the data from xml file.
6) valid xml, well defined (XSD, XSI, DTD)
XSD - XML Schema Definition/Description
XSI - XML Schema Information
DTD - Document Type Definition/Description


J2SE - Std Edition
J2EE - Enterprise Edition

J2EE /Server side Scripting/Technology
1) Servlet
2) JSP
3) JSF
4) JMS
5) JNDI
6) JPA
7) JAXP
8) EJB



1) Generic Servlet (Protocol Independant) (FTP/HTTP/SMTP/POP/MIME)
2) HTTP Servlet (Protocol Specific) - for HTTP/HTTPS




Session Management
1) URL Rewritting
2) Cookies
3) Hidden Form fields 
4) HttpSession API 


<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>
<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>





JSP  (Java Server Pages)

1) Scriptlet Tag  <%    %> - n lines of java code with ; at the end of each line

2) declarative tag <%!   %> - n lines of java code with ; at the end of each line

3) expression Tag <%=	%> - Only one line of java code without ;

4) Directive Tag  <%@   %> - Only one line of Java code without ;

5) action Tag <jsp:action_name>  </jsp:action_name>

Servlet - Embedding html code inside Java
JSP - Embedding java code inside html



Implicit Objects in JSP
1) out
2) session
3) request
4) response
5) config
6) pageContext
7) application
8) page


3 Directive Tags

<%@ page  %>
<%@ taglib %>
<%@ include %>





out.println  <%=


1) CRUD using JSP


C - Create/Insert
R - Read/Retrieve
U - Edit/Update
D - Delete/Remove



CREATE TABLE `test`.`employee` 
(
  `emp_id` INT NOT NULL,

  `emp_name` VARCHAR(45) NULL,

  `email` VARCHAR(200) NULL,
 
 `mobile` BIGINT(10) NULL,
 
 PRIMARY KEY (`emp_id`));





INSERT INTO `test`.`employee` (`emp_id`, `emp_name`, `email`, `mobile`) VALUES ('1', 'test', 'test@gmail.com', '1234567890');




JSTL (JSP Std Tag Library)

1) Custom Tags  (User defined Tags)

<ram:readTable tname=""></ram:readTable>

jstl1.2.jar



CREATE TABLE `test`.`department` (
 
 `dept_id` INT NOT NULL AUTO_INCREMENT,
 
 `dept_name` VARCHAR(45) NULL,
  
 `start_date` DATE NULL,

  PRIMARY KEY (`dept_id`));



INSERT INTO `test`.`department` (`dept_name`, `start_date`) VALUES ('HR', '1995-10-13');


1) send data in the same order as of the table structure (full insert)
2) specify the column name whose value you are supplying (partial insert)



DATE_FORMAT(sysdate(), "%Y-%m-%d");


select date_format(sysdate(),'%Y-%m-%d') from dual;



CRUD Operation
1) Using JSP
2) Using JSP & DAO (Bean Class)
3) Using JSTL
4) Using JSTL & DAO

DAO - Data Access Object


AJAX - Asynchronous Javascript and XML




CREATE table "EMPLOYEE" (
    "EMPID"      NUMBER(10,0) NOT NULL,
    "EMPNAME"    VARCHAR2(50),
    "EMPAGE"     NUMBER(3,0),
    "EMPADDRESS" VARCHAR2(200),
    "SALARY"     NUMBER(10,0),
    constraint  "EMPLOYEE_PK" primary key ("EMPID")
)
/

CREATE sequence "EMPLOYEE_SEQ" 
/

CREATE trigger "BI_EMPLOYEE"  
  before insert on "EMPLOYEE"              
  for each row 
begin  
  if :NEW."EMPID" is null then
    select "EMPLOYEE_SEQ".nextval into :NEW."EMPID" from dual;
  end if;
end;
/   

CREATE table "BOOK" (
    "BOOKID"     NUMBER(5,0) NOT NULL,
    "AUTHOR"     VARCHAR2(50),
    "BOOKNAME"   VARCHAR2(200),
    "PRICE"      NUMBER(10,2),
    constraint  "BOOK_PK" primary key ("BOOKID")
)
/

CREATE sequence "BOOK_SEQ" 
/

CREATE trigger "BI_BOOK"  
  before insert on "BOOK"              
  for each row 
begin  
  if :NEW."BOOKID" is null then
    select "BOOK_SEQ".nextval into :NEW."BOOKID" from dual;
  end if;
end;
/   


CREATE table "STUDENT" (
    "STUDENTID"  NUMBER(5,0) NOT NULL,
    "NAME"       VARCHAR2(50),
    "DEPARTMENT" VARCHAR2(50),
    "EMAILID"    VARCHAR2(100),
    constraint  "STUDENT_PK" primary key ("STUDENTID")
)
/

CREATE sequence "STUDENT_SEQ" 
/

CREATE trigger "BI_STUDENT"  
  before insert on "STUDENT"              
  for each row 
begin  
  if :NEW."STUDENTID" is null then
    select "STUDENT_SEQ".nextval into :NEW."STUDENTID" from dual;
  end if;
end;
/   



Hibernate
OpenSource ORM (Object Relational Mapping) Framework 
It helps to interact with the any Database 
In SQL independant way

HQL - Hibernate Query Language

JPA - Java Persistance API 

Persistance (Process of storing the state(data) in DB Entity [table]) - Serialization (Is the process of Storing the state(data) in flat file System)


JPA is a Specification

JPA Implementation
1) EclipseLink
2) Generics
3) Hibernate 


sivakumar.os@cognizant.com
EmpID	:
FullName:
Branch  :
College :
Mobile  :

Maven
1) It is build tool
2) It is SCM (Source Code Mgmt)
3) Dependency Resolver 


\\pc377668

1) Save updated settings.xml file in maven-conf folder
C:\apache-maven-3.5.3\conf
2) Open Eclipse
3) Window -Preference - Maven


POM - Project Object Model


Spring 

It is a JAVA Framework used for creating 
Enterprise Application.


Core JAVA Applications/Project (Stand Alone) - JAR
Web Application/ Adv Java Projects - WAR
Enterprise Applications - 


J2SE - Core Java (Std Edition)
J2EE - Adv Java (Enterprise Edition)


J2EE
1) Servlets/Filters
2) JSP/JSTL
3) JMS
4) JNDI
5) EJB
6) Web Services



Spring Design Patterns
1) IOC (Inversion of Control)
2) DI (Dependency Injection)


public class Car{


}


Car c1 = new Car();



Spring MVC - Model-View- Controller

Model - Entity Beans
View  - HTML/JSP Pages (Front End)
Controller - FrontController (DispatcherServlet)

Front Controller - Dispatcher Servlet

web.xml






