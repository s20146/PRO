package com.emontazysta.repository;

import com.emontazysta.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    public AppUser findByUsername(String username);

}
