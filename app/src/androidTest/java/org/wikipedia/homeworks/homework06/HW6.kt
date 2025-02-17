import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher

enum class Color {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    BLACK,
    WHITE,
}

data class Shape(val length: Float, val sidesCount: Int, val color: Color)

class SideLengthRangeMatcher(val min: Float, val max: Float) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape) = item.length in min..max

    override fun describeTo(description: Description) {
        description.appendText("length should be between $min and $max")
    }
}

class CornerCountMatcher(val expectedCorners: Int) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape): Boolean {
        val corners = if (item.sidesCount >= 3) item.sidesCount else 0
        return corners == expectedCorners
    }

    override fun describeTo(description: Description) {
        description.appendText("sides count should be $expectedCorners")
    }
}

class SidesCountIsEvenMatcher(val isEven: Boolean) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape) = item.sidesCount % 2 == 0 == isEven

    override fun describeTo(description: Description) {
        description.appendText("sides count should be ${if (isEven) "even" else "odd"}")
    }
}

class ColorMatcher(val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape) = item.color == expectedColor

    override fun describeTo(description: Description) {
        description.appendText("color should be $expectedColor")
    }
}

class SideLengthMatcher(val isNegative: Boolean) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape) = item.length < 0 == isNegative

    override fun describeTo(description: Description) {
        description.appendText("length should be ${if (isNegative) "negative" else "positive"}")
    }
}

class SideCountMatcher(val isNegative: Boolean) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(item: Shape) = item.sidesCount < 0 == isNegative

    override fun describeTo(description: Description) {
        description.appendText("sides count should be ${if (isNegative) "negative" else "positive"}")
    }
}

class ShapeMatcherBuilder() {
    private val matchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: ShapeMatcherBuilder.() -> Unit) {
        function()
    }

    fun sideLengthInRange(min: Float, max: Float) = matchers.add(SideLengthRangeMatcher(min, max))
    fun cornerCount(expectedCorners: Int) = matchers.add(CornerCountMatcher(expectedCorners))
    fun sidesCountIsEven(isEven: Boolean) = matchers.add(SidesCountIsEvenMatcher(isEven))
    fun color(expectedColor: Color) = matchers.add(ColorMatcher(expectedColor))
    fun sideLengthIsNegative() = matchers.add(SideLengthMatcher(true))
    fun sideLengthIsPositive() = matchers.add(SideLengthMatcher(false))
    fun sideCountIsNegative() = matchers.add(SideCountMatcher(true))
    fun sideCountIsPositive() = matchers.add(SideCountMatcher(false))
    fun buildAllMatchers() = allOf(matchers)
    fun buildAnyMatchers() = anyOf(matchers)
}

fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )
    val builder = ShapeMatcherBuilder()
    builder {
        sideLengthInRange(0.1f, 100f)
        cornerCount(4)
        sidesCountIsEven(true)
        color(Color.BLUE)
        sideLengthIsPositive()
        sideCountIsPositive()
    }
    shapes.filter { builder.buildAllMatchers().matches(it) }.also { println(it) }
}