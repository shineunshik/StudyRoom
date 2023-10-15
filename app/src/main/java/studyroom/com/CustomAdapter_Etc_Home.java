package studyroom.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter_Etc_Home extends RecyclerView.Adapter<CustomAdapter_Etc_Home.CustomViewHolder>{

    ArrayList<Ob_Education> arrayList;
    Context context;

    public CustomAdapter_Etc_Home(ArrayList<Ob_Education> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter_Etc_Home.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comunity_list_all_form,parent,false);
        CustomAdapter_Etc_Home.CustomViewHolder customViewHolder = new CustomAdapter_Etc_Home.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_Etc_Home.CustomViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName());
        holder.title.setText(arrayList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView name,title;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.title = itemView.findViewById(R.id.title);


            view = itemView;



        }
    }
}
