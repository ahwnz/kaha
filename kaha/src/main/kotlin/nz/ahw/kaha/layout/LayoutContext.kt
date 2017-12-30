/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha.layout

import kotlinx.html.HTML
import kotlinx.html.HtmlBlockTag
import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import nz.ahw.kaha.Block
import nz.ahw.kaha.BlockContext
import nz.ahw.kaha.BlockRenderException

class LayoutContext(val appendable: Appendable, val block: Block) {

    fun html(body: HTML.() -> Unit) {
        appendable.append("<!DOCTYPE html>")
        appendable.appendHTML().html(body)
    }

    fun HtmlBlockTag.blockContent() {
        try {
            block(BlockContext(this))
        } catch(ex: Throwable) {
            throw BlockRenderException(ex)
        }
    }
}