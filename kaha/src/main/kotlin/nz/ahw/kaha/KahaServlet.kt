/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class KahaServlet: HttpServlet() {

    open fun delete(): KahaHandler = Handlers.NotFound

    open fun get(): KahaHandler = Handlers.NotFound

    open fun post(): KahaHandler = Handlers.NotFound

    open fun put(): KahaHandler = Handlers.NotFound

    override fun doDelete(request: HttpServletRequest, response: HttpServletResponse) {
        errorHandler(request, response) {
            delete().handle(request, response)
        }
    }

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        errorHandler(request, response) {
            get().handle(request, response)
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        errorHandler(request, response) {
            post().handle(request, response)
        }
    }

    override fun doPut(request: HttpServletRequest, response: HttpServletResponse) {
        errorHandler(request, response) {
            put().handle(request, response)
        }
    }

    private fun errorHandler(request: HttpServletRequest, response: HttpServletResponse, body: () -> Unit) {
        try {
            body()
        } catch(ex: KahaException) {
            var info = "${request.method} ${request.requestURI}"
            if(null != request.queryString) info += "?${request.queryString}"

            throw KahaException("Failure serving request $info", ex)
        }
    }
}

