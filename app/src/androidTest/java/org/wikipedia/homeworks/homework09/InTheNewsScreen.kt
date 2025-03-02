package org.wikipedia.homeworks.homework09

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object InTheNewsScreen {
    val image = KImageView { withId(R.id.gradient_view) }
    val text = KTextView { withId(R.id.story_text_view) }
    val items = KRecyclerView(
        builder = { withId(R.id.news_story_items_recyclerview) },
        itemTypeBuilder = { itemType(::InTheNewsStoryItemsItem) }
    )
}