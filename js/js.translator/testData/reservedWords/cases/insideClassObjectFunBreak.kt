package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

class TestClass {
    companion object {
        fun `break`() { `break`() }

        fun test() {
            testNotRenamed("break", { `break`() })
        }
    }
}

fun box(): String {
    TestClass.test()

    return "OK"
}