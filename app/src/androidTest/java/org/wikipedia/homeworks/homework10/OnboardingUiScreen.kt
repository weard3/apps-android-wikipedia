package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

class OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val image = UiView { withId(this@OnboardingUiScreen.packageName, "imageViewCentered") }
    val skipBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }
    val continueBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }
    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }
    val secondaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }
    val pageIndicator = UiBottomNavigationView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }
    val getStartedBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }
}