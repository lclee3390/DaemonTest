package com.company.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;


public class Logger {
    private File logFile = null;
    private BufferedWriter writer = null;
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Logger(String Path) {
        createLogFile(Path);
    }

    public void createLogFile(String path) {
        logFile = new File(path);
        System.out.println(path);
        try {
            logFile.createNewFile();
            log("log file :" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String msg) {
        if (msg == null) {
            return;
        }

        msg = String.format("[ %s ] %s", df.format(new Date()), msg);
        System.out.println(msg);

        if (logFile == null) {
            return;
        }
        if (!logFile.exists()) {
            return;
        }
        if(!logFile.canWrite()) {
            return;
        }

        try {
            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }


    }

    private void logSystemEnvironment(){
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null)
            log("Missing currentThread context ClassLoader");
        else
            log("Using context ClassLoader : " + cl.toString());
        log("Program environment: ");

        log("System properties: ");
        Properties ps = System.getProperties();
        TreeSet<Object> ts = new TreeSet<Object>(ps.keySet());
        for (Iterator<Object> i = ts.iterator(); i.hasNext();) {
            String n = (String)i.next();
            log(n + " ->  " + ps.get(n));
        }

    }



}
