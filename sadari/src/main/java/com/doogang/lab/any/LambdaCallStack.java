package com.doogang.lab.any;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import com.doogang.lab.user.domain.User;

public class LambdaCallStack {

  public Runnable getRunnable() {
    AtomicInteger cnt = new AtomicInteger();
    int num = 10;
    Consumer<Integer> consumer = System.err::println;
    consumer.accept(num);
    num = 1000;
    return () -> cnt.getAndIncrement();
  }

  public Runnable test(User user) {
    User user1 = new User();
    System.err.println(Thread.currentThread().getName() + " : " + user1);
    return () -> {
      // System.err.println("Thread name : " + Thread.currentThread().getName() + " : " );
      // System.err.println("Thread name : " + Thread.currentThread().getName() + " : " + user1);
      System.err.println("Thread name : " + Thread.currentThread().getName() + " : " + user1.getName() + " / reference : " + user1);
      // System.err.println(user);
      user1.setName("ddd");
      // System.err.println("now name : " + user1.getName());
    };
  }
}
