package mobileclass.kylesblogviewer;

import android.app.Fragment;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * This activity contains the action bar and is used simply as a driver
 */
public class HomeScreenActivity extends ActionBarActivity {

    private ArrayList<BlogPost> mBlogPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        getData();

        Fragment blogItemsFragment = BlogItemsFragment.newInstance(mBlogPosts);
        getFragmentManager().beginTransaction().replace(R.id.leftFragmentContainer, blogItemsFragment).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void getData() {

        HttpGet httpGet = new HttpGet("http://www.kylefrisbie.com/api/blogposts");
        mBlogPosts = httpGet.getBlogPostArray();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
