package com.example.tnp_portal.repository;

import com.example.tnp_portal.entity.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IJobRepository extends MongoRepository<Job, ObjectId> {
    @Query("{company:?0}")
    Optional<List<Job>> getJobForCompany(ObjectId company_id);
}
