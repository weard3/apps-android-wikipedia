package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferenceBottomSheetScreen : KScreen<ReferenceBottomSheetScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val referenceText = KTextView { withId(R.id.reference_text) }
    val referenceNumber = KTextView { withId(R.id.reference_id) }
}