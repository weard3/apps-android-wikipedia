package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.main.MainActivity

class OnboardingScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Тест проверяет отображение всех элементов на 1 экране онбординга
     */
    @Test
    fun firstScreenElementsAppearanceTest() {
        run {
            step("Проверка отображения элементов на первом экране") {
                OnboardingScreen {
                    pager.childAt<OnboardingItem>(0) {
                        image.isDisplayed()
                        primaryText.isDisplayed()
                        secondaryText.isDisplayed()
                        languageList.isDisplayed()
                        addLanguageBtn.isDisplayed()
                    }
                    skipBtn.isDisplayed()
                    continueBtn.isDisplayed()
                    pageIndicator.isDisplayed()
                }
            }
        }
    }

    /**
     * Тест проверяет тексты на первой странице онбординга
     */
    fun firstScreenTextsTest() {
        run {
            step("Проверка главного текста") {
                OnboardingScreen.pager.childAt<OnboardingItem>(0) {
                    primaryText.hasText(R.string.onboarding_welcome_title_v2)
                }
            }
            step("Проверка второстепенного текста") {
                OnboardingScreen.pager.childAt<OnboardingItem>(0) {
                    secondaryText.hasText(R.string.onboarding_multilingual_secondary_text)
                }
            }
        }
    }

    /**
     * Тест проверяет, что при клике на кнопку Continue происходит переход на след. экран
     */
    @Test
    fun continueBtnCheck() {
        run {
            step("Клик на кнопку продолжить и проверка, что произошел переход на след. экран") {
                OnboardingScreen {
                    continueBtn.click()
                    pageIndicator.isTabSelected(1)
                    pager.childAt<OnboardingItem>(1) {
                        isDisplayed()
                        primaryText.hasText(R.string.onboarding_explore_title)
                    }
                }
            }
        }
    }

    /**
     * Тест проверяет, что при клике на кнопку skip пропускается экран онбординга
     */
    @Test
    fun skipBtnTest() {
        run {
            step("Клик на кнопку skip и проверка, что отображается экран explore") {
                OnboardingScreen.skipBtn.click()
                ExploreScreen.feed.isDisplayed()
            }
        }
    }

    @Test
    fun languageListContainsEnglish() {
        run {
            step("Проверка, что первый язык в списке - 1. English") {
                OnboardingScreen.pager.childAt<OnboardingItem>(0) {
                    languageList.childAt<OnboardingLanguageListItem>(0) {
                        isDisplayed()
                        hasText("1.\t\tEnglish")
                    }
                }
            }
        }
    }
}