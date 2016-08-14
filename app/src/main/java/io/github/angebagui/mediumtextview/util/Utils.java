package io.github.angebagui.mediumtextview.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.widget.TextView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.github.angebagui.mediumtextview.BlockquoteView;
import io.github.angebagui.mediumtextview.DivView;
import io.github.angebagui.mediumtextview.ElementView;
import io.github.angebagui.mediumtextview.HeaderView;
import io.github.angebagui.mediumtextview.IFrameView;
import io.github.angebagui.mediumtextview.ImageView;
import io.github.angebagui.mediumtextview.ParagraphView;

/**
 * Created by angebagui on 06/08/2016.
 */

public class Utils {

    public static void appendView(ElementView elementView, Elements elements){
        for (Element e: elements){
            if (JsoupUtils.isBlockquote(e)){
                elementView.addView(new BlockquoteView( elementView.getContext(), e));
            }else if(JsoupUtils.isHeader(e)){
                elementView. addView(new HeaderView( elementView.getContext(),e));
            }else if(JsoupUtils.isIFrame(e)){
                elementView.addView(new IFrameView( elementView.getContext(),e));
            }else if(JsoupUtils.isParagraph(e)){
                elementView.addView(new ParagraphView( elementView.getContext(),e));
            }else if(JsoupUtils.isImage(e)){
                elementView.addView(new ImageView( elementView.getContext(),e));
            }else if(JsoupUtils.isDiv(e)){
                elementView.addView(new DivView(elementView.getContext(),e));
            }
            else {

            }
        }
    }

    public static int dpToPx(Context context , int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public static void setTypeface(TextView textView, String fontName){
        Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/"+fontName);
        textView.setTypeface(myTypeface);
    }
}
