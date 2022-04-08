package lesson7.task1

import edu.berkeley.cs.jqf.fuzz.Fuzz
import edu.berkeley.cs.jqf.fuzz.JQF
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import java.io.File


@RunWith(JQF::class)
class DirectedFuzzing {

    private val initFile = "input/fuzzing.md"

    private fun checkHtmlListsExample(file: String) {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected = file.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        Assertions.assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Fuzz
    fun testMarkdownToHtmlLists(inputName: String, outputName: String) {

        File(initFile).writeText("1. Utka\n\t* $inputName \n")


        val src = File(initFile).readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()

        markdownToHtmlLists(initFile, "temp.html")
        checkHtmlListsExample(html)
    }
}