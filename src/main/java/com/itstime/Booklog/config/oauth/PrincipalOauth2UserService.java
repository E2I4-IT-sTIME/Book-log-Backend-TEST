package com.itstime.Booklog.config.oauth;

import com.itstime.Booklog.config.auth.PrincipalDetails;
import com.itstime.Booklog.config.provider.GoogleUserInfo;
import com.itstime.Booklog.config.provider.NaverUserInfo;
import com.itstime.Booklog.config.provider.OAuth2UserInfo;
import com.itstime.Booklog.model.RoleType;
import com.itstime.Booklog.model.User;
import com.itstime.Booklog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;


// 일반로그인 vs 소셜로그인 사용자 구분 -> provider 유무로 구분

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    //private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration = " + userRequest.getClientRegistration());
        System.out.println("getAccessToken = " + userRequest.getAccessToken().getTokenValue());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("getAttributes = " + oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
            System.out.println("카카오 로그인 요청");
            oAuth2UserInfo = null;
        } else {
            System.out.println("우리는 구글, 네이버, 카카오톡 지원해요~!");
        }

//        String provider = userRequest.getClientRegistration().getRegistrationId(); // google
//        String providerId = oAuth2User.getAttribute("sub"); // 100704336381471839854
//        String username = provider + "_" + providerId; // username = google_100704336381471839854
//        String password = new BCryptPasswordEncoder().encode("book");
//        String email = oAuth2User.getAttribute("email");
//        String role = "ROLE_USER";

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId;
        String password = new BCryptPasswordEncoder().encode("book");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        // 임시로 강의 따라 User에 생성자 만들어서 회원가입
        String nickname = "nickname" + "_" + providerId;
        // 추후 User에 생성자 지우고, 추가정보 입력받아서 JoinDto 써야 할 듯
        User userEntity = userRepository.findByUsername(username).orElse(null);

        if (userEntity == null) {
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .email(email)
                    .provider(provider)
                    .providerId(providerId)
                    .birthday(null)
                    .area("서울")
                    .role(RoleType.USER)
                    .build();
            userRepository.save(userEntity);
            System.out.println("소셜로그인이 최초입니다.");
        } else {
            System.out.println("소셜로그인이 이미 되어있어 자동 로그인 됩니다.");

        }



        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }

    // 사용자의 이름이나 프로필 사진 변경 시 User Entity에 반영하는 update 기능

}
