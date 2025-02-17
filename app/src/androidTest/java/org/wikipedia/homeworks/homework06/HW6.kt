package org.wikipedia.homeworks.homework06

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
