package dev.saljuama.demos.easyticket.exceptions;

import org.junit.jupiter.api.Test;

class NewFancyServiceTest {

    private NewFancyService service = new NewFancyService();


    @Test
    void testingTheCheckedWithoutMessage() {
        service.someMethodThatThrowsCheckedExceptions();
    }

    @Test
    void testingExceptionWithoutMessage() {
        service.anotherMethodButThisOneUnchecked();
    }

    @Test
    void usingCauseConstructor() {
        try {
            service.anotherMethodButThisOneUnchecked();
        } catch (RuntimeException e) {
            throw new RuntimeException("Errm, rethrowing", e);
         }
    }
}