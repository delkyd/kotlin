// WITH_RUNTIME
// WITH_COROUTINES
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

class Controller {
    var result = false
    suspend fun suspendHere(): String = suspendCoroutineOrReturn { x ->
        x.resume("OK")
        SUSPENDED_MARKER
    }

    fun foo() {
        result = true
    }
}

fun builder(c: suspend Controller.() -> Unit) {
    val controller = Controller()
    c.startCoroutine(controller, EmptyContinuation)
    if (!controller.result) throw RuntimeException("fail")
}

fun noinlineRun(block: () -> Unit) {
    block()
}

fun box(): String {
    builder {
        if (suspendHere() != "OK") {
            throw RuntimeException("fail 1")
        }
        noinlineRun {
            foo()
        }

        if (suspendHere() != "OK") {
            throw RuntimeException("fail 2")
        }
    }

    return "OK"
}
