package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object LinkViewBottomSheetScreen : KScreen<LinkViewBottomSheetScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val readArticleBtn = KButton { withId(R.id.link_preview_primary_button) }
}