# Into The Deep: a guide to programming

## Zoe Stalnaker, Code Lead on 7604

# **Prerequisites**

- A fully assembled GoBuilda Starter Kit from the 2024-2025 Into The Deep season, found at [https://www.gobilda.com/ftc-starter-kit-2024-2025-season/](https://www.gobilda.com/ftc-starter-kit-2024-2025-season/)  
  - Assembly instructions: [https://www.gobilda.com/content/user\_manuals/starter-bot-assembly-instructions.min.pdf](https://www.gobilda.com/content/user_manuals/starter-bot-assembly-instructions.min.pdf)	  
- Said robot needs to be wired

STRUCTURE OF THIS GUIDE

- At points there will be asides: these will be targetted towards explaining programming concepts, such as variables and loops

# **Section 0: Set Up**

## **Step 1: Install Required Software**

### **1.1 Install GitHub Desktop**

1. Go to [https://desktop.github.com/](https://desktop.github.com/)  
2. Download and install GitHub Desktop  
3. When GitHub Desktop opens and asks you to sign in, click **"Skip this step"** or **"Continue without signing in"**  
4. You can still clone public repositories without an account\!

**Note:** You can always sign in later if you want to contribute back to the community or create your own repositories.

### **1.2 Install Android Studio**

1. Go to [https://developer.android.com/studio](https://developer.android.com/studio)  
2. Download Android Studio  
3. Run the installer and follow the setup wizard  
4. When prompted, install the Android SDK and additional components

---

## **Step 2: Get the Custom FTC Robot Controller Code**

### **2.1 Clone the Repository with GitHub Desktop**

1. Open GitHub Desktop  
2. Click "Clone a repository from the Internet"  
3. In the URL tab, paste: `https://github.com/fiverattack/FtcRobotController-IntoTheDeep-GoBuilda-Starter-Kit.git`  
4. Choose where to save it on your computer (remember this location\!)  
5. Click "Clone"

**Note:** Even without signing in, you can clone any public repository (like this FTC one). GitHub Desktop will download all the code to your computer.

### **2.2 Open the Project in Android Studio**

1. Open Android Studio  
2. Click "Open an Existing Project"  
3. Navigate to where you cloned the repository  
4. Select the `FtcRobotController-IntoTheDeep-GoBuilda-Starter-Kit` folder  
5. Click "OK"  
6. Android Studio will take a few minutes to load and sync the project

## **Step 3: wiring the robot**

## **Step 4: configuring the driver hub**

## **Step 5: Installing the code on the control hub**

## **Step 6: Test drive**

# **Section 1: Telemetry**

## **What is telemetry?**

Telemetry is a system for collecting and transmitting data from a remote or inaccessible point to a receiving station for monitoring and analysis. In programming, telemetry refers to the automatic collection and transmission of data from software applications to help developers understand how their programs are performing.

**In the real world**, telemetry is everywhere:
- **Space missions**: NASA uses telemetry to monitor spacecraft health, track position, and receive scientific data from rovers on Mars
- **Medical devices**: Heart monitors send patient data to nursing stations in real-time
- **Automotive**: Modern cars continuously monitor engine performance, GPS location, and system diagnostics
- **Web applications**: Companies like Google and Facebook collect usage statistics to improve user experience
- **IoT devices**: Smart home devices send status updates and sensor readings to mobile apps

**In FTC robotics**, telemetry serves as your window into what your robot is thinking and doing. It's your primary debugging tool and performance monitor, displaying real-time information on the Driver Station screen during matches and testing.

## **Telemetry in the Code**

There are three methods (actions) that we will be using within this guide on the telemetry class.

**📚 New to programming?** Learn about [classes and methods](./programming-concepts.md#what-are-classes-and-methods) in the Programming Concepts guide.

The first method is `telemetry.addLine("enter text here")`. This method displays a line of text on your Driver Station screen.

```java
telemetry.addLine("Robot Ready.");
```

**📚 New to programming?** Learn about [Strings and text in programming](./programming-concepts.md#what-are-strings) in the Programming Concepts guide.

The second method is `telemetry.addData("label text", data)`. This method shows a label followed by some data (usually a number). The first piece of information you give it is text in quotes, and the second piece is the actual data you want to display.

```java
telemetry.addData("armTarget: ", armMotor.getTargetPosition());
```

**📚 New to programming?** Learn about [variables and data types](./programming-concepts.md#what-are-variables-and-what-are-the-common-types) and [what casting means](./programming-concepts.md#what-does-it-mean-to-cast-as-a-string) in the Programming Concepts guide.

The third method is `telemetry.update()`. This method takes nothing in the parentheses, but it is vital to using telemetry. It sends whatever telemetry you have previously added to the Driver Station to be displayed. Without this method, the telemetry will not be visible.

```java
telemetry.update();
```

Before moving on to adding our own telemetry, let's observe the telemetry currently in place.

### What Does Telemetry Look Like?
When you run your robot code, telemetry appears as text on your Driver Hub. It might display something like:
```
armTarget: 1500
arm Encoder: 1487
```
This lets you see what your robot is thinking in real-time!

### Observing Code

Open up the file titled Code_Here.java, which you can find in TeamCode\src\main\java\org\firstinspires\ftc\teamcode .

>
> - The Code_Here file is for you to test out whatever code edits you want
>
> - The Blank_Slate_Code file is the original, unaltered code; if your code breaks, or you just want a fresh start, copy everything from this file into the Code_Here file!
>
> - The SectionNumber files are essentially keys for each section: they'll contain specific, relevant comments and edits to the original code
>

**The first set of telemetry** in the file is found around lines 78 and 79 (you can press Ctrl+G to jump to a line number):
```java
telemetry.addLine("Robot Ready.");
telemetry.update();
```

This first set of telemetry tells the user when the robot has finished initializing and is ready to start. The first line displays the text "Robot Ready." on screen, and the second line actually sends that text to your Driver Hub so you can see it.

**The second set of telemetry** in the file is found around lines 159-161:
```java
telemetry.addData("armTarget: ", armMotor.getTargetPosition());
telemetry.addData("arm Encoder: ", armMotor.getCurrentPosition());
telemetry.update();
```

This second set of telemetry continuously shows the arm's position and its target position. The first two lines use the `.addData()` method to display numbers. Looking at the first line, it shows a label "armTarget: " followed by the position the arm is trying to reach. Together, these create a display that looks like this: `armTarget: 1234`

There is also **one additional telemetry statement** around line 156:
```java
telemetry.addLine("MOTOR EXCEEDED CURRENT LIMIT!");
```

Here, this telemetry warns the user when something is going wrong. It's placed inside an if statement, so the warning only appears when the motor draws too much power.

**📚 New to programming?** Learn about [If else statements](./programming-concepts.md#if-else-statements) in the Programming Concepts guide.

## Try It Out! Adding Custom Telemetry

Now that we've seen what telemetry can do, it's time to use it for ourselves!

**1. Changing text**

Go to line 78 of the Code_Here.java file, which should have the following code:
```java
telemetry.addLine("Robot Ready.");
```

*note: if the line numbers don't match up with the instructions, that means that you may have altered the lines some how. If that was intentional, no worries! Press ctrl + f to locate the line you were told to find.*

Change the text from "Robot Ready." to "Initialized," then install the code onto the robot again and test it out.

**2. Logging a specific variable**

Go to line 85 of the Code_Here.java file, which should have the following code:
```java
forward = -gamepad1.left_stick_y;
```

On line 87 (the first empty line after the above code), use the telemetry.addData() method to show the user what the left_stick_y of the gamepad is returning

Your line should look something like this:
```java
telemetry.addData("left_stick_y: ", forward);
```

Now, try to instead return the value of the variable called rotate! Install the code and look at how these variables change with the movement of the joysticks.

**3. Looking at an actively changing variable**

Go to line 90 and 97, which should be empty lines on either side of the following code:
```java
max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
if (max > 1.0)
{
    leftPower /= max;
    rightPower /= max;
}
```

On line 90, use telemetry to show the variable of leftPower, then do the same on line 97 (this should make it so that the above section of code is surrounded by these two lines).

Install the code, move the joysticks, and see how this section of code is changing the leftPower variable!

**4. Try out other variables!**

Try logging the armPositionFudgeFactor variable, or the the constants calculated at the top of the class.

A few things to keep in mind:
- the telemetry.update() method must be called after whatever other telemetry methods are called! if it isn't called then the information will not be sent to the user
- the code within the while (opModeIsActive()) loop will run constantly, so code within there should be used for anything that should be seen during the match

**📚 New to programming?** Check out our detailed explanation of [while loops](./programming-concepts.md#what-while-loops) in the Programming Concepts guide.

# **Section 2: Drive Train**

# **Section 3: The Arm**

# **Section 4: Encoder Drive**

# **Section 5: Next Steps**

Where do you go from here? It's not the Into The Deep season anymore, and you need to figure out what you're doing for the new season.

There are two main options: you can either take what you've learned here and program a robot using what you've seen and experimented with, or you can spend more time learning about more complex systems.

If you're looking for what to learn next, here are my recommendations:

- Specific subsystems that your team will need for the current season, such as cameras or slides
- Mecanum drive (if you're team is able to use one)
- Pathfinding with RoadRunner or PedroPathing
- The theory behind PIDs

# **Section LAST ONE: Full Code Breakdown**

## **How to use this section**

If you are looking at a particular line of code, you can reference this section; if it is not explained at said line, then look for the earliest use of a similar line and it will be explained there.

## **Breakdown**

`package org.firstinspires.ftc.teamcode;`

- this line indicates where this file is located in the packages

```java
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
```

- these lines are import statements: they act as references to classes that we want to use within our code  
  - LinearOpMode →  
  - TeleOp →  
  - CRServo →  
  - DcMotor →  
  - DcMotorEx →  
  - Servo →  
  - CurrentUnit →

`@TeleOp(name="FTC Starter Kit Example Robot (INTO THE DEEP) (no comments)", group="Robot")`

- This line indicates to the driver hub what to name this teleop program

`public class ConceptGoBildaStarterKitRobotTeleop_IntoTheDeep_NoComments extends LinearOpMode {`

- This line defines a class called \_\_\_ that extends \_\_\_  
  - Extending another class means that the new class uses the old classes methods, unless they are overriden

```java
public DcMotor  leftDrive   = null;
public DcMotor  rightDrive  = null;
public DcMotor  armMotor    = null;
public CRServo  intake      = null;
public Servo    wrist       = null;
```

- Declaring variables

```java
final double ARM_TICKS_PER_DEGREE =
        28
        * 250047.0 / 4913.0
        * 100.0 / 20.0
        * 1/360.0;
```

- Talk about encoder ticks and the calculation

```java
final double ARM_COLLAPSED_INTO_ROBOT  = 0;
final double ARM_COLLECT               = 250 * ARM_TICKS_PER_DEGREE;
final double ARM_CLEAR_BARRIER         = 230 * ARM_TICKS_PER_DEGREE;
final double ARM_SCORE_SPECIMEN        = 160 * ARM_TICKS_PER_DEGREE;
final double ARM_SCORE_SAMPLE_IN_LOW   = 160 * ARM_TICKS_PER_DEGREE;
final double ARM_ATTACH_HANGING_HOOK   = 120 * ARM_TICKS_PER_DEGREE;
final double ARM_WINCH_ROBOT           = 15  * ARM_TICKS_PER_DEGREE;
```

- Defining positions for the robot arm  
  - State what each one is for

```java
final double INTAKE_COLLECT    = -1.0;
final double INTAKE_OFF        =  0.0;
final double INTAKE_DEPOSIT    =  0.5;
```

- Defining positions for the intake  
  - State what each one is for

    `final double WRIST_FOLDED_IN   = 0.8333;`  
    `final double WRIST_FOLDED_OUT  = 0.5;`

    `final double FUDGE_FACTOR = 15 * ARM_TICKS_PER_DEGREE;`

    `double armPosition = (int)ARM_COLLAPSED_INTO_ROBOT;`  
    `double armPositionFudgeFactor;`

    `@Override`  
    `public void runOpMode() {`  
        `double leftPower;`  
        `double rightPower;`  
        `double forward;`  
        `double rotate;`  
        `double max;`

        `// ===== initiate motors =====`  
        `leftDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");`  
        `rightDrive = hardwareMap.get(DcMotor.class, "right_front_drive");`  
        `armMotor   = hardwareMap.get(DcMotor.class, "left_arm");`

        `leftDrive.setDirection(DcMotor.Direction.FORWARD);`  
        `rightDrive.setDirection(DcMotor.Direction.REVERSE);`

        `leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);`  
        `rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);`  
        `armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);`

        `((DcMotorEx) armMotor).setCurrentAlert(5,CurrentUnit.AMPS);`

        `armMotor.setTargetPosition(0);`  
        `armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);`  
        `armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);`

        `// ===== initiate servos =====`  
        `intake = hardwareMap.get(CRServo.class, "intake");`  
        `wrist  = hardwareMap.get(Servo.class, "wrist");`

        `intake.setPower(INTAKE_OFF);`  
        `wrist.setPosition(WRIST_FOLDED_IN);`

        `// ===== wait for start =====`  
        `telemetry.addLine("Robot Ready.");`  
        `telemetry.update();`

        `waitForStart();`

        `while (opModeIsActive()) {`

            `forward = -gamepad1.left_stick_y;`  
            `rotate  = gamepad1.right_stick_x;`

            `leftPower  = forward + rotate;`  
            `rightPower = forward - rotate;`

            `max = Math.max(Math.abs(leftPower), Math.abs(rightPower));`  
            `if (max > 1.0)`  
            `{`  
                `leftPower /= max;`  
                `rightPower /= max;`  
            `}`

            `leftDrive.setPower(leftPower);`  
            `rightDrive.setPower(rightPower);`

            `if (gamepad1.a) {`  
                `intake.setPower(INTAKE_COLLECT);`  
            `}`  
            `else if (gamepad1.x) {`  
                `intake.setPower(INTAKE_OFF);`  
            `}`  
            `else if (gamepad1.b) {`  
                `intake.setPower(INTAKE_DEPOSIT);`  
            `}`

            `if(gamepad1.right_bumper){`  
                `armPosition = ARM_COLLECT;`  
                `wrist.setPosition(WRIST_FOLDED_OUT);`  
                `intake.setPower(INTAKE_COLLECT);`  
                `}`

                `else if (gamepad1.left_bumper){`  
                    `armPosition = ARM_CLEAR_BARRIER;`  
                `}`

                `else if (gamepad1.y){`  
                    `armPosition = ARM_SCORE_SAMPLE_IN_LOW;`  
                `}`

                `else if (gamepad1.dpad_left) {`  
                    `armPosition = ARM_COLLAPSED_INTO_ROBOT;`  
                    `intake.setPower(INTAKE_OFF);`  
                    `wrist.setPosition(WRIST_FOLDED_IN);`  
                `}`

                `else if (gamepad1.dpad_right){`  
                    `armPosition = ARM_SCORE_SPECIMEN;`  
                    `wrist.setPosition(WRIST_FOLDED_IN);`  
                `}`

                `else if (gamepad1.dpad_up){`  
                    `armPosition = ARM_ATTACH_HANGING_HOOK;`  
                    `intake.setPower(INTAKE_OFF);`  
                    `wrist.setPosition(WRIST_FOLDED_IN);`  
                `}`

                `else if (gamepad1.dpad_down){`  
                    `armPosition = ARM_WINCH_ROBOT;`  
                    `intake.setPower(INTAKE_OFF);`  
                    `wrist.setPosition(WRIST_FOLDED_IN);`  
            `}`

            `armPositionFudgeFactor = FUDGE_FACTOR * (gamepad1.right_trigger + (-gamepad1.left_trigger));`

            `armMotor.setTargetPosition((int) (armPosition + armPositionFudgeFactor));`

            `((DcMotorEx) armMotor).setVelocity(2100);`  
            `armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);`

            `if (((DcMotorEx) armMotor).isOverCurrent()){`  
                `telemetry.addLine("MOTOR EXCEEDED CURRENT LIMIT!");`  
            `}`

            `telemetry.addData("armTarget: ", armMotor.getTargetPosition());`  
            `telemetry.addData("arm Encoder: ", armMotor.getCurrentPosition());`  
            `telemetry.update();`

        `}`  
    `}`  
`}`

# **Resources**

Contact me\! Zoe Stalnaker, [zoe.c.stalnaker@gmail.com](mailto:zoe.c.stalnaker@gmail.com), I’m happy to answer any questions about these instructions; additionally, I’ll happily accept any feedback.

The Unofficial FIRST Tech Challenge Discord, which can be joined at [https://discord.gg/ftc](https://discord.gg/ftc); this server is filled with people willing to help with any questions you have.

Learn Java for FTC

GM0

FTC sample code, [https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples](https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples) 