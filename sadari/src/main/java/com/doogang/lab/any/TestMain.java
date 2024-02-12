package com.doogang.lab.any;

public class TestMain {
  public static void main(String[] args) {
    LambdaCallStack lambdaCallStack1 = new LambdaCallStack();
    Runnable runnable1 = lambdaCallStack1.getRunnable();
    runnable1.run();
    runnable1.run();
    runnable1.run();

    LambdaCallStack lambdaCallStack2 = new LambdaCallStack();
    Runnable runnable2 = lambdaCallStack2.getRunnable();
    runnable2.run();
    runnable2.run();
  }
}
