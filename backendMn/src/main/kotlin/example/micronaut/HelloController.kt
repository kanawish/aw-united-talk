package example.micronaut

import com.fasterxml.jackson.annotation.JsonCreator.Mode
import com.kanastruk.sandbox.FooModel
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

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
