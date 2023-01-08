package org.zubarev.java_vue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zubarev.java_vue.domain.User;

public interface UserDetailsRepository extends JpaRepository<User,String> {
}
