package cl.desafiolatam.preguntadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import cl.desafiolatam.preguntadinamica.api.Api;
import cl.desafiolatam.preguntadinamica.api.RetrofitClient;
import cl.desafiolatam.preguntadinamica.model.RespuestaApi;
import cl.desafiolatam.preguntadinamica.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private String cat, dific,preg,correcta,erronea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        initializeViews();
//        question.setText("Hey yo");
        Api api = RetrofitClient.getRetrofit()
                .create(Api.class);

        int a = (int)(Math.random()*30);
        Log.d(TAG, "onCreate: " + a);
        List<String> dificultades = Arrays.asList("medium","hard","easy");
        int f = (int)(Math.random()*3);
        String diff = dificultades.get(f);


        
        Call<RespuestaApi> call =api.getQuestion(String.valueOf(a), diff);
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {


                List<Result> listaResponse = response.body().getResults();
                  int codeResponse = response.body().getResponseCode();

                cat =response.body().getResults().get(0).getCategory();
                dific =response.body().getResults().get(0).getDifficulty();
                preg = response.body().getResults().get(0).getPregunta();
                correcta=response.body().getResults().get(0).getCorrectAnswer();
                erronea=response.body().getResults().get(0).getIncorrectAnswer().toString();




                // cambiar primerascosasses y verificar con getcategory, sincreonizar
                initializeFragment(cat, dific);
//                difficulty.setText(response.body().getResults().get(0).getDifficulty());
//                category.setText(response.body().getResults().get(0).getCategory());
//                question.setText(response.body().getResults().get(0).getQuestion());
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something's wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initializeFragment(String cosa1, String cosa2){
        Log.e("Error","initializeMethod");

        FirstFragment firstFragment = FirstFragment.newInstance(cosa1,cosa2);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, firstFragment, "FIRSTFRAGMENT")
                .commit();
    }
}
