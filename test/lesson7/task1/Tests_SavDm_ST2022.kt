package lesson7.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests_SavDm_ST2022 {

    private fun checkHtmlListsExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                      <body>
                        <p>
                          <ul>
                            <li>Утка по-пекински
                              <ul>
                                <li>Утка</li>
                                <li>Соус</li>
                              </ul>
                            </li>
                            <li>Салат Оливье
                              <ol>
                                <li>Мясо
                                  <ul>
                                    <li>Или колбаса</li>
                                  </ul>
                                </li>
                                <li>Майонез</li>
                                <li>Картофель</li>
                                <li>Что-то там ещё</li>
                              </ol>
                            </li>
                            <li>Помидоры</li>
                            <li>Фрукты
                              <ol>
                                <li>Бананы</li>
                                <li>Яблоки
                                  <ol>
                                    <li>Красные</li>
                                    <li>Зелёные</li>
                                  </ol>
                                </li>
                              </ol>
                            </li>
                          </ul>
                        </p>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkHtmlLists_ST2022() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                      <body>
                        <p>
                          <ol>
                            <li>Повелитель</li>
                            <li>О моём перерождении в слизь</li>
                            <li>Реинкарнация безработного</li>
                            <li>Атака титанов
                              <ul>
                                <li>27 марта выходит ласт серия 4 сезона</li>
                              </ul>
                            </li>
                            <li></li>
                          </ol>
                          <ul>          
                            <li>Внук мудреца</li>
                            <li>Повседневная жизнь бессмертного короля</li>
                          </ul>
                        </p>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result) // dropped, when main <ol>...</ol> is same level as <ul>...</ul>

        File("temp.html").delete()
    }

    @Test
    @Tag("23")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()

        markdownToHtmlLists("input/markdown_lists_ST2022.md", "temp.html")
        checkHtmlLists_ST2022()
    }
}