// "Change 2nd parameter of method 'K' from 'boolean' to 'String'" "true"

public class J {
    void foo() {
        new K(1, <caret>"2");
    }
}