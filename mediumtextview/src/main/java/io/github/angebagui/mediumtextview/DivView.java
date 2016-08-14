package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.jsoup.nodes.Element;

import io.github.angebagui.mediumtextview.util.Utils;

/**
 * Created by angebagui on 14/08/2016.
 */

public class DivView extends ElementView {

    public DivView(Context context, Element element) {
        super(context, element);
    }

    public DivView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        if(getElement() != null){
            if(getElement().children().size()>0){
                Utils.appendView(this,getElement().children());
            }
        }
    }
}
