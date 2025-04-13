package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {
    val headerText by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_header) }
            .name(withParent("Заголовок"))
    }
    val moreTopReadBtn = KTextView(matcher) { withId(R.id.footerActionButton) }
    val menuBtn = KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
    val cardList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadCardItem)
        }
    )
}