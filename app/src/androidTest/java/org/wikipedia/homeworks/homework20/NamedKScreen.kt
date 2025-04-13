package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen

/**
 * Наследник [KScreen] который обязывает иметь имя экрана
 */
abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {
    /**
     * Имя экрана/виджета
     */
    abstract val screenName: String

    /**
     * Создает и возвращает иерархию имен с именем экрана [screenName]
     */
    val nameHierarchy by lazy { NameHierarchy(screenName) }

    /**
     * Создает [NameHierarchy] для элемента где родительский элемент - имя экрана/виджета
     */
    fun withParent(elementName: String) = nameHierarchy.withParent(elementName)
}


