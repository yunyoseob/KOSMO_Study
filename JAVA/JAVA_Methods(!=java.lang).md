# java.lang 이외의 JAVA Methods 모음 

# java.util

## ✔️ ArrayList class

- **Generic: Elements, including null**

- Since : 1.2

### Constructors

|Constructor|Description|Detail|
|---|---|---|
|ArrayList()|Constructs an empty list with an initial capacity of ten.|X|
|ArrayList(Collection<? extends E> c)|Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.|Throws NullPointerException|
|ArrayList(int initialCapacity)|Constructs an empty list with the specified initial capacity.|Throws IllegalArgumentException|




|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|add(E e)|Appends the specified element to the end of this list.|Returns true|
|void|add(int index, E element|Inserts the specified element at the specified position in this list.|Throws IndexOutOfBoundsException|
|boolean|addAll(Collection<? extends E> c)|Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.|Returns true if list changed as a result of the call, Trhrows NullPointerException|



## ✔️ Calendar class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ Collections class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ Date class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ HashMap class

- **Generic: Key, Value**

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||


## ✔️ Scanner class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ StringTokenizer class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||


## ✔️ TimeZone class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ UUID class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

# java.Math

## ✔️ BigDecimal class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

# java.text

## ✔️ SimpleDateFormat class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

# java.time

## ✔️ Clock class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

# java.sql

## ✔️ Date

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

## ✔️ Time

- Deprecated : 

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|||||

# java.io

## ✔️ File

### Constructors

|Constructor|Description|
|----|----|
|File(String pathname)|Creates a new File instance by converting the given pathname string into an abstract pathname.|

### methods

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|exists()|Tests whether the file or directory denoted by this abstract pathname exists.|throws SecurityException, SecurityManager.checkRead(java.lang.String)|
|boolean|createNewFile()|Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.|Since 1.2|

## ✔️ FileInputStream

### Constructors

|Constructor|Description|
|----|----|
|FileInputStream(String name)|Creates a FileInputStream by opening a connection to an actual file, the file named by the path name name in the file system.|

### methods

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|int|read()|Reads a byte of data from this input stream.|throws IOException|
|int|read(byte[] b, int off, int len)|Reads up to len bytes of data from this input stream into an array of bytes.|throws NullPointerException, IndexOutOfBoundsException, IOException|
|void|close()|Closes this file input stream and releases any system resources associated with the stream.|throws IOException|

## ✔️ FileOutputStream

### Constructors

|Constructor|Description|
|----|----|
|FileOutputStream(String name)|Creates a file output stream to write to the file with the specified name.|
|FileOutputStream(String name, boolean append)|Creates a file output stream to write to the file with the specified name.|Since JDK1.1, throws FileNotFoundException, SecurityException|

### methods

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|void|close()|Closes this file output stream and releases any system resources associated with this stream.|Throws IOException|
|void|write(int b)|Writes the specified byte to this file output stream.|throws IOException|

## ✔️ FileReader

### Constructors

|Constructor|Description|
|----|----|
|FileReader(File file)|Creates a new FileReader, given the File to read from.|


> **InputStreamReader (java.io.FileReader가 상속받은 클래스<부모클래스>)**

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|int|read()|Reads a single character.|throws IOException|
|void|close()|Closes the stream and releases any system resources associated with it.|throws IOException|

## ✔️ FileWriter

### Constructors

|Constructor|Description|
|----|----|
|FileWriter (String fileName, boolean append)|Constructs a FileWriter object given a file name with a boolean indicating whether or not to append the data written.|

> **OutputStreamWriter (java.io.FileWriter가 상속받은 클래스<부모클래스>)**

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|void|write(int c)|Writes a single character.|throws IOException|
|void|close()|Closes the stream, flushing it first.|throws IOException|





