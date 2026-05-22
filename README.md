# **Into The Deep: a guide to programming**

# **Introduction**

Hello! I'm the coder for 7604 for the 2025-2026 season, Decode. This instructional document was created for two purposes: to train future coders and to give builders basic programming knowledge.

This guide is intended to be readable for anyone, but is written with people who have vry basic programming knowledge. For those who know nothing about programming, there is an additional guide, programming-concepts, that will be linked to at the relevant points in order to learn the new concepts covered or gain a deeper knowledge!

Disclaimer: I have heavily utilized copilot in the process of making this document.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Section 0: Set Up](#section-0-set-up)
- [Section 1: Telemetry](#section-1-telemetry)
- [Section 2: The Drive Train](#section-2-the-drive-train)
- [Section 3: The Arm](#section-3-the-arm)
- [Section 4: Encoder Drive](#section-4-encoder-drive)
- [Section 5: Next Steps](#section-5-next-steps)
- [Resources](#resources)

# **Prerequisites**

- A fully assembled GoBuilda Starter Kit from the 2024-2025 Into The Deep season, found at [https://www.gobilda.com/ftc-starter-kit-2024-2025-season/](https://www.gobilda.com/ftc-starter-kit-2024-2025-season/)  
  - Assembly instructions: [https://www.gobilda.com/content/user\_manuals/starter-bot-assembly-instructions.min.pdf](https://www.gobilda.com/content/user_manuals/starter-bot-assembly-instructions.min.pdf)	  



# **Section 0: Set Up**

## **Step 1: Install Required Software**

### **1.1 Install Git**

1. Go to [https://git-scm.com/](https://git-scm.com/)  
2. Download the installer for your operating system (Windows, Mac, or Linux)
3. Run the installer and follow the setup wizard
4. For most users, the default settings are fine
5. Complete the installation

**Note:** Git is the version control system that GitHub Desktop uses under the hood. You need this installed before GitHub Desktop will work properly.

### **1.2 Install GitHub Desktop**

1. Go to [https://desktop.github.com/](https://desktop.github.com/)  
2. Download and install GitHub Desktop  
3. When GitHub Desktop opens and asks you to sign in, click **"Skip this step"** or **"Continue without signing in"**  
4. You can still clone public repositories without an account\!

**Note:** You can always sign in later if you want to contribute back to the community or create your own repositories.

### **1.3 Install Android Studio**

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

Before wiring, ensure your GoBuilda Starter Kit is fully assembled according to the official assembly instructions at [https://www.gobilda.com/ftc-starter-bot-resource-guide-into-the-deep/](https://www.gobilda.com/ftc-starter-bot-resource-guide-into-the-deep/). This section covers the electrical wiring connections.

### **3.2 Understanding the REV Control Hub**

Your robot's brain is the **REV Control Hub**, which has the following ports:

**Motor/Encoder Ports (0-3):** Four labeled ports for DC motors
- Each port accepts motor power (2-position JST VH connector) and encoder data (4-position JST XH connector)
- Labeled 0, 1, 2, and 3

**Servo Ports (0-5):** Six labeled ports for servo controls
- Each port accepts a 3-position servo connector (signal, power, ground)
- Labeled 0, 1, 2, 3, 4, and 5

**Power Port:** One large connector for battery input

**USB Port:** For code deployment and debugging

### **3.3 Motor Wiring**

The GoBuilda Starter Kit includes **4 motors total**:
- **3x Drive Motors** (19.2:1 ratio, 312 RPM) - control the wheels
- **1x Arm Motor** (50.9:1 ratio, 117 RPM) - controls the arm

**Wiring Cables Used:**
- **2-Position JST VH Connector** (motor power): Connects motor to Control Hub
- **4-Position JST PH to JST XH Encoder Cable** (600mm): Connects encoder data from motor to Control Hub

**Motor Port Assignments (Recommended):**
- **Motor Port 0:** Left Front Drive Motor
- **Motor Port 1:** Right Front Drive Motor  
- **Motor Port 2:** Left Rear Drive Motor (if your robot uses them)
- **Motor Port 3:** Arm Motor (50.9:1 ratio)

**How to Connect a Motor:**

1. **Power Connection (JST VH):**
   - The motor has a 2-position JST VH connector at the end
   - Match this to the white 2-position connector on the motor port cable
   - The connection is keyed, so it only fits one way
   - Push firmly until you hear/feel a click

2. **Encoder Connection (JST XH):**
   - The motor has a 4-position JST PH encoder connector
   - Use an encoder cable to connect this to the 4-position JST XH connector on the motor port
   - This sends position data back to the Control Hub
   - Again, it's keyed and will only fit one way

3. **Cable Management:**
   - Use zip ties to secure cables along the robot frame
   - Keep encoder cables away from moving parts
   - Avoid sharp bends that could damage the wires

⚠️ **Important:** Motor connectors are keyed and will only fit correctly. **Never force a connector** - if it doesn't slide in easily, check the alignment.

### **3.4 Servo Wiring**

The GoBuilda Starter Kit includes **4 servos total** (used for 3 mechanisms):
- **2x Intake Servo** (Continuous rotation, "Speed" model) - one spins the intake wheel
- **1x Wrist Servo** (Positional, "Torque" model) - rotates the wrist to different angles

**Wiring Cables Used:**
- **3-Position TJC8 Servo Extension Cable** (300mm or 600mm): Connects servo to Control Hub
  - White connector on one end goes to the servo
  - Black connector on the other end goes to the Control Hub servo port

**Servo Port Assignments (Recommended):**
- **Servo Port 0:** Intake Servo (continuous rotation)
- **Servo Port 1:** Wrist Servo (positional)

**How to Connect a Servo:**

1. **Servo Connector:**
   - Servos have a 3-position connector (white plastic block)
   - Match this with the white end of the servo extension cable
   - The red wire is power, black is ground, yellow/white is signal
   - Keyed connectors will only fit correctly

2. **Control Hub Connection:**
   - Plug the black connector end into the servo port on the Control Hub
   - The three wires connect to: Power (red), Ground (black), Signal (yellow/white)

3. **Cable Management:**
   - Keep servo cables organized and labeled with tape or markers
   - Servos can generate heat, so avoid bundling cables too tightly
   - Route cables away from moving mechanical parts

🔌 **Connector Identification:**
- **Servo connectors (TJC8):** 3-position, looks like small white/black plastic blocks
- **Motor power (JST VH):** 2-position, white connector
- **Encoder (JST XH):** 4-position, part of the motor port cable assembly

### **3.5 Battery Wiring**

Your robot uses a **12V NiMH Battery** (3000mAh, XT30 connector).

**Battery Connector:**
- The battery has an **XT30 connector** (two small gold pins)
- Compatible with **JST VH converters** that come with the kit
- Color coding: Red wire = Positive (+), Black wire = Negative (-)

**How to Connect the Battery:**

1. **Battery to Adapter:**
   - Connect the battery's XT30 connector to the JST VH adapter (included in kit)
   - This gives you standard JST VH connectors for Control Hub compatibility

2. **Adapter to Control Hub:**
   - Connect the adapter's JST VH connector to the power port on the Control Hub
   - **Important:** The power port is located separately from motor/servo ports
   - Red wire must connect to positive (+) terminal, black to negative (-)

**Charging the Battery:**
- Use the provided NiMH battery charger (included with kit)
- Charge overnight before your first use
- Check battery voltage regularly during competition season

⚠️ **Critical Safety Notes:**
- **Never disconnect the battery while the robot is powered on**
- **Don't short the battery terminals** - this can cause damage or fire
- **Disconnect the battery when not in use** to preserve charge and prevent safety issues
- **Store battery in a cool, dry place**
- **Never leave a charging battery unattended**

### **3.6 Encoder Cable Routing**

Encoder cables are critical for precise motor control. Proper routing prevents damage:

**Best Practices:**
- Run encoder cables separately from power cables when possible
- Keep encoder cables away from high-current areas
- Don't pinch or bend encoder cables sharply
- Use protective conduit for cables running through tight spaces
- Label each encoder cable with the motor it connects to

**Why Encoders Matter:**
- Encoders count motor rotations to determine exact position
- Used for autonomous movement and precise arm positioning
- Damaged encoder cables will cause the robot to malfunction

### **3.7 Quick Wiring Checklist**

Before moving on, verify:

**Motors:**
- [ ] Left drive motor connected to Motor Port 0
- [ ] Right drive motor connected to Motor Port 1
- [ ] Arm motor connected to Motor Port 3
- [ ] All motor power connectors fully seated
- [ ] All encoder cables fully connected

**Servos:**
- [ ] Intake servo connected to Servo Port 0
- [ ] Wrist servo connected to Servo Port 1
- [ ] All servo connectors fully seated
- [ ] No servo cables pinched or twisted

**Battery & Power:**
- [ ] Battery connected to Control Hub power port
- [ ] Power connection secure and correct polarity (red to +, black to -)
- [ ] No exposed wires

**Cable Management:**
- [ ] All cables secured with zip ties
- [ ] No cables blocking robot movement
- [ ] Cables labeled where appropriate
- [ ] No sharp bends or pinches

**💡 Important:** Take note of which port numbers your motors and servos are connected to - you'll need this information for the configuration step!

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
   - Enter the password, "password", which is the default for the WiFi
   - Wait for the connection status to show green

**✅ Verification:** If connected successfully, you should see the robot's name displayed in red text on the WiFi Settings page.

### **4.2 Configure Hardware and Motors**
1. **Access Robot Controller**: On the Driver Hub, open the "FTC Robot Controller" app
2. **Start Configuration**:
   - Touch the three dots (⋮) in the upper right corner
   - Select "Configure Robot"
   - If no configuration exists, touch "New"
   - Touch "Control Hub Portal"
   - Touch "Control Hub"
3. **Access Motors**: Touch "Motors" to access the motor configuration screen
4. **Configure Drive Motors**:
   - Touch the port number where your left drive motor is connected
   - Select "GoBuilda 5203 Series Motor" from the list (this is the motor type used in the starter kit)
   - Name it exactly `left_front_drive` (this must match the code)
   - Touch "Done"
   - Repeat for the right drive motor, naming it exactly `right_front_drive`
5. **Configure Arm Motor**:
   - Touch the port number where your arm motor is connected
   - Select "GoBuilda 5203 Series Motor" from the list (this is the motor type used in the starter kit)
   - Name it exactly `left_arm`
   - Touch "Done"

### **4.3 Configure Servos**

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

### **4.4 Save Configuration**
1. **Save**: Touch "Save" to save your configuration and name your config (e.g., "GoBuilda Starter Kit")
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
   - If using a macbook, an adaptor is needed as this cable must go from USB-C to USB-A
3. **Wait for connection**: The robot should appear as a connected device at the top of Android Studio
   - Look for the device name in the device dropdown (usually shows as something like "Control Hub")

NOTE FROM WILL: Probably should describe the device once it plugs in. It shows up as a file, but has a little phone icon. 
NOTE TO WILL: this doesn't happen on my windows laptop so idk what u want me to say

NOTE FROM WILL: Another weird discontinuity imo. 

NOTE FROM WILL: Photos/gifs would work great here this is not intuitive.

### **5.2 Deploy the Code**
1. **Click the green "Run" button** in Android Studio
   - This is typically a play icon (▶) but may appear as a replay icon (↻) depending on your Android Studio version
2. **Wait for the build process** (should take approximately 15 seconds):
   - First notification: "Build finished" 
   - Second notification: "Install finished"
   - ⚠️ **Important**: while the build notification may not always happen, you must wait for the install finished notification before proceeding
   - If the build takes longer than 120 seconds, consider restarting the process
3. **Handle connection issues** (if applicable):
   - If the connection drops during installation, unplug the USB cable and plug it back in
   - Retry the deployment process
4. **Disconnect the USB cable** once installation is complete
   - ⚠️ **Important**: Wait for "Install finished" message, not "Build finished" message, to unplug
5. **Verify success**: If no error messages appeared, the code installed correctly!

**💡 Troubleshooting**: If you get errors, verify that:
- The Control Hub is powered on and connected
- The USB cable is properly seated at both ends
- You waited for both "Build finished" and "Install finished" notifications
- If problems persist, restart Android Studio and try again

## **Step 6: Test Drive**

### **6.1 Initial Setup**
1. **Ensure the robot is powered on** (battery connected and Control Hub LED is green)
2. **Power on the Driver Hub device** and ensure it's charged
3. **Open the FTC Driver Station app** (if not already open from earlier steps)
4. **Connect to the robot**: The Driver Hub should automatically detect and connect to the Control Hub via WiFi - you should see the connection status change to green

### **6.1b Controller Initialization**

Before you can control the robot, the gamepad controllers need to be set up and initialized:

1. **Plug in the controllers**:
   - Connect the gamepad controller(s) to the Driver Hub using USB cables
   - Most gamepads use USB-C or standard USB connections
   - Wait a moment for the Driver Hub to recognize the controllers
   - You should see the controller(s) appear in the Driver Station app

2. **Initialize the controller(s)**:
   - **For Player 1**: Press **START + A** on the gamepad simultaneously
   - **For Player 2** (if using two controllers): Press **START + B** on the second gamepad
   - You should see a confirmation on the Driver Hub screen when each controller is initialized
   - Both controllers should now show "Ready" status

⚠️ **Common Issue - Controller Not Responding:**
If your controller is plugged in but not responding to input:
1. **Unplug the controller** from the Driver Hub
2. **Plug the controller back in** and initialize again (START + A or START + B)

💡 **Tip**: If you're having persistent controller issues, make sure you're pressing START + A (or B) firmly and simultaneously - timing matters!

### **6.2 Select and Run Your Program**
1. **Select your TeleOp program**:
   - On the left side of Driver Station, find two dropdown arrows
   - **Left arrow**: Autonomous programs
   - **Right arrow**: TeleOp programs
   - Click the **right arrow** and select **"Blank_Slate_Code"**

**📝 Note on Code Files:**
- **Blank_Slate_Code**: This is the original, unaltered working code on the robot. Use this as your baseline reference.
- **Code_Here**: This is the file you should use for editing and making changes. If your code breaks or you want a fresh start, you can copy everything from Blank_Slate_Code back into Code_Here to reset.

2. **Initialize the program**: Press the **"INIT"** button
3. **Start**: Press the **"▶ START"** button when ready

⚠️ **Configuration Mismatch Troubleshooting**: If the robot doesn't respond to controls or motors don't spin:
   - Go back to Step 4 (Configuring the Driver Hub) and double-check that your hardware names exactly match:
     - Code names: `left_front_drive`, `right_front_drive`, `left_arm`, `intake`, `wrist`
     - Configuration names: Must match EXACTLY (case-sensitive)
   - If names don't match, the code won't be able to find the hardware, causing errors or no response

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

### **6.5 ⚠️ Important Safety Information**

**Wrist Servo Initialization**: When the robot powers on, the wrist servo will snap into position automatically. Keep hands and fingers clear of the wrist servo area during startup to avoid pinching or contact.

**General Robot Safety**:
- **Moving parts**: The robot has continuously spinning intake motors and moving arm joints. Keep long hair, loose clothing, and fingers away from these moving parts
- **Arm movement**: The arm can move quickly and has significant force. Never place your hands under or near the arm while it's operating
- **Motor power**: Even at low power settings, motors can pinch fingers or snag clothing. Treat the robot with the same caution you'd give a drill press or power tool
- **Battery safety**: Never touch the battery terminals or expose the battery to water or damage
- **During testing**: Always have a clear area around the robot and keep people at a safe distance when testing

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

**📚 New to programming?** Check out our detailed explanation of [while loops](./programming-concepts.md#what-are-while-loops) in the Programming Concepts guide.

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

# **Section 3: The Arm**

## **What is Arm Control?**

The GoBuilda Starter Kit includes a sophisticated arm system that can pick up, move, and place game pieces with precision. The arm system combines motor-controlled positioning with servo-controlled mechanisms to create a versatile manipulation system.

**In the real world**, robotic arm systems are everywhere:
- **Manufacturing**: Industrial robots assemble cars, electronics, and machinery with incredible precision
- **Medical devices**: Surgical robots assist doctors in delicate operations
- **Space exploration**: Mars rovers use robotic arms to collect samples and operate scientific instruments
- **Logistics**: Warehouse robots pick and place packages for automated fulfillment
- **Food service**: Some restaurants use robotic arms for food preparation and serving

**In FTC robotics**, arm control is essential for manipulating game pieces during both TeleOp and Autonomous modes. It's the key to scoring points and completing game-specific tasks.

### What Does Arm Control Look Like?
When you operate the arm system, your robot will respond to specific gamepad inputs:
```
Driver presses RIGHT BUMPER button
→ Robot: Arm rotates to collection angle + wrist extends + intake activates
→ Result: Robot is ready to pick up game pieces from the ground

Driver presses Y button  
→ Robot: Arm rotates to scoring angle + wrist positions for release + stops intake
→ Result: Robot is positioned to score game pieces in the high goal
```

**Key point:** With just a single button press on your gamepad controller, the robot automatically coordinates multiple components (arm motor, wrist servo, and intake servo) to achieve complex positioning. This makes driving much easier since you don't have to manually control each component separately!

This gives you precise, repeatable positioning for consistent game piece manipulation!

## **Understanding the Arm System**

Before we can control the arm effectively, we need to understand the different components and how they work together.

### **What are the Arm Components?**

The GoBuilda Starter Kit arm system consists of three main components:

**1. Arm Motor (Rotational Joint)**
- A motor that rotates the entire arm up and down
- Uses encoders for precise angle positioning
- Controlled with target positions rather than continuous power

**2. Wrist Servo (Positioning Servo)**  
- A servo that positions the wrist/end effector
- Moves to specific angles between 0° and 180°
- Used to orient the intake for different tasks

**3. Intake Servo (Continuous Rotation Servo)**
- A servo that spins continuously to collect or eject game pieces
- Can spin forward, backward, or stop completely
- Controlled with power values like a motor

### **What Does Arm Data Look Like?**
When you run your robot and check arm values, you might see:
```
Arm Target: 1,250 ticks (about 45 degrees up)
Arm Current: 1,247 ticks (almost at target)
Wrist Position: 0.5 (middle position)
Intake Power: -1.0 (collecting at full speed)
```
Each value represents the current state of that arm component!

### **Converting Between Angles and Encoder Ticks**

The key to arm control is understanding how motor encoder ticks relate to arm angles. For the GoBuilda arm motor:

**Arm Motor Calculation:**
- **Motor**: GoBuilda 5203 Series with gearing
- **Total gear ratio**: Complex chain and gear reduction
- **Ticks per degree**: Approximately 19.7 ticks per degree of arm rotation

**The math:**
```
ARM_TICKS_PER_DEGREE = 28 * 250047.0/4913.0 * 100.0/20.0 * 1/360.0
This equals approximately 19.7 ticks per degree

To move arm to 45 degrees:
Required ticks = 45 degrees × 19.7 ticks/degree = 887 ticks
```

💡 **New concept: Servo positions** - Unlike motors that use encoder ticks, servos use position values from 0.0 to 1.0, where 0.0 is one extreme, 1.0 is the other extreme, and 0.5 is the middle position.

## **Arm Control in the Code**

Let's explore how the code controls each component of the arm system to create coordinated movement.

### **What Does Arm Code Look Like?**
When you run your robot code and look at the arm control sections, you'll see patterns like this:
```java
if (gamepad1.right_bumper) {
    armPosition = ARM_COLLECT;              // Set arm angle
    wrist.setPosition(WRIST_FOLDED_OUT);    // Position wrist  
    intake.setPower(INTAKE_COLLECT);        // Start intake
}
```
This is your robot coordinating multiple mechanisms with a single button press!

### **Step 1: Connecting to the Arm Hardware**

First, the code connects to the physical arm components:

```java
armMotor = hardwareMap.get(DcMotor.class, "left_arm");
intake = hardwareMap.get(CRServo.class, "intake");
wrist = hardwareMap.get(Servo.class, "wrist");
```

These lines create "remote controls" for your arm components. The text names must exactly match your Driver Hub configuration.

💡 **Important distinction: Different hardware types** - Notice we use `DcMotor` for the arm (precise positioning), `CRServo` for the intake (continuous rotation), and `Servo` for the wrist (precise angles). Each hardware type has different capabilities and control methods, so choosing the right type for each component is crucial for proper robot control.

### **Step 2: Setting Up Arm Constants**

The code defines specific positions for different arm tasks:

```java
final double ARM_COLLAPSED_INTO_ROBOT  = 0;
final double ARM_COLLECT               = 250 * ARM_TICKS_PER_DEGREE;
final double ARM_CLEAR_BARRIER         = 230 * ARM_TICKS_PER_DEGREE;
final double ARM_SCORE_SPECIMEN        = 160 * ARM_TICKS_PER_DEGREE;
final double ARM_SCORE_SAMPLE_IN_LOW   = 160 * ARM_TICKS_PER_DEGREE;
final double ARM_ATTACH_HANGING_HOOK   = 120 * ARM_TICKS_PER_DEGREE;
final double ARM_WINCH_ROBOT           = 15  * ARM_TICKS_PER_DEGREE;
```

💡 **Why use named positions?** - Instead of remembering that "4930 ticks means collection position," we can write `ARM_COLLECT` and the computer knows exactly what we mean. This makes the code much easier to read and modify.

**What each position does:**
- **ARM_COLLAPSED_INTO_ROBOT**: Arm folded completely inside the robot's frame
- **ARM_COLLECT**: Arm positioned to collect game pieces from the ground  
- **ARM_CLEAR_BARRIER**: Arm high enough to drive over field barriers
- **ARM_SCORE_SPECIMEN**: Arm positioned to hang specimens on the submersible
- **ARM_SCORE_SAMPLE_IN_LOW**: Arm angled to score samples in the low basket
- **ARM_ATTACH_HANGING_HOOK**: Arm positioned to attach the hanging hook
- **ARM_WINCH_ROBOT**: Arm positioned for end-game hanging

### **Step 3: Configuring the Arm Motor**

The arm motor uses special settings for precise control:

```java
armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
armMotor.setTargetPosition(0);
armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
```

**What these do:**
- **BRAKE**: Motor actively holds position when power is zero (prevents arm from falling)
- **setTargetPosition(0)**: Initially target the starting position  
- **RUN_TO_POSITION**: Motor automatically moves to target positions
- **STOP_AND_RESET_ENCODER**: Set the current position as the zero reference point

### **Step 4: Servo Control**

The wrist and intake servos are controlled differently:

```java
// Wrist servo positions (0.0 to 1.0)
final double WRIST_FOLDED_IN   = 0.8333;  // Wrist folded into robot
final double WRIST_FOLDED_OUT  = 0.5;     // Wrist extended for collection

// Intake servo powers (-1.0 to 1.0)  
final double INTAKE_COLLECT    = -1.0;    // Full speed inward
final double INTAKE_OFF        =  0.0;    // Stopped
final double INTAKE_DEPOSIT    =  0.5;    // Half speed outward
```

💡 **New concept: Servo vs Motor control** - Servos use `.setPosition()` for angles and `.setPower()` for continuous rotation, while motors use `.setTargetPosition()` and `.setPower()` for precise positioning.

### **Step 5: Coordinated Arm Control**

The magic happens when multiple arm components work together:

```java
if (gamepad1.right_bumper) {
    armPosition = ARM_COLLECT;
    wrist.setPosition(WRIST_FOLDED_OUT);
    intake.setPower(INTAKE_COLLECT);
}
```

**What this accomplishes:**
- **Sets arm angle** to collection position
- **Extends wrist** to reach game pieces on the ground
- **Starts intake** to pull in game pieces
- **All with one button press!**

### **Step 6: Fine Adjustment Control**

The triggers provide manual fine-tuning:

```java
armPositionFudgeFactor = FUDGE_FACTOR * (gamepad1.right_trigger + (-gamepad1.left_trigger));
armMotor.setTargetPosition((int) (armPosition + armPositionFudgeFactor));
```

💡 **New concept: Fine adjustment** - Sometimes preset positions aren't perfect for every situation. The triggers let drivers make small adjustments (+/- 15 degrees) to dial in the exact position needed.

**📚 New to programming?** Learn about [math operations and trigger controls](./programming-concepts.md#what-are-gamepad-inputs) in the Programming Concepts guide.

## **Try It Out! Experimenting with Arm Control**

Now let's modify the arm code to better understand how each component works!

**1. Adding Arm Telemetry**

Add these lines inside your `while (opModeIsActive())` loop to monitor arm status:

```java
telemetry.addData("Arm Target", armMotor.getTargetPosition());
telemetry.addData("Arm Current", armMotor.getCurrentPosition());
telemetry.addData("Wrist Position", wrist.getPosition());
telemetry.addData("Intake Power", intake.getPower());
telemetry.addData("Arm at Target", !armMotor.isBusy());
```

Install the code and operate the arm while watching the Driver Hub screen. You'll see exactly how each component responds to your inputs!

**2. Test Individual Components**

Try controlling each arm component separately to understand their behavior:

**Test the arm motor only:**
```java
if (gamepad1.dpad_up) {
    armPosition = ARM_CLEAR_BARRIER;  // Just move the arm
}
else if (gamepad1.dpad_down) {
    armPosition = ARM_COLLAPSED_INTO_ROBOT;  // Just move the arm
}
```

**Test the wrist servo only:**
```java
if (gamepad1.x) {
    wrist.setPosition(WRIST_FOLDED_OUT);  // Just move the wrist
}
else if (gamepad1.y) {
    wrist.setPosition(WRIST_FOLDED_IN);   // Just move the wrist  
}
```

**Test the intake servo only:**
```java
if (gamepad1.left_bumper) {
    intake.setPower(INTAKE_COLLECT);      // Just run the intake
}
else if (gamepad1.right_bumper) {
    intake.setPower(INTAKE_OFF);          // Just stop the intake
}
```

**3. Create Custom Arm Positions**

Try defining your own arm positions for specific tasks:

```java
// Add these with the other arm constants
final double ARM_CUSTOM_LOW    = 100 * ARM_TICKS_PER_DEGREE;  // Custom low position
final double ARM_CUSTOM_HIGH   = 200 * ARM_TICKS_PER_DEGREE;  // Custom high position

// Add this in your control section
if (gamepad1.left_stick_button) {
    armPosition = ARM_CUSTOM_LOW;
    wrist.setPosition(0.3);  // Custom wrist angle
}
else if (gamepad1.right_stick_button) {
    armPosition = ARM_CUSTOM_HIGH;
    wrist.setPosition(0.7);  // Different custom wrist angle
}
```

**4. Experiment with Intake Speeds**

Try different intake speeds for different tasks:

```java
if (gamepad1.a) {
    intake.setPower(-0.5);    // Gentle collection
}
else if (gamepad1.b) {
    intake.setPower(-1.0);    // Aggressive collection
}
else if (gamepad1.x) {
    intake.setPower(0.3);     // Gentle ejection
}
else if (gamepad1.y) {
    intake.setPower(1.0);     // Aggressive ejection
}
```

**5. Understanding Arm Safety**

The arm motor includes current limiting for safety:

```java
if (((DcMotorEx) armMotor).isOverCurrent()) {
    telemetry.addLine("MOTOR EXCEEDED CURRENT LIMIT!");
}
```

This protects the motor if the arm gets stuck or encounters unexpected resistance.

**Why this matters:**
- **Hardware protection**: Prevents motor damage from excessive load
- **Competition reliability**: Avoids robot failures during matches
- **Safety**: Stops dangerous situations if something goes wrong

## **Understanding Coordinated Motion**

One of the most powerful aspects of the arm system is how multiple components work together seamlessly. Let's examine how the preset positions create coordinated behaviors.

### **Collection Sequence (Right Bumper)**
```java
if (gamepad1.right_bumper) {
    armPosition = ARM_COLLECT;
    wrist.setPosition(WRIST_FOLDED_OUT);
    intake.setPower(INTAKE_COLLECT);
}
```

**What happens:**
1. **Arm rotates down** to collection angle (near the ground)
2. **Wrist extends** to position intake over game pieces  
3. **Intake starts spinning** to pull in game pieces
4. **Driver can now drive** around to collect items

### **Stowing Sequence (D-Pad Left)**
```java
else if (gamepad1.dpad_left) {
    armPosition = ARM_COLLAPSED_INTO_ROBOT;
    intake.setPower(INTAKE_OFF);
    wrist.setPosition(WRIST_FOLDED_IN);
}
```

**What happens:**
1. **Arm folds completely** into the robot frame
2. **Intake stops** to conserve power and avoid accidents
3. **Wrist retracts** to fit within robot dimensions
4. **Robot becomes compact** for driving and maneuvering

### **Scoring Sequence (Y Button)**
```java
else if (gamepad1.y) {
    armPosition = ARM_SCORE_SAMPLE_IN_LOW;
}
```

**What happens:**
1. **Arm rotates up** to the correct angle for the low basket
2. **Wrist stays** in its current position (usually extended)
3. **Intake can be activated** later to eject the game piece
4. **Driver positions robot** and then activates intake to score

💡 **Why coordinate multiple components?** - Real-world tasks require multiple actions happening together. Instead of making the driver control each component separately (which is slow and error-prone), coordinated sequences make complex operations simple and consistent.

## **Understanding the Bigger Picture**

Congratulations! You've learned the fundamentals of robotic arm control. Here's what you've accomplished:

**Core Concepts Mastered:**
- **Motor positioning**: Using encoders for precise arm angles
- **Servo control**: Positioning wrists and controlling continuous rotation
- **Coordinated motion**: Making multiple components work together
- **Preset positions**: Creating reliable, repeatable arm configurations
- **Fine adjustment**: Manual tweaking for perfect positioning

**This opens the door to:**
- **Autonomous arm control**: Moving the arm to precise positions without driver input
- **Complex sequences**: Chaining multiple arm movements together
- **Game-specific strategies**: Optimizing arm positions for scoring and collection
- **Advanced control**: Learning about feedback systems and motion profiles

**Next steps you could explore:**
- **Autonomous arm sequences**: Move the arm to specific positions during autonomous
- **Vision-guided control**: Use cameras to automatically position the arm over targets
- **Multi-step operations**: Create sequences that combine driving and arm movement
- **Advanced sensors**: Add limit switches or force sensors for more sophisticated control

You now understand the same principles that power industrial robots, medical devices, and space exploration equipment!

# **Section 4: Encoder Drive**

## **What is Encoder Drive?**

Encoder drive is a method of making your robot move precise distances automatically. Instead of just saying "drive forward for 2 seconds and hope for the best," encoder drive lets you say "drive forward exactly 12 inches" with remarkable accuracy.

**In the real world**, encoder-based movement is everywhere:
- **Elevators**: Know exactly which floor they're on and stop precisely at each level
- **3D Printers**: Move the print head to exact positions to create detailed objects
- **Factory robots**: Position parts with millimeter precision for assembly
- **Self-driving cars**: Track exactly how far they've traveled for navigation
- **Medical equipment**: MRI machines position patients with extreme accuracy

**In FTC robotics**, encoder drive is essential for autonomous programs where your robot must complete tasks without human control. It's the foundation for precise, repeatable robot movement.

### What Does Encoder Drive Look Like?
When you use encoder drive, your robot will:
```
Command: "Drive forward 12 inches"
Robot: Calculates that 12 inches = 1,000 encoder ticks
Robot: Drives forward, counting ticks: 100... 500... 900... 1,000 - STOP!
Result: Robot has moved exactly 12 inches forward
```
This gives you the precision needed for autonomous challenges!

## **Understanding Encoders**

Before we can make the robot drive precise distances, we need to understand what encoders are and how they work.

### **What is an Encoder?**

An encoder is like a digital odometer for your motors. Just like your car's odometer (the gauge that shows how many miles your car has driven) counts distance, an encoder counts how many times your motor shaft has rotated.

**How encoders work:**
- Inside each motor, there's a sensor that detects rotation
- Every time the motor shaft turns a tiny amount, the encoder adds 1 to its count
- These individual counts are called "ticks" or "counts"
- By counting ticks, we can calculate exactly how far the robot has moved

### **What Does Encoder Data Look Like?**
When you run your robot and check encoder values, you might see:
```
Left Drive Encoder: 1,247 ticks
Right Drive Encoder: 1,251 ticks
Arm Encoder: 892 ticks
```
Each number represents how far that motor has rotated since the robot started!

### **Converting Ticks to Distance**

The key to encoder drive is converting between encoder ticks and real-world distances. For the GoBuilda motors in your starter kit:

**Drive Motor Calculation:**
- **Motor**: GoBuilda 5202 Series (312 RPM)
- **Ticks per rotation**: 537.7 ticks
- **Wheel diameter**: 96mm (about 3.78 inches)
- **Wheel circumference**: 96mm × π = 301.6mm (about 11.87 inches)

**The math:**
```
Distance per tick = Wheel circumference ÷ Ticks per rotation
Distance per tick = 11.87 inches ÷ 537.7 ticks = 0.022 inches per tick

To drive 12 inches:
Required ticks = 12 inches ÷ 0.022 inches per tick = 545 ticks
```

💡 **New concept: Constants in programming** - We'll store these calculations as constants (fixed numbers) at the top of our code so we can reuse them easily.

**📚 New to programming?** Learn about [constants and calculations](./programming-concepts.md#what-are-constants-and-calculations) in the Programming Concepts guide.

## **Understanding Autonomous Mode**

So far, we've only worked with TeleOp (Teleoperated) mode where a human driver controls the robot. Now we're going to learn about Autonomous mode, where the robot operates completely on its own.

### **What is Autonomous Mode?**

Autonomous mode is a 30-second period at the start of FTC matches where robots must complete tasks without any human input. Your robot follows a pre-programmed sequence of movements and actions.

**In the real world**, autonomous systems are everywhere:
- **Roomba vacuum cleaners**: Navigate and clean rooms without human control
- **Autopilot systems**: Keep airplanes on course during long flights
- **Manufacturing robots**: Assemble products following precise sequences
- **Space missions**: Mars rovers operate autonomously due to communication delays with Earth
- **Warehouse robots**: Amazon's robots move inventory without human guidance

**In FTC competitions**, autonomous mode is crucial:
- **30 seconds**: Your robot has half a minute to complete its programmed tasks
- **No driver input**: Once you press START, you can only watch (though you can press STOP to end early if needed)
- **High scoring**: Autonomous tasks often award more points than TeleOp
- **Consistency**: A good autonomous program works the same way every time

### **Autonomous vs TeleOp Programming**

The code structure is different between the two modes:

**TeleOp structure:**
```java
while (opModeIsActive()) {
    // Read gamepad input
    // Update motor powers based on joysticks
    // This loop runs continuously during the match
}
```

**Autonomous structure:**
```java
// Step 1: Drive forward 12 inches
// Step 2: Turn left 90 degrees  
// Step 3: Drive forward 6 inches
// Step 4: Lower arm and score
// Code runs once, then stops
```

💡 **Sequential vs Continuous** - TeleOp runs in a continuous loop responding to driver input, while Autonomous follows a step-by-step sequence that runs once.

## **Encoder Drive in the Code**

Let's build an autonomous program that drives the robot forward exactly 12 inches. We'll add this code to create a simple but effective autonomous program.

### **Step 1: Setting Up Constants**

First, we'll add the encoder calculations to our code. These go at the top with the other constants:

```java
// Encoder drive constants
final double TICKS_PER_INCH = 537.7 / (3.78 * Math.PI);  // About 45.3 ticks per inch
final double DRIVE_SPEED = 0.5;  // Motor power for autonomous driving
```

💡 **Why use constants?** - Instead of remembering that "45.3 ticks equals one inch," we can just write `TICKS_PER_INCH` and the computer remembers for us! Plus, if we need to adjust this value later, we only change it in one place and it updates everywhere in our code.

### **Step 2: Creating Encoder Drive Methods**

We'll create a special method (function) that handles driving specific distances:

```java
public void driveForward(double inches) {
    // Calculate how many ticks we need to travel
    int targetTicks = (int)(inches * TICKS_PER_INCH);
    
    // Reset encoder counts to zero
    leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    
    // Set target positions
    leftDrive.setTargetPosition(targetTicks);
    rightDrive.setTargetPosition(targetTicks);
    
    // Switch to RUN_TO_POSITION mode
    leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    
    // Start driving
    leftDrive.setPower(DRIVE_SPEED);
    rightDrive.setPower(DRIVE_SPEED);
    
    // Wait until we reach the target
    while (opModeIsActive() && 
           (leftDrive.isBusy() || rightDrive.isBusy())) {
        
        // Display progress
        telemetry.addData("Target", targetTicks);
        telemetry.addData("Left Position", leftDrive.getCurrentPosition());
        telemetry.addData("Right Position", rightDrive.getCurrentPosition());
        telemetry.update();
    }
    
    // Stop driving
    leftDrive.setPower(0);
    rightDrive.setPower(0);
}
```

**💡 Where does this method go in your code?**

The `driveForward` method should be placed **inside your class but outside the `runOpMode()` method**. Here's the correct structure:

```java
@Autonomous(name="My First Autonomous", group="Robot")
public class MyFirstAutonomous extends LinearOpMode {
    
    // Hardware declarations
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    
    // Constants
    final double TICKS_PER_INCH = 537.7 / (3.78 * Math.PI);
    final double DRIVE_SPEED = 0.3;
    
    // PUT THE driveForward METHOD HERE
    public void driveForward(double inches) {
        // ... method code goes here
    }
    
    @Override
    public void runOpMode() {
        // ... your autonomous program goes here
    }
}
```

**Key placement rules:**
- **Inside the class** (between the opening `{` after the class name and the closing `}` at the end)
- **Outside the runOpMode() method** (before the `@Override` line)
- **After your hardware declarations and constants** (keeps your code organized)

💡 **New concept: Custom methods** - This is our first time creating our own method! Think of `driveForward()` as a new command we're teaching the robot. Once we define it, we can use `driveForward(12)` to drive 12 inches anytime we want.

**📚 New to programming?** Learn about [creating your own methods](./programming-concepts.md#how-do-i-create-my-own-methods) in the Programming Concepts guide.

### **Step 3: Understanding Motor Modes**

The code above uses special motor modes that make encoder drive possible:

```java
// STOP_AND_RESET_ENCODER: Sets the encoder count back to zero
leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

// RUN_TO_POSITION: Motor automatically drives to a target position
leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

// Set where we want the motor to go
leftDrive.setTargetPosition(targetTicks);
```

**What these modes do:**
- **STOP_AND_RESET_ENCODER**: Like pressing "trip reset" on your car's odometer - sets the count back to 0
- **RUN_TO_POSITION**: Motor becomes smart - it automatically adjusts power to reach the target position
- **setTargetPosition()**: Tells the motor "go to this encoder position"
- **isBusy()**: Returns true if the motor is still moving toward its target

### **Step 4: The Complete Autonomous Program**

Here's how your autonomous program would look:

```java
@Override
public void runOpMode() {
    // Initialize hardware (same as TeleOp)
    leftDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
    rightDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
    
    leftDrive.setDirection(DcMotor.Direction.FORWARD);
    rightDrive.setDirection(DcMotor.Direction.REVERSE);
    
    leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    
    // Tell driver we're ready
    telemetry.addLine("Autonomous Ready - Robot will drive 12 inches forward");
    telemetry.update();
    
    waitForStart();
    
    // THE AUTONOMOUS SEQUENCE
    if (opModeIsActive()) {
        driveForward(12);  // Drive forward exactly 12 inches
        
        telemetry.addLine("Autonomous Complete!");
        telemetry.update();
    }
}
```

💡 **Sequential execution** - Notice how different this is from TeleOp! There's no `while` loop. The robot executes each command once in order, then stops.

## **Try It Out! Building Your First Autonomous**

Now let's create and test your autonomous program!

**1. Creating an Autonomous OpMode**

Create a new file called `MyFirstAutonomous.java` in your TeamCode folder. Here's the basic structure:

```java
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="My First Autonomous", group="Robot")
public class MyFirstAutonomous extends LinearOpMode {
    
    // Hardware
    public DcMotor leftDrive   = null;
    public DcMotor rightDrive  = null;
    
    // Constants
    final double TICKS_PER_INCH = 537.7 / (3.78 * Math.PI);
    final double DRIVE_SPEED = 0.3;  // Start with slow, safe speed
    
    // Your driveForward method goes here
    // Your runOpMode method goes here
}
```

**2. Test with Telemetry First**

Before making the robot move, let's verify our encoder readings:

```java
// Add this to your autonomous program after waitForStart()
while (opModeIsActive()) {
    telemetry.addData("Left Encoder", leftDrive.getCurrentPosition());
    telemetry.addData("Right Encoder", rightDrive.getCurrentPosition());
    telemetry.addData("Push robot to see encoder changes", "");
    telemetry.update();
    sleep(100);  // Update 10 times per second
}
```

**Install this code and manually push your robot around while watching the Driver Hub. You should see the encoder numbers change as the wheels rotate!**

**3. Test Short Distances**

Start with a very short distance to make sure everything works:

```java
driveForward(3);  // Just 3 inches to start
```

**4. Measure and Verify**

Use a ruler or measuring tape to check if your robot actually moved 3 inches. If it's off, you might need to adjust your `TICKS_PER_INCH` constant.

**5. Scale Up**

Once 3 inches works correctly, try your 12-inch target:

```java
driveForward(12);  // Full 12 inches
```

**6. Add More Movements**

Try creating a simple autonomous routine:

```java
if (opModeIsActive()) {
    driveForward(12);    // Go forward 12 inches
    sleep(1000);         // Wait 1 second
    driveForward(-6);    // Back up 6 inches
    
    telemetry.addLine("Autonomous sequence complete!");
    telemetry.update();
}
```

💡 **New concept: sleep() method** - The `sleep(1000)` command tells the robot to pause and do nothing for a specified amount of time. The number in parentheses is in milliseconds, so `sleep(1000)` means "wait for 1,000 milliseconds" or "wait for 1 second." This is useful in autonomous programs when you want to add pauses between actions, like waiting for a mechanism to settle or creating a timed delay.

⚠️ **Important safety note:** The `sleep()` command pauses ALL code execution, meaning your robot cannot respond to anything during the sleep period - not even emergency stops or safety checks. Use sleep sparingly and only for short periods in autonomous mode. Never use long sleep commands, and avoid sleep entirely in TeleOp programs where the driver needs continuous control.

**Troubleshooting Tips:**
- **Robot doesn't move**: Check that your motor directions are correct
- **Wrong distance**: Adjust the `TICKS_PER_INCH` value up or down
- **Veering left/right**: Your motors might have slightly different speeds, or your robot may have weight imbalances, wheel differences, or mechanical variations - this is completely normal for basic encoder drive and happens even with professional robots

💡 **Why start slow?** - Using `DRIVE_SPEED = 0.3` gives you more control and makes it easier to see what's happening. You can increase speed once everything works correctly.

**📚 New to programming?** Learn about [program flow and debugging](./programming-concepts.md#what-is-program-flow-and-debugging) in the Programming Concepts guide.

## **Understanding the Bigger Picture**

Congratulations! You've just learned the foundation of autonomous robot programming. Here's what you've accomplished:

**Core Concepts Mastered:**
- **Encoder counting**: Understanding how motors track their position
- **Distance calculation**: Converting between real distances and encoder ticks  
- **Motor modes**: Using RUN_TO_POSITION for automatic control
- **Sequential programming**: Writing step-by-step autonomous routines
- **Custom methods**: Creating reusable functions for common tasks

**This opens the door to:**
- **Complex autonomous routines**: Multi-step sequences with turns, arm movements, and scoring
- **Competition autonomous**: Scoring points automatically during the first 30 seconds
- **Precision control**: Exact positioning for delicate tasks
- **Repeatable performance**: Your autonomous works the same way every time

**Next steps you could explore:**
- **Turning**: Use encoders to make precise turns
- **Arm positioning**: Move your arm to exact angles using its encoder
- **Sensor integration**: Combine encoder drive with color sensors, distance sensors, or cameras
- **Advanced control**: Learn about PID controllers for even smoother movement

You now have the fundamental building blocks that professional robotics teams use to create sophisticated autonomous programs!

# **Section 5: Next Steps**

Where do you go from here? It's not the Into The Deep season anymore, and you need to figure out what you're doing for the new season.

There are two main options: you can either take what you've learned here and program a robot using what you've seen and experimented with, or you can spend more time learning about more complex systems.

If you're looking for what to learn next, here are my recommendations:

- Specific subsystems that your team will need for the current season, such as cameras or slides
- Mecanum drive (if you're team is able to use one)
- Pathfinding with RoadRunner or PedroPathing
- The theory behind PIDs

# **Resources**

The Unofficial FIRST Tech Challenge Discord, which can be joined at [https://discord.gg/ftc](https://discord.gg/ftc); this server is filled with people willing to help with any questions you have.

[Learn Java for FTC](https://raw.githubusercontent.com/alan412/LearnJavaForFTC/master/LearnJavaForFTC.pdf)

[GM0](https://gm0.org/en/latest/index.html)

FTC sample code, [https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples](https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples)