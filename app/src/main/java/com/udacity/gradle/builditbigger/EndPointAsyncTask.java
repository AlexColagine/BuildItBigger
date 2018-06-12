package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.displayjoke.DisplayJoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myJokeApi.MyJokeApi;

import java.io.IOException;

@SuppressLint("StaticFieldLeak")
public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyJokeApi myApiService = null;
    private Context mContext;
    ProgressBar loading;


    public EndPointAsyncTask(Context mContext /*ProgressBar loading*/){
        this.mContext = mContext;
        //this.loading = loading;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(loading != null){
            loading.setVisibility(View.VISIBLE);
        }
    }

    @SafeVarargs
    @Override
    protected final String doInBackground(Pair<Context, String>... pairs) {
        if (myApiService == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.24:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(loading != null){
            loading.setVisibility(View.GONE);
        }
        sendToAndroidLibrary(s);
    }

    private void sendToAndroidLibrary(String result) {
        Intent sendIntent = new Intent(mContext, DisplayJoke.class);
        sendIntent.putExtra(DisplayJoke.EXTRA_INTENT , result);
        mContext.startActivity(sendIntent);
    }
}