package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks.homework20.getName

class Steps(private val testContext: TestContext<*>) {
    private fun execute(stepDesc: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepDesc, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(element: BaseActions) {
        execute("Клик на элемент ${element.getName()}") {
            element.click()
        }
    }

    fun disableNetwork() = execute("Отключение сети") { testContext.device.network.disable() }
    fun enableNetwork() = execute("Включение сети") { testContext.device.network.enable() }
    fun typeText(element: EditableActions, elementDesc: String, text: String) =
        execute("Ввод текста в $element") { element.typeText(text) }

    fun setChecked(element: CheckableActions, elementDesc: String, checked: Boolean) =
        execute("Установка состояния $elementDesc в $checked") { element.setChecked(checked) }

    fun setOrientationLeft() =
        execute("Установка ориентации лево") { testContext.device.uiDevice.setOrientationLeft() }

    fun setOrientationRight() =
        execute("Установка ориентации право") { testContext.device.uiDevice.setOrientationRight() }

    fun setOrientationNatural() =
        execute("Установка ориентации дефолтная") { testContext.device.uiDevice.setOrientationNatural() }

    fun hasText(element: TextViewAssertions, elementDesc: String, text: String) =
        execute("Текст у $elementDesc = $text") { element.hasText(text) }

    fun hasText(element: TextViewAssertions, elementDesc: String) =
        execute("$elementDesc имеет текст") { element.hasAnyText() }

    fun isChecked(element: CheckableAssertions, elementDesc: String) =
        execute("$elementDesc имеет checked состояние") { element.isChecked() }

    fun isNotChecked(element: CheckableAssertions, elementDesc: String) =
        execute("$elementDesc не имеет checked состояние") { element.isNotChecked() }

    fun isDisplayed(element: BaseAssertions, elementDesc: String) =
        execute("${(element as BaseActions).getName()} отображается") { element.isDisplayed() }
}