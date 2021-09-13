# Generics and Collections

#### 1. ```hashCode()``` and ```equals()```
Why study ```hashCode()``` and ```equals()``` here? Cause they are essential to working with Java Collections Framework. Whenever you need to sort or search through a collection of objects, the ```equals()``` and ```hashCode()``` methods are essential.

* ```equals()``` decides whether two objects are meaningfully equivalent.
    * ```==``` operator just compares two object references. It simply looks at the bits in the variables and verify if they are the same or not.
    * If we don't override a class's ```equals()``` method, we won't be able to use those objects as a key in a hashtable and we won't be able to get accurate Sets such that does not allow duplicated object.
    * If we want objects of our class can be used as keys for a hashtable (or as elements in any data structure that uses equivalency for searching for and/or retrieving an object), so we must override ```equals()``` so that two different instances can be considered the same.
    * The ```equals()``` contract:
        * **Reflexive**: ```x.equals(x)``` == true
        * **Symetric**: ```x.equals(y)``` then ```y.equals(x)```
        * **Transitive**: ```x.equals(y)``` and ```y.equals(z)``` then ```x.equals(z)```
        * For non-null reference x then ```x.equals(null)``` should return false

* ```hashCode()``` is used by some collections to specify the way how an object is *stored* in the collection and how it is *located* from the collection. ```hashCode()``` implements the hash function and it should use the same instance variables that the ```equals()``` method uses.
    * The ```hashCode()``` contract:
        * ```x.equals(y)``` returns true then ```x.hashCode()``` == ```y.hashCode()```
        * But ```x.hashCode()``` == ```y.hashCode()``` then ```x.equals(y)``` may not return true
        * And ```x.hashCode()``` != ```y.hashCode()``` then ```x.equals(y)``` must return false


#### 2. Collections
* [Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/TOC.html)
* **Collections Overview**
    * **Ordered** When a collection is ordered, it means you can iterate through the collection in a specific order. A ```Hashtable``` is not an ordered collection although it has its internal logic to determine the order of iteration. An ```ArrayList``` keeps the order established by the element's index (just like an array). A ```LinkedHashSet``` keeps the order established by insertion so the last element inserted is the last element in that ```LinkedHashSet```.
    * **Sorted** Use ```Comparator``` and ```Comparable``` to define sort order to sort a collection.

* **List Interface**

* **Set Interface**

* **Map Interface**

* **Queue Interface**

#### 3. How to use Collections


#### 4. Generic Type
