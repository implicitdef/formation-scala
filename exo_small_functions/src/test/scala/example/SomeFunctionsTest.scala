package example

import org.scalatest.FreeSpec

class SomeFunctionsTest extends FreeSpec {

  "Fibonacci" - {
    "number #0 should be correct" in {
      assert(SomeFunctions.fibonacci(0) == 1)
    }
    "number #1 should be correct" in {
      assert(SomeFunctions.fibonacci(1) == 1)
    }
    "number #2 should be correct" in {
      assert(SomeFunctions.fibonacci(2) == 2)
    }
    "number #3 should be correct" in {
      assert(SomeFunctions.fibonacci(3) == 3)
    }
    "number #18 should be correct" in {
      assert(SomeFunctions.fibonacci(18) == 4181)
    }
  }

  "isPalindrome" - {
    "should work with basic palindrom word" in {
      assert(SomeFunctions.isPalindrome("racecar"))
      assert(SomeFunctions.isPalindrome("redder"))
    }
    "should ignore case and non alphanumeric characters" in {
      assert(SomeFunctions.isPalindrome("Madam, I'm Adam"))
    }
    "should detect if not palindrome" in {
      assert(!SomeFunctions.isPalindrome("Madam, I'm George"))
    }
  }

  "factorial" - {
    "recursive" - {
      "should work" in {
        assert(SomeFunctions.factorialRecursive(5) == 120)
      }
    }
    "not recursive" - {
      "should work" in {
        assert(SomeFunctions.factorialNotRecursive(5) == 120)
      }
    }
  }

  "isSorted" - {
    "isSortedSimple" - {
      "with empty Seq should return true" in {
        assert(SomeFunctions.isSortedSimple(Seq.empty))
      }
      "with a few sorted Seq should return true" in {
        assert(SomeFunctions.isSortedSimple(Seq(2, 3)))
        assert(SomeFunctions.isSortedSimple(Seq(10, 20, 100)))
        assert(SomeFunctions.isSortedSimple(Seq(-3, 0, 1, 99, 1000, 1001, 1002)))
      }
      "with a sorted Seq with equal numbers should return true" in {
        assert(SomeFunctions.isSortedSimple(Seq(2, 3, 3, 10)))
      }
      "with a few non-sorted Seq should return false" in {
        assert(!SomeFunctions.isSortedSimple(Seq(2, -2)))
        assert(!SomeFunctions.isSortedSimple(Seq(10, 20, 100, -1)))
        assert(!SomeFunctions.isSortedSimple(Seq(10, 20, 15, 30)))
      }
    }
    "isSortedWithPatternMatching" - {
      "with empty Seq should return true" in {
        assert(SomeFunctions.isSortedPatternMatching(Seq.empty))
      }
      "with a few sorted Seq should return true" in {
        assert(SomeFunctions.isSortedPatternMatching(Seq(2, 3)))
        assert(SomeFunctions.isSortedPatternMatching(Seq(10, 20, 100)))
        assert(SomeFunctions.isSortedPatternMatching(Seq(-3, 0, 1, 99, 1000, 1001, 1002)))
      }
      "with a sorted Seq with equal numbers should return true" in {
        assert(SomeFunctions.isSortedPatternMatching(Seq(2, 3, 3, 10)))
      }
      "with a few non-sorted Seq should return false" in {
        assert(!SomeFunctions.isSortedPatternMatching(Seq(2, -2)))
        assert(!SomeFunctions.isSortedPatternMatching(Seq(10, 20, 100, -1)))
        assert(!SomeFunctions.isSortedPatternMatching(Seq(10, 20, 15, 30)))
      }
    }
    "isSortedFoldLeft" - {
      "with empty Seq should return true" in {
        assert(SomeFunctions.isSortedFoldLeft(Seq.empty))
      }
      "with a few sorted Seq should return true" in {
        assert(SomeFunctions.isSortedFoldLeft(Seq(2, 3)))
        assert(SomeFunctions.isSortedFoldLeft(Seq(10, 20, 100)))
        assert(SomeFunctions.isSortedFoldLeft(Seq(-3, 0, 1, 99, 1000, 1001, 1002)))
      }
      "with a sorted Seq with equal numbers should return true" in {
        assert(SomeFunctions.isSortedFoldLeft(Seq(2, 3, 3, 10)))
      }
      "with a few non-sorted Seq should return false" in {
        assert(!SomeFunctions.isSortedFoldLeft(Seq(2, -2)))
        assert(!SomeFunctions.isSortedFoldLeft(Seq(10, 20, 100, -1)))
        assert(!SomeFunctions.isSortedFoldLeft(Seq(10, 20, 15, 30)))
      }
    }
  }


  "combineAlternatively" - {
    "should work with basic case" in {
      assert(SomeFunctions.combineAlternatively(
        Seq("foo", "bar", "qux"),
        Seq("one", "two", "three")
      ) == Seq("foo", "one", "bar", "two", "qux", "three"))
    }
    "should work with different seq lengths" in {
      assert(SomeFunctions.combineAlternatively(
        Seq("foo", "bar"),
        Seq("one", "two", "three")
      ) == Seq("foo", "one", "bar", "two"))
    }
    "should work with empty seq" in {
      assert(SomeFunctions.combineAlternatively(
        Seq("foo", "bar"),
        Seq.empty
      ) == Seq.empty)
    }
  }

  "convertNumberToBase10" - {
    "should work with base 2" in {
      assert(SomeFunctions.convertNumberToBase10("1011", 2) == "11")
    }
    "should work with base 14" in {
      assert(SomeFunctions.convertNumberToBase10("419", 14) == "807")
    }
    "should work with single digit" in {
      assert(SomeFunctions.convertNumberToBase10("3", 6) == "3")
    }
    "should work with 0" in {
      assert(SomeFunctions.convertNumberToBase10("0", 8) == "0")
    }

  }





}
