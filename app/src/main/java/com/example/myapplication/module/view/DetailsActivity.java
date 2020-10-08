package com.example.myapplication.module.view;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.base.RecyclerViewClickListener;
import com.example.myapplication.module.model.EntertainmentzModel;
import com.example.myapplication.module.model.Item;
import com.example.myapplication.module.view_model.EntertainmentDataViewModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private EntertainmentDataViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        Bundle extras = getIntent().getExtras();
       String url= extras.getString("url");
        Log.e("Hello",url);
        CircleImageView iv_details=(CircleImageView)findViewById(R.id.iv_detail);
        Picasso.get().load(url).into(iv_details);
        setData();


    }

    private  void setData(){
        TextView tv_title=(TextView)findViewById(R.id.tv_title);
        TextView tv_description=(TextView)findViewById(R.id.tv_description);
        TextView tv_content=(TextView)findViewById(R.id.tv_content);
        TextView tv_date=(TextView)findViewById(R.id.tv_date);
        TextView tv_url_website=(TextView)findViewById(R.id.url_website);
        Bundle extras = getIntent().getExtras();
        tv_title.setText(extras.getString("title"));
        tv_description.setText(extras.getString("description"));
        tv_content.setText(extras.getString("content"));
        tv_date.setText(extras.getString("date"));
        tv_url_website.setText(extras.getString("link"));
       // tv_url_website.setMovementMethod(LinkMovementMethod.getInstance());


    }
    @Override
    protected void onResume() {
        super.onResume();
        initilizePostViewModel();

    }

    private void initilizePostViewModel(){

    }

    private EntertainmentAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    public void onClick(View view) {

    }
}


