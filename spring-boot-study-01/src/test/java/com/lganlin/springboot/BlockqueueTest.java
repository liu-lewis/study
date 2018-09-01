package com.lganlin.springboot;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockqueueTest {

    public static class Basket {

        private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        public void produce(String string) throws InterruptedException {
            blockingQueue.put(string);
        }

        public String consume() throws InterruptedException {
            return blockingQueue.take();
        }

        public int getSize() {
            return blockingQueue.size();
        }
    }

    public static void test() {

        final Basket basket = new Basket();

        class Producer implements Runnable {

            @Override
            public void run() {
                try {
                    int i = 0;
                    while (i < 10) {
                        System.out.println("produce ================>" + "element: " + i);
                        basket.produce("element: " + i);
                        i++;
                        System.out.println("produce size: " + basket.getSize());
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        class Consumer implements Runnable {

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("consume ====================>" + basket.consume());
                        System.out.println("consume size: "+basket.getSize());
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit(producer);
        service.submit(consumer);


    }

    public static void main(String[] args) {
        BlockqueueTest.test();
    }
}