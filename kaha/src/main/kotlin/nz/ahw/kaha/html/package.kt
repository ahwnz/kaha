/*---------------------------------------------*\
**                                             **
**        Kaha Web Framework                   **
**        Copyright 2018, Alex Westphal        **
**        https://github.com/ahwnz/kaha        **
**                                             **
\*---------------------------------------------*/
package nz.ahw.kaha.html

typealias Render = RenderContext<*>.() -> Unit

typealias LayoutRender = LayoutRenderContext<*>.() -> Unit