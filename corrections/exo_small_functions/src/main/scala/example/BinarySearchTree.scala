package example

object BinarySearchTree {

  // https://en.wikipedia.org/wiki/Binary_search_tree#

  // Each node has at most two children, which are referred to as the left child and the right child
  // The key in each node must be greater than or equal to any key stored in the left sub-tree
  // and less than or equal to any key stored in the right sub-tree

  case class Node(
    value: Int,
    left: Option[Node],
    right: Option[Node],
  )


  // TODO fonction pour instancier un binary tree arbitraire (instancer les cases classes)
  // TODO Multiplier un binary tree par deux (toutes les valeurs)
  // TODO Instancier un tree dans une factory function pour construire un arbre entier

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




}
