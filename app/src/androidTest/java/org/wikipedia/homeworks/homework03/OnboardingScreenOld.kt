package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val primaryText = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_welcome_title_v2"
)
val secondaryText = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_multilingual_secondary_text"
)
val continueBtn = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)
val skipBtn = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip",
)
val addLanguageBtn = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)
val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList"
)
val languageLabel = listOf(
    AppTextView::class.java,
    "option_label"
)

val image = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val tabs = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)
