package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeFeedItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeFeedItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }
    val text = KTextView(matcher) { withId(R.id.view_announcement_text) }
    val customizeBtn = KButton(matcher) { withId(R.id.view_announcement_action_positive) }
    val gotItBtn = KButton(matcher) { withId(R.id.view_announcement_dialog_action_negative) }
}