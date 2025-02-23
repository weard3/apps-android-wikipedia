package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId = null
    override val viewClass = null

    val skipBtn = KButton { withId(R.id.fragment_onboarding_skip_button) }
    val continueBtn = KButton { withId(R.id.fragment_onboarding_forward_button) }
    val pageIndicator = KTabLayout { withId(R.id.view_onboarding_page_indicator) }
    val pager = KViewPager2(
        builder = { withId(R.id.fragment_pager) },
        itemTypeBuilder = { itemType(::OnboardingItem) }
    )

}