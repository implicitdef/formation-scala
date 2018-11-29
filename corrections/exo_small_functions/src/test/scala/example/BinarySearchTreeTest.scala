package example

import example.BinarySearchTree.Node
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
    "multiplyAllNodesBy2" - {
      "should work with a simple node" in {
        assert(BinarySearchTree.multiplyAllNodesBy2(Node(value = 3)) == Node(value = 6))
      }
      "should work with the tree from buildSomeSpecificTree" in {
        val tree = BinarySearchTree.multiplyAllNodesBy2(BinarySearchTree.buildSomeSpecificTree)
        assert(tree.value == 20)
        assert(tree.left.isDefined)
        assert(tree.left.get.value == 8)
        assert(tree.left.get.left.isEmpty)
        assert(tree.left.get.right.isDefined)
        assert(tree.left.get.right.get.value == 10)
        assert(tree.left.get.right.get.left.isEmpty)
        assert(tree.left.get.right.get.right.isEmpty)
        assert(tree.right.isDefined)
        assert(tree.right.get.value == 30)
        assert(tree.right.get.left.isEmpty)
        assert(tree.right.get.right.isEmpty)
      }
    }

    "isInTree" - {
      "should find the values that are in it" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(BinarySearchTree.isInTree(tree, 10))
        assert(BinarySearchTree.isInTree(tree, 4))
        assert(BinarySearchTree.isInTree(tree, 5))
        assert(BinarySearchTree.isInTree(tree, 15))
      }
      "should not find the values that are not in it" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(!BinarySearchTree.isInTree(tree, 9))
        assert(!BinarySearchTree.isInTree(tree, 7))
        assert(!BinarySearchTree.isInTree(tree, 45))
        assert(!BinarySearchTree.isInTree(tree, -10))
      }
    }

    "insert" - {
      "should do nothing if already there" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(BinarySearchTree.insert(tree, 15) == tree)
        assert(BinarySearchTree.insert(tree, 4) == tree)
      }
      "should insert 6" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(BinarySearchTree.insert(tree, 6) == tree.copy(
          left = tree.left.map { subNode =>
            subNode.copy(
              right = subNode.right.map { subSubNode =>
                subSubNode.copy(
                  right = Some(Node(6))
                )
              }
            )
          }
        ))
      }
      "should insert 12" in {
        val tree = BinarySearchTree.buildSomeSpecificTree
        assert(BinarySearchTree.insert(tree, 12) == tree.copy(
          right = tree.right.map { subNode =>
            subNode.copy(
              left = Some(Node(12))
            )
          }
        ))
      }
    }

    "buildTree" - {
      "recursive" in {
        val tree = BinarySearchTree.buildTreeRecursive(Seq(10, 4, 5, 15))
        assert(tree == BinarySearchTree.buildSomeSpecificTree)
      }
      "foldLeft" in {
        val tree = BinarySearchTree.buildTreeFoldLeft(Seq(10, 4, 5, 15))
        assert(tree == BinarySearchTree.buildSomeSpecificTree)
      }

    }

  }





}
