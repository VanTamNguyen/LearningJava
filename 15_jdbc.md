# JDBC
The purpose of JDBC is to provide an API for Java developers to write Java applications that can access and manipulate relational databases and use SQL to perform CRUD operations.<br/>

The JDBC driver is an implementation of JDBC API provided by the vendor of database product in a jar or zip file.<br/>

The JDBC API is a set of interfaces with one concrete class, ```DriverManager``` class. The provider (vender) of JDBC driver write code that implements those interfaces. The key interfaces a JDBC driver must implement include ```Driver```, ```Connection```, ```Statement``` and ```ResultSet```.

```
Note:
    In this document, when we say JDBC driver ("d" in lowercase) we mean the implementation of JDBC API 
    that provided by a database vendor.
    When we say JDBC Driver ("D" in uppercase) we mean the interface Driver in JDBC API.
```

#### 1. Connect to a Database Using DriverManager
```DriverManager``` is a concrete class in JDBC API. It's a factory with static method ```getConnection(url, username, password)``` that help us construct ```Connection``` to a database.

* **When the method ```getConnection(url, username, password)``` is invoked**, the DriverManager will parse the url to find the appropriate ```JDBC Driver``` (provided by database vendor) to construct a connection to the database.

* **How JDBC Drivers register with the DriverManager?**
    * First, one or more JDBC drivers, in a JAR or ZIP file, are inlcuded in the classpath of our application.
    * The DriverManager will use a service provider mechanism to search the file **java.sql.Driver** in any JAR or ZIP libraries. The file java.sql.Driver is placed in the folder **META-INF/services**. The file **java.sql.Driver** is a simply text file that contains the full name of the class that the vendor uses to implement ```java.sql.Driver``` interface.
    * For example, the MySQL JDBC driver provides the class **com.mysql.jdbc.Driver** that implements ```java.sql.Driver``` interface.
    * The DriverManager will try to load the class that implements ```java.sql.Driver``` interface using the class loader.
        ```
        Class.forName("com.mysql.jdbc.Driver");
        ```
    * When the Driver class is loaded, its static initialization block will be executed to register itself with the DriverManager.
        ```
        public class SomeDriver implement java.sql.Driver {
            static {
                DriverManager.register(new SomeDriver());
            }
        }
        ```

* **JDBC URL**
    * The format of JDBC URL is *jdbc:subprotocol:subname* where as the subprotocol is usually the vendor name which helps DriverManager specifies which JDBC driver should be used to construct a connection to the database.
    * jdbc:mysql://localhost:3306/MyDB

#### 2. Submit Queries and Read Results from a Database

#### 3. PreparedStatement and CallableStatement

#### 4. Construct and Use RowSet

#### 5. JDBC Transactions
