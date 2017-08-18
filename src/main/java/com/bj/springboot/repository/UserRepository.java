package com.bj.springboot.repository;

import com.bj.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunboyu on 2017/8/6.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findById(Long id);
    User findByUsernameAndPassword(String userName, String password);
}
