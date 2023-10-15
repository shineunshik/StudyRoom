package studyroom.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter_My_Info extends RecyclerView.Adapter<CustomAdapter_My_Info.CustomViewHolder>{

    ArrayList<Ob_Education> arrayList;
    Context context;

    public CustomAdapter_My_Info(ArrayList<Ob_Education> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter_My_Info.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_info_form,parent,false);
        CustomAdapter_My_Info.CustomViewHolder customViewHolder = new CustomAdapter_My_Info.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_My_Info.CustomViewHolder holder, int position) {

        holder.content.setText(arrayList.get(position).getContent());
        holder.title.setText(arrayList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView content,title;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.content = itemView.findViewById(R.id.content);

            this.title = itemView.findViewById(R.id.title);




            view = itemView;



        }
    }
}
