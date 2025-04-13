package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

/**
 * Действие с айтемом ресайклера по переданному индексу с созданием иерархии имен по индексу
 * @param index индекс айтема
 * @param T тип айтема
 */
inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    index: Int,
    function: T.() -> Unit
) {
    val recycler = this
    childAt<T>(index) {
        name(recycler.getName().withParent("$index"))
        function()
    }
}