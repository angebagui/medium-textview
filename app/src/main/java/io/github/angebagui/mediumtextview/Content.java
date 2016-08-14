package io.github.angebagui.mediumtextview;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by angebagui on 06/08/2016.
 */

public class Content {

    @SerializedName("content")
    private String content;

    public Content(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public static Content deserialize(Context context){
        try {
            String jsonString = parseResource(context, R.raw.content);
            Content content = new Gson().fromJson(jsonString,Content.class);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String  parseResource(Context context, int ressource) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(ressource);
        StringBuilder sb= new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String read = br.readLine();

        while(read!= null) {
            sb.append(read);
            read = br.readLine();
        }
        return sb.toString();
    }
}
