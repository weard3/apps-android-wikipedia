package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.TopReadCardItem

class TopReadItemNew(matcher: Matcher<View>) : KRecyclerItem<TopReadItemNew>(matcher) {
    val headerText by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_header) }
            .name(withParent("Заголовок"))
    }
    val moreTopReadBtn by lazy {
        KTextView(matcher) { withId(R.id.footerActionButton) }.name(
            withParent("Кнопка More top read")
        )
    }
    val menuBtn by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }.name(
            withParent("Троеточие справа сверху")
        )
    }
    val cardList by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadCardItem)
            }
        ).name(withParent("Список карточек"))
    }
}