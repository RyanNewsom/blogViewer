package mobileclass.kylesblogviewer;


import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
    private RelativeLayout mainContainer;

    /**
     *
     * @param blogPost
     * @return
     */
    public static BlogPostFragment newInstance(BlogPost blogPost) {
        BlogPostFragment fragment = new BlogPostFragment();
        mBlogPost = blogPost;

        //put the data in the fragment
        return fragment;
    }

    public BlogPostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.blog_post_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title = (TextView) getView().findViewById(R.id.title);
        subTitle = (TextView) getView().findViewById(R.id.subtitle);
        textBody = (TextView) getView().findViewById(R.id.text_body);
        mainContainer = (RelativeLayout) getView().findViewById(R.id.mainContainer);

        title.setText(mBlogPost.getTitle());
        subTitle.setText(mBlogPost.getSubTitile());
        textBody.setText(Html.fromHtml(mBlogPost.getPostBody()));
    }
}
