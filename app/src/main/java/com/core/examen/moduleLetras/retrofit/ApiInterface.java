package com.core.examen.moduleLetras.retrofit;

import com.core.examen.moduleLetras.model.common.DatosLetras;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("{artis}/{title}")


    Call<DatosLetras> groupList(@Path("artis")
                            String artis, @Path("title") String title);
}
