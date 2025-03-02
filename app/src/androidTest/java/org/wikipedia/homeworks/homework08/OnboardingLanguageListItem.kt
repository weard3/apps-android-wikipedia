package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

class OnboardingLanguageListItem(matcher: Matcher<View>) : KRecyclerItem<OnboardingItem>(matcher),
    TextViewAssertions
