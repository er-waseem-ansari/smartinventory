package com.smartinventory.smartinventory.repository;

import com.smartinventory.smartinventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);


    @Query( value="SELECT * FROM users WHERE email= :email AND password= :password", nativeQuery = true)
    List<User> findByEmailAndPassword(String email, String password);

    @Query( value="SELECT * FROM users WHERE email= :email", nativeQuery = true)
    List<User> findByEmail(String email);

}
