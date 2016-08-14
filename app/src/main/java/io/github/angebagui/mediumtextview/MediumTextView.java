package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import io.github.angebagui.mediumtextview.util.Utils;

/**
 * Created by angebagui on 06/08/2016.
 */

public class MediumTextView  extends ElementView{


    public MediumTextView(Context context) {
        super(context, null);
    }

    public MediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs, null);
    }

    @Override
    public void render() {
        setOrientation(LinearLayout.VERTICAL);
    }

    public void setText(String html){
        Document document =  Jsoup.parse(html);
        Element element = document.body();
        setElement(element);
        Utils.appendView(this,getElement().children());
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
