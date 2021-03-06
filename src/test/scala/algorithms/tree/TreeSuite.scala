package algorithms.tree

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import utils.Helper

@RunWith(classOf[JUnitRunner])
class TreeSuite extends FunSuite {

	test("Symmetric Tree") {
		import SymmetricTree._
		val tree1 = TreeNode(
			1,
			TreeNode(2, TreeNode(8), TreeNode(16)),
			TreeNode(4)
		)
		val tree2 = TreeNode(
			2,
			TreeNode(8),
			TreeNode(16)
		)
		val tree3 = TreeNode(
			2,
			TreeNode(17),
			TreeNode(17)
		)
		assert(!isSymmetric(tree1))
		assert(!isSymmetric(tree2))
		assert(isSymmetric(tree3))
	}

	test("Same Tree") {
		import SameTree._
		val tree1 = TreeNode(
			1,
			TreeNode(2, TreeNode(8), TreeNode(16)),
			TreeNode(4)
		)
		val tree2 = TreeNode(
			2,
			TreeNode(8),
			TreeNode(16)
		)
		val tree3 = TreeNode(
			2,
			TreeNode(17),
			TreeNode(17)
		)
		assert(!isSameTree(tree1, tree2))
		assert(isSameTree(tree2, tree2))
		assert(isSameTree(tree3, tree3))
	}

	test("Minimum Depth of Binary Tree") {
		import MinimumDepthofBinaryTree._
		val tree1 = TreeNode(
			1,
			TreeNode(2, TreeNode(8), TreeNode(16)),
			TreeNode(4)
		)
		val tree2 = TreeNode(
			2,
			TreeNode(8),
			TreeNode(16)
		)
		val tree3 = TreeNode(
			2
		)
		assert(minDepth(tree1) == 2)
		assert(minDepth(tree2) == 2)
		assert(minDepth(tree3) == 1)
	}

	test("Maximum Depth of Binary Tree") {
		import MaximumDepthofBinaryTree._
		val tree1 = TreeNode(
			1,
			TreeNode(2, TreeNode(8), TreeNode(16)),
			TreeNode(4)
		)
		val tree2 = TreeNode(
			2,
			TreeNode(8),
			TreeNode(16)
		)
		val tree3 = TreeNode(
			2
		)
		assert(maxDepth(tree1) == 3)
		assert(maxDepth(tree2) == 2)
		assert(maxDepth(tree3) == 1)
	}

	test("Binary TreeLevel Order Traversal II") {
		import BinaryTreeLevelOrderTraversalII._
		val tree = TreeNode(
			3,
			TreeNode(9),
			TreeNode(20, TreeNode(15), TreeNode(7))
		)
		assert(levelOrderBottom(tree).map(_.mkString(",")).mkString(",") == "15,7,9,20,3")
	}

	test("Invert Tree") {
		import InvertTree.invertTree
		val tree = TreeNode(
			3,
			TreeNode(9),
			TreeNode(20, TreeNode(15), TreeNode(7))
		)
		assert(invertTree(tree).toString == "7,20,15,3,9")
	}

	test("Balanced Binary Tree") {
		import BalancedBinaryTree._
		val balancedTree = TreeNode(
			3,
			TreeNode(9),
			TreeNode(20, TreeNode(15), TreeNode(7))
		)
		val unBalancedTree = TreeNode(
			1,
			TreeNode(
				2,
				TreeNode(
					3,
					TreeNode(4),
					TreeNode(4)
				),
				TreeNode(3)
			),
			TreeNode(2)
		)
		assert(isBalancedTopDown(balancedTree), "isBalancedTopDown")
		assert(isBalancedBottomUp(balancedTree), "isBalancedBottomUp")
		assert(!isBalancedTopDown(unBalancedTree), "isBalancedTopDown")
		assert(!isBalancedBottomUp(unBalancedTree), "isBalancedBottomUp")
	}

	test("SearchInABinarySearchTree") {
		import SearchInABinarySearchTree.searchBST
		val tree = TreeNode(
			4,
			TreeNode(
				2,
				TreeNode(1),
				TreeNode(3)
			),
			TreeNode(7)
		)
		assert(searchBST(tree, 2).toString == "1,2,3")
		assert(searchBST(tree, 0)  == null)
	}

	test("Build Binary Search Tree") {
		import BuildBinarySearchTree.sortedArrayToBST
		assert(BalancedBinaryTree.isBalancedBottomUp(sortedArrayToBST(Array(-10,-3,0,5,9))))
		assert(BalancedBinaryTree.isBalancedBottomUp(sortedArrayToBST(Array(1, 2, 4, 8, 16))))
	}

	test("PathSumII") {
		import PathSumII.pathSum

		val tree = TreeNode(
			5,
			TreeNode(
				4,
				TreeNode(
					11,
					TreeNode(7),
					TreeNode(2)
				)
			),
			TreeNode(
				8,
				TreeNode(13),
				TreeNode(
					4,
					TreeNode(5),
					TreeNode(1)
				)
			)
		)

		assert(pathSum(tree, 22).map(_.sum).mkString(",") == "22,22")

	}

	test("Binary Tree Level Order") {
		import BinaryTreeLevelOrderTraversal.levelOrder
		val tree = TreeNode(
			4,
			TreeNode(
				2,
				TreeNode(1),
				TreeNode(3)
			),
			TreeNode(7)
		)

		assert(Helper.llcompare(levelOrder(tree), List(List(4), List(2,7), List(1,3))))
	}

	test("Pre Order") {
		import PreOrder.solution

		val tree = TreeNode(
			4,
			TreeNode(
				2,
				TreeNode(1),
				TreeNode(3)
			),
			TreeNode(7)
		)

		assert(Helper.lcompare(solution(tree), List(4,2,1,3,7)))
	}
}
