package com.h5190052.umut_bulat_final.network;



import com.h5190052.umut_bulat_final.model.FilmModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("KorkuFilmleriApi.json")
    Observable<List<FilmModel>> filmleriGetir();
}
