package com.company;

import com.company.util.Logger;

public class ServiceRunnable implements Runnable {

    Logger logger = null;
    long waitMillsec = 1000;
    public boolean flag = true;
    public ServiceRunnable(long waitMillsec, Logger logger) {
        this.logger = logger;
        this.waitMillsec = waitMillsec;
    }

    @Override
    public void run() {
        while(flag){
            try {
                logger.log("pausing...");
                Thread.sleep(waitMillsec);
            } catch (InterruptedException e) {
                logger.log("Exitting");
                break;
            }
        }
    }
}
