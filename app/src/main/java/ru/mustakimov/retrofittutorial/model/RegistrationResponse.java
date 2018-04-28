package ru.mustakimov.retrofittutorial.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Khokhlov.M on 25.04.2018.
 */


public class RegistrationResponse {
    @SerializedName("client_secret")
   private String clientSecret;
    @SerializedName("client_id")
   private String clientId;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "clientSecret='" + clientSecret + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
