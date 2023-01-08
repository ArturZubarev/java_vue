package org.zubarev.java_vue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zubarev.java_vue.domain.Message;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
