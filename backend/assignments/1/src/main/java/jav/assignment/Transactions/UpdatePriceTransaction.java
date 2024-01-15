package jav.assignment.Transactions;


import jav.assignment.BlockHash.BlockHash;
import jav.assignment.Entities.UpdatePrice;


import java.util.concurrent.CountDownLatch;

public class UpdatePriceTransaction extends Thread {
    private final UpdatePrice updatePrice;
    private String transactionID;
    private final CountDownLatch latch;



    public UpdatePriceTransaction(UpdatePrice updatePrice, CountDownLatch latch) {
        this.updatePrice = updatePrice;
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this.updatePrice.getCoin()) {
            while (this.updatePrice.getCoin().getStatus().equals("not-available")) {
                try {
                    this.updatePrice.getCoin().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.updatePrice.getCoin().setStatus("not-available");
            this.transactionID = BlockHash.getBlockHash();


            this.updatePrice.getCoin().setPrice(updatePrice.getPrice());

            this.updatePrice.getCoin().notifyAll();
            this.updatePrice.getCoin().setStatus("available");


            latch.countDown();
        }
    }
}
