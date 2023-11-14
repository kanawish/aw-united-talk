package com.kanastruk.sandbox

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow

/*
@startuml
hide empty methods
hide empty attributes
class Foo {
 a
 b
 c
}

entity Product
entity Variant
entity Option
entity Inventory
entity Location

Product -- Option
Option -- Variant
Variant -- Inventory
Inventory -- Location
@enduml
 */


data class Y (val z:String)

/**
 * For music albums, we could think of Releases for a
 * given Artist & Album: Year, Country, Track list, Cover art,
 * and so on.
 *
 * It's all a bit subjective, but we'll probably just defer to
 * Discogs.com structure.
 */
data class Product(
    val id: String,
    val albumName: String,
    val artist: String,
    val releaseDate: Long,
    /* etc... */
)

data class ProductVariant(val mock:String)
/**
 * Combination of options categorizing a product.
 */
data class Variant(val id: String, val options: List<Option> /*, etc... */)

/**
 * "Grading" [Mint, Near Mint, Excellent...],
 * "Pressing" [standard,heavy,colored..],
 * etc, etc...
 */
data class Option(
    val id: String,
    val name: String,
    val value: String,
    /*, etc... */
)
data class Foo(val bar:Int)
interface CRUD {
    fun create(foo:Foo)
    fun read():Foo
    fun update()
    fun delete()
}


/**
 * Calls throw exceptions on error.
 */
interface ProductRepo {
    suspend fun create(newProduct: Product): String
    suspend fun read(productId: String): Product
    suspend fun update()
    suspend fun delete()
    // Bonus: Streamed results.
    fun subscribe(productId: String): Flow<Product>
}

// theory -> friendly tech stacks and approaches.
// NOTE: How are transactions are 'translated' into REST?
//  i.e. deleting prod means deleting variants/options, more examples down the line.
// theory: general approaches make for reusable repo/viewmodel code. (show if possible)
// NOTE: graphQL had good story around that, but overhead..
// https://cashapp.github.io/sqldelight/2.0.0/android_sqlite/coroutines/

class FooModel() {
    // see https://www.discogs.com/developers
    // TODO: https://ktor.io/docs/user-agent.html

    // TODO: Add more meat.
    fun modelId():String = "I am Foo."

    fun salutation(name:String) = "Hello $name!"

    private val client = HttpClient()

    // exposing suspend, callers manage cancellation.
    suspend fun greeting():String {
        val response: HttpResponse = client.get("https://ktor.io/docs")
        return response.toString()
    }

    suspend fun get() {
    }
}

class ProductEditViewModel {

}

/**
 * Expand on talking points with core ideas that
 * I want to use in my talk.
 */
data class FooData(val id:String, val message: String, val counter: Int, val flag: Boolean)

/**
 *
 */
interface Taxonomy {
    // fire and forget
    fun fafUpdate(data:FooData):Unit
    suspend fun susUpdate(data:FooData)
}



/**
 * NOTE: https://github.com/Kotlin/KEEP/blob/master/proposals/stdlib/result.md#use-cases
 */
val x = Result.success("Woot")
