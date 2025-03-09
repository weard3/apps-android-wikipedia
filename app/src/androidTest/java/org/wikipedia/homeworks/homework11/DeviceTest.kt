package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.text.KButton
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework03.skipBtn
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.InTheNewsScreen
import org.wikipedia.homeworks.homework09.InTheNewsStoryItemsItem
import org.wikipedia.main.MainActivity
import org.wikipedia.onboarding.InitialOnboardingActivity
import java.util.Locale

class DeviceTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    private val retryBtn = KButton { withId(R.id.view_wiki_error_button) }

    @Test
    fun orientationTest() {
        before {
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            device.uiDevice.apply {
                setOrientationRight()
                assertFalse(isNaturalOrientation)
            }
        }
    }

    @Test
    fun deviceWakeUpTest() {
        before {
        }.after {
            device.uiDevice.wakeUp()
        }.run {
            device.uiDevice.apply {
                sleep()
                wakeUp()
            }
            OnboardingScreen.continueBtn.isDisplayed()
        }
    }

    @Test
    fun restoreAppTest() {
        before {

        }.after {

        }.run {
            device.uiDevice.pressHome()
            repeat(2) { device.uiDevice.pressRecentApps() }
            OnboardingScreen.continueBtn.isDisplayed()
        }
    }

    @Test
    fun networkErrorAppearanceTest() {
        before {

        }.after {
            device.network.enable()
        }.run {
            OnboardingScreen.skipBtn.click()
            step("Клик по первой картинке в блоке In the news") {
                ExploreScreen.feed.childWith<InTheNewsItem> {
                    withDescendant { withText(R.string.view_card_news_title) }
                }.perform {
                    items.childAt<InTheNewsCardItem>(0) { image.click() }
                }
            }
            device.network.disable()
            step("Экран In the news. Клик по первой карточке") {
                InTheNewsScreen.items.childAt<InTheNewsStoryItemsItem>(0) { title.click() }
            }
            retryBtn.isDisplayed()
            device.network.enable()
            retryBtn.click()
            retryBtn.isNotDisplayed()
        }
    }

    @Test
    fun languageTest() {
        before {

        }.after {
            device.language.switchInApp(Locale.getDefault())
        }.run {
            device.language.switchInApp(Locale.FRENCH)
            OnboardingScreen.skipBtn {
                isDisplayed()
                hasText("Sauter")
            }
        }
    }

    @Test
    fun activityTest() {
        run {
            device.activities.isCurrent(InitialOnboardingActivity::class.java)
        }
    }
}