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
     * **Abstract Class**, keyword *abstact* in class declaration. An abstract class CANNOT be instantiated. Its sole purpose is to be extended.<br/>


       | **Modifier** | **Class** | **Package** | **Subclass** | **World** |
       | :--- | :---: | :---: | :---: | :---: |
       | public | Y | Y | Y | Y |
       | protected | Y | Y | Y | N |
       | no modifier (default) | Y | Y | N | N |
       | private | Y | N | N | N |


#### 3. Interfaces
**Interface** is a contract for what class can do without saying anything how class can do it. Think of interface as an 100% abstract class. Rules for defining methods and variables in interface:
* All interfaces methods are implicitly *public* and *abstract*, meaning you don't need to type *public abstract* but the methods are always *public Abstract*
* All variables in interface must be *public static final*, meaning you only can define constants in interfaces NOT instance variables. Even if you don't type *public static final* the variables in interfaces are still *public static final*
* Interfaces methods must NOT be *static*
* Because interface methods are abstract they cannot be marked *final, strictfp, native*
* An interface can extend one or more other interfaces (NOTE: interface can extend multiple interfaces, class can extend only one class)
* An interface cannot extend anything but another interface
* An interface cannot implement another interface or class

#### 4. Class Members


#### 5. Enums
* An **enum** specifies a list of constant values assigned to enum type
* An **enum** is NOT a String or int, enum constant's type is enum type
* Enum can be declared inside or outside class but NOT inside method
* Enum declared outside class MUST NOT be marked *static, final, abstract, protected, private*
* Enum can contain constructors, methods, variables, constants
* Enum constants can send arguments to enum constructors
    ```
    enum Size {
        SMALL(5), BIG(10), HUGE(20);

        private int size;

        Size(int size) {
            this.size = size;
        }

        public int getSize() {
            return this.size;
        }
    }
    ```
* Enum constructors can NEVER invoked directly in code. They are always called when enum is initialized
* Evey enums has static method ```values()``` returns list of enum constants
