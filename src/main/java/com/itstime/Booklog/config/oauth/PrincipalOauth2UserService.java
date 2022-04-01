package com.itstime.Booklog.config.oauth;

import com.itstime.Booklog.config.auth.PrincipalDetail;
import com.itstime.Booklog.model.RoleType;
import com.itstime.Booklog.model.User;
import com.itstime.Booklog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    // private final BCryptPasswordEncoder BCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration = " + userRequest.getClientRegistration());
        System.out.println("getAccessToken = " + userRequest.getAccessToken().getTokenValue());

        OAuth2User oauth2User = super.loadUser(userRequest);
        System.out.println("getAttributes = " + oauth2User.getAttributes());

        // 회원가입을 강제로 진행
        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oauth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String password = new BCryptPasswordEncoder().encode("book");
        String nickname = "nickname" + "_" + providerId;
        String email = oauth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username).orElse(null);

        if (userEntity == null){
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(RoleType.USER)
                    .area("서울")
                    .active(true)
                    .nickname(nickname)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
            System.out.println("구글 로그인이 최초입니다.");
        } else{
            System.out.println("구글 로그인이 이미 되어있습니다.");
        }

        return new PrincipalDetail(userEntity, oauth2User.getAttributes());
    }
}
