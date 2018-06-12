package com.example.android.jokeslibrary;


import java.util.ArrayList;
import java.util.Random;

public class Jokes {

    private ArrayList<String> italianJokesFromMovie = new ArrayList<>();
    private ArrayList<String> englishJokes = new ArrayList<>();

    private Random rndArrayList = new Random();
    private Random rndStringResult = new Random();

    public Jokes() {
    }

    private ArrayList<String> getItalianJokesFromMovie() {
        italianJokesFromMovie.add(" - Non potrei mai essere una donna , starei tutto il giorno a toccarmi le tette! (Pazzi a Beverly Hills)");
        italianJokesFromMovie.add(" - Magari qualche volta ci rivedremo. \\n - Certo … se mi trovo nei paraggi e devo andare al cesso… (Il grande Lebowsky)");
        italianJokesFromMovie.add(" - Ma lei non ha nessun complesso di inferiorità! \\n - Davvero? \\n - Lei \"è\" inferiore… (Fantozzi alla riscossa)");
        italianJokesFromMovie.add(" - In quale battaglia morì l'ammiragio Nelson? \\n - Sicuramente nell'ultima! (Pierino torna a scuola)");
        italianJokesFromMovie.add(" Nel 1848 Dracula si sfamava solo con donne vergini… nel 2005 è morto di fame… ");
        return italianJokesFromMovie;
    }

    private ArrayList<String> getEnglishJokes() {
        englishJokes.add(" - Can a kangaroo jump higher than a house? \\n - Of course , a house doesn't jump at all.");
        englishJokes.add(" - What is difference between a snowman and a snowwoman? \\n - Snowballs");
        englishJokes.add(" - Police: Open the door! \\n - Man: I don't want any balls! \\n - Police: What? We don't have any balls! \\n - Man: I know.");
        return englishJokes;
    }

    private String resultItalianJoke = getItalianJokesFromMovie().get(rndArrayList.nextInt(italianJokesFromMovie.size()));
    private String resultEnglishJoke = getEnglishJokes().get(rndArrayList.nextInt(englishJokes.size()));

    private String getResult[] = {
            resultItalianJoke,
            resultEnglishJoke
    };

    public String getRandomString(){
        int random = rndStringResult.nextInt(getResult.length);
        return getResult[random];
    }

}