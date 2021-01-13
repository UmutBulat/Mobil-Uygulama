package com.h5190052.umut_bulat_final.util;

import com.google.gson.Gson;
import com.h5190052.umut_bulat_final.model.FilmModel;


public class ObjectUtil {

    public  static String filmToJsonString(FilmModel film)
    {
        Gson gson = new Gson();
        return   gson.toJson(film);
    }

    public  static FilmModel jsonStringToFilm(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,FilmModel.class);
    }
}
