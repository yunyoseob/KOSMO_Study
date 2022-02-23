# JAVA Methods 모음

## java.lang

### ✔️ Boolean Class
|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|a Boolean object that represents **the same boolean value** as this object.|




### ✔️ Byte Class
|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|Byte object that contains **the same byte value** as this object.|
|double|doubleValue()|public double doubleValue()|Returns the value of this Byte as a double after a widening primitive conversion.|
|float|floatValue()|public float floatValue()|Returns the value of this Byte as a float after a widening primitive conversion.|
|int|hashCode()|public int hashCode()|Returns a hash code for this Byte; equal to the result of invoking intValue().|
|static int|hashCode(byte value)|public static int hashCode(byte value)|Returns a hash code for a byte value; compatible with Byte.hashCode().|
|int|intValue()|public int intValue()|Returns the value of this Byte as an int after a widening primitive conversion.|
|long|longValue()|public long longValue()|Returns the value of this Byte as a long after a widening primitive conversion.|
|short|shortValue()|public short shortValue()|Returns the value of this Byte as a short after a widening primitive conversion.|
|String|toString()|public String toString()|The value is converted to signed decimal representation and returned as a string, exactly as if the byte value were given as an argument to the toString(byte) method.|
|static String|toString(byte b)|public static String toString(byte b)|Returns a new String object representing the specified byte. The radix is assumed to be 10.|
|static Byte|valueOf(byte b)|public static Byte valueOf(byte b)|Returns a Byte instance representing the specified byte value.|

### ✔️ Short Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|a Short object that contains **the same short value** as this object.|

### ✔️ Character Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|a Character object that represents **the same char value** as this object.|
|char|charValue()|public char charValue()|Returns the value of this Character object.|
|int|hashCode()|public int hashCode()|Returns a hash code for this Character; equal to the result of invoking charValue().|
|static int|hashCode(char value)|public static int hashCode(char value)|Returns a hash code for a char value; compatible with Character.hashCode().(since 1.8)|
|static boolean|isLowerCase(char ch)|public static boolean isLowerCase(char ch)|Determines if the specified character is a lowercase character.|
|static int|compare(char x, char y)|public static int compare(char x, char y)|Compares two char values numerically.|
|int|compareTo(Character anotherCharacter)|public int compareTo(Character anotherCharacter)|Compares two Character objects numerically.|
|static int|getNumericValue(char ch)|public static int getNumericValue(char ch)|Returns the int value that the specified Unicode character represents.|
|int|hashcode()|public int hashCode()|Returns a hash code for this Character; equal to the result of invoking charValue().|
|static int|hashCode(char value)|public static int hashCode(char value)|Returns a hash code for a char value; compatible with Character.hashCode().(since 1.8)|
|static boolean|isUpperCase(char ch)|public static boolean isUpperCase(char ch)|Determines if the specified character is an uppercase character.|
|String|toString()|public String toString()|Returns a String object representing this Character's value.|
|static String|toString(char c)|public static String toString(char c)|Returns a String object representing the specified char.|
|static Character|valueOf(char c)|public static Character valueOf(char c)|Returns a Character instance representing the specified char value.|


### ✔️ Integer Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|an Integer object that contains **the same int value** as this object.|
|short|shortValue()|public short shortValue()|Returns the value of this Integer as a short after a narrowing primitive conversion.|
|int|sum(int a, int b)|public static int sum(int a, int b)|Adds two integers together as per the + operator.|
|static String|toBinaryString(int i)|public static String toBinaryString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 2.|
|static String|toHexString(int i)|public static String toHexString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 16.|
|static String|toOctalString(int i)|public static String toOctalString(int i)|Returns a string representation of the integer argument as an unsigned integer in base 8.|
|String|toString()|public String toString()|Returns a String object representing this Integer's value. |
|static String|toString(int i)|public static String toString(int i)|Returns a String object representing the specified integer.|
|static Integer|valueOf(String s)|public static Integer valueOf(String s) throws NumberFormatException|Returns an Integer object holding the value of the specified String.|
|static int|parseInt(String s)|public static int parseInt(String s) throws NumberFormatException|Parses the string argument as a signed decimal integer. |




### ✔️ Long Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)|a Long object that contains **the same long value** as this object.|

### ✔️ Float Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)| Float object that represents **a float with the same value as the float represented by this object.**|

### ✔️ Double Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|public boolean equals(Object obj)| a Double object that represents a double that has **the same value as the double represented by this object.**|

### ✔️ String Class
|JAVA Methods|Describe|
|---|---|
|String : String.valueOf()|public static String valueOf(boolean b)|
|''|public static String valueOf(char c)|
|''|public static String valueOf(int i)|
|''|public static String valueOf(long l)|
|''|public static String valueOf(float f)|
|''|public static String valueOf(double d)|
|char : String.charAt()|public char charAt(int index)|

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
boolean|equals(Object anObject)|public boolean equals(Object anObject)|a String object that represents **the same sequence of characters** as this object.|
|String|concat(String str)|public String concat(String str)|a String object is returned that represents a character sequence that is the concatenation of the character sequence represented by this String object and the character sequence represented by the argument string.|

### ✔️ Object Class(java 상속클래스의 시조)

|Modifier and Type|Method|Description|Detail|
|---|---|---|--|
|boolean|equals(Object obj)|public boolean equals(Object obj)|아래 사진 첨부|
|Class<?>|getClass()|public final Class<?> getClass()|Returns the runtime class of this Object. The returned Class object is the object that is locked by static synchronized methods of the represented class.|
|int|hashCode()|public int hashCode()|Returns a hash code value for the object.|
|String|toString()|public String toString()|Returns a string representation of the object. +getClass().getName() + '@' + Integer.toHexString(hashCode())|

![](https://images.velog.io/images/yunyoseob/post/7fef7850-600f-4cbc-9f4e-eca9a0ffaa14/image.png)

### ✔️ StringBuffer

### ✔️ System Class

### ✔️ Class Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|T|newInstance()|public T newInstance() throws InstantiationException, IllegalAccessException|Creates a new instance of the class represented by this Class object.|
|Method[]|getDeclaredMethods()|public Method[] getDeclaredMethods() throws SecurityException|Returns an array containing Method objects reflecting all the declared methods of the class or interface represented by this Class object, including public, protected, default (package) access, and private methods, but excluding inherited methods.|

## Exceptions (java.lang)

### ✔️ Throwable class

### ✔️ Exception class


