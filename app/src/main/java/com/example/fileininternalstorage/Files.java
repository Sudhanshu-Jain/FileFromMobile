package com.example.fileininternalstorage;

import java.util.ArrayList;

/**
 * Created by sudhanshu on 30/4/16.
 */
public class Files {
    public Files(String fileName, String extension, String source, boolean isFile) {
        this.fileName = fileName;
        this.extension = extension;
        this.source = source;
        this.isFile = isFile;
    }

    public Files() {

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExtension() {
        int k =fileName.lastIndexOf(".");
        if(k>0) {
            String extension1 = fileName.substring(k + 1);
            return extension1;
        }
        return "";
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }
//    public static ArrayList<Files> createFilesList(int numOfContacts){
//        ArrayList<Files> filesList = new ArrayList<>();
//        for(int i=0;i<numOfContacts;i++){
//            filesList.add(new Files())
//        }
//    }

    private String fileName;
    private String extension;
    private String source;
    private boolean isFile;
}
