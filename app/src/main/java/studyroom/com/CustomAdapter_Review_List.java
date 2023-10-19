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

public class CustomAdapter_Review_List extends RecyclerView.Adapter<CustomAdapter_Review_List.CustomViewHolder>{
    ArrayList<Ob_Review_List> arrayList;
    Context context;

    public CustomAdapter_Review_List(ArrayList<Ob_Review_List> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter_Review_List.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_form,parent,false);
        CustomAdapter_Review_List.CustomViewHolder customViewHolder = new CustomAdapter_Review_List.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_Review_List.CustomViewHolder holder, int position) {


        holder.name.setText(arrayList.get(position).getName());
        holder.review.setText(arrayList.get(position).getReview());
        holder.time.setText(arrayList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView name,review,time;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.review = itemView.findViewById(R.id.review);
            this.time = itemView.findViewById(R.id.time);


            view = itemView;



        }
    }
}
