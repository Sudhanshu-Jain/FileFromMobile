package com.example.fileininternalstorage;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


public class MainActivity extends Activity {

    private File root;
    private ArrayList<File> fileList = new ArrayList<File>();
    private ArrayList<Files> filesArrayList = new ArrayList<>();
    private HashMap<String,String> map;
    private ArrayList<HashMap<String,String>> mapArrayList = new ArrayList<>();
    public FileAdapter adp;
    private ArrayList<Files> filesArrayList1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView listView=(ListView)findViewById(R.id.listView1);
        RecyclerView fileViews = (RecyclerView) findViewById(R.id.listfiles);


        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());

        getfilefromSDCARD(root);
        for (int i = 0; i < fileList.size(); i++) {
            Files files = new Files();
            String fileName = fileList.get(i).getName();
            files.setFileName(fileName);
            if (fileList.get(i).isDirectory())
                files.setIsFile(false);
            else
                files.setIsFile(true);
            int k = fileName.lastIndexOf('.');
            if (k > 0) {
                String extension = fileName.substring(k + 1);
                files.setExtension(extension);
            } else
                files.setExtension("");
            files.setSource("sd-card");
            filesArrayList.add(files);

        }
        getfilefromMEMORY(new File("/"));
        for (int i = 0; i < fileList.size(); i++) {
            Files files = new Files();
            String fileName = fileList.get(i).getName();
            files.setFileName(fileName);
            if (fileList.get(i).isDirectory())
                files.setIsFile(false);
            else
                files.setIsFile(true);
            int k = fileName.lastIndexOf('.');
            if (k > 0) {
                String extension = fileName.substring(k + 1);
                files.setExtension(extension);
            } else
                files.setExtension("");
            files.setSource("phone-memory");
            filesArrayList1.add(files);

        }

        List<Files> newList = new ArrayList<Files>();
        newList.addAll(filesArrayList);
        newList.addAll(filesArrayList1);
        getMapsforFile(newList);
//        getfilefromSDCARD(new File("/"),false);

        adp = new FileAdapter(mapArrayList);
        fileViews.setAdapter(adp);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        fileViews.setLayoutManager(mLayoutManager);

    }


    public void getMapsforFile(List<Files> list){


        for(int i=0;i<list.size();i++){
            map = new HashMap<String ,String>();
            Files files = list.get(i);
            map.put(Constants.FIRST_COLUMN,files.getFileName());
            if(files.isFile()) {
                map.put(Constants.SECOND_COLUMN, "File");
                map.put(Constants.THIRD_COLUMN, files.getExtension());
            }
            else {
                map.put(Constants.SECOND_COLUMN, "Folder");
                map.put(Constants.THIRD_COLUMN, "");
            }
                map.put(Constants.FOURTH_COLUMN,files.getSource());
                mapArrayList.add(map);
        }


    }



    public void getfilefromSDCARD(File dir) {


        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    fileList.add(listFile[i]);
                    getfilefromSDCARD(listFile[i]);

                } else {
//                        String extension = "";
//                        String fileName = listFile[i].getName();

//
                    fileList.add(listFile[i]);
//
                }
            }
        }
    }





    public void getfilefromMEMORY(File dir) {

        fileList = new ArrayList<>();

            File listFile[] = dir.listFiles();
            if (listFile != null && listFile.length > 0 ) {
                for (int i = 0; i < listFile.length; i++) {
                    fileList.add(listFile[i]);
//
                }
            }
    }


}