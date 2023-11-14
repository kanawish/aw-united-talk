package scratches

import com.kanastruk.sandbox.FooModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.lang.System.exit
import kotlin.system.exitProcess

class Demo {
}

val foo = FooModel()

// NOTE: runBlocking doesn't have `common` impl.
// https://medium.com/androiddevelopers/cancellation-in-coroutines-aa6b90163629
fun main(args:Array<String>) {
    runBlocking {
        val job = launch {
            try {
                println("calling greeting")
                val greetz = foo.greeting()
                println("got $greetz")
                println("delay for 4s")
                delay(4000)
                println("delay complete")
            } catch (e: Throwable) {
                println("Cancel: ${e.message}")
            } finally {
                println("And finally...")
            }
        }
        println("Hello")
        delay(5L)
        // NOTE: Gotcha if you only pass a string in.
        job.cancel(CancellationException("Bork bork bork"))
        job.join()
        println("Goodbye")
    }
    exitProcess(0)
}
