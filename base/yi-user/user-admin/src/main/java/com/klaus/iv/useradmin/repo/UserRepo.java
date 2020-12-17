package com.klaus.iv.useradmin.repo;

import com.klaus.iv.commonjpa.repo.BaseRepo;
import com.klaus.iv.useradmin.po.User;

import java.util.Optional;

public interface UserRepo extends BaseRepo<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByMobile( String mobile);

    Optional<User> findByOpenID(String openID);


}
