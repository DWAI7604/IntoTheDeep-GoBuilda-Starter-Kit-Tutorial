# **Into The Deep: a guide to programming**

## By Zoe Stalnaker

# **Introduction**

Hello! I'm Zoe, the code lead for 7604 for the 2025-2026 season, Decode. This instructional document was created for two purposes: to train future coders and to give builders basic programming knowledge.

This guide is intended to be readable for anyone, but is written with people who have vry basic programming knowledge. For those who know nothing about programming, there is an additional guide, programming-concepts, that will be linked to at the relevant points in order to learn the new concepts covered or gain a deeper knowledge!

Disclaimer: I have heavily utilized copilot in the process of making this document for a few reasons:

- it speeds up my work flow immensely,
- it creates simple and easy to understand formatting that would take me far more time to do,
- and most importantly in my opinion, the programming industry actively uses AI in their workflow

However, I am proof reading and editing everything created, and my lovely editors also helped to double check everything.

Thank you to the following
- Trask Stalnaker, my lovely dad, for helping make this easily understandable
- add other proof readers and such

# **Table of Contents**

- [Prerequisites](#prerequisites)
- [Section 0: Set Up](#section-0-set-up)
  - [Step 1: Install Required Software](#step-1-install-required-software)
  - [Step 2: Get the Custom FTC Robot Controller Code](#step-2-get-the-custom-ftc-robot-controller-code)
  - [Step 3: Wiring the Robot](#step-3-wiring-the-robot)
  - [Step 4: Configuring the Driver Hub](#step-4-configuring-the-driver-hub)
  - [Step 5: Installing the Code on the Control Hub](#step-5-installing-the-code-on-the-control-hub)
  - [Step 6: Test Drive](#step-6-test-drive)
- [Section 1: Telemetry](#section-1-telemetry)
  - [What is Telemetry?](#what-is-telemetry)
  - [Telemetry in the Code](#telemetry-in-the-code)
  - [Try It Out! Adding Custom Telemetry](#try-it-out-adding-custom-telemetry)
- [Section 2: Drive Train](#section-2-drive-train)
- [Section 3: The Arm](#section-3-the-arm)
- [Section 4: Encoder Drive](#section-4-encoder-drive)
- [Section 5: Next Steps](#section-5-next-steps)
- [Section LAST ONE: Full Code Breakdown](#section-last-one-full-code-breakdown)
- [Resources](#resources)

# **Prerequisites**

- A fully assembled GoBuilda Starter Kit from the 2024-2025 Into The Deep season, found at [https://www.gobilda.com/ftc-starter-kit-2024-2025-season/](https://www.gobilda.com/ftc-starter-kit-2024-2025-season/)  
  - Assembly instructions: [https://www.gobilda.com/content/user\_manuals/starter-bot-assembly-instructions.min.pdf](https://www.gobilda.com/content/user_manuals/starter-bot-assembly-instructions.min.pdf)	  



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

## **Step 3: Wiring the Robot**

### **3.1 Physical Assembly**
Ensure your GoBuilda Starter Kit is fully assembled according to the official assembly instructions. The basic wiring connections should include:

**Drive Motors:**
- **Left drive motor** → Control Hub motor port (note which port number)
- **Right drive motor** → Control Hub motor port (note which port number)

**Arm System:**
- **Arm motor** → Control Hub motor port
- **Intake servo** → Control Hub servo port
- **Wrist servo** → Control Hub servo port

NOTE TO SELF: here there should be discussion of the different types of ports on the control hub AND the names of cords and such

**Power:**
- **12V Battery** → Control Hub power port
- Ensure all connections are secure and the battery is charged

**💡 Important:** Take note of which port numbers your motors and servos are connected to - you'll need this information for configuration!

## **Step 4: Configuring the Driver Hub**

### **4.1 Connect Driver Hub to Robot**
1. **Power on the Driver Hub device** and ensure it's charged
2. **Power on the robot** by connecting the battery to the Control Hub
3. **Connect wirelessly**:
   - On the Driver Hub, touch the settings (gear icon) or three dots (⋮) in the upper right corner
   - Select **Settings** (you may need to scroll down)
   - Tap **Pair With Robot Controller**
   - Tap **WiFi Settings**
   - Select your Control Hub's WiFi network (usually named something like "FTC-XXXX" where XXXX are numbers)
   - Wait for the connection status to show green

**✅ Verification:** If connected successfully, you should see the robot's name displayed in red text on the WiFi Settings page.

### **4.2 Configure Hardware**
1. **Access Robot Controller**: On the Driver Hub, open the "FTC Robot Controller" app
2. **Start Configuration**:
   - Touch the three dots (⋮) in the upper right corner
   - Select "Configure Robot"
   - If no configuration exists, touch "New" and give it a name (e.g., "GoBuilda Starter Kit")
   - Touch "Control Hub Portal"
   - Touch "Control Hub"

NOTE TO SELF: i thought you named it at the end of the process?

### **4.3 Configure Motors**
1. **Access Motors**: Touch "Motors" to access the motor configuration screen
2. **Configure Drive Motors**:
   - Touch the port number where your left drive motor is connected
   - Select "DC Motor" from the list
   - Name it exactly `left_front_drive` (this must match the code)
   - Touch "Done"
   - Repeat for the right drive motor, naming it exactly `right_front_drive`
3. **Configure Arm Motor**:
   - Touch the port number where your arm motor is connected
   - Select "DC Motor" from the list  
   - Name it exactly `left_arm`
   - Touch "Done"

NOTE TO SELF: i don't think it's "DC Motor" in the list? I think it's dependant on the motor type: same goes for the servo section below

### **4.4 Configure Servos**
1. **Access Servos**: Touch "Servos" to access the servo configuration screen
2. **Configure Intake**:
   - Touch the port number where your intake servo is connected
   - Select "Continuous Rotation Servo" from the list
   - Name it exactly `intake`
   - Touch "Done"
3. **Configure Wrist**:
   - Touch the port number where your wrist servo is connected
   - Select "Servo" from the list
   - Name it exactly `wrist`
   - Touch "Done"

### **4.5 Save Configuration**
1. **Save**: Touch "Save" to save your configuration
2. **Activate**: Make sure your new configuration is selected as the active configuration

**⚠️ Critical:** In the future when you're coding, the device names in your configuration MUST exactly match the names in your code (this is preset in the given code):
- Code: `hardwareMap.get(DcMotor.class, "left_front_drive")`
- Configuration: Must have a motor named `left_front_drive`

**💡 Battery Status:** The Driver Hub displays both the Driver Hub battery percentage (top of screen) and robot battery voltage (to the right). Green indicates a healthy battery (~12V), while yellow or red means the battery should be replaced.

## **Step 5: Installing the Code on the Control Hub**

### **5.1 Power and Connect the Robot**
1. **Power on the robot** by connecting a charged battery to the Control Hub
2. **Connect via USB cable**: 
   - Plug USB-C end into the Control Hub on the robot
   - Plug USB-A end into your laptop/computer
3. **Wait for connection**: The robot should appear as a connected device at the top of Android Studio
   - Look for the device name in the device dropdown (usually shows as something like "Control Hub")

### **5.2 Deploy the Code**
1. **Click the green "Run" button** (play icon) in Android Studio
2. **Wait for the build process**:
   - First notification: "Build finished" 
   - Second notification: "Install finished"
   - ⚠️ **Important**: Wait for BOTH notifications before proceeding
3. **Disconnect the USB cable** once installation is complete
4. **Verify success**: If no error messages appeared, the code installed correctly!

**💡 Troubleshooting**: If you get errors, check that the Control Hub is powered and properly connected via USB.

## **Step 6: Test Drive**

### **6.1 Initial Setup**
1. **Ensure the robot is powered on** (battery connected and Control Hub LED is on)
2. **Power on the Driver Hub device** and ensure it's charged and open to the FTC app
3. **Connect to the robot**: 
   - The Driver Hub should automatically detect and connect to the Control Hub
   - Look for a green connection indicator

### **6.2 Select and Run Your Program**
1. **Select your TeleOp program**:
   - On the left side of Driver Station, find two dropdown arrows
   - **Left arrow**: Autonomous programs
   - **Right arrow**: TeleOp programs
   - Click the **right arrow** and select **"Your Code"**
2. **Initialize**: Press the **"INIT"** button
3. **Start**: Press the **"▶ START"** button when ready

### **6.3 Test Robot Controls**

#### **Drive Controls (Joysticks)**
- **Left joystick**: 
  - **Up/Down**: Moves robot forward/backward
  - **Left/Right**: No effect (tank drive style)
- **Right joystick**:
  - **Left/Right**: Rotates robot left/right
  - **Up/Down**: No effect

#### **Intake Controls (Face Buttons)**
- **A button**: Turn intake to collection mode (spins inward)
- **X button**: Turn intake off (stops spinning)
- **B button**: Turn intake to deposit mode (spins outward)

#### **Arm Positioning (D-Pad + Button)**
- **Right Bumper**: Moves arm to collection position + activates intake + extends wrist
- **Left Bumper**: Moves arm to clear barrier position
- **Y button**: Moves arm to score sample in low basket position
- **D-Pad Left**: Collapses arm into robot + stops intake + folds wrist in
- **D-Pad Right**: Moves arm to score specimen position + folds wrist in
- **D-Pad Up**: Moves arm to attach hanging hook position + stops intake + folds wrist in  
- **D-Pad Down**: Moves arm to winch robot position + stops intake + folds wrist in

#### **Fine Adjustment (Triggers)**
- **Left/Right Triggers**: Make small adjustments to arm position
  - **Right Trigger**: Raises arm slightly
  - **Left Trigger**: Lowers arm slightly

### **6.4 What to Observe**
- **Smooth movement**: Robot should respond immediately to joystick inputs
- **Telemetry data**: Watch the Driver Station screen for real-time data display
- **Arm positions**: Arm should move to distinct positions when buttons are pressed
- **Intake operation**: Listen for intake motor spinning when activated

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

💡 **New concept: Strings** - The text in quotes like `"Robot Ready."` is called a "string" in programming. It's just a way to represent text that the computer can understand and display.

**📚 New to programming?** Learn more about [Strings and text in programming](./programming-concepts.md#what-are-strings) in the Programming Concepts guide.

The second method is `telemetry.addData("label text", data)`. This method shows a label followed by some data (usually a number). The first piece of information you give it is text in quotes (a string), and the second piece is the actual data you want to display.

```java
telemetry.addData("armTarget: ", armMotor.getTargetPosition());
```

The `armMotor.getTargetPosition()` part asks the arm motor "what position are you trying to reach?" and gets back a number that changes as your robot runs!

**📚 New to programming?** Learn about [variables and data types](./programming-concepts.md#what-are-variables-and-what-are-the-common-types) in the Programming Concepts guide.

The third method is `telemetry.update()`. This method takes nothing in the parentheses, but it is vital to using telemetry. It sends whatever telemetry you have previously added to the Driver Station to be displayed. Without this method, the telemetry will not be visible.

```java
telemetry.update();
```

💡 **Why telemetry.update() is needed** - Think of telemetry like writing on a whiteboard. You can write multiple things (`addLine`, `addData`), but you need to hold up the whiteboard (`update`) for people to see what you wrote!

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

# **Section 2: The Drive Train**

## **What is Arcade Drive?**

The GoBuilda Starter Kit uses what's called "arcade drive" - a driving method that feels intuitive and is easy to learn. While it's sometimes called "tank drive" in FTC, it's actually different from true tank drive.

**In the real world**, arcade drive is like driving a car with power steering:
- **Video games**: Most racing games use arcade-style controls where one stick steers and another controls speed
- **Construction equipment**: Many modern excavators and bulldozers use similar joystick controls
- **Military vehicles**: Modern tanks actually use arcade-style controls rather than the old dual-lever system
- **RC cars**: Most remote-controlled cars use this same control scheme

**In our robot**, arcade drive combines forward/backward movement with rotation using simple math, making it perfect for beginners while still being powerful enough for competition.

### What Does Arcade Drive Look Like?
When you operate arcade drive, your robot will:
```
Left stick UP + Right stick NEUTRAL → Robot moves forward
Left stick DOWN + Right stick NEUTRAL → Robot moves backward  
Left stick NEUTRAL + Right stick RIGHT → Robot rotates clockwise
Left stick UP + Right stick RIGHT → Robot moves forward while turning right
```
This gives you smooth, car-like movement that's intuitive to control!

## **Drive Train in the Code**

The drive system uses two motors that each control two wheels on one side of the robot. Let's explore how the code makes this work.

### **What Does Drive Code Look Like?**
When you run your robot code and look at the key drive sections, you'll see patterns like this:
```java
forward = -gamepad1.left_stick_y;    // Read joystick
leftPower = forward + rotate;        // Calculate motor power
leftDrive.setPower(leftPower);       // Tell motor what to do
```
This is your robot translating joystick movements into wheel movements!

### **Step 1: Connecting to the Motors**

First, the code connects to the physical motors on your robot:

```java
leftDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
rightDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
```

These lines create "remote controls" for your motors. The text `"left_front_drive"` and `"right_front_drive"` must exactly match what you named them in your Driver Hub configuration.

💡 **New concept: Hardware Mapping** - This process of connecting code variables to physical devices is called "hardware mapping" in FTC. It's how your code knows which motor to control when you write `leftDrive.setPower()`.

**📚 New to programming?** Learn about [variables and motor control](./programming-concepts.md#what-are-variables-and-what-are-the-common-types) in the Programming Concepts guide.

### **Step 2: Reading Joystick Input**

The code reads your joystick movements and stores them in variables:

```java
forward = -gamepad1.left_stick_y;
rotate  = gamepad1.right_stick_x;
```

💡 **New concept: Variables** - This is our first look at variables! Think of `forward` and `rotate` as boxes that hold numbers. The `=` sign means "put this value into the box." The joystick puts a number between -1 and +1 in each box.

- `forward`: How much you want to move forward/backward (-1 to +1)
- `rotate`: How much you want to turn left/right (-1 to +1)
- The minus sign (`-`) flips the direction because joysticks naturally give opposite values for forward/backward movement (pushing up gives a negative number, but we want positive for "forward")

### **Step 3: Calculating Motor Powers**

Here's where the arcade drive magic happens:

```java
leftPower  = forward + rotate;
rightPower = forward - rotate;
```

💡 **New concept: Math in programming** - The computer does math for us! When you push the joystick forward and right, it adds those numbers together to make the left wheel spin faster than the right wheel.

**Why this math works:**
- **Moving forward**: Both motors get the same positive power
- **Turning right**: Left motor gets more power, right motor gets less (or negative)
- **Moving forward while turning right**: Left motor gets extra power, right motor gets normal power

**Example calculation:**
```
forward = 0.5 (joystick halfway forward)
rotate = 0.3 (joystick slightly right)

leftPower = 0.5 + 0.3 = 0.8 (left wheels spin faster)
rightPower = 0.5 - 0.3 = 0.2 (right wheels spin slower)
Result: Robot moves forward while turning right!
```

### **Step 4: Power Scaling (Keeping Correct Ratios)**

Sometimes our math gives us powers greater than 1.0 or less than -1.0. Motors automatically cap these values to their -1 to 1 range, creating incorrect power ratios:

```java
max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
if (max > 1.0)
{
    leftPower /= max;
    rightPower /= max;
}
```

**What this does:**
- Finds the largest power value
- If it's over 1.0, scales both powers down proportionally
- **Example**: Without scaling, powers of 1.5 and 0.5 would become 1.0 and 0.5 (wrong ratio!)
- With scaling, they become 1.0 and 0.33 (preserving the correct 3:1 ratio)

**📚 New to programming?** Learn about [Math operations and if statements](./programming-concepts.md#if-else-statements) in the Programming Concepts guide.

### **Step 5: Sending Power to Motors**

Finally, the code tells the motors how fast to spin:

```java
leftDrive.setPower(leftPower);
rightDrive.setPower(rightPower);
```

The `.setPower()` method takes a number from -1.0 to 1.0:
- **1.0**: Full speed forward
- **0.0**: Stopped
- **-1.0**: Full speed backward

### **Motor Settings**

The code also configures how the motors behave:

```java
leftDrive.setDirection(DcMotor.Direction.FORWARD);
rightDrive.setDirection(DcMotor.Direction.REVERSE);
leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
```

**What these do:**
- **`.setDirection()`**: Fixes motors that spin backward (very common in robotics)
- **`.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)`**: Makes motors actively stop instead of coasting

## **Try It Out! Experimenting with Drive Controls**

Now let's modify the drive code to better understand how it works!

**1. Adding Drive Telemetry**

Add these lines inside your `while (opModeIsActive())` loop, right after the power calculations:

```java
telemetry.addData("Forward", forward);
telemetry.addData("Rotate", rotate);
telemetry.addData("Left Power", leftPower);
telemetry.addData("Right Power", rightPower);
```

Don't forget to make sure `telemetry.update()` is called at the end of the loop! Install the code and drive around while watching the Driver Hub screen. You'll see exactly how joystick movements translate to motor powers.

**2. Experiment with Joystick Sensitivity**

Try changing the drive equations to make the robot more or less sensitive:

```java
// More sensitive (smaller movements = bigger robot response)
leftPower  = (forward + rotate) * 1.5;
rightPower = (forward - rotate) * 1.5;

// Less sensitive (good for precise movements)
leftPower  = (forward + rotate) * 0.5;
rightPower = (forward - rotate) * 0.5;
```

**3. Try Different Control Schemes**

Replace the existing joystick reading with one of these alternatives to explore different ways of controlling your robot:

**Single-stick driving (like a car):**
```java
forward = -gamepad1.right_stick_y;
rotate  = gamepad1.right_stick_x;
```
This control scheme uses only the right joystick for all movement. Push the stick up/down to move forward/backward, and left/right to turn. This feels like driving a car or playing a racing video game - very intuitive for beginners! The left joystick becomes unused with this setup.

**Button-based turning:**
```java
forward = -gamepad1.left_stick_y;
if (gamepad1.dpad_right) {
    rotate = 0.5;  // Turn right
} else if (gamepad1.dpad_left) {
    rotate = -0.5; // Turn left
} else {
    rotate = 0;    // Go straight
}
```
This scheme uses the left joystick for forward/backward movement, but replaces joystick turning with digital buttons on the D-pad. When you press the right arrow on the D-pad, the robot turns right at a fixed speed (0.5 power). Press left arrow to turn left, or release both to go straight. This can be more precise for some drivers who prefer digital controls over analog sticks.

**True tank drive:**
```java
// Skip the arcade drive math entirely and control each side directly
leftPower = -gamepad1.left_stick_y;   // Left joystick controls left wheels
rightPower = -gamepad1.right_stick_y; // Right joystick controls right wheels

// Remove the arcade drive calculations and scaling - not needed for tank drive
// leftPower  = forward + rotate;  // Comment out or delete
// rightPower = forward - rotate;  // Comment out or delete
```
True tank drive gives each joystick direct control over one side of the robot. Push the left joystick forward to move the left wheels forward, right joystick for right wheels. To turn right, push the left joystick forward while pulling the right joystick back (or vice versa for left turns). This gives maximum control but requires more coordination from the driver. Note: You'll also want to remove or comment out the power scaling section since tank drive doesn't use the arcade math.

**Why try different schemes?**
- **Driver preference**: Some people find certain controls more comfortable
- **Precision**: Button controls can be more precise for fine movements
- **Accessibility**: Different schemes work better for drivers with different physical abilities
- **Match strategy**: Some control schemes work better for specific game tasks

**4. Understanding Motor Directions**

If your robot drives backward when you expect forward, try changing:
```java
leftDrive.setDirection(DcMotor.Direction.REVERSE);  // or FORWARD
rightDrive.setDirection(DcMotor.Direction.FORWARD); // or REVERSE
```

Test different combinations until the robot moves correctly!

**📚 New to programming?** Learn about [loops and continuous execution](./programming-concepts.md#what-while-loops) in the Programming Concepts guide.

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

## **Support & Community**

Contact me! Zoe Stalnaker, [zoe.c.stalnaker@gmail.com](mailto:zoe.c.stalnaker@gmail.com), I'm happy to answer any questions about these instructions; additionally, I'll happily accept any feedback.

The Unofficial FIRST Tech Challenge Discord, which can be joined at [https://discord.gg/ftc](https://discord.gg/ftc); this server is filled with people willing to help with any questions you have.

## **Learning More**

Learn Java for FTC

GM0

FTC sample code, [https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples](https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples)