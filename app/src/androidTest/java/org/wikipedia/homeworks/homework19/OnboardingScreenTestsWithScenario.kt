package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingItem
import org.wikipedia.homeworks.homework08.OnboardingLanguageListItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class OnboardingScreenTestsWithScenario :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Тест проверяет отображение всех элементов на 1 экране онбординга
     */
    @Test
    fun firstScreenElementsAppearanceTest() {
        run {
            val steps = Steps(this)
            steps {
                isDisplayed(OnboardingScreen.skipBtn, "Кнопка пропуска онбординга")
                isDisplayed(OnboardingScreen.continueBtn, "Кнопка continue")
                OnboardingScreen.pager.childAt<OnboardingItem>(0) {
                    isDisplayed(image, "Картинка")
                    isDisplayed(primaryText, "Заголовок")
                    isDisplayed(secondaryText, "Второстепенный текст")
                    languageList.childAt<OnboardingLanguageListItem>(0) {
                        hasText(this, "Первый язык в списке", "1.\t\tEnglish")
                    }
                    isDisplayed(addLanguageBtn, "Кнопка добавления языка")
                }
            }
        }
    }
}