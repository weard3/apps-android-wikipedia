package org.wikipedia.homeworks.homework20

/**
 * Класс с иерархией имен элементов
 */
class NameHierarchy(
    /**
     * Имя текущего элемента.
     */
    val name: String,
    /**
     * Ссылка на родительский элемент. По умолчанию null, т.е элемент не имеет родителя и является корневым
     */
    val parent: NameHierarchy? = null
) {
    /**
     * Создает новый экземпляр NameHierarchy, где текущий объект (this) выступает в роли родителя нового элемента.
     */
    fun withParent(currentElementName: String) = NameHierarchy(currentElementName, this)

    /**
     * Выводит всю иерархию имен от корневого элемента разделяя их двоеточием
     */
    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}