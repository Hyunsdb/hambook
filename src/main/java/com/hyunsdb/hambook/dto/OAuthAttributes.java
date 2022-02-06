package com.hyunsdb.hambook.dto;

import com.hyunsdb.hambook.constant.Role;
import com.hyunsdb.hambook.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;


    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name=name;
        this.email=email;
        this.picture = picture;
    }


    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    /**
     * Oauth2User에서 반환하는 사용자 정본느 Map이라서 값 하나하나 변환해야함
     */
    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    /**
     *UserEntity 생성
     * OAuthAttributes 에서 Entity 생성 시점은 처음 가입할 때임.
     * OAuthAttributes 클래스 생성이 끝났으면, 같은 패키지에 SessionUser 클래스를 생성함.
     */
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER) //가입할 때 기본 권한 USER
                .build();
    }


}
