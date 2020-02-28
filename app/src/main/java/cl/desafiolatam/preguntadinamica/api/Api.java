package cl.desafiolatam.preguntadinamica.api;

import cl.desafiolatam.preguntadinamica.model.RespuestaApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("api.php?amount=1&type=boolean")
    Call<RespuestaApi> getQuestion(@Query("category") String b, @Query("difficulty") String c);

}
