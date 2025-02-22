package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchCardViewItem(matcher: Matcher<View>) : KRecyclerItem<SearchCardViewItem>(matcher) {
    val searchBtn = KView(matcher) { withDrawable(R.drawable.ic_search_white_24dp) }

    val voiceSearchBtn = KView(matcher) { withDrawable(R.drawable.ic_mic_black_24dp) }

    val searchText = KTextView(matcher) { withText(R.string.search_hint) }

}