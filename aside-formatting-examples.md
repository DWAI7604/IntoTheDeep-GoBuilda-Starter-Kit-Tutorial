# Aside Formatting Options Demo

This file demonstrates different ways to format beginner-friendly programming asides that experienced programmers can easily skip.

---

## Option 1: Collapsible Sections (Recommended)

This is the main content that everyone reads. Now let's explain a programming concept...

<details>
<summary><strong>💡 New to Programming? What are variables? (Click to expand)</strong></summary>

Variables are containers that store data values. Think of them like labeled boxes where you can put different types of information. In Java, you need to specify what type of data goes in each box:

- `int` - whole numbers like 42, -15, 0
- `double` - decimal numbers like 3.14, -2.7
- `String` - text like "Hello World", "Robot Ready"
- `boolean` - true/false values

Example:
```java
int motorPower = 75;        // A whole number
String robotName = "FTC Bot"; // Text in quotes
boolean isRunning = true;    // True or false
```

The cool thing about variables is you can change their values later in your program!

</details>

Continuing with the main content...

---

## Option 2: Blockquote Callouts

This is the main content. Here's how blockquotes look for asides:

> **💡 Aside for Beginners: What are classes and methods?**
> 
> Think of a **class** like a blueprint for building something. Just like you might have blueprints for a house, a class is a blueprint for creating objects in code.
> 
> A **method** is like a specific instruction or action that the object can perform. If a class is a blueprint for a car, methods would be things like "start engine", "turn left", or "brake".
> 
> In our robot code, `telemetry` is an object, and `.addLine()` is a method (action) we can tell it to perform.

Back to the main content flow...

---

## Option 3: Styled Callout Boxes with Horizontal Rules

Regular content continues here. Now for an aside:

---
**🎓 New to Programming? Understanding Strings**

**Strings** are just programmer-speak for "text". Anything you want to display as words or sentences goes in quotes like this: `"Robot Ready"` or `"Hello World"`. 

The computer treats text in quotes differently from numbers or code instructions.

Think of it like this: when you see quotes around something, the computer says "oh, this is meant to be displayed as words, not calculated or executed."

---

Main content continues after the aside...

---

## Option 4: Indented Sections

Regular paragraph content flows here. Time for a programming concept explanation:

    📚 **Programming Concept: What are import statements?**
    
    Think of imports like telling your program "I want to use tools from this toolbox."
    Each import line says "give me access to specific capabilities I'll need later."
    
    It's like saying "I need my screwdriver, hammer, and wrench" before starting a project.
    
    ```java
    import com.qualcomm.robotcore.hardware.DcMotor;  // I need motor tools
    import com.qualcomm.robotcore.eventloop.opmode.TeleOp;  // I need teleop tools
    ```

Content continues normally after the indented aside...

---

## Option 5: Alert-Style Boxes (Using HTML)

<div style="background-color: #e7f3ff; border-left: 6px solid #2196F3; margin: 20px 0; padding: 15px;">
<strong>🔰 Beginner's Corner: Understanding Methods</strong><br><br>

A **method** is like giving your robot a specific command. When you write:

```java
telemetry.addLine("Robot Ready");
```

You're essentially saying: "Hey telemetry object, use your `addLine` method to display this text!"

It's like having a remote control with different buttons - each method is a different button that makes the robot do something specific.
</div>

---

## Option 6: Simple Warning/Info Style

**ℹ️ First-Time Programmer?** 

If you've never coded before, think of **variables** like labeled storage boxes. You can put different types of things in them:
- Numbers (for motor speeds, sensor readings)  
- Text (for messages, names)
- True/False values (for checking if something is on or off)

---

## Option 7: Emoji Section Headers

### 🎯 **For Experienced Programmers**
Jump to the next section - this explains basic concepts.

### 📖 **For Programming Beginners**
**What's a Loop?**

A loop is like telling your robot "keep doing this action until I tell you to stop." It's like setting your alarm to snooze - it keeps repeating the same action (ringing) until you turn it off.

In our robot code, we use loops to continuously check the gamepad buttons and update the robot's movements.

---

## Comparison Summary

| Option | Pros | Cons | Best For |
|--------|------|------|----------|
| **Collapsible** | Clean, skippable, GitHub native | Requires click to view | Complex explanations |
| **Blockquotes** | Visually distinct, always visible | Takes up space | Short, important notes |
| **HR Boxes** | Very clear separation | Breaks up flow | Medium-length asides |
| **Indented** | Subtle, traditional | Less visually distinct | Brief explanations |
| **HTML Boxes** | Most customizable | May not render everywhere | Special emphasis |
| **Simple Info** | Quick and easy | Basic formatting | One-liner tips |
| **Emoji Headers** | Fun and accessible | Informal tone | Youth-oriented content |

---

## Recommendation

For your FTC programming guide, I recommend **Option 1 (Collapsible Sections)** because:

✅ Keeps main content clean for experienced programmers  
✅ Clearly signals optional content for beginners  
✅ Works great on GitHub and most Markdown renderers  
✅ Professional appearance suitable for educational content  
✅ Students can easily skip or expand based on their needs  
✅ Maintains good flow for both audience types