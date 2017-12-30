/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha

import javax.servlet.http.HttpServletResponse

object Responses {
    object None: Response {
        override fun apply(httpServletResponse: HttpServletResponse) {}
    }

    data class ErrorCode(private val errorCode: Int): Response {
        override fun apply(httpServletResponse: HttpServletResponse) {
            httpServletResponse.sendError(errorCode)
        }

    }
}
