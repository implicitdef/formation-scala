package example

object SomeFunctions {

  // Write a program that prints ‘Hello World’ to the screen.
  // - print to the console
  def helloWorld(): Unit = ???

  // Write a program that prints the number 1 to 100
  // Except that if the number is a multiple of 3, prints "Fizz"
  // If the number is a multiple of 5, prints "Buzz"
  // If the number is both a multiple of 3 and 5, prints "FizzBuzz" instead
  // Otherwise, just print the number itself
  // - simple for comprehension
  // - ranges
  // - if else
  // - val
  def fizzbuzz(): Unit = ???

  // Write a program that prints a multiplication table for numbers up to 12.
  // - ranges
  // - for comprehension
  // - string concatenation
  def multiplicationTable(): Unit = ???

  // Write a program that prints the sum of the numbers 1 to n
  // - collections methods
  def sumOfNumbersToN(n: Int): Unit = ???


  // -------------------------------------
  // All the methods below are unit-tested

  // Write a function that computes the N-th fibonacci number
  // The first two Fibonacci numbers are 1 and 1.
  // The n+1-st Fibonacci number can be computed by adding the n-th and the n-1-th Fibonacci number.
  // The first few are therefore 1, 1, 1+1=2, 1+2=3, 2+3=5, 3+5=8.
  // - recursion
  // - if statement
  def fibonacci(n: Int): Int = ???

  // Write a function that tests whether a string is a palindrome.
  // Should ignore all non-alphanumeric characters, and be case-insensitive
  // Example of valid palindromes :
  // "racecar"
  // "redder"
  // "Able was I ere I saw Elba"
  // "Madam, I'm Adam"
  // - collections
  // - strings
  def isPalindrome(str: String): Boolean = ???

  // Example :
  // convertNumberToBase10("419", 14) => "807"
  // convertNumberToBase10("1011", 2) => "11"
  // - collection methods
  def convertNumberToBase10(number: String, currentBase: Int): String = ???

  // Returns the factorial of a number
  // - recursion
  def factorialRecursive(n: Int): Int = ???

  // - ranges
  // - collection methods
  def factorialNotRecursive(n: Int): Int = ???

  // Write a function that returns true if the collection is sorted
  // /!\ Do not use the existing sort methods, you have to compare
  // the elements manually

  // - recursion
  // - basic collection manipulation
  def isSortedSimple(seq: Seq[Int]): Boolean = ???
  // - pattern matching
  def isSortedPatternMatching(seq: Seq[Int]): Boolean = ???
  // - advanced collection methods
  def isSortedFoldLeft(seq: Seq[Int]): Boolean = ???

  // Write a function that combines two lists by alternatively taking elements
  // e.g. [a,b,c], [1,2,3] → [a,1,b,2,c,3].
  // - collections advanced
  // - zip
  // - tuples
  // - flatmap
  // - partial functions for destructuring
  def combineAlternatively(seqA: Seq[String], seqB: Seq[String]): Seq[String] = ???

}
