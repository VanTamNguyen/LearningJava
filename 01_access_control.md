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
        * ***public static void main(String[] args)***
        * ***public static void main(String... args)***
        * ***public static void main(String args[])***
    * All other main methods with different signatures is just a normal method

* **Imports**
    * Unlike the *include* in C the import statements in Java is just for indicating which class is used => save key strokes

* **Static imports**
    ```
    import static java.lang.System.out;
    import static java.lang.Integer.*;
    
    public class TestStaticImport {
        public static void main(String... args) {
            out.println(MAX_VALUE);
            out.println(toHexString(42));
        }
    }
    ```
    * In code you must use *import static* NOT *static import*
    * You can do an static import on *static* object references, constants and methods
    * If you import two static members of two classes which have same name then you will encounter the compilation error

* **Modifiers**<br/>
Three modifiers (*private, protected, public*) but four access controlls (*private, package, subclass, public*).<br/>
    * **Class Access**, what does it mean to access a class? When we say class A has access to class B it means class A can do the following things:
        * Create an instance of class B
        * Extend class B
        * Access certain methods or variables within class B, depend on the access controls of those methods and variables
    * **Default Access**, a class with default access has no modifier preceding in its declaration. Default access is *package-level* access. Meaning a class with default access can be seen by only classes in the same package.
    * **Public Access**, a class with public access has *public* modifier preceding in its declaration. All classes in Java Universe can see the public class.
    * **Private Access**, *private* modifier. A private class can be seen by only itself.
    * **Protected Access**, *protected* modifier. A protected class can be seen by classes in the same package and its subclass.
    * **Final Class**, when the keyword *final* is used in class declarations, it means the class CANNOT be subclassed any more. In other words, no class can extend the final class
     * **Abstract Class**<br/>, keyword *abstact* in class declaration. An abstract class CANNOT be instantiated. Its sole purpose is to be extended.


       | **Modifier** | **Class** | **Package** | **Subclass** | **World** |
       | :--- | :---: | :---: | :---: | :---: |
       | public | Y | Y | Y | Y |
       | protected | Y | Y | Y | N |
       | no modifier (default) | Y | Y | N | N |
       | private | Y | N | N | N |


#### 3. Interfaces

#### 4. Class Members

#### 5. Enums
