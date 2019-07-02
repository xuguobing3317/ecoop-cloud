package com.ecoop.repository.user;

import com.ecoop.entity.user.RoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RoleUserRepository
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 19:39
 * @Version 1.0
 **/
public interface RoleUserRepository extends JpaRepository<RoleUserEntity, Long> {


    long countByUserId(Long userId);
}
