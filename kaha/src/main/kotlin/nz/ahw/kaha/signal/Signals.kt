/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha.signal

import nz.ahw.kaha.Responses

object Signals {

    open class ErrorCode(errorCode: Int, message: String? = null): Signal(Responses.ErrorCode(errorCode, message))

    class BadRequest(message: String): ErrorCode(400, message)
}