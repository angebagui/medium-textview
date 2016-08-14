package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jsoup.nodes.Element;
import io.github.angebagui.mediumtextview.util.Utils;

/**
 * Created by angebagui on 06/08/2016.
 */

public class ParagraphView extends ElementView{


    private static final String TAG = ParagraphView.class.getSimpleName();

    public ParagraphView(Context context, Element element) {
        super(context, element);
    }

    protected ParagraphView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        if (getElement() != null){


            if(getElement().children().size()>0){
                Utils.appendView(this,getElement().children());
            }
            if(!getElement().text().isEmpty()){
                Log.d(TAG, "Text : "+getElement().text());
                setText(getElement().text());
            }


        }

    }

    public void setText(String text){
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setPadding(Utils.dpToPx(getContext(),16),0,Utils.dpToPx(getContext(),16),0);

        final Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/"+"freight_text_pro.ttf");

        textView.setTypeface(myTypeface,0);
        textView.setTextSize(18f);

        textView.setTextColor(getResources().getColor(android.R.color.black));

        addView(textView);
    }

}
