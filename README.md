# Jinny SMPP Java charset

This Java charset implements the encoding and decoding of the default alphabet in SMPP messages for the Jinny SMSC. The alphabet holds all GSM 03.38 characters. Some characters are mapped to similar characters for convenience, when the are not part of the GSM 7-bit alphabet.

The source is the Jinny Short Message Service Centre 3.6.11 (SMSC Translation Table par 15.5).

Release 1.2 is not depended on JDK6/7 anymore. It uses the Freenet JCharset structures. 

## Usage
Build the jar, and place the generated jar in your Java classpath. The charset name is X-SMPP-JINNY. 

## Author
The author is pim.moerenhout(at)gmail.com.
