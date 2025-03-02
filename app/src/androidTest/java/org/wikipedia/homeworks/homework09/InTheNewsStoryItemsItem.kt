package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsStoryItemsItem(matcher: Matcher<View>) :
    KRecyclerItem<InTheNewsStoryItemsItem>(matcher) {
    val title = KTextView(
        parent = matcher,
        function = { withId(R.id.view_list_card_item_title) }
    )
    val subTitle = KTextView(
        parent = matcher,
        function = { withId(R.id.view_list_card_item_title) }
    )
    val image = KImageView(
        parent = matcher,
        function = { withId(R.id.view_list_card_item_image) }
    )


}