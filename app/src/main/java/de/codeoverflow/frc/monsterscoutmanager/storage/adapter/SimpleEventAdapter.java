package de.codeoverflow.frc.monsterscoutmanager.storage.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import java.util.List;
import de.codeoverflow.frc.monsterscoutmanager.R;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.util.ui.OnRecyclerViewItemClickListener;


public class SimpleEventAdapter extends RecyclerView.Adapter<SimpleEventAdapter.ViewHolder>
        implements FastScrollRecyclerView.SectionedAdapter {

    private List<SimpleEvent> events;
    private OnRecyclerViewItemClickListener listener;

    public SimpleEventAdapter(List<SimpleEvent> events, OnRecyclerViewItemClickListener listener) {
        this.events = events;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_event_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleEvent event = events.get(position);

        final int index = position;
        holder.title.setText(event.getName());
        holder.subTitle.setText(event.getCountry());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRecyclerViewItemClicked(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    @Override
    public String getSectionName(int position) {
        return String.valueOf(events.get(position).getName().charAt(0));
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout layout;
        public TextView title;
        public TextView subTitle;

        ViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.parent);
            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subTitle);
        }
    }
}
