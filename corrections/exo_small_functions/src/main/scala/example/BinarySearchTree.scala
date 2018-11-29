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


  // TODO faire des unit tests de tous ces exos
  // TODO faire la function isSorted maybe

  // This method should build the following tree :
  //     10
  //    /  \
  //   4    15
  //    \
  //     5
  def buildSomeSpecificTree: Node = {
    Node(
      value = 10,
      left = Some(Node(
        value = 4,
        left = None,
        right = Some(Node(
          value = 5,
          left = None,
          right = None
        )),
      )),
      right = Some(Node(
        value = 15,
        left = None,
        right = None
      )),
    )
  }

  def multiplyAllNodesBy2(node: Node): Node =
    node.copy(
      value = node.value * 2,
      left = node.left.map(multiplyAllNodesBy2),
      right = node.right.map(multiplyAllNodesBy2)
    )

  // The next methods all assume the tree is ordered

  def isInTree(node: Node, value: Int): Boolean = {
    node.value == value || {
      val subNodeOption = if (node.value > value) node.left else node.right
      subNodeOption.exists(subNode => isInTree(subNode, value))
    }
  }


  def insert(node: Node, value: Int): Node = {
    if (node.value == value) node
    else if (node.value > value) {
      node.left match {
        case None => node.copy(
          left = Some(Node(value = value, left = None, right = None))
        )
        case Some(subNode) => node.copy(
          left = Some(insert(subNode, value))
        )
      }
    } else {
      node.right match {
        case None => node.copy(
          right = Some(Node(value = value, left = None, right = None))
        )
        case Some(subNode) => node.copy(
          right = Some(insert(subNode, value))
        )
      }
    }
  }

  // TODO be careful this seems a bit difficult, see wikipedia
  def isSorted(): Boolean = ???


  def buildTreeRecursive(elements: Seq[Int]): Node = {

    def insertElements(currentNode: Node, elts: Seq[Int]): Node = {
      elts match {
        case Seq() =>
          currentNode
        case head +: tail =>
          insertElements(insert(currentNode, head), tail)
      }
    }

    insertElements(
      Node(
        value = elements.head,
        left = None,
        right = None
      ),
      elements.tail
    )

  }


  def buildTreeFoldLeft(elements: Seq[Int]): Node = {
    elements.tail.foldLeft(Node(
      value = elements.head,
      left = None,
      right = None
    )) { (acc, elt) =>
      insert(acc, elt)
    }
  }



}
