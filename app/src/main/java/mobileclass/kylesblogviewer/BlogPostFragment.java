package mobileclass.kylesblogviewer;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogPostFragment extends Fragment {

    private static BlogPost mBlogPost;
    private TextView title;
    private TextView subTitle;
    private TextView textBody;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
<<<<<<< HEAD
     *
     * @param blogPost single blog post from list view.
=======
>>>>>>> 5a29a2a2eacba7b87566fc13d6de00210abc9e65
     * @return A new instance of fragment BlogPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlogPostFragment newInstance(BlogPost blogPost) {
        BlogPostFragment fragment = new BlogPostFragment();
<<<<<<< HEAD
        mBlogPost = blogPost;

        fragment.title.setText(blogPost.getTitle());
        fragment.subTitle.setText(blogPost.getSubTitile());
        fragment.textBody.setText(blogPost.getPostBody());

=======
        mBlogPosts = blogPosts;

        //put the data in the fragment
>>>>>>> 5a29a2a2eacba7b87566fc13d6de00210abc9e65
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
