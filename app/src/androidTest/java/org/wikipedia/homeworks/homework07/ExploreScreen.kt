package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle = KImageView { withId(R.id.main_toolbar_wordmark) }
    val feed = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::CustomizeFeedItem)
            itemType(::TopReadItem)
            itemType(::InTheNewsItem)
        }
    )
}