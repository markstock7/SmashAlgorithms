package algorithms.string


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PalindromeSuite extends FunSuite {
	import Palindrome._

	test("isPalindrome") {
		assert(isPalindrome(" race a E-car "), "")
	}
}