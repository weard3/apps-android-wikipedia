package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {
    val titleText = KTextView(matcher) { withId(R.id.view_list_card_item_title) }
    val subTitleText = KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
    val graph = KView(matcher) { withId(R.id.view_list_card_item_graph) }
    val numberText = KTextView(matcher) { withId(R.id.numberView) }
    val pageViews = KTextView(matcher) { withId(R.id.view_list_card_item_pageviews) }
    val image = KImageView(matcher) { withId(R.id.view_list_card_item_image) }
}