package com.example.tnp_portal.repository;

import com.example.tnp_portal.entity.Admin;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface IAdminRepository extends MongoRepository<Admin, ObjectId> {

    @Query("{username:?0}")
    Optional<Admin> getAdminByUsername(String username);
}
