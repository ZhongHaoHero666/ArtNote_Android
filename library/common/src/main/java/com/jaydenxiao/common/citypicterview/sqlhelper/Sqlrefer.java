package com.jaydenxiao.common.citypicterview.sqlhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jaydenxiao.common.citypicterview.model.Banks;
import com.jaydenxiao.common.citypicterview.model.BanksType;
import com.jaydenxiao.common.citypicterview.model.BaseDates;
import com.jaydenxiao.common.citypicterview.model.Citys;
import com.jaydenxiao.common.citypicterview.model.Districts;
import com.jaydenxiao.common.citypicterview.model.Provinces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RXPC-D250 on 2016/8/2.
 */
public class Sqlrefer {
    private String TAG = "yfzy.Sqlrefer";

    private DBManager dbm;
    private SQLiteDatabase db;
    public static int PROVINCE = 0;
    public static int CITY = 1;
    public static int COUNTY = 2;

    private List<BaseDates> provincesList = new ArrayList<BaseDates>();
    private List<BaseDates> citysesList = new ArrayList<BaseDates>();
    private List<BaseDates> districtsesList = new ArrayList<BaseDates>();
    private List<BaseDates> banksList = new ArrayList<BaseDates>();
    private List<BaseDates> banlstypesLists = new ArrayList<BaseDates>();

    public Sqlrefer(Context context) {
        dbm = new DBManager(context);
        dbm.openDatabase();
        db = dbm.getDatabase();
    }

    /**
     * 查询所有省
     *
     * @return
     */
    public List<BaseDates> province() {
        try {
            String sql = "select * from sys_province";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                int code = cursor.getInt(cursor.getColumnIndex("code"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Provinces provinces = new Provinces();
                provinces.setCode(code+"");
                provinces.setName(name);
                provincesList.add(provinces);
                cursor.moveToNext();
            }
            //查询最后一个
            int code = cursor.getInt(cursor.getColumnIndex("code"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Provinces provinces = new Provinces();
            provinces.setCode(code+"");
            provinces.setName(name);
            provincesList.add(provinces);
        } catch (Exception e) {

        }
        dbm.closeDatabase();
        db.close();
        return provincesList;
    }

    /*
       查询所有市
     */
    public List<BaseDates> city(String pcode) {
        try {
            String sql = "select * from sys_city where province_id ='" + pcode + "'";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("code"));
                String city_name = cursor.getString(cursor.getColumnIndex("name"));
                Citys citys = new Citys();
                citys.setCode(id+"");
                citys.setName(city_name);
                citysesList.add(citys);
                cursor.moveToNext();
            }
            //查询最后一个
            int id = cursor.getInt(cursor.getColumnIndex("code"));
            String city_name = cursor.getString(cursor.getColumnIndex("name"));
            Citys citys = new Citys();
            citys.setCode(id+"");
            citys.setName(city_name);
            citysesList.add(citys);

        } catch (Exception e) {

        }
        dbm.closeDatabase();
        db.close();
        return citysesList;
    }


    /**
     * 查询所有县
     *
     * @param pcode
     * @return
     */
    public List<BaseDates> county(String pcode) {
        try {
            String sql = "select * from sys_region where city_id ='" + pcode + "'";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("code"));
                String district_name = cursor.getString(cursor.getColumnIndex("name"));
                Districts districts = new Districts();
                districts.setCode(id+"");
                districts.setName(district_name);
                districtsesList.add(districts);
                cursor.moveToNext();
            }
            //查询最后一个
            int id = cursor.getInt(cursor.getColumnIndex("code"));
            String district_name = cursor.getString(cursor.getColumnIndex("name"));
            Districts districts = new Districts();
            districts.setCode(id+"");
            districts.setName(district_name);
            districtsesList.add(districts);
        } catch (Exception e) {

        }
        dbm.closeDatabase();
        db.close();
        return districtsesList;
    }

    /**
     * 查询所有银行
     *
     * @return
     */
    public List<BaseDates> banks() {
        try {
            String sql = "select * from sys_bank";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                int code = cursor.getInt(cursor.getColumnIndex("code"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Banks banks = new Banks();
                banks.setCode(code+"");
                banks.setName(name);
                banksList.add(banks);
                cursor.moveToNext();
            }
            //查询最后一个
            int code = cursor.getInt(cursor.getColumnIndex("code"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Banks banks = new Banks();
            banks.setCode(code+"");
            banks.setName(name);
            banksList.add(banks);
        } catch (Exception e) {

        }
        dbm.closeDatabase();
        db.close();
        return banksList;
    }

    /**
     * 查询所有卡类型
     *
     * @param code
     * @return
     */
    public List<BaseDates> bankTypes(String code) {
        try {
            String sql = "select * from sys_bank_type";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("code"));
                String district_name = cursor.getString(cursor.getColumnIndex("name"));
                BanksType banksType = new BanksType();
                banksType.setCode(id+"");
                banksType.setName(district_name);
                banlstypesLists.add(banksType);
                cursor.moveToNext();
            }
            //查询最后一个
            int id = cursor.getInt(cursor.getColumnIndex("code"));
            String district_name = cursor.getString(cursor.getColumnIndex("name"));
            BanksType banksType = new BanksType();
            banksType.setCode(id+"");
            banksType.setName(district_name);
            banlstypesLists.add(banksType);
        } catch (Exception e) {

        }
        dbm.closeDatabase();
        db.close();
        return banlstypesLists;
    }
//
//    public String SQltlis (String pocde){
//        String fan=null ;
//        if (pocde.length()==2){
//            fan =Fuzzyquerys(pocde,0);
//        }else if (pocde.length()==4){
//            for (int i= 1;i<3;i++){
//                fan=fan+Fuzzyquerys(pocde.substring(0,i/2),i);
//            }
//        }else {
//            for (int i =1 ;i<4;i++){
//                fan=fan+Fuzzyquerys(pocde.substring(0,i/2),i);
//            }
//        }
//        return fan ;
//    }

    /**
     * @param pcode 查询条件
     * @param i     查询类型
     * @return
     */
    public  String Fuzzyquerys(String pcode, int i) {
        String province = null;
        try {
            String sql = null;
            switch (i) {
                case 0:  //根据id查询审
                    sql = "select * from sys_province where code ='" + pcode + "'";
                    break;
                case 1://根据id查询市
                    sql = "select * from sys_city where code ='" + pcode + "'";
                    break;
                case 2: //根据id查询区
                    sql = "select * from sys_region where code ='" + pcode + "'";
                    break;
            }
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            //查询最后一个
            int id = cursor.getInt(cursor.getColumnIndex("code"));
            province = cursor.getString(cursor.getColumnIndex("name"));
        } catch (Exception e) {
        }
        return province;
    }
}
