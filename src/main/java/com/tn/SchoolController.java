package com.tn;

import com.tn.entity.School;
import com.tn.repository.SchoolRepository;
import com.tn.req.SchoolReq;
import com.tn.req.SchoolUpdateReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepo;

    @GetMapping("show")
    public ResponseEntity<?> show() {
        List<School> schools = schoolRepo.findAll();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody SchoolReq schoolReq) {
        School school = new School();
        school.setSchoolName(schoolReq.getSchoolName());
        school.setAddress(schoolReq.getAddress());
        schoolRepo.save(school);
        return new ResponseEntity<>("Create successfully: " + school, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody SchoolUpdateReq schoolUpdateReq,
                                    @PathVariable Integer id) {
        School school = schoolRepo.findById(id).orElse(null);

        if (school != null) {
            school.setSchoolName(schoolUpdateReq.getSchoolName());
            school.setAddress(schoolUpdateReq.getAddress());
            schoolRepo.save(school);
            return new ResponseEntity<>("Update success " + school, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found school with id: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id) {
        schoolRepo.deleteById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
