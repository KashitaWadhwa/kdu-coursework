package kdu.backend3;
class MessageReceiver implements Runnable {
    private final MessageQueue messageQueue;
    private final int receiverId;

    public MessageReceiver(MessageQueue messageQueue, int receiverId) {
        this.messageQueue = messageQueue;
        this.receiverId = receiverId;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) { // Check the interrupted status in the loop condition
            String message = messageQueue.getMessage();
            if (message != null) {
                Logging.logInfo("Receiver " + receiverId + " received: " + message);
            }
        }
        Logging.logInfo("Receiver " + receiverId + " is stopping.");
    }
}
