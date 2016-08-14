package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Element;

import io.github.angebagui.mediumtextview.util.Utils;


/**
 * Created by angebagui on 06/08/2016.
 */

public class ImageView extends ElementView {

    private static final String TAG = ImageView.class.getSimpleName();


    public ImageView(Context context, Element element) {
        super(context, element);
    }

    protected ImageView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        Log.d(TAG, "I am image view");
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        imageView.setPadding(Utils.dpToPx(getContext(),8), Utils.dpToPx(getContext(),16),Utils.dpToPx(getContext(),8),Utils.dpToPx(getContext(),16) );
        final String url = getLink();
        Picasso.with(getContext()).load(url).error(R.drawable.image_placeholder_error).into(imageView);
        imageView.setAdjustViewBounds(true);
        addView(imageView);

    }

    public String getLink(){
        if(getElement() ==null)
            return null;
        return getElement().attr("abs:src");
    }
}
