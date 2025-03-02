package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class Hw9Tests() : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        run {
            step("Клик на кнопку пропуска онбординга") {
                OnboardingScreen.skipBtn.click()
            }
            step("Клик по третьей картинке в блоке In the news") {
                ExploreScreen.feed.childWith<InTheNewsItem> {
                    withDescendant { withText(R.string.view_card_news_title) }
                }.perform {
                    items.childAt<InTheNewsCardItem>(2) { image.click() }
                }
            }
            step("Экран In the news. Клик по второй карточке") {
                InTheNewsScreen.items.childAt<InTheNewsStoryItemsItem>(1) { title.click() }
            }
            step("Проверка, что отображается web view") {
                ArticleScreen.webView.isDisplayed()
            }
        }
    }
}