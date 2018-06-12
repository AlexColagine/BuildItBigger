package com.udacity.gradle.builditbigger.backend;

import com.example.android.jokeslibrary.Jokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */

@Api(
        name = "myJokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)

public class MyJokeEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name= "getJoke")
    public MyJoke getJoke() {
        MyJoke response = new MyJoke();
        Jokes libraryJokes = new Jokes();
        response.setData(libraryJokes.getRandomString());
        return response;
    }

}
