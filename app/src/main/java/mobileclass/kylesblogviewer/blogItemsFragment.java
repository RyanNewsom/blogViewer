package mobileclass.kylesblogviewer;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 */
public class BlogItemsFragment extends ListFragment {

    private static ArrayList<BlogPost> mBlogPosts;
    private ArrayList<String> mTitles;

    public static BlogItemsFragment newInstance(ArrayList<BlogPost> blogPosts) {
        BlogItemsFragment fragment = new BlogItemsFragment();
        mBlogPosts = blogPosts;
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         populateListView();
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, mTitles);
         setListAdapter(adapter);
          return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Check to see which item was picked,
        showBlogPost(position);
    }

    private void populateListView(){
        mTitles = new ArrayList<>();

        for(int i = 0; i < mBlogPosts.size(); i++){
            mTitles.add(i, mBlogPosts.get(i).getTitle());
        }
    }

    private void showBlogPost(int position) {
        BlogPost selectedBlogPost = mBlogPosts.get(position);
        Fragment blogPost = BlogPostFragment.newInstance(selectedBlogPost);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().addToBackStack(null ).replace(R.id.mainContainer, blogPost).commit();


    }
}
