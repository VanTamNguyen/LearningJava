# Generics and Collections

#### 1. ```hashCode()``` and ```equals()```
Why study ```hashCode()``` and ```equals()``` here? Cause they are essential to working with Java Collections Framework. Whener you need to sort or search through a collection of objects, the ```equals()``` and ```hashCode()``` methods are essential.

* ```equals()``` decides whether two objects are meaningfully equivalent.
    * ```==``` operator just compares two object references. It simply looks at the bits in the variables and verify if they are the same or not.
    * If we don't override a class's ```equals()``` method, we won't be able to use those objects as a key in a hashtable and we won't be able to get accurate Sets such that does not allow duplicated object.
    * If we want objects of our class can be used as keys for a hashtable (or as elements in any data structure that uses equivalency for searching for and/or retrieving an object), so we must override ```equals()``` so that two different instances can be considered the same.

* ```hashCode()``` is used by some collections to specify the way how an object is *stored* in the collection and how it is *retrieved* from the collection.


#### 2. Collections


#### 3. How to use Collections


#### 4. Generic Type
