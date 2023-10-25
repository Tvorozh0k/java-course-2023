package edu.hw2.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();

        if (stackTraceElements.length >= 2) {
            String className = stackTraceElements[1].getClassName();
            String methodName = stackTraceElements[1].getMethodName();
            return new CallingInfo(className, methodName);
        }

        return null;
    }

    public static void main(String[] args) {
        LOGGER.info(callingInfo());
    }
}
