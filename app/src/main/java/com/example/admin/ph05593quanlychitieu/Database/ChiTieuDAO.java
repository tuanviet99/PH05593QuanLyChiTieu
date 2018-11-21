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
    public static final String SQL_CHI_TIEU = "CREATE TABLE ChiTieu(tenChiphi text primary key, soLuong text, giaTien text, ngayChi)";
    public static final String TAG = "StundentDAO";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ChiTieuDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertChiTieu(ChiTieu chiTieu) {
        ContentValues values = new ContentValues();
        values.put("tenChiphi", chiTieu.getChitieuName());
        values.put("soLuong", chiTieu.getSoluong());
        values.put("giaTien", chiTieu.getGiatien());
        values.put("ngayChi", sdf.format(chiTieu.getNgaychi()));
        if (checkPrimaryKey(chiTieu.getChitieuName())) {
            int result = db.update(TABLE_NAME, values, "tenChiphi=?", new String[]{chiTieu.getChitieuName()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
        return 1;
    }

    /// getAlll
    public List<ChiTieu> getALLChiTieu() throws ParseException {
        List<ChiTieu> nv = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            ChiTieu n = new ChiTieu();
            n.setChitieuName(c.getString(0));
            n.setSoluong(c.getInt(1));
            n.setGiatien(c.getInt(2));
            try {
                n.setNgaychi(sdf.parse(c.getString(3)));
            } catch (Exception e){}
            nv.add(n);
            Log.e("//====", n.toString());
            c.moveToNext();
        }
        c.close();
        return nv;
    }
    public boolean checkPrimaryKey(String strPrimaryKey) {
        //SELECT
        String[] columns = {"tenChiphi"};
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
        values.put("tenChiphi", chiTieu.getChitieuName());
        values.put("soLuong", chiTieu.getSoluong());
        values.put("giaTien", chiTieu.getGiatien());
        values.put("ngayChi", chiTieu.getNgaychi().toString());
        int result = db.update(TABLE_NAME, values, "tenChiphi=?", new String[]{chiTieu.getChitieuName()});
        if (result == 0) {
            return -1;
        }
        return 1;
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
