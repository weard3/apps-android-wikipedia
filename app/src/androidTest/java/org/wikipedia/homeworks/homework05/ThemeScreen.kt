package org.wikipedia.homeworks.homework05

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.slider.KSlider
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

/**
 * Заголовок блока редактирования текста
 */
val textSettingsTitle = KTextView { withId(R.id.textSettingsCategory) }

/**
 * Текущий размер текста
 */
val textSize = KTextView { withId(R.id.text_size_percent) }

/**
 * Кнопка уменьшения размера текста
 */
val decreaseTextSizeBtn = KButton { withId(R.id.buttonDecreaseTextSize) }

/**
 * Кнопка увеличения размера текста
 */
val increaseTextSizeBtn = KButton { withId(R.id.buttonIncreaseTextSize) }

/**
 * Слайдер редактирования размера текста
 */
val editTextSizeSlider = KSlider { withId(R.id.text_size_seek_bar) }

/**
 * Кнопка выбора шрифта sans-serif
 */
val sansSerifBtn = KButton { withId(R.id.button_font_family_sans_serif) }

/**
 * Кнопка выбора шрифта serif
 */
val serifBtn = KButton { withId(R.id.button_font_family_serif) }

/**
 * Свитч включения фокус мода
 */
val focusModeSwitch = KSwitch { withId(R.id.theme_chooser_reading_focus_mode_switch) }

/**
 * Изображение фокус мода
 */
val focusModeImg = KImageView {
    withParent { withId(R.id.readingFocusModeContainer) }
    withDrawable(R.drawable.ic_icon_reading_focus_mode)
}

/**
 * Описание фокус мода
 */
val focusModeDescription = KTextView { withId(R.id.theme_chooser_reading_focus_mode_description) }

/**
 * Заголовок выбора темы
 */
val themeTitle = KTextView {
    withParent { withId(R.id.readingFocusModeContainer) }
    isAssignableFrom(MaterialTextView::class.java)
}

/**
 * Кнопка выбора светлой темы
 */
val lightThemeBtn = KButton { withId(R.id.button_theme_light) }

/**
 * Кнопка выбора сепиа темы
 */
val sepiaThemeBtn = KButton { withId(R.id.button_theme_sepia) }

/**
 * Кнопка выбора темной темы
 */
val darkThemeBtn = KButton { withId(R.id.button_theme_dark) }

/**
 * Кнопка выбора черной темы
 */
val blackThemeBtn = KButton { withId(R.id.button_theme_black) }

/**
 * Свитч совпадения темы с системной
 */
val matchSystemThemeSwitch = KSwitch { withId(R.id.theme_chooser_match_system_theme_switch) }

/**
 * Свитч затемнения изображений
 */
val imageDimmingSwitch = KSwitch { withId(R.id.theme_chooser_dark_mode_dim_images_switch) }