// WITH_RUNTIME
// WITH_COROUTINES
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

suspend fun foo(x: Any): Int {
    return when {
        x == "56" -> suspendHere()
        else -> 13
    }
}

suspend fun suspendHere(): Int = suspendCoroutineOrReturn { x ->
    x.resume(56)
    SUSPENDED_MARKER
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    var result = -1

    builder {
        result = foo("56")
    }

    if (result != 56) return "fail 1: $result"

    return "OK"
}
