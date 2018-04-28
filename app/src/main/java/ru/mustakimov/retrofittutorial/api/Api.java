package ru.mustakimov.retrofittutorial.api;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.mustakimov.retrofittutorial.model.GetTokenBody;
import ru.mustakimov.retrofittutorial.model.RegistrationBody;
import ru.mustakimov.retrofittutorial.model.RegistrationResponse;
import ru.mustakimov.retrofittutorial.model.TokenResponce;
import rx.Observable;

public interface Api {

    @POST("/api-application-registration/register")
    Observable<RegistrationResponse> registerUser(
            @Header("Authorization") String registerCredents,
            @Header("Content-Type") String content_type,
            @Body RegistrationBody registrationBody);

    @POST("/token")
    Observable<TokenResponce> getToken(
            @Query("grant_type") String grantType,
            @Query("username") String username,
            @Query("password") String password,
            @Query("scope") String scope,
            @Header("Content-Type") String content_type,
            @Header("Authorization") String token);

    @GET("/api/appm/publisher/v1.1/apps/mobileapp")
    Observable<TokenResponce> getAllApps(
            @Header("Authorization") String token);
}