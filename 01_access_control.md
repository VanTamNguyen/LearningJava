# Java Syntax and Access Control

#### 1. Identifiers & Keywords
* **Identifiers** are the name of Java components include ***classes***, ***methods*** and ***variables***
* **Legal identifiers** must follow rules below
    * Can only start with ***letter*** or ***$*** or ***_***
    * CANNOT start with a digit
    * After the first character, identifiers can contain any combination of letters, &, _ and numbers
    * CANNOT use keywords for identifiers
    * Identifiers are case sensitive

#### 2. Classes
* **Source file rules**
    * There can be only one public class per source code java file
    * The name of file must match the name of public class
    * If the class is part of a package, the *package* statement must be the first line of source code file
    * Import statements must go between package statement and class declaration
    * Import and package statments apply for all classes in source code file
    * A source code file can have more than one nonpublic classes
    * Files with no public classes can have the name that does not match any classes in the file

* **javac** and **java** commands

* **public static void main(String[] args)**
    * **main** is the entry point of Java program, JVM use main to start execution, main will be at the bottom of call stack
    * Legal main signatures for JVM to start execution
        * ***public static void main(String[] args)*8*
        * ***public static void main(String... args)***
        * ***public static void main(String args[])***
    * All other main methods with different signatures is just a normal method

* **Imports**
* **Static imports**
* **Modifiers**


#### 3. Interfaces

#### 4. Class Members

#### 5. Enums
