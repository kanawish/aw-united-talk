import kotlinx.browser.document
import kotlinx.dom.addClass
import kotlinx.html.TagConsumer
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.js.div
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.p
import org.w3c.dom.Document
import org.w3c.dom.HTMLElement

fun byId(id:String) = document.getElementById(id)

fun create() = document.create

fun headAppendCss(href:String) {
    document.head?.append { link(href,"stylesheet","text/css") }
}

/**
 * @param block will be appended to the 'main' element
 *
 * @return the main HTMLElement, to allow for further manipulation by caller.
 */
fun Document.appendContent(
    header: HTMLElement,
    main: HTMLElement = document.create.main("container"),
    footer: HTMLElement,
    block: TagConsumer<HTMLElement>.() -> Unit = {}
): HTMLElement {
    main.append {
        this.block()
    }

    body?.apply {
        append {
            div("container-fluid px-0").apply {
                append(header)
                append(main)
                footer.addClass(
                    "container",
                    "text-black-50"
                )
                append(footer)
            }
        }
    }

    return main
}

data class CoverPageData(val title:String, val description:String)

/**
 * buildCoverPage manipulates the DOM to create a centered "Cover Page"
 * with a fixed width and height that will match the available real-estate.
 */
fun Document.buildCoverPage(header: HTMLElement, data: CoverPageData, footer: HTMLElement) {
    // Targets HTML to 'cap' height to 100%
    documentElement?.addClass("h-100")
    // Header / Main / Footer
    body?.apply {
        addClass("d-flex", "h-100", "text-center", "text-white", "bg-dark")
        append {
            div("d-flex w-100 h-100 pt-0 p-3 mx-auto flex-column") {
                main("cover-container container pt-3 text-center") {
                    h1 { +data.title }
                    p("lead") { +data.description }
                }
            }.apply {
                header.addClass("mb-auto")
                prepend(header)
                footer.addClass("text-white-50")
                append(footer)
            }
        }
    } ?: console.error("No body?")
}

/**
 * createFooter creates and returns a footer for use by our other 'builder' functions.
 */
fun Document.createFooter(classes: String, copyrightNotice: String): HTMLElement {
    return create.footer(classes) {
        p { +copyrightNotice }
        // TODO: Confidentiality / Terms
    }
}