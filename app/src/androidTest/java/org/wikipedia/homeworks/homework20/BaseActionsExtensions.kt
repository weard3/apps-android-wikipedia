package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

/**
 * Мапа которая хранит иерархию имен у элементов.
 * В качестве ключа выступает элемент(от [BaseActions] наследуются все элементы)
 */
private val names = mutableMapOf<BaseActions, NameHierarchy>()

/**
 * Устанавливает иерархию имен для элемента
 * @param nameHierarchy иерархия имен
 */
fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

/**
 * Возвращает иерархию имен для элемента.
 * @throws RuntimeException если у элемента нет иерархии имен
 */
fun BaseActions.getName(): NameHierarchy {
    return names[this] ?: throw RuntimeException("Укажи имя")
}

/**
 * Создает новый [NameHierarchy] у которого текущий элемент является родителем
 */
fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)