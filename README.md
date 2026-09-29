# Assignment 6: Training Sessions

## 1. What I Learned from the Reading

The example in the article where drive() was overriden helped me better understand how overriding works and what it looks like in real code. 
## 2. What I Changed

- I made it so that it asks for user input to know what to data to store.
- The user now enters the number of sessions, session type, date, start time, mileage.
- I made it so workouts also ask about mileage (before it only asked for easy runs) because usually runners want to track total weekly mileage. 
- Normal practices support optional double runs, and their total mileage is calculated through an overloaded method.

## 3. Method Overloading and Method Overriding

### Method overloading

`NormalPractice` contains both `getMiles()` and `getMiles(boolean includeDoubleRun)`. These methods have the same name but different parameter lists. The no-argument version returns the regular practice mileage, while the overloaded version can include the second run. This is appropriate because normal practices may or may not have a double run.

The `NormalPractice` class also has overloaded constructors: one constructor creates a normal practice without a double run, and the other accepts double-run information.

### Method overriding

`NormalPractice`, `Workout`, and `LongRun` each override `toString()` from `TrainingSessions`. Each subclass adds its own details to the shared date and start-time information. This is appropriate because every session should be displayed through the same general interface while still showing type-specific information.

In `Driver`, calling `session.toString()` through a `TrainingSessions` reference demonstrates dynamic method binding: Java selects the `toString()` implementation belonging to the object's actual subclass.

## 4. Challenges Encountered

The main challenge was understanding the existing classes and how they functioned before knowing what to add or change. The original constructors accepted dates and start times, but the driver created every object with hard-coded values. I changed the input flow while keeping the existing structure and summary logic.


## 5. Use of AI Tools
I used github copilot to implement the changes in the code and to fix errors. 

