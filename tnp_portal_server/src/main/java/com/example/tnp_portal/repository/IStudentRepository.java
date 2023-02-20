package com.example.tnp_portal.repository;

import com.example.tnp_portal.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends MongoRepository<Student, ObjectId> {
    @Query("{isPlaced:?0}")
    Optional<List<Student>> findPlacedStudents(boolean isPlaced);

    @Query("{email:?0}")
    Optional<Student> getStudentByEmail(String email);

}
