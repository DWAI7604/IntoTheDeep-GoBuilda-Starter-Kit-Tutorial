# Programming Concepts for Beginners

This file contains beginner-friendly explanations of programming concepts referenced in the main FTC programming guide. If you're new to programming, these sections will help you understand the fundamental concepts used throughout the guide.

---

## **What are comments?**

Comments are lines of text in your code that are completely ignored by the computer when the program runs. They exist solely for human readers - including your future self! Comments are used to explain what code does, why certain decisions were made, and how complex algorithms work.

In professional software development, well-commented code is often the difference between a maintainable system and a nightmare that nobody wants to touch.

### **Inline comments**

These are used for single lines of text. Whenever there is a // in a line, all of the content following it will be ignored.

```java
// ===== TELEMETRY UPDATING SECTION =====
```

To quickly comment out a section, highlight the lines of code and press Ctrl + / .

### **Block Comments**

These are used for large portions of text. The syntax used is displayed below. The first line uses /*, all lines in between use *, and the end line uses */.

```java
/*
 * This OpMode is an example driver-controlled (TeleOp) mode for the goBILDA 2024-2025 FTC
 * Into The Deep Starter Robot
 * The code is structured as a LinearOpMode
 */
```

---

## **What are classes and methods?**

Think of a **class** like a blueprint for building something. Just like you might have blueprints for a house, a class is a blueprint for creating objects in code.

A **method** is like a specific instruction or action that the object can perform. If a class is a blueprint for a car, methods would be things like "start engine", "turn left", or "brake".

In our robot code, `telemetry` is an object, and `.addLine()` is a method (action) we can tell it to perform.

### **Parameters in Methods**

Methods can take **parameters** - these are pieces of information you give to the method so it knows what to do. Think of parameters like ingredients you give to a recipe.

For example:
```java
telemetry.addLine("Robot Ready");  // The text "Robot Ready" is a parameter
```

The `addLine` method needs to know what text to display, so you give it that text as a parameter inside the parentheses.

---

## **What are Strings?**

**Strings** are just programmer-speak for "text". Anything you want to display as words or sentences goes in quotes like this: `"Robot Ready"` or `"Hello World"`.

The computer treats text in quotes differently from numbers or code instructions. When you see quotes around something, the computer says "oh, this is meant to be displayed as words, not calculated or executed."

Examples:
```java
"Robot Ready"           // This is a String
"armTarget: "          // This is also a String
"Hello World"          // Another String
```

---

## **What are variables and what are the common types?**

Variables are containers that store data values. Think of them like labeled boxes where you can put different types of information. In Java, you need to specify what type of data goes in each box.

### **Common Variable Types:**

- **`int`** - whole numbers like 42, -15, 0
- **`double`** - decimal numbers like 3.14, -2.7, 1.5
- **`String`** - text like "Hello World", "Robot Ready"
- **`boolean`** - true/false values

### **Examples:**
```java
int motorPower = 75;          // A whole number
double armPosition = 150.5;   // A decimal number  
String robotName = "FTC Bot"; // Text in quotes
boolean isRunning = true;     // True or false
```

### **Why Variables Matter:**
Instead of writing the same number over and over, you can store it in a variable and use the variable name. If you need to change the value later, you only change it in one place!

---

## **What does it mean to cast as a String?**

**Casting** means converting one type of data to another type. When we say something "casts as a String," it means the computer can convert that data into text format.

For example:
- The number `42` can be cast as the String `"42"`
- The decimal `3.14` can be cast as the String `"3.14"`
- The boolean `true` can be cast as the String `"true"`

### **Why This Matters for Telemetry:**

The `telemetry.addData()` method needs text to display on the screen. So when you give it a number like:

```java
telemetry.addData("Arm Position: ", armMotor.getCurrentPosition());
```

The computer automatically converts (casts) that number into text so it can be displayed. You don't have to do anything special - Java handles this conversion for you!

---

## **What are If-Else Statements?**

An **if-else statement** is how a program makes decisions. It's like saying: "If something is true, do this. Otherwise, do that."

### **Basic Structure:**

```java
if (condition is true) {
    // Do this code
} else {
    // Do this code instead
}
```

### **Real Robot Example:**

```java
if (gamepad1.a) {
    intake.setPower(1.0);  // If A button is pressed, start intake
} else {
    intake.setPower(0.0);  // If A button is not pressed, stop intake
}
```

### **Multiple Conditions:**

You can also check multiple conditions:

```java
if (gamepad1.right_bumper) {
    armPosition = ARM_COLLECT;  // Right bumper = collection
} else if (gamepad1.left_bumper) {
    armPosition = ARM_CLEAR_BARRIER;  // Left bumper = clear barrier
} else {
    armPosition = armPosition;  // No button = keep current position
}
```

The computer checks conditions from top to bottom and stops at the first one that's true. If none are true, the `else` block runs (if there is one).

---

## **What are While Loops?**

A **while loop** is code that repeats over and over as long as a condition is true. The moment the condition becomes false, the loop stops.

### **Basic Structure:**

```java
while (condition is true) {
    // Repeat this code over and over
}
```

### **Real Robot Example:**

```java
while (opModeIsActive()) {
    // This runs repeatedly while the match is active
    forward = -gamepad1.left_stick_y;
    leftDrive.setPower(forward);
    rightDrive.setPower(forward);
    telemetry.update();
}
```

This loop runs continuously during the entire match. Every time through the loop, it reads the joystick, updates motor power, and updates the telemetry display.

### **Loops and Continuous Execution:**

In TeleOp (driver-controlled) mode, while loops are essential because the robot needs to respond to the driver's input continuously. The loop runs thousands of times per second, constantly checking for new joystick input and updating the robot accordingly.

### **Important Safety Note:**

Make sure your loop condition will eventually become false, or your program will run forever! In FTC, `opModeIsActive()` returns false when the match ends, so the loop stops automatically.

```java
// GOOD - Loop stops when match ends
while (opModeIsActive()) { 
    // code
}

// BAD - Loop never stops!
while (true) {
    // This will run forever!
}
```

---

## **What are Constants and Calculations?**

**Constants** are values that don't change throughout your program. Instead of using the same number in multiple places, you store it once with a descriptive name and reuse it everywhere.

### **Why Use Constants?**

- **Easy to modify**: Change the value once, and it updates everywhere
- **Readable**: A name like `ARM_COLLECT` is clearer than `4930`
- **Less error-prone**: You won't accidentally use different values in different places

### **Declaring Constants:**

```java
final double ARM_TICKS_PER_DEGREE = 19.7;
final int ARM_COLLECT = 250;
final double INTAKE_SPEED = 0.8;
final String TEAM_NAME = "FTC Team 7604";
```

The keyword `final` means "this value cannot be changed once created."

### **Math in Constants:**

Constants can include calculations:

```java
final double TICKS_PER_INCH = 537.7 / (3.78 * Math.PI);
final double ARM_COLLECTION_ANGLE = 250 * ARM_TICKS_PER_DEGREE;
```

The computer performs the calculation once when the program starts, then stores the result.

### **Real Robot Example:**

```java
// Instead of this:
if (gamepad1.y) {
    armMotor.setTargetPosition(4930);
}

// Do this:
if (gamepad1.y) {
    armMotor.setTargetPosition(ARM_COLLECT);
}
```

Much clearer and easier to understand!

---

## **What are Gamepad Inputs?**

A **gamepad** (game controller) is how the driver controls the robot during matches. Your code reads inputs from buttons, joysticks, and triggers, then tells the robot what to do.

### **Types of Gamepad Controls:**

**Analog Stick Input** (returns values -1.0 to +1.0):
```java
gamepad1.left_stick_y    // Forward/backward (-1 = back, +1 = forward)
gamepad1.left_stick_x    // Left/right (-1 = left, +1 = right)
gamepad1.right_stick_y   // Forward/backward on right stick
gamepad1.right_stick_x   // Left/right on right stick
```

**Trigger Input** (returns values 0.0 to 1.0):
```java
gamepad1.left_trigger    // Left trigger (0 = not pressed, 1 = fully pressed)
gamepad1.right_trigger   // Right trigger (0 = not pressed, 1 = fully pressed)
```

**Button Input** (returns true/false):
```java
gamepad1.a              // A button
gamepad1.b              // B button
gamepad1.x              // X button
gamepad1.y              // Y button
gamepad1.left_bumper    // Left shoulder button
gamepad1.right_bumper   // Right shoulder button
gamepad1.dpad_up        // D-Pad Up
gamepad1.dpad_down      // D-Pad Down
gamepad1.dpad_left      // D-Pad Left
gamepad1.dpad_right     // D-Pad Right
```

### **Using Gamepad Input:**

```java
// Simple button press
if (gamepad1.a) {
    intake.setPower(1.0);  // Start intake when A is pressed
}

// Analog stick with math
forward = -gamepad1.left_stick_y;  // Read joystick
leftDrive.setPower(forward);        // Use it to control motor

// Trigger for fine adjustment
adjustment = gamepad1.right_trigger - gamepad1.left_trigger;
newPosition = currentPosition + adjustment * SENSITIVITY;
```

### **Important:** 

Different trigger values can be combined. For example, if the right trigger is halfway pressed (0.5) and the left trigger is fully pressed (1.0), their difference would be -0.5. This is how fine adjustment controls work!

---

## **How Do I Create My Own Methods?**

Sometimes you write the same code over and over in different places. Instead of repeating yourself, you can create your own **method** (custom function) and reuse it.

### **Basic Method Structure:**

```java
public void myMethodName() {
    // Code that the method does
}
```

### **Method with Parameters:**

```java
public void driveForward(double inches) {
    // Use the parameter 'inches' to know how far to drive
    int targetTicks = (int)(inches * TICKS_PER_INCH);
    leftDrive.setTargetPosition(targetTicks);
    rightDrive.setTargetPosition(targetTicks);
    // ... rest of driving code
}
```

### **Calling Your Method:**

Once you create a method, you can use it like this:

```java
driveForward(12);   // Drive forward 12 inches
driveForward(6);    // Drive forward 6 inches
driveForward(-3);   // Drive backward 3 inches
```

### **Method with Return Value:**

```java
public int getArmPosition() {
    return armMotor.getCurrentPosition();  // Returns the current position
}

// Using it:
int position = getArmPosition();
telemetry.addData("Arm at: ", position);
```

### **Why Create Methods?**

- **Reuse code**: Write once, use many times
- **Readable**: `driveForward(12)` is clearer than repeating all the encoder code
- **Maintainable**: If you need to fix a bug, you fix it in one place
- **Organized**: Your code becomes less cluttered and easier to understand

### **Placement in Your Code:**

Methods should be placed inside your class but outside the `runOpMode()` method:

```java
@Autonomous
public class MyAutonomous extends LinearOpMode {
    
    // PUT YOUR METHODS HERE
    public void driveForward(double inches) {
        // ... code
    }
    
    @Override
    public void runOpMode() {
        // Your main program here
    }
}
```

---

## **What is Program Flow and Debugging?**

**Program flow** is the order in which your code executes. **Debugging** is the process of finding and fixing problems in your code.

### **Understanding Program Flow:**

Code runs line by line from top to bottom, unless a control structure (like an if statement or loop) changes the flow:

```java
System.out.println("Step 1");     // Runs first
System.out.println("Step 2");     // Runs second

if (someCondition) {
    System.out.println("Step 3A");  // Maybe runs third
} else {
    System.out.println("Step 3B");  // Or runs third
}

System.out.println("Step 4");     // Runs fourth regardless
```

### **Common Debugging Techniques:**

**1. Use Telemetry to Monitor Values:**
```java
telemetry.addData("Arm Position", armMotor.getCurrentPosition());
telemetry.addData("Motor Power", motorPower);
telemetry.addData("Is Button Pressed", gamepad1.a);
telemetry.update();
```

This lets you see what's happening inside your robot in real-time!

**2. Add Telemetry Markers:**
```java
telemetry.addLine("--- SECTION 1 STARTING ---");
// Your code here
telemetry.addLine("--- SECTION 1 COMPLETE ---");
```

This helps you track which part of your code is running.

**3. Print Values at Key Points:**
```java
leftPower = forward + rotate;
telemetry.addData("Left Power Before Scaling", leftPower);

if (max > 1.0) {
    leftPower /= max;
}
telemetry.addData("Left Power After Scaling", leftPower);
```

Compare values before and after changes to find problems.

### **Common Problems and Solutions:**

**Problem: Motor doesn't move**
- Check telemetry: Is the power value actually being set?
- Verify: Is the motor name spelled correctly in the configuration?
- Test: Try setting power to 1.0 and see if anything happens

**Problem: Robot moves wrong direction**
- Add telemetry to show joystick values
- Check: Are your motor directions set correctly?

**Problem: Arm moves but not to the right position**
- Display the target and current positions
- Check: Is your ticks-per-degree constant correct?
- Verify: Are encoders working and counting?

### **Testing Strategy:**

1. **Test one piece at a time**: Don't test everything at once
2. **Add lots of telemetry**: More data = easier debugging
3. **Make small changes**: Change one thing, test, then change the next
4. **Keep notes**: Write down what you tried and what happened

---

## **Navigation**

**Return to main guide:** [README](./README.md)

**Quick links to specific sections:**
- [Comments explanation](#what-are-comments)
- [Classes and methods](#what-are-classes-and-methods)  
- [Strings explanation](#what-are-strings)
- [Variables and types](#what-are-variables-and-what-are-the-common-types)
- [Casting explanation](#what-does-it-mean-to-cast-as-a-string)
- [If-else statements](#what-are-if-else-statements)
- [While loops](#what-are-while-loops)
- [Constants and calculations](#what-are-constants-and-calculations)
- [Gamepad inputs](#what-are-gamepad-inputs)
- [Creating methods](#how-do-i-create-my-own-methods)
- [Program flow and debugging](#what-is-program-flow-and-debugging)