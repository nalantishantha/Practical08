object Q1 {

  // Function to encrypt a single character
  def encryptChar(shift: Int)(char: Char): Char = {
    if (char.isLetter) {
      val offset = if (char.isUpper) 'A' else 'a'
      ((char - offset + shift) % 26 + offset).toChar
    } else {
      char
    }
  }

  // Function to decrypt a single character
  def decryptChar(shift: Int)(char: Char): Char = {
    encryptChar(-shift)(char)
  }

  // Function to encrypt a string
  def encrypt(shift: Int)(text: String): String = {
    text.map(encryptChar(shift))
  }

  // Function to decrypt a string
  def decrypt(shift: Int)(text: String): String = {
    text.map(decryptChar(shift))
  }

  // Generic cipher function
  def cipher(transform: (Int) => (String) => String, shift: Int, text: String): String = {
    transform(shift)(text)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3

    //Print plaintext
    println(s"Original Text : $plaintext")

    // Encrypting the plaintext
    val encryptedText = cipher(encrypt, shift, plaintext)
    println(s"Encrypted Text : $encryptedText")

    // Decrypting the ciphertext
    val decryptedText = cipher(decrypt, shift, encryptedText)
    println(s"Decrypted Text : $decryptedText")
  }
}
