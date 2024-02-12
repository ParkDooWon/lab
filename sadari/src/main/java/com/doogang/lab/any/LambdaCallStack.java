package com.doogang.lab.any;

import java.util.concurrent.atomic.AtomicInteger;

public class LambdaCallStack {

  public Runnable getRunnable() {
    AtomicInteger cnt = new AtomicInteger();
    return () -> cnt.getAndIncrement();
  }
}
