/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Handler(private val body: HandlerContext.() -> Response) {

    fun handle(req: HttpServletRequest, resp: HttpServletResponse) {
        try {
            body(HandlerContext(req)).apply(resp)
        } catch(ex: Throwable) {
            resp.sendError(500)
            throw ex
        }
    }
}

