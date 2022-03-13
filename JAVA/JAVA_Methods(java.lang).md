# JAVA Methods(java.lang) 모음

## ✔️ Boolean Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|a Boolean object that represents **the same boolean value** as this object.|X|
|int|hashCode()|Returns a hash code for this Boolean object.|X|
|static int|hashCode(boolean value)|Returns a hash code for a boolean value; compatible with Boolean.hashCode().|Since: 1.8|
|static String|toString(boolean b)|Returns a String object representing the specified boolean.|Since 1.4|
|static Boolean|valueOf(boolean b)|Returns a Boolean instance representing the specified boolean value.|Since 1.4|
|static Boolean|valueOf(String s)|Returns a Boolean with a value represented by the specified string.|Since 1.4|


## ✔️ Byte Class

### Field Summary

|Modifier and Type|Field|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a byte value in two's complement binary form.|Since 1.8, Constant Field Values|
|static byte|MAX_VALUE|A constant holding the maximum value a byte can have, 2^7-1.|Constant Field Values|
|static byte|MIN_VALUE|A constant holding the minimum value a byte can have, -2^7.|Constant Field Values|
|static int|SIZE|The number of bits used to represent a byte value in two's complement binary form.|Since 1.5. Constant Field Values|

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object to the specified object.|Byte object that contains **the same byte value** as this object.|
|int|hashCode()|Returns a hash code for this Byte; equal to the result of invoking intValue().|X|
|static int|hashCode(byte value)|Returns a hash code for a byte value; compatible with Byte.hashCode().|Since 1.8|
|int|intValue()|Returns the value of this Byte as an int after a widening primitive conversion.|intValue in class Number|
|long|longValue()|Returns the value of this Byte as a long after a widening primitive conversion.|longValue in class Number|
|short|shortValue()|Returns the value of this Byte as a short after a widening primitive conversion.|shortValue in class Number|
|static String|toString(byte b)|Returns a new String object representing the specified byte.|X|
|static Byte|valueOf(byte b)|Returns a Byte instance representing the specified byte value.|Since 1.5|
|static Byte|valueOf(String s)|Returns a Byte object holding the value given by the specified String.|throws NumberFormatException, arguments were given to the parseByte(java.lang.String) method|

## ✔️ Short Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a short value in two's complement binary form.|Since 1.8, Constant Field Values|
|static short|MAX_VALUE|A constant holding the maximum value a short can have, 2^15-1.|X|
|static short|MIN_VALUE|A constant holding the minimum value a short can have, -2^15.|X|
|static int|SIZE|The number of bits used to represent a short value in two's complement binary form.|Since 1.5, Constant Field Values|

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object to the specified object.|a Short object that contains **the same short value** as this object.|
|int|hashCode()|Returns a hash code for this Short; equal to the result of invoking intValue().|X|
|static int|hashCode(short value)|Returns a hash code for a short value; compatible with Short.hashCode().|Since 1.8|
|static String|toString(short s)|Returns a new String object representing the specified short.|X|
|static Short|valueOf(String s)|Returns a Short object holding the value given by the specified String.|throws NumberFormatException, argument were given to the parseShort(java.lang.String)|



## ✔️ Character Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object against the specified object.|argument is not null and is a Character object that represents **the same char value** as this object.|
|static int|hashCode(char value)|Returns a hash code for a char value; compatible with Character.hashCode().|Since 1.8|
|static boolean|isLowerCase(char ch)|Determines if the specified character is a lowercase character.|look at examples of lowercase characters|
|static boolean|isUpperCase(char ch)|Determines if the specified character is an uppercase character.|look at examples of uppercase characters.|
|static int|compare(char x, char y)|Compares two char values numerically.|Since 1.7|
|static int|getNumericValue(char ch)|Returns the int value that the specified Unicode character represents.|Since 1.1|
|static int|hashCode(char value)|Returns a hash code for a char value; compatible with Character.hashCode().|Since 1.8|
|static String|toString(char c)|Returns a String object representing the specified char.|Since 1.4|
|static Character|valueOf(char c)|Returns a Character instance representing the specified char value.|Since 1.5|

### examples lowercase characters

![image](https://user-images.githubusercontent.com/81727895/155846759-01acec0b-6f6a-412c-bf2b-2f952362ccfa.png)

### examples of uppercase characters

![image](https://user-images.githubusercontent.com/81727895/155846920-9f4f0151-a5fd-4bab-a8ef-b2c6684d830c.png)


## ✔️ Integer Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a int value in two's complement binary form.|Since 1.8|
|static int|MAX_VALUE|A constant holding the maximum value an int can have, 2^31-1.|Constant Field Values|
|static int|MIN_VALUE|A constant holding the minimum value an int can have, -2^31.|Constant Field Values|
|static int|SIZE|The number of bits used to represent an int value in two's complement binary form.|Since 1.5, Constant Field Values|

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object to the specified object.|argument is not null and is an Integer object that contains **the same int value** as this object.|
|static int|sum(int a, int b)|Adds two integers together as per the + operator.|Since 1.8|
|static String|toBinaryString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 2.|Since JDK1.0.2|
|static String|toHexString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 16.|Since JDK1.0.2, This value is converted to a string of **ASCII digits** in hexadecimal (base 16) with no extra leading 0s.|
|static String|toOctalString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 8.|Since JDK1.0.2|
|String|toString()|Returns a String object representing this Integer's value.|X|
|static String|toString(int i)|Returns a String object representing the specified integer.|X|
|static Integer|valueOf(String s)|Returns an Integer object holding the value of the specified String.|throws NumberFormatException|
|static int|parseInt(String s)|Parses the string argument as a signed decimal integer.|throws NumverFormatException|

## ✔️ Long Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a long value in two's complement binary form.|Since 1.8, Constant Field Values|
|static long|MAX_VALUES|A constant holding the maximum value a long can have, 2^63-1.|X|
|static long|MIN_VALUE|A constant holding the minimum value a long can have, -2^63.|X|
|static int|SIZE|The number of bits used to represent a long value in two's complement binary form.|Since 1.5, Constant Field Values|

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object to the specified object.|the argument is not null and is a Long object that contains **the same long value** as this object.|
|int|hashCode()|Returns a hash code for a long value; compatible with Long.hashCode().|X|
|static long|max(long a, long b)|Returns the smaller of two long values as if by calling Math.min.|Since 1.8|
|static long|parseLong|Parses the string argument as a signed decimal long.|throws NumberFormatException|
|static String|toBinaryString(long i)|Returns a string representation of the long argument as an unsigned integer in base 2.|Since JDK 1.0.2|
|static String|toHexString(long i)|Returns a string representation of the long argument as an unsigned integer in base 16.|Since JDK 1.0.2|
|static String|toOctalString(long i)|Returns a string representation of the long argument as an unsigned integer in base 8.|Since JDK 1.0.2|
|static String|toString(long i)|Returns a String object representing the specified long.|X|
|static Long|valueOf(String s)|Returns a Long object holding the value of the specified String.|Throws NumberFormatException|

## ✔️ Float Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a float value.|Since 1.8|
|static float|MAX_VALUE|A constant holding the largest positive finite value of type float, (2-2^-23)·2^127.|Constant Field Values|
|static float|MIN_VALUE|A constant holding the smallest positive nonzero value of type float, 2-^149.|Constant Field Values|
|static float|NaN|A constant holding a Not-a-Number (NaN) value of type float.|Constant Field Values|
|static int|SIZE|The number of bits used to represent a float value.|Since 1.5, Constant Field Values|

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object against the specified object.| the argument is not null and is a Float object that represents **a float with the same value as the float** represented by this object.|
|static int|compare(float f1, float f2)|Compares the two specified float values.|Since 1.4|
|static int|hashCode(float value)|Returns a hash code for a float value; compatible with Float.hashCode().|Since 1.8|
|static float|parseFloat(String s)|Returns a new float initialized to the value represented by the specified String, as performed by the valueOf method of class Float.|Since 1.2|
|static String|toString(float f)|Returns a string representation of the float argument.|All characters mentioned below are ASCII characters.|
|static Float|valueOf(String s)|Returns a Float object holding the float value represented by the argument string s.|throws NumberFormatException|

## ✔️ Double Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a double value.|Since 1.8|
|static double|MAX_VALUE|A constant holding the largest positive finite value of type double, (2-2^-52)·2^1023.|Since JDK1.1|
|static double|MIN_VALUE|A constant holding the smallest positive nonzero value of type double, 2^-1074.|Constant Field Values|
|static double|NaN|A constant holding a Not-a-Number (NaN) value of type double.|Constant Field Values|
|static double|NEGATIVE_INFINITY|A constant holding the negative infinity of type double.|Constant Field Values|
|static double|POSITIVE_INFINITY|A constant holding the positive infinity of type double.|Constant Field Values|
|static int|SIZE|The number of bits used to represent a double value.|Since 1.5, Constant Field Values|


### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object against the specified object.|the argument is not null and is a Double object that **represents a double that has the same value as the double represented** by this object. |
|static int|hashCode(double value)|Returns a hash code for a double value; compatible with Double.hashCode().|Since 1.8|
|static double|parseDouble(String s)|Returns a new double initialized to the value represented by the specified String, as performed by the valueOf method of class Double.|Since 1.2|
|static String|toHexString(double d)|Returns a hexadecimal string representation of the double argument.|Since 1.5, Returns a hexadecimal string representation of the double argument. All characters mentioned below are ASCII characters.|
|static String|toString(double d)|Returns a string representation of the double argument.|X|
|static Double|valueOf(String s)|Returns a Double object holding the double value represented by the argument string s.|throws NumberFormatException|


## ✔️ String Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object anObject)|Compares this string to the specified object.|a String object that represents **the same sequence of characters** as this object.|
|char|charAt(int index)|Returns the char value at the specified index.|throws IndexOutOfBoundsException|
|String|concat(String str)|Concatenates the specified string to the end of this string.|X|
|boolean|contains(CharSequence s)|Returns true if and only if this string contains the specified sequence of char values.|Since 1.5|
|static String|format(String format, Objcet ... args|Returns a formatted string using the specified format string and arguments.|Since 1.5|
|int|indexOf(int ch)|Returns the index within this string of the first occurrence of the specified character.|X|
|int|indexOf(String str)|Returns the index within this string of the first occurrence of the specified substring.|X|
|int|lastIndexOf(int ch)|Returns the index within this string of the last occurrence of the specified character.|X|
|int|lastIndexOf(String str)|Returns the index within this string of the last occurrence of the specified substring.|X|
|int|length()|Returns the length of this string.|X|
|String|replace(char oldChar, char newChar)|Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.|X|
|int|indexOf(String str)|Returns the index within this string of the first occurrence of the specified substring.||
|String|substring(int start)|Returns a new String that contains a subsequence of characters currently contained in this character sequence.|X|
|String[]|split(String regax)|Splits this string around matches of the given regular expression.|Since 1.4|
|String|substring(int beginIndex, int endIndex)|Returns a string that is a substring of this string.|throws IndexOutofBoundsException|
|char[]|toCharArray()|Converts this string to a new character array.|X|
|String|toLowerCase()|Converts all of the characters in this String to lower case using the rules of the default locale.|X|
|String|toUpeerCase()|Converts all of the characters in this String to upper case using the rules of the default locale.|X|
|static String|valuOf(boolean b)|Returns the string representation of the boolean argument.|X|
|static String|valueOf(char c)|Returns the string representation of the char argument.|X|
|static Stirng|valueOf(char[] data)|Returns the string representation of the char array argument.|X|
|static String|valueOf(double d)|Returns the string representation of the double argument.|X|
|static String|valueOf(float f)|Returns the string representation of the float argument.|X|
|static String|valueOf(int i)|Returns the string representation of the int argument.|X|
|static String|valueOf(long i)|Returns the string representation of the long argument.|X|
|static String|valueOf(Object obj)|Returns the string representation of the Object argument.|X|

## ✔️ StringBuffer Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|StringBuffer|append(boolean b), append(char c), append(char[] str), append(char[] str, int offset, int len), append(CharSequence s), append(CharSequence s, int start, int end), append(double d), 	append(float f), append(int i), append(long lng), append(Object obj), append(String str), append(StringBuffer sb)|Appends to sequence|X|
|StringBuffer|delete(int start, int end)|Removes the characters in a substring of this sequence.|X|
|StringBuffer|	deleteCharAt(int index)|Removes the char at the specified position in this sequence.|X|

## ✔️ Math Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static doublie, float, int, long, doublie|abs(double a), abs(float a) abs(int a), abs(long a), abs(double a)|Returns the absloute value of a data value.|X|
|static double|ceil(double a)|Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.(올림)|X|
|static double|exp(double a)|Returns Euler's number e raised to the power of a double value.|X|
|static double|round(double a)|Returns the closest long to the argument, with ties rounding to positive infinity.(반올림)|X|
|static int|round(float a)|eturns the closest int to the argument, with ties rounding to positive infinity.(반올림)|X|
|static double|floor(double a)|Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.(내림)|
|static double|pow(double a, double b)|Returns the value of the first argument raised to the power of the second argument.(제곱연산)|a^b|
|static double, float, int, long|max(double a, double b), max(float a, float b), max(int a, int b), max(long a, long b)|Returns the greater of two values|X|
|static double|random()|Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.(난수 발생)|

## ✔️ System Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static PrintStream|err|The "standard" error output stream.|This stream is already open and ready to accept output data.|
|static InputStream|in|The "standard" input stream.|This stream is already open and ready to accept output data.|
|static PrintStream|out|The "standard" output stream.|This stream is already open and ready to accept output data.|

![image](https://user-images.githubusercontent.com/81727895/158065964-6b88943e-6e07-4e9e-8c97-577c215bc011.png)

|Modifier and Type|Method|Description|Detail|
|---|---|---|--|
|static long|currentTimeMillis()|Returns the current time in milliseconds.|See the description of the class Date for a discussion of slight discrepancies that may arise between "computer time" and coordinated universal time (UTC).|
|static void|exit(int status)|Terminates the currently running Java Virtual Machine|This method calls the exit method in class Runtime. This method never returns normally.|
|static Properties|getProperties()|Determines the current system properties.|X|
|static String|getProperty(String key)|Gets the system property indicated by the specified key.|Return the string value of the system property, or null if there is no property with that key.|
|static String|getProperty(String key, String def)|Gets the system property indicated by the specified key.|Returns the string value of the system property, or the default value if there is no property with that key.|
|static int|identityHashCode(Object x)|Returns the same hash code for the given object as would be returned by the default method hashCode(), whether or not the given object's class overrides hashCode().|X|
|static String|	lineSeparator()|Returns the system-dependent line separator string.|On UNIX systems, it returns "\n"; on Microsoft Windows systems it returns "\r\n". (Since 1.7)|
|static void|load(String filename)|Loads the native library specified by the filename argument.|The filename argument must be an absolute path name.|X|
|static void|setProperties(Properties props)|Sets the system properties to the Properties argument.|
|static String|setProperty(String key, String value)|Sets the system property indicated by the specified key.|Returns the previous value of the system property, or null if it did not have one.(Since 1.2)|

## ✔️ Throwable Class

![image](https://user-images.githubusercontent.com/81727895/158066427-b8fef159-3de7-48ec-951b-92cee26082b0.png)

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|String|getMessage()|Returns the detail message string of this throwable.|X|
|void|printStackTrace()|Prints this throwable and its backtrace to the standard error stream.|사용을 지양한다.|

## ✔️ Exception

### Constructors

|Modifier|Constructor|Description|Deail|
|--|--|--|--|
||Exception()|Constructs a new exception with null as its detail message.|X|
||Exception(String message)|Constructs a new exception with the specified detail message.|X|
||	Exception(String message, Throwable cause)|Constructs a new exception with the specified detail message and cause.|Since 1.4|
|protected|Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)|Constructs a new exception with the specified detail message, cause, suppression enabled or disabled, and writable stack trace enabled or disabled.|Since 1.7|
||Exception(Throwable cause)|Constructs a new exception with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).|Since 1.4|

## ✔️ Class Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|T|newInstance()|public T newInstance() throws InstantiationException, IllegalAccessException|Creates a new instance of the class represented by this Class object.|
|Method[]|getDeclaredMethods()|public Method[] getDeclaredMethods() throws SecurityException|Returns an array containing Method objects reflecting all the declared methods of the class or interface represented by this Class object, including public, protected, default (package) access, and private methods, but excluding inherited methods.|
|static Class<?>|forName(String className)|Returns the Class object associated with the class or interface with the given string name.|Parameters: className - the fully qualified name of the desired class.|
|static Class<?>|	forName(String name, boolean initialize, ClassLoader loader)|Returns the Class object associated with the class or interface with the given string name, using the given class loader.|Since 1.2|
|Class<?>[]|getClasses()|Returns an array containing Class objects representing all the public classes and interfaces that are members of the class represented by this Class object.|X|
|Method[]|getMethods()|Returns an array containing Method objects reflecting all the public methods of the class or interface represented by this Class object, including those declared by the class or interface and those inherited from superclasses and superinterfaces.|X|
|String|getName()|Returns the name of the entity (class, interface, array class, primitive type, or void) represented by this Class object, as a String.|X|
|Package|getPackage()|Gets the package for this class.|X|
|T|newInstance()|Creates a new instance of the class represented by this Class object.|X|
|String|toString()|Converts the object to a string.|X|


## ✔️ Object Class(java 상속클래스의 시조)

### Constructors

|Constructor and Description|
|--|
|Object()|

Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.

|Modifier and Type|Method|Description|Detail|
|---|---|---|--|
|boolean|equals(Object obj)|public boolean equals(Object obj)|아래 사진 첨부|
|Class<?>|getClass()|public final Class<?> getClass()|Returns the runtime class of this Object. The returned Class object is the object that is locked by static synchronized methods of the represented class.|
|int|hashCode()|public int hashCode()|Returns a hash code value for the object.|
|String|toString()|public String toString()|Returns a string representation of the object. +getClass().getName() + '@' + Integer.toHexString(hashCode())|
|void|wait()|Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.|X|
|void|wait(lnog timeout)|Causes the current thread to wait until either another thread invokes the notify() method or the notifyAll() method for this object, or a specified amount of time has elapsed.|X|
|void|wait(long timeout, int nanos)|Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object, or some other thread interrupts the current thread, or a certain amount of real time has elapsed.|X|

![](https://images.velog.io/images/yunyoseob/post/7fef7850-600f-4cbc-9f4e-eca9a0ffaa14/image.png)

