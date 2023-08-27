package com.kanastruk.utils

import kotlinx.browser.document
import kotlinx.html.dom.append
import kotlinx.html.js.link

fun headAppendCss(href:String) {
    document.head?.append { link(href,"stylesheet","text/css") }
}
