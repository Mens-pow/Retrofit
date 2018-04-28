package ru.mustakimov.retrofittutorial.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Khokhlov.M on 25.04.2018.
 */


public class RegistrationBody{
    private String callbackUrl;
    private String clientName;
    private String tokenScope;
    private String owner;
    private String grantType;
    private boolean saasApp;
    private String[] tags;

    public RegistrationBody(String callbackUrl, String clientName, String tokenScope, String owner, String grantType, boolean saasApp, String[] tags) {
        this.callbackUrl = callbackUrl;
        this.clientName = clientName;
        this.tokenScope = tokenScope;
        this.owner = owner;
        this.grantType = grantType;
        this.saasApp = saasApp;
        this.tags = tags;
    }
}
