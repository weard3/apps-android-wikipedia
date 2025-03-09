package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    private val onboardingUiScreen = OnboardingUiScreen()

    @Test
    fun firstScreenTextsTest() {
        run {
            onboardingUiScreen {
                step("Главный текст отображается и имеет корректный текст") {
                    primaryText {
                        isDisplayed()
                        hasText("The Free Encyclopedia\n…in over 300 languages")
                        containsText("The Free Encyclopedia")
                    }
                }
                step("Вторичный текст отображается и имеет корректный текст") {
                    secondaryText {
                        isDisplayed()
                        hasText("We’ve found the following on your device:")
                    }
                }
                step("Кнопка пропуска отображается и имеет текст Skip") {
                    skipBtn {
                        isDisplayed()
                        hasText("Skip")
                    }
                }
                step("Кнопка продолжения отображается и имеет текст Continue") {
                    continueBtn {
                        isDisplayed()
                        hasText("Continue")
                    }
                }
                step("Проверка отображения изображения") {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun secondScreenTextsTest() {
        run {
            onboardingUiScreen {
                step("Переход на второй экран через bottom nav") {
                    pageIndicator.setSelectedItemWithIndex(1)
                }
                step("Главный текст отображается и имеет корректный текст") {
                    primaryText {
                        isDisplayed()
                        hasText("New ways to explore")
                    }
                }
                step("Вторичный текст отображается и имеет корректный текст") {
                    secondaryText {
                        isDisplayed()
                        hasText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \nCustomize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.")
                    }
                }
                step("Кнопка пропуска отображается и имеет текст Skip") {
                    skipBtn {
                        isDisplayed()
                        hasText("Skip")
                    }
                }
                step("Кнопка продолжения отображается и имеет текст Continue") {
                    continueBtn {
                        isDisplayed()
                        hasText("Continue")
                    }
                }
                step("Проверка отображения изображения") {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun thirdScreenTextsTest() {
        run {
            onboardingUiScreen {
                step("Переход на третий экран через bottom nav") {
                    pageIndicator.setSelectedItemWithIndex(2)
                }
                step("Главный текст отображается и имеет корректный текст") {
                    primaryText {
                        isDisplayed()
                        hasText("Reading lists with sync")
                    }
                }
                step("Вторичный текст отображается и имеет корректный текст") {
                    secondaryText {
                        isDisplayed()
                        hasText("You can make reading lists from articles you want to read later, even when you’re offline. \nLogin to your Wikipedia account to sync your reading lists. Join Wikipedia")
                    }
                }
                step("Кнопка пропуска отображается и имеет текст Skip") {
                    skipBtn {
                        isDisplayed()
                        hasText("Skip")
                    }
                }
                step("Кнопка продолжения отображается и имеет текст Continue") {
                    continueBtn {
                        isDisplayed()
                        hasText("Continue")
                    }
                }
                step("Проверка отображения изображения") {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun fourthScreenTextsTest() {
        run {
            onboardingUiScreen {
                step("Переход на четвертый экран через bottom nav") {
                    pageIndicator.setSelectedItemWithIndex(3)
                }
                step("Главный текст отображается и имеет корректный текст") {
                    primaryText {
                        isDisplayed()
                        hasText("Data & Privacy")
                    }
                }
                step("Вторичный текст отображается и имеет корректный текст") {
                    secondaryText {
                        isDisplayed()
                        hasText("We believe that you should not have to provide personal information to participate in the free knowledge movement. Usage data collected for this app is anonymous. Learn more about our privacy policy and terms of use.")
                    }
                }
                step("Кнопка пропуска не отображается") {
                    skipBtn.isNotDisplayed()
                }
                step("Кнопка продолжения не отображается") {
                    continueBtn.isNotDisplayed()
                }
                step("Кнопка завершения онбординга отображается и имеет текст Get started") {
                    getStartedBtn {
                        isDisplayed()
                        hasText("Get started")
                    }
                }
                step("Проверка отображения изображения") {
                    image.isDisplayed()
                }
            }
        }
    }
}