package com.doogang.lab.any;

import com.doogang.lab.user.domain.User;

public class TestMain {
  public static void main(String[] args) {
    LambdaCallStack lambdaCallStack1 = new LambdaCallStack();
    User user = new User();
    // Thread thread1 = new Thread(lambdaCallStack1.test(user), "first");
    // Thread thread2 = new Thread(lambdaCallStack1.test(user), "second");
    // Thread thread3 = new Thread(lambdaCallStack1.test(user), "third");
    // Thread thread4 = new Thread(lambdaCallStack1.test(user), "forth");
    // Thread thread41 = new Thread(lambdaCallStack1.test(user), "1");
    // Thread thread42 = new Thread(lambdaCallStack1.test(user), "2");
    // Thread thread43 = new Thread(lambdaCallStack1.test(user), "3");
    // Thread thread44 = new Thread(lambdaCallStack1.test(user), "4");
    // Thread thread45 = new Thread(lambdaCallStack1.test(user), "5");
    // Thread thread46 = new Thread(lambdaCallStack1.test(user), "6");

    Runnable test = lambdaCallStack1.test(user);
    for (int i=0;i<100;i++) {
      test.run();
    }

    // Thread thread1 = new Thread(lambdaCallStack1.test(), "first");
    // Thread thread2 = new Thread(lambdaCallStack1.test(), "second");
    // Thread thread3 = new Thread(lambdaCallStack1.test(), "third");
    // Thread thread4 = new Thread(lambdaCallStack1.test(), "forth");
    // Thread thread41 = new Thread(lambdaCallStack1.test(), "1");
    // Thread thread42 = new Thread(lambdaCallStack1.test(), "2");
    // Thread thread43 = new Thread(lambdaCallStack1.test(), "3");
    // Thread thread44 = new Thread(lambdaCallStack1.test(), "4");
    // Thread thread45 = new Thread(lambdaCallStack1.test(), "5");
    // Thread thread46 = new Thread(lambdaCallStack1.test(), "6");

    // thread1.start();
    // thread2.start();
    // thread3.start();
    // thread4.start();
    // thread41.start();
    // thread42.start();
    // thread43.start();
    // thread44.start();
    // thread45.start();
    // thread46.start();

    // Runnable runnable1 = lambdaCallStack1.getRunnable();
    // runnable1.run();
    // runnable1.run();
    // runnable1.run();
    //
    // LambdaCallStack lambdaCallStack2 = new LambdaCallStack();
    // Runnable runnable2 = lambdaCallStack2.getRunnable();
    // runnable2.run();
    // runnable2.run();
  }
}
