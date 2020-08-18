package com.example.webview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NotesViewHolder> implements Filterable {



     List<ResponseModel.Datum> Data_list;
    Context context;

    List<ResponseModel.Datum> filter_list;
    public RecyclerAdapter(Context context, ArrayList<ResponseModel.Datum> Data_list) {
        this.context=context;
        this.Data_list=Data_list;
        this.filter_list=Data_list;

    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_list_items, parent,false);
        NotesViewHolder usersViewHolder = new NotesViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, final int position) {
        holder.tv_name.setText("Name  "+(filter_list.get(position).getEmployeeName()));
        holder.tv_age.setText("Age  "+(filter_list.get(position).getEmployeeAge()));
        holder.tv_data.setText("Salary  "+(filter_list.get(position).getEmployeeSalary()));

    }

    @Override
    public int getItemCount() {
        return filter_list.size();
    }




    class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView tv_data,tv_name,tv_age ;

        public NotesViewHolder(View itemView) {
            super(itemView);
            tv_data =  itemView.findViewById(R.id.tv_data);
            tv_name =  itemView.findViewById(R.id.tv_name);
            tv_age =  itemView.findViewById(R.id.tv_age);



        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filter_list = Data_list;
                } else {
                    ArrayList<ResponseModel.Datum> filteredList = new ArrayList<>();
                    for (ResponseModel.Datum data1 : filter_list) {
                        if (data1.getEmployeeName().toLowerCase().contains(charString)) {
                            filteredList.add(data1);
                        }
                    }
                    filter_list = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filter_list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filter_list = (ArrayList<ResponseModel.Datum>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


}
