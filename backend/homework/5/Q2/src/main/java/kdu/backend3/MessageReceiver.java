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
        while (true) {
            String message = messageQueue.getMessage();
            if (message != null) {
                Logging.logInfo("Receiver " + receiverId + " received: " + message);
            }
        }
    }
}