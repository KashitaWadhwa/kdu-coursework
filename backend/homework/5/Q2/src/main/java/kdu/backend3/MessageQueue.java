package kdu.backend3;
import java.util.concurrent.*;

class MessageQueue {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void addMessage(String message) {
        try {
            queue.put(message);
            synchronized (this) {
                notifyAll();  // Notify waiting threads that a new message is available
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getMessage() {
        try {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();  // Wait until a message is available
                }
            }
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}