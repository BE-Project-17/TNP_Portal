package com.example.tnp_portal.repository;

import com.example.tnp_portal.entity.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICompanyRepository extends MongoRepository<Company, ObjectId> {
}
