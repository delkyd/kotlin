abstract class A : MutableList<String> {
    override fun sort(/*0*/ p0: java.util.Comparator<in String>) {
        super.<!DEFAULT_METHOD_CALL_FROM_JAVA6_TARGET!>sort<!>(p0)
    }
}

fun foo(x: MutableList<String>, y: java.util.ArrayList<String>, z: A, p: java.util.Comparator<in String>) {
    // Resolved to extension with no parameters
    x.<!DEPRECATION_ERROR!>sort<!>(p)
    y.<!DEPRECATION_ERROR!>sort<!>(p)

    z.<!DEPRECATION_ERROR!>sort<!>(p)
}
