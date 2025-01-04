package com.grinder;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
public class JasyptTest {

    @BeforeAll
    static void setUp() {
        System.setProperty("jasypt.encryptor.password", "grinder123");
    }

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Test
    void encryptTest() {

        String key = System.getProperty("jasypt.encryptor.password");
        System.out.println("============= 암호화 테스트 =============");
        System.out.println("암호화 키: " + key);

        // 암호화 할 데이터들
        // 필요 시 여기에 형식에 맞춰 추가 후 적용
        String url = "jdbc url";
        String username = "유저명";
        String password = "패스워드";
        String driver = "드라이버 클래스 명";
        String clientId = "클라이언트 아이디";
        String clientSecret = "클라이언트 시크릿 아이디";
        String redirectUri = "URI";
        String authorizationUri = "URI";
        String tokenUri = "URI";
        String userInfoUri = "URI";

        // 암호화 결과값
        System.out.println("============= 암호화 값 =============");
//        System.out.println("url=" + jasyptStringEncryptor.encrypt(url) );
//        System.out.println("username=" + jasyptStringEncryptor.encrypt(username));
//        System.out.println("password=" + jasyptStringEncryptor.encrypt(password));
//        System.out.println("driver-class-name=" + jasyptStringEncryptor.encrypt(driver));


        // 테스트를 위한 검증
        String encryptedText = jasyptStringEncryptor.encrypt("test");
        String decryptedText = jasyptStringEncryptor.decrypt(encryptedText);
        assertThat(decryptedText).isEqualTo("test");
    }
}