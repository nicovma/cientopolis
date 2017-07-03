package cientopolis.cientopolis.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cientopolis.cientopolis.R;
import cientopolis.cientopolis.adapters.WorkflowAdapter;

/**
 * Created by nicolas.valentini on 2/7/17.
 */

public class MyWorkflowsFragment extends Fragment {

    private View view;
    private RecyclerView recycler;
    private View downloading;
    private View error;
    private TextView textError;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Button retry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_workflows_list, container, false);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        downloading = view.findViewById(R.id.cargando);
        downloading.setVisibility(View.VISIBLE);
        Animation ballAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ball_animation);
        ballAnimation.setRepeatCount(Animation.INFINITE);
        ImageView ball = (ImageView) view.findViewById(R.id.ball);
        ball.startAnimation(ballAnimation);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        error = view.findViewById(R.id.error);
        textError = (TextView) error.findViewById(R.id.text_error);
        retry = (Button) view.findViewById(R.id.retry);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //RefreshView
                //requestController.get(new TypeToken<ResponseDTO<List<Match>>>() {}.getType(), "/games/mygames", 6, params);
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RefreshView
                //requestController.get(new TypeToken<ResponseDTO<List<Match>>>() {}.getType(), "/games/mygames", 6, params);
                //downloading.setVisibility(View.VISIBLE);
                //error.setVisibility(View.GONE);
                //recycler.setVisibility(View.GONE);
                //mSwipeRefreshLayout.setVisibility(View.GONE);
            }
        });
        if (savedInstanceState == null ) {
            // if i haven´t an instance i request for one.
            responseOk();
        } else {
            //
        }
        return view;
    }

    public void responseOk(){
        mSwipeRefreshLayout.setRefreshing(false);
        List<String> cientifics = new ArrayList<String>();
        cientifics.add("Nicolas Valentini");
        cientifics.add("Alex Rojas");
        cientifics.add("Diego Torres");
        cientifics.add("Juan Perez");
        cientifics.add("Jose Gomez");
        if(cientifics.size()>0){
            downloading.setVisibility(View.GONE);
            error.setVisibility(View.GONE);
            recycler.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            recycler.setAdapter(new WorkflowAdapter(cientifics));
        }
        else {
            retry.setVisibility(View.GONE);
            downloading.setVisibility(View.GONE);
            error.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setVisibility(View.GONE);
            recycler.setVisibility(View.GONE);
            textError.setText(R.string.empty_workflows);
        }

    }

}
