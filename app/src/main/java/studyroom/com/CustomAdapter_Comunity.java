package studyroom.com;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter_Comunity extends RecyclerView.Adapter<CustomAdapter_Comunity.CustomViewHolder>{

    ArrayList<Ob_Education> arrayList;
    Context context;

    public CustomAdapter_Comunity(ArrayList<Ob_Education> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter_Comunity.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.etc_list_form,parent,false);
        CustomAdapter_Comunity.CustomViewHolder customViewHolder = new CustomAdapter_Comunity.CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter_Comunity.CustomViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.memo.setText(arrayList.get(position).getMemo());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;

        TextView name,title,memo;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.title = itemView.findViewById(R.id.title);
            this.memo = itemView.findViewById(R.id.memo);


            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    Intent intent = new Intent(context,Mento_Info_view.class);
                    intent.putExtra("name",arrayList.get(position).getName());
                    intent.putExtra("title",arrayList.get(position).getTitle());
                    intent.putExtra("memo",arrayList.get(position).getMemo());
                    intent.putExtra("layout","커뮤니티");
                    context.startActivity(intent);
                }
            });



        }
    }
}
