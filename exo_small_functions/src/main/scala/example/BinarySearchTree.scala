package example

object BinarySearchTree {

  // https://en.wikipedia.org/wiki/Binary_search_tree#

  // Each node has at most two children, which are referred to as the left child and the right child
  // The key in each node must be greater than or equal to any key stored in the left sub-tree
  // and less than or equal to any key stored in the right sub-tree

  case class Node(
    value: Int,
    left: Option[Node] = None,
    right: Option[Node] = None,
  )

  // This method should build the following tree :
  //     10
  //    /  \
  //   4    15
  //    \
  //     5
  def buildSomeSpecificTree: Node = ???

  def multiplyAllNodesBy2(node: Node): Node = ???

  // The next methods all assume the tree is ordered

  def isInTree(node: Node, value: Int): Boolean = ???

  def insert(node: Node, value: Int): Node = ???

  def buildTreeRecursive(elements: Seq[Int]): Node = ???
  def buildTreeFoldLeft(elements: Seq[Int]): Node = ???



}
