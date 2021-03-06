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

open class Handler(private val body: HandlerContext.() -> Response) {

    fun handle(req: HttpServletRequest, resp: HttpServletResponse) {
        val response = try {
            body(HandlerContext(req))
        } catch(signal: Signal) {
            signal.response
        } catch (ex: Throwable) {
            resp.sendError(500)
            throw ex
        }
        try {
            response.apply(resp)
        } catch(signal: Signal) {
            throw InvalidSignalLocationException(signal)
        }
    }
}

private typealias H = Handler

fun KahaServlet.Handler(body: HandlerContext.() -> Response): Handler = H(body)