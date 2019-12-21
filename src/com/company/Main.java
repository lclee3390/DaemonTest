package com.company;
import com.company.util.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static volatile Thread thrd;
    public static Logger logger = null;
    private static String loggerDir = System.getProperty("user.home");
    private static String loggerFileName = "daemon.log";
    private static String loggerPath = "";//loggerDir  + File.separatorChar + loggerFileName;
    private static ServiceRunnable serviceRunnable = null;

    private static void startThread() {
        long waitSec = 5;
        serviceRunnable = new ServiceRunnable(waitSec*1000, logger);
        thrd = new Thread(serviceRunnable);
        thrd.start();
    }

    public static void start(String args[]){

        String userprofile = System.getProperty("java.io.tmpdir");
        if (userprofile != null) {
            loggerDir = userprofile;
        }
        loggerPath = loggerDir + File.separatorChar + loggerFileName;

        logger = new Logger(loggerPath);
        logger.log("Start");
        startThread();
    }

    public static void stop(String args[]){
        logger.log("Stop");
        serviceRunnable.flag = false;
        if (thrd != null) {
            logger.log("Interrupting the thread");
            thrd.interrupt();
        } else {
            logger.log("No thread to interrupt");
        }
    }

    public static void main(String args[]) {
        start(args);
        System.out.println("wait");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stop(args);
        System.out.println("exit");
    }

}
