package com.jaydenxiao.common.citypicterview.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.jaydenxiao.common.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DBManager {
    private final int BUFFER_SIZE = 1024;
    public static final String DB_NAME = "region_sql_1.db";
    public static final String PACKAGE_NAME = "com.loyaltys.yifenzhiyi";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"+ PACKAGE_NAME;
    private SQLiteDatabase database;
    private Context context;
    private File file=null;

    public DBManager(Context context) {
//        LogUtils.e("cc", "DBManager");
        this.context = context;
    }

    public void openDatabase() {
//        LogUtils.e("cc", "openDatabase()");
        this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
    }
    public SQLiteDatabase getDatabase(){
//        LogUtils.e("cc", "getDatabase()");
        return this.database;
    }

    private SQLiteDatabase openDatabase(String dbfile) {
        try {
//            LogUtils.e("cc", "open and return");
            file = new File(dbfile);
            if (!file.exists()) {// 查看数据库文件是否存在

                InputStream is = context.getResources().openRawResource(R.raw.region_sql_1);//得到数据库文件
                if(is!=null){
//                    LogUtils.e("cc", "is null");
                }else{
                }
                FileOutputStream fos = new FileOutputStream(dbfile);

                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count =is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
//                    LogUtils.e("cc", "while");
                    fos.flush();
                }
                fos.close();
                is.close();
            }
            database = SQLiteDatabase.openOrCreateDatabase(dbfile,null); // 存在则直接返回打开的数据库
            return database;
        } catch (FileNotFoundException e) {
//            LogUtils.e("cc", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
//            LogUtils.e("cc", "IO exception");
            e.printStackTrace();
        } catch (Exception e){
//            LogUtils.e("cc", "exception "+e.toString());
        }
        return null;
    }
    public void closeDatabase() {
//        LogUtils.e("cc", "closeDatabase()");
        if(this.database!=null)
            this.database.close();
    }
}