import com.kanastruk.sandbox.FooModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.dom.clear

fun main() {
    val scope = MainScope()

    val model = FooModel()
    scope.launch {
        // TODO: Add if we demo FB?
        // val fbApp = initializeApp()
        byId("main")?.apply {
            clear()
            // "Hello New York! 🏙\uD83C\uDF4E️"
            textContent = model.salutation("from JS land")
        }
    }
}