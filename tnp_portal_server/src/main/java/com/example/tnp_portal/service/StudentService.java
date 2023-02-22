package com.example.tnp_portal.service;

import com.example.tnp_portal.entity.Job;
import com.example.tnp_portal.entity.Student;
import com.example.tnp_portal.repository.IJobRepository;
import com.example.tnp_portal.repository.IStudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Autowired
    private IJobRepository jobRepository;

    @Override
    public ResponseEntity<?> addStudent(Student student) {
        try{
            Optional<Student> student1 = repository.getStudentByEmail(student.getEmail());
            if(student1.isPresent()){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            repository.save(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllStudents() {
        try{
            List<Student> students = repository.findAll();
            return new ResponseEntity<>(students,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> applyForCompany(ObjectId id, ObjectId job_id) {
        try {
            Optional<Student> student = repository.findById(id);
            Optional<Job> job = jobRepository.findById(job_id);
            if(job.isEmpty() || student.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Job> jobs = student.get().getAppliedJobs();
            if(jobs == null){
                jobs = new ArrayList<>();
            }
            jobs.add(job.get());
            student.get().setAppliedJobs(jobs);
            repository.save(student.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteApplicationForJob(ObjectId id, ObjectId job_id) {
        try {
            Optional<Student> student = repository.findById(id);
            Optional<Job> job = jobRepository.findById(job_id);
            if(job.isEmpty() || student.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Job> jobs = student.get().getAppliedJobs();
            System.out.println(jobs.size());
            jobs.removeIf(job1 -> Objects.equals(job1.getId(), String.valueOf(job_id)));
            System.out.println(jobs.size());
            student.get().setAppliedJobs(jobs);
            repository.save(student.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateStudent(ObjectId id, Map<String,?> request) {
        try {
            Optional<Student> student = repository.findById(id);
            if(student.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if(request.containsKey("name")){
                student.get().setName(request.get("name").toString());
            }
            if(request.containsKey("rollNo")){
                student.get().setRollNo(Long.valueOf(request.get("rollNo").toString()));
            }
            if(request.containsKey("cgpa")){
                student.get().setCgpa(Float.valueOf(request.get("cgpa").toString()));
            }
            if(request.containsKey("ssc")){
                student.get().setSsc(Float.valueOf(request.get("ssc").toString()));
            }
            if(request.containsKey("hsc")){
                student.get().setHsc(Float.valueOf(request.get("hsc").toString()));
            }
            if(request.containsKey("quantitative_score")){
                student.get().setQuantitative_score(Float.valueOf(request.get("quantitative_score").toString()));
            }
            if(request.containsKey("logical_reasoning_score")){
                student.get().setLogical_reasoning_score(Float.valueOf(request.get("logical_reasoning_score").toString()));
            }
            if(request.containsKey("english_prof_score")){
                student.get().setEnglish_prof_score(Float.valueOf(request.get("english_prof_score").toString()));
            }
            if(request.containsKey("automata_pro_score")){
                student.get().setAutomata_pro_score(Float.valueOf(request.get("automata_pro_score").toString()));
            }
            if(request.containsKey("computer_science_score")){
                student.get().setComputer_science_score(Float.valueOf(request.get("computer_science_score").toString()));
            }
            if(request.containsKey("internships")){
                student.get().setInternships(Integer.valueOf(request.get("internships").toString()));
            }
            if(request.containsKey("backlogs")){
                student.get().setBacklogs(Integer.valueOf(request.get("backlogs").toString()));
            }
            if(request.containsKey("projects")){
                student.get().setProjects(Integer.valueOf(request.get("projects").toString()));
            }
            if(request.containsKey("placed")){
                student.get().setPlaced(Boolean.valueOf(request.get("placed").toString()));
            }
            repository.save(student.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllPlacedStudents() {
        try{
            Optional<List<Student>> students = repository.findPlacedStudents(true);
            return new ResponseEntity<>(students,HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> login(Map<String, ?> request) {
        try {
            if(!request.containsKey("email") || !request.containsKey("password")){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            String email = request.get("email").toString();
            String password = request.get("password").toString();

            Optional<Student> student = repository.getStudentByEmail(email);
            if(student.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if(!student.get().getPassword().equals(password)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(student,HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAppliedStudents(String id) {
        try{
            List<Student> students = repository.findAll();
            List<Student> appliedStudents = new ArrayList<>();
            for (Student student : students) {
                if(student.getAppliedJobs() == null){
                    continue;
                }
                for(Job job: student.getAppliedJobs()){
                    if(job.getId().equals(id)){
                        appliedStudents.add(student);
                        break;
                    }
                }
            }
            return new ResponseEntity<>(appliedStudents,HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
