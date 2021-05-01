package com.saradha.multipledatasource.repository.user;

import com.saradha.multipledatasource.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiory extends JpaRepository<User, Long> {

}
