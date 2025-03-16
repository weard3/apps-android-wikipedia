package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.ArticleScreen
import org.wikipedia.main.MainActivity

class WebViewTests : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    // В первой статье не было Bibliography, поэтому проверяю Notes
    @Test
    fun test() {
        run {
            OnboardingScreen.skipBtn.click()
            ExploreScreen.getTopReadItem().cardList.childAt<TopReadCardItem>(0) { click() }
            ArticleScreen.webViewAsWebView {
                withElement(Locator.ID, "Notes") {
                    scroll()
                    hasText("Notes")
                }
                withElement(
                    Locator.XPATH,
                    "//sup[@id='cite_ref-5']//a[@class='reference-link']"
                ) {
                    click()
                }
            }
            ReferenceBottomSheetScreen {
                referenceText.hasText(""""Total Lunar Eclipse of 2025 Mar 14" (PDF). NASA. Archived (PDF) from the original on 4 December 2024. Retrieved 18 November 2024.""")
                referenceNumber.hasText("5.")
            }
            device.uiDevice.pressBack()
            ArticleScreen.webViewAsWebView {
                withElement(Locator.CSS_SELECTOR, ".mw-redirect:nth-child(2)"){
                    click()
                }
            }
            LinkViewBottomSheetScreen.readArticleBtn.click()
            ArticleScreen.webViewAsWebView {
                withElement(Locator.ID, "Bibliography") {
                    scroll()
                }
            }
        }
    }
}