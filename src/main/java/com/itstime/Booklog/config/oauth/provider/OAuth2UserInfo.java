package com.itstime.Booklog.config.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();  // 구글, 네이버, 카카오
    String getEmail();
    String getName();
}