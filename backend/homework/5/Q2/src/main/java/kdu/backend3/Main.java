package kdu.backend3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        // Creating instances of MessageSender and MessageReceiver
        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            senderThreadPool.execute(new MessageSender(messageQueue, i));
            receiverThreadPool.execute(new MessageReceiver(messageQueue, i));
        }

        // Shutdown the thread pools after tasks are completed
        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}
