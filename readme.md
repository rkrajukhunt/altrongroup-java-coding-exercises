# Serialization Exercise

This exercise involves fixing issues in a Java serialization project, as well as making improvements and adding additional features. The project is divided into two components: `SerializationExercises` and `Serialization`.

## Components:

### SerializationExercises:
The main driver with little to no functionality. It provides sample data objects for serialization and test cases.

### Serialization:
The core implementation of the serialization library.

## Exercises:

### 1) Fix Serialization:
The solution has issues with serializing sample data objects. The goal is to make necessary changes to successfully serialize the objects and run the solution.

### 2) Partial Serialization:
The aim is to serialize all of `DataObject1` but only a portion of `DataObject2`. Adjustments should be made to `DataObject2` to serialize only `Property1` and `Property2` but not the `SourceIdentifier` property. The test case needs to be modified or an additional test case added to prove this functionality.

### 3) Fix Unmanaged Resource Issues:
The `SerializationManager` is using unmanaged resources. Code changes are required to handle these resources properly.

### 4) Improve Error Handling:
Treat `Serialization.jar` as a reusable utility library. Improve code with exception handling and diagnostic trace for better manageability and debugging. Consider:
   - 4.a) The main application should never crash.
   - 4.b) The library should provide diagnostic trace about any serialization errors.
   - 4.c) The library should NOT mask any error from its driver application.
   - 4.d) The trace should provide enough detail to allow (within reason) the ability to correct issues without needing to recreate the bug.

### 5) General Improvements:
Make any general improvements to bring the code more in line with best practices, style, and supportability.

### 6) Extra Credit - Unit Test:
Create and add a JUnit UnitTest to the solution to exercise the behavior of `Serialization.jar`.

### 7) Extra Credit - Code Analysis:
Activate JavaHints and FindBugs code analysis in the NetBeans IDE and address any warnings raised.

## Additional Notes:
- Provide links to any articles used for guidance.
- Add small comment notes in this README for each exercise step to document your approach.

Happy coding!