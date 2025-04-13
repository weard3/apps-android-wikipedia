package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

class NamedSteps(private val testContext: TestContext<*>) {
    private fun execute(stepDesc: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepDesc, actions)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    fun click(element: BaseActions) {
        execute("Клик на элемент ${element.getName()}") {
            element.click()
        }
    }

    fun isDisplayed(element: BaseAssertions) =
        execute("${(element as BaseActions).getName()} отображается") { element.isDisplayed() }
}