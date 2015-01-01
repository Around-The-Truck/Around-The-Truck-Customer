package kr.co.aroundthetruck.customer.network;

/**
 * Created by ebsud89 on 12/20/14.
 */

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpCommunication {

    String buf = "";

    public String doPost(ArrayList<NameValuePair> param, String context) {

        String retBuf = "";
        String url = "http://165.194.35.161:3000/";

        // fill in Context
        url += context;

        try {

            HttpClient http = new DefaultHttpClient();

            HttpParams params = http.getParams();

            HttpPost httpPost = new HttpPost(url);
            UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(param, "UTF-8");

            httpPost.setEntity(entityRequest);

            HttpResponse responsePost = http.execute(httpPost);
            HttpEntity resEntity = responsePost.getEntity();

            retBuf = EntityUtils.toString(resEntity);
            retBuf = retBuf.trim();

        } catch (Exception e) {
            Log.d("exception!","exception");
            e.printStackTrace();
            retBuf = "Error";

        }
        return retBuf;
    }

    public String getTruckInfo () {



//        doPost()

        return buf;
    }

    public String getTruckListWithGPS () {

        return buf;
    }


    public String getTruckListNoGPS () {

        return buf;
    }
}
