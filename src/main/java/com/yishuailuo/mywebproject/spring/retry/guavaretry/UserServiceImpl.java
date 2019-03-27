package com.yishuailuo.mywebproject.spring.retry.guavaretry;


import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.github.rholder.retry.WaitStrategy;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class UserServiceImpl {
    
    private OutService outService;
    
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }
    
    public void addUser() {
    
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("UserServiceImpl.addUser()");
                return outService.addUserOut();
            }
        };
    
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.equalTo(false))
                .retryIfExceptionOfType(RuntimeException.class)
                .withWaitStrategy(WaitStrategies.fixedWait(200, TimeUnit.MILLISECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        System.out.println("retry " + attempt.getAttemptNumber());
                    }
                })
                .build();
        try {
            retryer.call(callable);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
    }
}
