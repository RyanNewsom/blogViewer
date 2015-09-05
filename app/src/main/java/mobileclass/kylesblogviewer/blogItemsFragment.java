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

import java.util.ArrayList;


/**
 *
 */
public class BlogItemsFragment extends ListFragment {

    String[] numbers_text = new String[] { "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen" };
    String[] numbers_digits = new String[] { "1", "2", "3", "4", "5", "6", "7",
           "8", "9", "10", "11", "12", "13", "14", "15" };


    public static BlogItemsFragment newInstance(String param1) {
        BlogPostFragment fragment = new BlogPostFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                   inflater.getContext(), android.R.layout.simple_list_item_1,
                     numbers_text);
         setListAdapter(adapter);
          return super.onCreateView(inflater, container, savedInstanceState);
          }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Check to see which item was picked,
        showBlogPost();
    }

    private void showBlogPost() {
        Fragment blogPost = BlogPostFragment.newInstance("");
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.mainContainer, blogPost);


    }
}
