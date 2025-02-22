package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsCardItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsCardItem>(matcher) {
    val image = KImageView { withId(R.id.horizontal_scroll_list_item_image) }
    val text = KTextView { withId(R.id.horizontal_scroll_list_item_text) }
}