package com.davidmahendra.cuaca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.invoke.MethodHandles;
import java.text.DecimalFormat;
import java.util.List;

public class CuacaAdapter extends RecyclerView.Adapter<CuacaViewHolder> {
    private List<ListModel> listModelList;
    private RootModel rm;

    public CuacaAdapter(RootModel rm) {
        this.rm = rm;

        listModelList = rm.getListModelList();
    }

    @NonNull
    @Override
    public CuacaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cuaca, parent, false);
        return new CuacaViewHolder(view);
    }

    private double toCelcius(double kelvin) { return kelvin - 272.15; }

    public String formatNumber (double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    @Override
    public void onBindViewHolder(@NonNull CuacaViewHolder holder, int position) {
        ListModel lm = listModelList.get(position);
        WeatherModel wm = lm.getWeatherModelList().get(0);
        MainModel mm = lm.getMainModel();

        String suhu = formatNumber(toCelcius(mm.getTemp_min()), "###.##") + "°C - " +
                formatNumber(toCelcius(mm.getTemp_max()), "###.##") + "C";

        switch (wm.getIcon()) {
            case "01d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_01d);
                break;

            case "01n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_01n);
                break;

            case "02d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_02d);
                break;

            case "02n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_02n);
                break;

            case "03d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_03d);
                break;

            case "03n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_03n);
                break;

            case "04d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_04d);
                break;

            case "04n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_04n);
                break;

            case "09d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_09d);
                break;

            case "09n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_09d);
                break;

            case "10d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_10d);
                break;

            case "10n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_10n);
                break;

            case "11d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_11d);
                break;

            case "11n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_11n);
                break;
        }

        holder.namaTextView.setText(wm.getMain());
        holder.deskrisiTextView.setText(wm.getDescription());
        holder.tglWaktuTextView.setText(lm.getDt_txt());
        holder.suhuTextView.setText(suhu);
    }

    @Override
    public int getItemCount() { return (listModelList != null) ? listModelList.size() : 0; }

}
