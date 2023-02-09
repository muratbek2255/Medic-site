package com.example.medic_kg.repository.user;

import com.example.medic_kg.entity.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class UserRepositoryTest {

    private final UserRepository underTest;

    @Autowired
    UserRepositoryTest(UserRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    void itShouldCheckFindByEmail(){
        String email = "nameis@gmail.com";
        User user = new User(1, "nameis", email, "https://www.abbreviationfinder.org/blog/wp-content/uploads/Ext3-File-System-1.jpg", "MALE",
                "1980-12-28T07:43:40.500Z", "password", "ROLE_PATIENT", false, false);
        underTest.save(user);

        User findByEmail = underTest.findByEmail(email);
        assertThat(findByEmail).isEqualTo("nameis@gmail.com");
    }
}