package example

import org.scalatest.FreeSpec

class BinarySearchTreeTest extends FreeSpec {

  "BinarySearchTree" - {
    "buildSomeSpecificTree" - {
      "should build the correct tree" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(tree.value == 10)
        assert(tree.left.isDefined)
        assert(tree.left.get.value == 4)
        assert(tree.left.get.left.isEmpty)
        assert(tree.left.get.right.isDefined)
        assert(tree.left.get.right.get.value == 5)
        assert(tree.left.get.right.get.left.isEmpty)
        assert(tree.left.get.right.get.right.isEmpty)
        assert(tree.right.isDefined)
        assert(tree.right.get.value == 15)
        assert(tree.right.get.left.isEmpty)
        assert(tree.right.get.right.isEmpty)
      }
    }
  }





}
