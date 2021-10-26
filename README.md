# ExpressTolling Application

### ```Java``` 

This is a sample Java Application (version 1.8)

Calculate the distance and cost between the two end points from the Json file where cost=0.25/km

## How to Run

* Clone this repository in to your eclipse
* Make sure you are using JDK 1.8
* Check the dependency jars:

     In eclipse go to project-> Right click-> Build Path-> Configure Build Path-> Libraries-> Add External JARs..:

        Add the Junit 4 dependency jars from the Junit 4 folder in the Git.
        Add the jose4j dependency jar from the Referenced Libraries folder in the Git.
  
  or
  
* Check the paths of the jar folders in the .classpath file:
        
	```
	<classpathentry kind="lib" path="./JUnit 4/junit.jar"/>
	<classpathentry kind="lib" path="./JUnit 4/org.hamcrest.core_1.3.0.v201303031735.jar"/>
	<classpathentry kind="lib" path="./Referenced Libraries/jose4j-0.6.3.jar"/>
	```

* Run the Calculator.java file in the src/demo
    
  ## Provide the Inputs    
     Example:
    ```
    Enter starting point: 
    QEW
    Enter exit point:
    Highway 400
    distance: 67.748
    cost: 16.937
    ```
* Run the sample test cases from the CalculatorTest.java file in the src/demo
       

	
