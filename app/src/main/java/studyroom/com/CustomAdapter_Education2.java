package studyroom.com;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter_Education2 extends RecyclerView.Adapter<CustomAdapter_Education2.CustomViewHolder>{

    ArrayList<Ob_Education> arrayList;
    Context context;

    public CustomAdapter_Education2(ArrayList<Ob_Education> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter_Education2.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.study_list_form2,parent,false);
        CustomAdapter_Education2.CustomViewHolder customViewHolder = new CustomAdapter_Education2.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_Education2.CustomViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName()+" 강사");
        holder.title.setText("("+arrayList.get(position).getType()+")"+arrayList.get(position).getTitle());

        Glide.with(context)
                .load(arrayList.get(position).getImage())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView name,title;

        ImageView image;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.image = itemView.findViewById(R.id.image);
            this.title = itemView.findViewById(R.id.title);



            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    Intent intent = new Intent(context, Road_Info.class);
                    intent.putExtra("url",arrayList.get(position).getUrl());
                    context.startActivity(intent);
                }
            });


        }
    }
}
