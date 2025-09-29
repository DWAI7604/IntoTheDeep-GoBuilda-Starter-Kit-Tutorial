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

Before jumping into looking at code and trying to understand it, there’s one important part of programming to understand.

>## **Aside: What are comments?**
> 
> Comments are lines of text in your code that are completely ignored by the computer when the program runs. They exist solely for human readers - including your future self! Comments are used to explain what code does, why certain decisions were made, and how complex algorithms work. They're critically important because they make code maintainable and help teams collaborate effectively.
>
> **Why comments matter:**
> - **Documentation**: Explain complex logic that isn't immediately obvious
> - **Collaboration**: Help team members understand your code
> - **Future reference**: Remind yourself what you were thinking one month later
> - **Debugging**: Temporarily disable code without deleting it
>
> In professional software development, well-commented code is often the difference between a maintainable system and a nightmare that nobody wants to touch.
>
>### **Block Comments**
>
>These are used for large portions of text.
>
>```java
>/*
> * This OpMode is an example driver-controlled (TeleOp) mode for the goBILDA 2024-2025 FTC
> * Into The Deep Starter Robot
> * The code is structured as a LinearOpMode
> */
>```
>
>### **Inline comments**
>
>These are used for single lines of text. To quickly comment out a section, select it and press ctrl \+ / .
>
>```java
>//@Disabled
>```

## **Telemetry in the Code**

There are three main methods\* that we will be using on the telemetry class\*.

Aside: What are classes and methods?

```java
telemetry.addLine("Robot Ready.");
```

This first method takes the text within the String\* and puts it into the telemetry.

Aside: what are Strings?

```java
telemetry.addData("armTarget: ", armMotor.getTargetPosition());
```

This second method takes the text within the String, just like above, and adds another element after it. This element displays as text, but can be anything from another String to an int to a double.

Aside: what are variables and what are the common types?

```java
telemetry.update();
```

This third method takes the telemetry and sends it to the driver hub. Without this method call, all added telemetry will NOT be visible.

# **Section 2: Drive Train**

# **Section 3: The Arm**

# **Section 4: Next Steps**

So, where do you go from here? It's not the Into The Deep season, and you need to create new code for 

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