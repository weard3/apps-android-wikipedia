package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.main.MainActivity

class NamedStepsTest :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        run {
            step("Пропуск онбординга") {
                OnboardingScreen.skipBtn.click()
            }
            val topReadBlock = ExploreScreenNew.topReadItem()
            namedSteps{
                isDisplayed(topReadBlock.moreTopReadBtn)
                isDisplayed(topReadBlock.menuBtn)
                isDisplayed(topReadBlock.headerText)
                isDisplayed(topReadBlock.cardList)
            }
        }
    }

}