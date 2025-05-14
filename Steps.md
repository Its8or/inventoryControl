# Creating an Executable JAR File for the Stock Control Application

This guide provides step-by-step instructions to create an executable JAR file for the Stock Control Java application.

## Prerequisites

- Java Development Kit (JDK) installed on your system
- Basic knowledge of command-line operations
- Access to the project source code

## Steps

### Step 1: Navigate to the Project Directory

Open a command prompt or terminal and navigate to the directory containing your project files:

```
cd path\to\inventoryControl
```

### Step 2: Compile the Java Source Files

Compile all Java source files in the project:

```
javac *.java
```

This command will generate .class files for each of your Java source files (Main.class, Application.class, Estoque.class, EstoqueControls.class, EntradaInvalidaException.class).

### Step 3: Verify the Manifest File

Ensure that the manifest.txt file exists in your project directory and contains the following content:

```
Main-Class: Main

```

Note: The manifest file must end with a blank line.

### Step 4: Create the JAR File

Use the `jar` command to create your executable JAR file:

```
jar cfm StockControl.jar manifest.txt *.class
```

This command:
- `c`: Creates a new archive
- `f`: Specifies the archive file name (StockControl.jar)
- `m`: Includes manifest information from the specified manifest file
- `manifest.txt`: The manifest file containing the Main-Class specification
- `*.class`: Includes all class files in the current directory

### Step 5: Include Additional Resources (if needed)

If your application uses additional resources like data files, include them in the JAR:

```
jar cfm StockControl.jar manifest.txt *.class estoque.dat
```

### Step 6: Test the JAR File

Test that your JAR file works correctly by running:

```
java -jar StockControl.jar
```

The Stock Control application should launch with its GUI interface.

### Step 7: Distribute the JAR File

Your executable JAR file (StockControl.jar) can now be distributed and run on any system with Java Runtime Environment (JRE) installed.

## Troubleshooting

- **"No main manifest attribute" error**: Ensure your manifest.txt file correctly specifies the Main-Class and ends with a blank line.
- **ClassNotFoundException**: Make sure all required classes are included in the JAR file.
- **Missing resources**: If your application needs additional files, make sure they're included in the JAR or accessible from the execution directory.