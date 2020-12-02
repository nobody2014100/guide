package com.klaus.iv.useradmin.repo;

import com.klaus.iv.useradmin.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleResourceRepo extends JpaRepository<User, Long> {



}
