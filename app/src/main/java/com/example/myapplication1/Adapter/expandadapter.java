package com.example.myapplication1.Adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication1.Model.QuizQuestion;
import com.example.myapplication1.Model.Quizzes;
import com.example.myapplication1.R;
import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.OmegaExpandableRecyclerView;
import com.omega_r.omegarecyclerview.R;
import java.util.ArrayList;

public class expandadapter extends OmegaExpandableRecyclerView.Adapter<Quizzes, QuizQuestion> {

    @Override
    protected ExGroupViewHolder provideGroupViewHolder(@NonNull ViewGroup viewGroup) {
        return new ExGroupViewHolder(viewGroup);
    }

    @Override
    protected ExChildViewHolder provideChildViewHolder(@NonNull ViewGroup viewGroup) {
        return new ExChildViewHolder(viewGroup);
    }

    class ExGroupViewHolder extends GroupViewHolder {

        private TextView textView;

         ExGroupViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_exp_group);
            textView= findViewById(R.id.textview_group_name);
        }

        @Override
        public void onBind(Quizzes item) {
            textView.setText(item.getTitle());
        }

        @Override
        protected void onExpand(GroupViewHolder viewHolder, int groupIndex) {

        }

        @Override
        protected void onCollapse(GroupViewHolder viewHolder, int groupIndex) {

        }


    }

    class ExChildViewHolder extends ChildViewHolder {

        private TextView textView;

        ExChildViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_exp_child);
            textView = findViewById(R.id.textview_child_content);
        }

        @Override
        protected void onBind(QuizQuestion item) {
            textView.setText("dkdkfdkfdk");
        }
    }
    }
