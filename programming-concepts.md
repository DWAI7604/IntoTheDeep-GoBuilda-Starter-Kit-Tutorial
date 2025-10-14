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

## **Navigation**

**Return to main guide:** [Programming Guide](./guide-to-programming.md)

**Quick links to specific sections:**
- [Comments explanation](#what-are-comments)
- [Classes and methods](#what-are-classes-and-methods)  
- [Strings explanation](#what-are-strings)
- [Variables and types](#what-are-variables-and-what-are-the-common-types)
- [Casting explanation](#what-does-it-mean-to-cast-as-a-string)