package com.yishuailuo.mywebproject.distributed.lock.zookeeper;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZookeeperDistributedLockDemo {
    public static void main(String[] args) throws Exception {
        String quorumPeer = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        
        CuratorFramework client1 = CuratorFrameworkFactory.newClient(quorumPeer, retryPolicy);
        client1.start();
        new Thread(new InterProcess(client1), "thread1").start();
        
        CuratorFramework client2 = CuratorFrameworkFactory.newClient(quorumPeer, retryPolicy);
        client2.start();
        new Thread(new InterProcess(client2), "thread2").start();
    }
    
    static class InterProcess implements Runnable {
        
        private CuratorFramework client;
        
        public InterProcess(CuratorFramework client) {
            this.client = client;
        }
        
        @Override
        public void run() {
            InterProcessMutex mutex = new InterProcessMutex(client, "/curator/firstlock");
            try {
                mutex.acquire();
                System.out.println("enter mutex");
                mutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                client.close();
            }
        }
    }
}
