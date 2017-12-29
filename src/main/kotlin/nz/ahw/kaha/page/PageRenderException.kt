/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha.page

import nz.ahw.kaha.KahaException

class PageRenderException(cause: Throwable): KahaException("Error while rendering page", cause)