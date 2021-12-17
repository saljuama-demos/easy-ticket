package dev.saljuama.demos.easyticket.exceptions;

public class NewFancyService {


    // CHECKED EXCEPTIONS
    // Root Class: Exception
    public void someMethodThatThrowsCheckedExceptions() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UNCHECKED EXCEPTIONS - This is the preferred option 😇
    // Root Class: RuntimeException
    public void anotherMethodButThisOneUnchecked() {
        throw new MyNewFancyException("With a fancy message");
    }
}
