package com.example.admin.ph05593quanlychitieu.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.ph05593quanlychitieu.common.Common;
import com.example.admin.ph05593quanlychitieu.database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.model.ChiTieu;
import com.example.admin.ph05593quanlychitieu.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ChiTieuAdapter extends BaseAdapter {
    private List<ChiTieu> chiTieuList;
    private LayoutInflater inflater;
    private Context context;
    private ChiTieuDAO chiTieuDAO;


    public ChiTieuAdapter(Context context, List<ChiTieu> chiTieus) {
        this.chiTieuList = chiTieus;
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        chiTieuDAO = new ChiTieuDAO(context);
    }

    @Override
    public int getCount() {
        return chiTieuList.size();
    }

    @Override
    public Object getItem(int i) {
        return chiTieuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_chitieu, parent, false);

            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvSoluong = convertView.findViewById(R.id.tvSoluong);
            holder.tvGiatien = convertView.findViewById(R.id.tvGiatien);
            holder.tvNgaychi = convertView.findViewById(R.id.tvNgaychi);
            holder.imgDel = convertView.findViewById(R.id.imgDel);

            holder.imgDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chiTieuDAO.deleteChiTieuByID(chiTieuList.get(position).getTenChiphi());
                    chiTieuList.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        } else {  //Đã tạo ra
            holder = (ViewHolder) convertView.getTag();
        }
        //thiết lập giá trị cho item
        ChiTieu chiTieu = chiTieuList.get(position);
        holder.tvName.setText(chiTieu.getTenChiphi());
        holder.tvSoluong.setText(chiTieu.getSoLuong()+"");
        holder.tvGiatien.setText(chiTieu.getGiaTien()+"");
        holder.tvNgaychi.setText(Common.convertDate(chiTieu.getNgayChi()));

        return convertView;
    }


    public static class ViewHolder {
        public ImageView imgDel;
        public TextView tvName, tvSoluong, tvGiatien, tvNgaychi;
    }

}
