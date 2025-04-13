package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.CustomizeFeedItem
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }
    val feed by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::TopReadItemNew)
            }
        ).name(withParent("Список блоков"))
    }

    fun topReadItem(index: Int, function: TopReadItemNew.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReadItemNew {
        return feed.childWith<TopReadItemNew> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }


}