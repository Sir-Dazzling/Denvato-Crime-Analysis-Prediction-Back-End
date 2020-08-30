package com.example.denvatocrimeanalyticsplatform.payload.response;

public class JwtResponse
{
    //Defining the fields
    private String accessToken;

    public JwtResponse(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
