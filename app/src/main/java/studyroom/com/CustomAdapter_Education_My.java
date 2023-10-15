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

public class CustomAdapter_Education_My extends RecyclerView.Adapter<CustomAdapter_Education_My.CustomViewHolder>{

    ArrayList<Ob_Education> arrayList;
    Context context;

    public CustomAdapter_Education_My(ArrayList<Ob_Education> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter_Education_My.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stuty_list_form,parent,false);
        CustomAdapter_Education_My.CustomViewHolder customViewHolder = new CustomAdapter_Education_My.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_Education_My.CustomViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName()+" 강사");
        holder.title.setText(arrayList.get(position).getTitle());

        Glide.with(context)
                .load(arrayList.get(position).getImage())
                .into(holder.image);

        holder.join.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView name,title,join;

        ImageView image;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.image = itemView.findViewById(R.id.image);
            this.title = itemView.findViewById(R.id.title);
            this.join = itemView.findViewById(R.id.join);



            view = itemView;



        }
    }
}
