package com.cotato.when2meet.promise.config.auth;

import com.cotato.when2meet.promise.model.googleuser.Googlelogin;
import com.cotato.when2meet.promise.repository.GoogleuserRepository;
import com.cotato.when2meet.promise.web.dto.OAuthAttributes;
import com.cotato.when2meet.promise.web.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2GoogleloginService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final GoogleuserRepository googleuserRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        //어떤 서비스에서 로그인하는지 확인
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // 로그인시 키가 되는 필드값
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Googlelogin googlelogin = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(googlelogin));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(googlelogin.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    private Googlelogin saveOrUpdate(OAuthAttributes attributes) {
        Googlelogin googlelogin = googleuserRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return googleuserRepository.save(googlelogin);
    }
}