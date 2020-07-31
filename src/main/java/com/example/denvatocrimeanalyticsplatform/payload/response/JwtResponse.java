package com.example.denvatocrimeanalyticsplatform.payload.response;

import java.util.List;

public class JwtResponse
{
    //Defining the fields
    private String accessToken;
    private String refreshToken;
    private Long expiresInMsec;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private boolean isEnabled;

    //Defining the constructors
    public JwtResponse(String accessToken, String refreshToken, Long expiresInMsec, Long id, String username, String email, List<String> roles, boolean isEnabled) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresInMsec = expiresInMsec;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.isEnabled = isEnabled;
    }

    public JwtResponse(String accessToken, String refreshToken, Long expiresInMsec)
    {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresInMsec = expiresInMsec;
    }

    //Defining the getters/setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpiresInMsec() {
        return expiresInMsec;
    }

    public void setExpiresInMsec(Long expiresInMsec) {
        this.expiresInMsec = expiresInMsec;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
