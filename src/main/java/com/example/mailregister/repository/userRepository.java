package com.example.mailregister.repository;


import com.example.mailregister.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User2,Integer> {
}
