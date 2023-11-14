package example.micronaut

import com.kanastruk.sandbox.FooModel
import com.kanastruk.sandbox.Product
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Put
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

interface Product {}
interface Option {}
interface Inventory {}
interface Intent {}

class EditorModel {
    private val _state = MutableStateFlow<EditorState>()
    val state = _state.asStateFlow()

    fun process(intent:Intent) { /* ... */ }
}

sealed class EditorState {
    data object Closed:EditorState()
    data class Loading(val id:Id):EditorState()
    data class Editing(val productVariant: ProductVariant):EditorState()
    data class Saving(val productVariant: ProductVariant):EditorState()
    data class Error(val msg:String):EditorState()
}

data class ProductVariant(
    val id: String,
    val name: String,
    val description: String,
    val option:Option,
    val inventory: Inventory
)

interface IncomingRepo {

}

interface VariantEditorModel {

}

interface ProductRepo {
    suspend fun create(newProduct: Product): String
    suspend fun read(productId: String): Product
    suspend fun update()
    suspend fun delete()
    // Bonus: Streamed results.
    fun subscribe(productId: String): Flow<Product>
}

interface SearchTerm
interface Id
object MockId:Id {}
fun String.toId():Id = MockId

interface ProductVariantRepo {
    fun create(newVariant: ProductVariant): String
    fun read(id: Id): ProductVariant
    fun update(editedVariant: ProductVariant)
    fun delete(id:Id)
    fun subscribe(id: Id): Flow<ProductVariant>
    fun subscribe(term: SearchTerm): Flow<List<ProductVariant>>
}

@Controller("/variant")
class ProductVariantController(
    private val variantRepo:ProductVariantRepo
) {
    @Put
    fun put(variant:ProductVariant) = variantRepo.create(variant)
    @Get
    fun read(param:String) = variantRepo.read(param.toId())
    @Post // 🧐?
    fun post(variant:ProductVariant) = variantRepo.update(variant)
    @Delete("{param}")
    fun delete(param:String) = variantRepo.delete(param.toId())

    // NOTE: Websocket streaming possible too.
}

@Controller("/") // <1>
class HelloController(
    private val models:Models
) {
    private val foo = models.fooModel

    @Get// <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    fun index() = "Hello World"

    @Get("hello/{name}")
    fun hello(name:String) = "Hello $name"

    @Get("goodbye/{name}")
    fun goodbye(name:String) = "Goodbye $name"

    fun

    @Get("foo/{param}")
    fun foo(param:String): Flow<String> =
        flowOf("1", "2", "3 : $param")

    @Get("salutation/{name}")
    fun salutation(name:String):String {
        println(foo.modelId())
        return foo.salutation(name)
    }
}

// TODO: Basically the counter-example of what we'd like...
@Singleton
class Models {
    val fooModel = FooModel()
}
