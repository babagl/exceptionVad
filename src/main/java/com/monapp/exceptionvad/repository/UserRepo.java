package com.monapp.exceptionvad.repository;

import com.monapp.exceptionvad.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByUserId(int id);
}
