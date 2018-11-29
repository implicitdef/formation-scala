package example

object SomeFunctions {

  // TODO réorganiser, classifier, faire la version sans correction

  // Write a program that prints ‘Hello World’ to the screen.
  // - print to the console
  def helloWorld(): Unit =
    println("Hello world")

  // Write a program that prints the number 1 to 100
  // Except that if the number is a multiple of 3, prints "Fizz"
  // If the number is a multiple of 5, prints "Buzz"
  // If the number is both a multiple of 3 and 5, prints "FizzBuzz" instead
  // Otherwise, just print the number itself
  // - simple for comprehension
  // - ranges
  // - if else
  // - val
  def fizzbuzz(): Unit =
    for (i <- 1 to 100) {
      val multipleOf3 = i % 3 == 0
      val multipleOf5 = i % 5 == 0
      println {
        if (multipleOf3 && multipleOf5) "FizzBuzz"
        else if (multipleOf3) "Fizz"
        else if (multipleOf5) "Buzz"
        else i
      }
    }

  // Write a program that prints a multiplication table for numbers up to 12.
  // - ranges
  // - for comprehension
  // - string concatenation
  def multiplicationTable(): Unit =
    for {
      i <- 1 to 12
      j <- 1 to 12
    } println(s"$i x $j = ${i * j}")

  // Write a program that prints the sum of the numbers 1 to n
  // - collections methods
  def sumOfNumbersToN(n: Int): Unit =
    println((1 to n).sum)


  // -------------------------------------
  // All the methods below are unit-tested

  // Write a function that computes the N-th fibonacci number
  // The first two Fibonacci numbers are 1 and 1.
  // The n+1-st Fibonacci number can be computed by adding the n-th and the n-1-th Fibonacci number.
  // The first few are therefore 1, 1, 1+1=2, 1+2=3, 2+3=5, 3+5=8.
  // - recursion
  // - if statement
  def fibonacci(n: Int): Int =
    if (n == 0 || n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  // Write a function that returns true if the collection is sorted
  // /!\ Do not use the existing sort methods, you have to compare
  // the elements manually

  // - recursion
  // - basic collection manipulation
  def isSortedSimple(seq: Seq[Int]): Boolean =
    if (seq.size <= 1) true
    else seq.head <= seq(1) && isSortedSimple(seq.tail)
  // - pattern matching
  def isSortedPatternMatching(seq: Seq[Int]): Boolean = seq match {
    case a +: b +: rest =>
      a <= b && isSortedPatternMatching(b +: rest)
    case _ => true
  }
  // - advanced collection methods
  def isSortedFoldLeft(seq: Seq[Int]): Boolean =
    seq.sliding(2).foldLeft(true) { case (acc, current) =>
      acc && current.head <= current(1)
    }

  // Write a function that tests whether a string is a palindrome.
  // Should ignore all non-alphanumeric characters, and be case-insensitive
  // Example of valid palindromes :
  // "racecar"
  // "redder"
  // "Able was I ere I saw Elba"
  // "Madam, I'm Adam"
  // - collections
  // - strings
  def isPalindrome(str: String): Boolean = {
    val strCleaned = str
      .filter(_.isLetterOrDigit)
      .toLowerCase
    strCleaned.reverse == strCleaned
  }

  // Write a function that combines two lists by alternatingly taking elements
  // e.g. [a,b,c], [1,2,3] → [a,1,b,2,c,3].
  // - collections advanced
  // - zip
  // - tuples
  // - flatmap
  // - partial functions for destructuring
  def combineAlternatively(seqA: Seq[String], seqB: Seq[String]): Seq[String] =
    seqA.zip(seqB).flatMap { case (a, b) =>
      Seq(a, b)
    }


  // example :
  // convertNumberToBase10("419", 14) => "807"
  // convertNumberToBase10("1011", 2) => "11"
  def convertNumberToBase10(number: String, currentBase: Int): String =
    number
      .reverse
      .zipWithIndex.map { case (digit, idx) =>
      digit.toString.toInt * Math.pow(currentBase, idx)
    }.sum.toInt.toString


}
