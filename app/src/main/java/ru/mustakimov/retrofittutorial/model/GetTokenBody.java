package ru.mustakimov.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Khokhlov.M on 25.04.2018.
 */

public class GetTokenBody {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("scope")
    private String scope;
    @SerializedName("grant_type")
    private String grant_type;

    public GetTokenBody(String grant_type, String username, String password, String scope) {
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
        this.scope = scope;
    }
}
