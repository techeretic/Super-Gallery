package app.supergallery.techeretic.com.filereader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.supergallery.techeretic.com.supergallery.R;

/**
 * Created by p.shetye on 1/2/15.
 */
public class ImageAdapter extends
        RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final static String LOG_TAG = "ImageAdapter";

    private static List<String> mImagePaths = new ArrayList<String>();

    private Context mContext;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mIView;
        public ViewHolder(View view) {
            super(view);
            mIView = (ImageView) view.findViewById(R.id.sdImage);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ImageAdapter(List<String> objects, Context context) {
        Log.d(LOG_TAG, "Inside Constructor");
        mContext = context;
        mImagePaths = objects;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent,
                false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        File imgFile = new  File(mImagePaths.get(position));
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        int nh = (int) ( myBitmap.getHeight() * (128.0 / myBitmap.getWidth()) );
        Bitmap scaled = Bitmap.createScaledBitmap(myBitmap, 128, nh, true);
        holder.mIView.setImageBitmap(scaled);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mImagePaths.size();
    }

}
