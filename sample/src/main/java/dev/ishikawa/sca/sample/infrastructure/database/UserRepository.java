package dev.ishikawa.sca.sample.infrastructure.database;

import dev.ishikawa.sca.sample.domains.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    public UserEntity findByUserName(String userName);
}
