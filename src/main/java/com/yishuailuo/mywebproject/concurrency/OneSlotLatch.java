package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class OneSlotLatch {
    
    private Sync sync = new Sync();
    
    public void signal() {
        sync.releaseShared(0);
    }
    
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }
    
    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;
        }
    
        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }
}
