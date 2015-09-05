package mobileclass.kylesblogviewer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogPostFragment extends Fragment {

    private static ArrayList<BlogPost> mBlogPosts;
    private TextView title;
    private TextView subTitle;
    private TextView textBody;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlogPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlogPostFragment newInstance(ArrayList<BlogPost> blogPosts) {
        BlogPostFragment fragment = new BlogPostFragment();
        mBlogPosts = blogPosts;
        return fragment;
    }

    public BlogPostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = (TextView) getView().findViewById(R.id.title);
        subTitle = (TextView) getView().findViewById(R.id.subtitle);
        textBody = (TextView) getView().findViewById(R.id.text_body);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.blog_post_fragment, container, false);
    }


}
