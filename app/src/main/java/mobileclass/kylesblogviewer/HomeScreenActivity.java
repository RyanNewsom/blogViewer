package mobileclass.kylesblogviewer;

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

        getData();


        BlogItemsFragment.newInstance()
        getFragmentManager().beginTransaction().replace(R.id.leftFragmentContainer, ).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void getData() {
        HttpGet httpGet = new HttpGet("http://javatechig.com/android/display-html-in-android-textview");
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
