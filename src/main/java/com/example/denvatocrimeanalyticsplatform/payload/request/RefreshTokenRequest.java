package com.example.denvatocrimeanalyticsplatform.payload.request;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest
{
    //Defining the fields
    @NotBlank(message = "Not Found")
    private String refreshToken;

    @NotBlank(message = "Not Found")
    private String username;

    @NotBlank(message = "Not Found")
    private String password;

    //Defining the getters/setters
    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
