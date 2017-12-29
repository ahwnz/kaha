/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha.page

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class Layout {

    fun apply(request: HttpServletRequest, response: HttpServletResponse, pageContextConsumer: (PageContext) -> Unit) {
        response.writer.use { writer ->

            val layoutContext = LayoutContext(request, writer, pageContextConsumer)
            try {
                render(layoutContext)
            } catch(ex: PageRenderException) {
                response.sendError(500)
                throw ex
            } catch (ex: Throwable) {
                response.sendError(500)
                throw LayoutRenderException(layoutName, ex)
            }
        }
    }

    open val layoutName: String = this::class.java.name

    abstract val render: LayoutRender

    companion object {

        operator fun invoke(name: String, _render: LayoutRender): Layout = object: Layout() {
            override val layoutName: String = name

            override val render: LayoutRender = _render
        }

    }
}