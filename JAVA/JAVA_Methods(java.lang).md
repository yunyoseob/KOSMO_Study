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

### ✔️ Long Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a long value in two's complement binary form.|Since 1.8, Constant Field Values|
|static long|MAX_VALUES|A constant holding the maximum value a long can have, 2^63-1.|X|
|static long|MIN_VALUE|A constant holding the minimum value a long can have, -2^63.|X|
|static int|SIZE|The number of bits used to represent a long value in two's complement binary form.|Since 1.5, Constant Field Values|


# ============= 다음시간에 작성하기================

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object to the specified object.|the argument is not null and is a Long object that contains **the same long value** as this object.|
|int|hashCode()|Returns a hash code for a long value; compatible with Long.hashCode().||
|static long|max(long a, long b)|Returns the smaller of two long values as if by calling Math.min.||
|static long|parseLong|Parses the string argument as a signed decimal long.|throws NumberFormatException|
|static String|toBinaryString(long i)|Returns a string representation of the long argument as an unsigned integer in base 2.||
|static String|toHexString(long i)|Returns a string representation of the long argument as an unsigned integer in base 16.||
|static String|toOctalString(long i)|Returns a string representation of the long argument as an unsigned integer in base 8.||
|static String|toString(long i)|Returns a String object representing the specified long.||
|static Long|valueOf(String s)|Returns a Long object holding the value of the specified String.||

## ✔️ Float Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a float value.||
|static float|MAX_VALUE|A constant holding the largest positive finite value of type float, (2-2^-23)·2127.||
|static float|MIN_VALUE|A constant holding the smallest positive nonzero value of type float, 2-^149.||
|static float|NaN|A constant holding a Not-a-Number (NaN) value of type float.||
|static int|SIZE|The number of bits used to represent a float value.||

### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object against the specified object.| the argument is not null and is a Float object that represents **a float with the same value as the float** represented by this object.|
|static int|compare(float f1, float f2)|Compares the two specified float values.||
|static int|hashCode(float value)|Returns a hash code for a float value; compatible with Float.hashCode().||
|static float|parseFloat(String s)|Returns a new float initialized to the value represented by the specified String, as performed by the valueOf method of class Float.||
|static String|toString(float f)|Returns a string representation of the float argument.||
|static Float|valueOf(String s)|Returns a Float object holding the float value represented by the argument string s.||

## ✔️ Double Class

### Field Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|static int|BYTES|The number of bytes used to represent a double value.||
|static double|MAX_VALUE|A constant holding the largest positive finite value of type double, (2-2^-52)·2^1023.||
|static double|MIN_VALUE|A constant holding the smallest positive nonzero value of type double, 2^-1074.||
|static double|NaN|A constant holding a Not-a-Number (NaN) value of type double.||
|static double|NEGATIVE_INFINITY|A constant holding the negative infinity of type double.||
|static double|POSITIVE_INFINITY|A constant holding the positive infinity of type double.||
|static int|SIZE|The number of bits used to represent a double value.||


### Method Summary

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|boolean|equals(Object obj)|Compares this object against the specified object.|the argument is not null and is a Double object that **represents a double that has the same value as the double represented** by this object. |
|static int|hashCode(double value)|Returns a hash code for a double value; compatible with Double.hashCode().||
|static double|parseDouble(String s)|Returns a new double initialized to the value represented by the specified String, as performed by the valueOf method of class Double.||
|static String|toHexString(double d)|Returns a hexadecimal string representation of the double argument.||
|static String|toString(double d)|Returns a string representation of the double argument.||
|static Double|valueOf(String s)|Returns a Double object holding the double value represented by the argument string s.||


## ✔️ String Class

- implements CharSequence
- equals vs contains boolean contains(CharSequence s)

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

## ✔️ StringBuffer Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|StringBuffer|append(boolean b), append(char c), append(char[] str), append(char[] str, int offset, int len), append(CharSequence s), append(CharSequence s, int start, int end), append(double d), 	append(float f), append(int i), append(long lng), append(Object obj), append(String str), append(StringBuffer sb)|||
|StringBuffer|delete(int start, int end)|Removes the characters in a substring of this sequence.||
|StringBuffer|	deleteCharAt(int index)|Removes the char at the specified position in this sequence.||
|int|indexOf(String str)|Returns the index within this string of the first occurrence of the specified substring.||
|String|substring(int start)|Returns a new String that contains a subsequence of characters currently contained in this character sequence.||

## ✔️ Math Class


## ✔️ System Class

## ✔️ Throwable Class

## ✔️ Class Class

|Modifier and Type|Method|Description|Detail|
|---|---|---|---|
|T|newInstance()|public T newInstance() throws InstantiationException, IllegalAccessException|Creates a new instance of the class represented by this Class object.|
|Method[]|getDeclaredMethods()|public Method[] getDeclaredMethods() throws SecurityException|Returns an array containing Method objects reflecting all the declared methods of the class or interface represented by this Class object, including public, protected, default (package) access, and private methods, but excluding inherited methods.|


## ✔️ Object Class(java 상속클래스의 시조)

|Modifier and Type|Method|Description|Detail|
|---|---|---|--|
|boolean|equals(Object obj)|public boolean equals(Object obj)|아래 사진 첨부|
|Class<?>|getClass()|public final Class<?> getClass()|Returns the runtime class of this Object. The returned Class object is the object that is locked by static synchronized methods of the represented class.|
|int|hashCode()|public int hashCode()|Returns a hash code value for the object.|
|String|toString()|public String toString()|Returns a string representation of the object. +getClass().getName() + '@' + Integer.toHexString(hashCode())|

![](https://images.velog.io/images/yunyoseob/post/7fef7850-600f-4cbc-9f4e-eca9a0ffaa14/image.png)

