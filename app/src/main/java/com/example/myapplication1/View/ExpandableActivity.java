package com.example.myapplication1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication1.Adapter.expandadapter;
import com.example.myapplication1.Model.JsonPlaceHolderAPi;
import com.example.myapplication1.Model.QuizQuestion;
import com.example.myapplication1.Model.Quizid;
import com.example.myapplication1.Model.Quizzes;
import com.example.myapplication1.Model.SimpleData;
import com.example.myapplication1.R;
import com.google.firebase.inject.Provider;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.OmegaExpandableRecyclerView;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.animation.ExpandableItemAnimator;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.animation.standard_animations.DropDownItemAnimator;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.animation.standard_animations.FadeItemAnimator;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.data.GroupProvider;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExpandableActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private static final ExpandableItemAnimator FADE_ANIMATOR = new FadeItemAnimator();
    private static final ExpandableItemAnimator DROPDOWN_ANIMATOR = new DropDownItemAnimator();
    private String[]stringlist;
    public  String favouritelist;

    private OmegaExpandableRecyclerView mRecyclerView;
    private OmegaExpandableRecyclerView.Adapter mAdapter=provideAdapter();

    protected  OmegaExpandableRecyclerView.Adapter provideAdapter(){
        return new expandadapter();
    }
    private List<? extends GroupProvider<Quizzes,Quizzes>> items;

    protected int provideContentLayoutRes() {
        return R.layout.activity_expandable;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentLayoutRes());


        createItems();

        setupRecyclerView();
        setupRadioButtons();
        fillAdapter();
        findViewById(R.id.button_test_update_child).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quizzes quote = items.get(3).provideChilds().get(1);
                quote.setTitle("UPDATED QUOTE");
                mAdapter.notifyChildChanged(quote);
            }
        });

    }

    private void createItems(){
        Intent intent=getIntent();
        String quizID = intent.getStringExtra("quizid");
        SharedPreferences sharedPreferencetoken =getSharedPreferences("userdata", Context.MODE_PRIVATE);
        String token = sharedPreferencetoken.getString("Token", null);
        favouritelist=sharedPreferencetoken.getString("favourite",null);
        if(favouritelist!=null) {
            stringlist = favouritelist.split(",");
            Toast.makeText(getApplicationContext(),stringlist.length+"1223",Toast.LENGTH_SHORT).show();
        }

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://collaborative-learning-system.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final JsonPlaceHolderAPi jsonPlaceHolderAPi=retrofit.create(JsonPlaceHolderAPi.class);
        final Call<Quizid> call=jsonPlaceHolderAPi.getQUizzesid("Bearer " + token,quizID);
        /*items=Arrays.asList(
                SimpleData.from(
                       new Quizzes("fdfdfdfd"),
                        new Quizzes("sdffdffdf"))
                ),
                SimpleData.from(
                        new Quizzes("fdfdfdfd"),
                        new Quizzes("sdffdffdf")
                )
        );
        )*/
        items=Arrays.asList(
               SimpleData.from(
                       new Quizzes("sdsdsdsd"),
                       new Quizzes("dsdsdsd")
               ),
                SimpleData.from(
                        new Quizzes("sdsdsd"),
                        new Quizzes("sdsdsds")
                ),
                SimpleData.from(
                        new Quizzes("sdsdsd"),
                        new Quizzes("sdsdsds")
                ),
                SimpleData.from(
                        new Quizzes("sdsdsd"),
                        new Quizzes("sdsdsds")
                )
        );

    }
    protected void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(mAdapter);
    }
    protected void fillAdapter() {
        mAdapter.setItemsAsGroupProviders(items);
    }
    protected void setupRadioButtons() {
        RadioButton dropdownRadioButton = findViewById(R.id.radiobutton_dropdown);
        RadioButton fadeRadioButton = findViewById(R.id.radiobutton_fade);
        RadioButton singleRadioButton = findViewById(R.id.radiobutton_single);
        RadioButton multipleRadioButton = findViewById(R.id.radiobutton_multiple);

        switch (mRecyclerView.getChildExpandAnimation()) {
            case OmegaExpandableRecyclerView.CHILD_ANIM_DROPDOWN:
                dropdownRadioButton.setChecked(true);
                break;
            case OmegaExpandableRecyclerView.CHILD_ANIM_FADE:
                fadeRadioButton.setChecked(true);
                break;
        }

        switch (mRecyclerView.getChildExpandAnimation()) {
            case OmegaExpandableRecyclerView.CHILD_ANIM_DROPDOWN:
                dropdownRadioButton.setChecked(true);
                break;
            case OmegaExpandableRecyclerView.CHILD_ANIM_FADE:
                fadeRadioButton.setChecked(true);
                break;
        }

        dropdownRadioButton.setOnCheckedChangeListener(this);
        fadeRadioButton.setOnCheckedChangeListener(this);
        singleRadioButton.setOnCheckedChangeListener(this);
        multipleRadioButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.radiobutton_fade:
                    mRecyclerView.setItemAnimator(FADE_ANIMATOR);
                    break;
                case R.id.radiobutton_dropdown:
                    mRecyclerView.setItemAnimator(DROPDOWN_ANIMATOR);
                    break;
                case R.id.radiobutton_single:
                    mRecyclerView.setExpandMode(OmegaExpandableRecyclerView.EXPAND_MODE_SINGLE);
                    break;
                case R.id.radiobutton_multiple:
                    mRecyclerView.setExpandMode(OmegaExpandableRecyclerView.EXPAND_MODE_MULTIPLE);
                    break;
            }
        }
    }

}
