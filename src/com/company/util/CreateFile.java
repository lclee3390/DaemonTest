package com.company.util;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public CreateFile() {

        String fileSeparator = System.getProperty("file.separator");

        //absolute file name with path
        String absoluteFilePath = "C:\\Users\\Lee\\Desktop\\daemon\\file.txt";
        File file = new File(absoluteFilePath);
        try {
            if(file.createNewFile()){
                System.out.println(absoluteFilePath+" File Created");
            }else System.out.println("File "+absoluteFilePath+" already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
