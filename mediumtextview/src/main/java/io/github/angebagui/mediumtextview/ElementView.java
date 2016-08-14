package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.jsoup.nodes.Element;

/**
 * Created by angebagui on 06/08/2016.
 */

public abstract class ElementView extends LinearLayout{

    private Element element;

    protected ElementView(Context context, Element element) {
        super(context);
        this.element = element;
        render();
    }

    protected ElementView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs);
        this.element = element;
        render();
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public abstract void render();
}
