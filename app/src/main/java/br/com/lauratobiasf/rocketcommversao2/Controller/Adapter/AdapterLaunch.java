package br.com.lauratobiasf.rocketcommversao2.Controller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lauratobiasf.rocketcommversao2.Model.Launch;
import br.com.lauratobiasf.rocketcommversao2.R;

public class AdapterLaunch extends RecyclerView.Adapter<AdapterLaunch.LaunchViewHolder>
{
    private List<Launch> launchList;

    public AdapterLaunch(List<Launch> launchList)
    {
        this.launchList = launchList;
    }

    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_launch_list, parent, false);
        return new LaunchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder holder, int position)
    {
        Launch launch = launchList.get(position);
        holder.launchID.setText(launch.getId());
    }

    @Override
    public int getItemCount() {
        return launchList.size();
    }

    public class LaunchViewHolder extends RecyclerView.ViewHolder
    {
        TextView launchID;

        public LaunchViewHolder(View itemView) {
            super(itemView);

            launchID = itemView.findViewById(R.id.textIDLaunch);
        }
    }
}