package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingItem>(matcher) {
    val image = KImageView(matcher) { withId(R.id.imageViewCentered) }
    val primaryText = KTextView(matcher) { withId(R.id.primaryTextView) }
    val secondaryText = KTextView(matcher) { withId(R.id.secondaryTextView) }
    val addLanguageBtn = KButton(matcher) { withId(R.id.addLanguageButton) }
    val languageList = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.languagesList) },
        itemTypeBuilder = { itemType(::OnboardingLanguageListItem) }
    )

}