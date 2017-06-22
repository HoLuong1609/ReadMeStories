package ominext.com.readmestories.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ominext.com.readmestories.Data;
import ominext.com.readmestories.R;
import ominext.com.readmestories.adapters.BookAdapter;
import ominext.com.readmestories.adapters.SimpleDividerItemDecoration;

public class MyBooksFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;

    public MyBooksFragment() {
        // Required empty public constructor
    }

    public static MyBooksFragment newInstance() {
        MyBooksFragment fragment = new MyBooksFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_books, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_my_books);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        mBookAdapter = new BookAdapter(getContext(), Data.getBookList());
        mRecyclerView.setAdapter(mBookAdapter);
    }
}
