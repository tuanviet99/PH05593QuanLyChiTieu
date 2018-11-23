package com.example.admin.ph05593quanlychitieu.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.ph05593quanlychitieu.Model.ChiTieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTieuDAO {
    public SQLiteDatabase db;
    public DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "ChiTieu";
    public static final String SQL_CHI_TIEU = "CREATE TABLE ChiTieu(tenChiphi text primary key, soLuong text, giaTien text, ngayChi date)";
    public static final String TAG = "StundentDAO";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    final public static String TEN_CHI_PHI = "tenChiphi";
    final public static String SO_LUONG = "soLuong";
    final public static String GIA_TIEN = "giaTien";
    final public static String NGAY_CHI = "ngayChi";


    public ChiTieuDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertChiTieu(ChiTieu chiTieu) throws ParseException {

        Log.e("DATE",sdf.format(chiTieu.getNgayChi()));
        ContentValues values = new ContentValues();
        values.put(TEN_CHI_PHI, chiTieu.getTenChiphi());
        values.put(SO_LUONG, chiTieu.getSoLuong());
        values.put(GIA_TIEN, chiTieu.getGiaTien());
        values.put(NGAY_CHI, sdf.parse(chiTieu.getNgayChi()).toString());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    /// getAlll
    public List<ChiTieu> getALLChiTieu()  {
        List<ChiTieu> nv = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            ChiTieu n = new ChiTieu();
            n.setTenChiphi(c.getString(0));
            n.setSoLuong(c.getInt(1));
            n.setGiaTien(c.getInt(2));
            n.setNgayChi((c.getString(3)));

            nv.add(n);
            Log.e("//====", n.toString());
            c.moveToNext();
        }
        c.close();
        return nv;
    }

    public boolean checkPrimaryKey(String strPrimaryKey) {
        //SELECT
        String[] columns = {TEN_CHI_PHI};
        //WHERE clause
        String selection = "tenChiphi=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int updateChiTieu(ChiTieu chiTieu) {
        ContentValues values = new ContentValues();
        values.put(TEN_CHI_PHI, chiTieu.getTenChiphi());
        values.put(SO_LUONG, chiTieu.getSoLuong());
        values.put(GIA_TIEN, chiTieu.getGiaTien());
        try {
            values.put(NGAY_CHI, sdf.parse(chiTieu.getNgayChi()).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = db.update(TABLE_NAME, values, "tenChiphi=?", new String[]{chiTieu.getTenChiphi()});
        return result;
    }

    public double getChiTieuTheoNgay() {
        double chiTieu = 0;
        String sSQL = "SELECT SUM(giaTien*soLuong) FROM ChiTieu  " + " where ngayChi = date('now') GROUP BY tenChiphi";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            chiTieu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return chiTieu;
    }

    public double getChiTieuTheoThang() {
        double chiTieu = 0;
        String sSQL = "SELECT SUM(giaTien * soLuong) FROM ChiTieu  " + " where ngayChi = date('now') GROUP BY tenChiphi";
        Cursor c = db.rawQuery(sSQL, null);
        c.close();
        return chiTieu;
    }

    //delete
    public int deleteChiTieuByID(String tenChitieu) {
        int result = db.delete(TABLE_NAME, "tenChiphi=?", new String[]{tenChitieu});
        if (result == 0) return -1;
        return 1;
    }


}
