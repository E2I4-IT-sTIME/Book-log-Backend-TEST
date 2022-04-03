package com.itstime.Booklog.config.provider;

public interface OAuth2UserInfo {
    String getProviderId();

    String getProvider();
    String getEmail();
    String getName();
}
