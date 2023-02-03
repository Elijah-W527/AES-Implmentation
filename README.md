# AES Encryption and Decryption in Java
A program that implements Advanced Encryption Standard (AES) encryption and decryption in Java using the Java Cryptography Architecture (JCA) library.

## Author

Elijah Williams

## Resources

* https://www.section.io/engineering-education/implementing-aes-encryption-and-decryption-in-java/
* https://csrc.nist.gov/csrc/media/publications/fips/197/final/documents/fips-197.pdf
* https://www.devglan.com/online-tools/aes-encryption-decryption
* https://www.youtube.com/watch?v=I68uBhHdnM4

## Usage

The program takes two inputs from the user:

1. Plaintext: The text that needs to be encrypted.
2. Key: The encryption key.

The program outputs the encrypted text and decrypted text using the same key.

## Code

The code uses Base64 encoding and decoding to convert encrypted and decrypted data to and from a readable format. The AES encryption algorithm is employed in ECB mode with PKCS5Padding for enhanced security.
