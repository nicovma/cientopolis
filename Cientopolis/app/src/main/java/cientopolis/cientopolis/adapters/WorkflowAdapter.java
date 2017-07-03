package cientopolis.cientopolis.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cientopolis.cientopolis.R;

/**
 * Created by nicolas.valentini on 2/7/17.
 */

public class WorkflowAdapter extends RecyclerView.Adapter<WorkflowAdapter.ViewHolder> {

    private List<String> workflows;
    public WorkflowAdapter(List<String> workflows) {
        this.workflows = workflows;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workflow, parent, false);
        return new WorkflowAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cientificName.setText(workflows.get(position));
        holder.workflowName.setText("Número" + String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return workflows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cientificName;
        TextView workflowName;

        public ViewHolder(View itemView) {
            super(itemView);
            cientificName = (TextView) itemView.findViewById(R.id.cientific_name);
            workflowName = (TextView) itemView.findViewById(R.id.workflow_name);

        }
    }
}
