package com.application.TestJavaApplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.TestJavaApplication.models.ProductModel;
import com.application.TestJavaApplication.models.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	Optional<UserModel> findUserByName(String name);
}
