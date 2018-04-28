package ru.mustakimov.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import ru.mustakimov.retrofittutorial.adapter.PostsAdapter;
import ru.mustakimov.retrofittutorial.api.Api;
import ru.mustakimov.retrofittutorial.model.GetTokenBody;
import ru.mustakimov.retrofittutorial.model.RegistrationBody;

import ru.mustakimov.retrofittutorial.model.PostModel;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<PostModel> posts;
    private String token;
    private String clientId;
    private String clientSecret;
    private Api api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posts = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PostsAdapter adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);
        this.api = App.getApi();
        getSecret();
    }

    private void getSecret(){

        String tags[] = {"device_management"};
        RegistrationBody registrationBody = new RegistrationBody("www.google.com", "rest_api_publisher","Production","admin",
                "password refresh_token", true, tags);
        api.registerUser(App.getAuthToken("admin", "admin"), "application/json", registrationBody)
                .subscribe(token -> {
                            Log.i("qwe", token.toString());
                            clientId = token.getClientId();
                            clientSecret = token.getClientSecret();
                            getToken();
                        },
                        //обработка ошибки
                        Throwable::printStackTrace);

    }

    private void getToken(){
        api.getToken("password", "admin", "admin", "create appm:publish appm:read","application/x-www-form-urlencoded",  App.getAuthToken(clientId, clientSecret))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(token->{
                    token.toString();
                    this.token = token.getAccessToken();
                    App.changeApiBaseUrl("https://192.168.50.19:9443");
                    this.api = App.getApi();
                    getAllApps();
                },
                        Throwable::printStackTrace);
    }

    private void getAllApps(){
        api.getAllApps("Bearer "+ token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responce->{
                            responce.toString();
                        },
                        Throwable::printStackTrace);
    }


}
