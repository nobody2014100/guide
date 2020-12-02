package com.klaus.iv.useradmin.repo;

import com.klaus.iv.useradmin.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<User, Long> {



}
