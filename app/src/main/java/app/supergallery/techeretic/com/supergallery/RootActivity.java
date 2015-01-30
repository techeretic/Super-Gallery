package app.supergallery.techeretic.com.supergallery;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import app.supergallery.techeretic.com.filereader.FileHelper;
import app.supergallery.techeretic.com.filereader.ImageAdapter;


public class RootActivity extends ActionBarActivity {

    ArrayList<String> mFilePaths = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        FileHelper fh = new FileHelper(this.getApplicationContext());
        mFilePaths = fh.getFilePaths();
        Log.d("SuperGallery", "mFilePaths are as Follows: ");
        for (String path : mFilePaths) {
            Log.d("SuperGallery","path = " + path);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ListView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));
        ImageAdapter imageAdapter = new ImageAdapter(mFilePaths, getApplicationContext());
        recyclerView.setAdapter(imageAdapter);
    }
}
