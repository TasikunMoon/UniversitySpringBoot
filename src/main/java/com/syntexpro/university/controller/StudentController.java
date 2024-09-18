package com.syntexpro.university.controller;

import com.syntexpro.university.repository.StudentRepository;
import com.syntexpro.university.entity.Student;
import com.syntexpro.university.response.Response;
import com.syntexpro.university.service.StudentService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.syntexpro.university.utils.ResponseConstants.*;

@RequestMapping(path = "/api/v1/university")
@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    public ResponseEntity<Response> student(
            @RequestHeader(value = AUTHORIZATION)
            @Parameter(description = "Oath bearer token will be sent", required = true)
            @NotBlank
            @Size(max = 500) final String authorization,

            @RequestHeader(value = TRACE_ID)
            @NotBlank
            @Size(max = 500) final String trace_id,


            @RequestHeader(value = CHANNEL_TYPE)
            @NotBlank
            @Size(max = 500) final String channel_type,

            @RequestHeader(value = SESSION_ID)
            @NotBlank
            @Size(max = 500) final String session_id

    ) {
        return (ResponseEntity<Response>) ResponseEntity.ok();
    }


    @GetMapping("/findAll")   //for showing data
    List<Student> getStudents() {
        return studentRepository.findAll();
    }


//    @GetMapping(path = "{id}")
//    Student getSingleStudent(@PathVariable("id")Long id){
//        return studentRepository.findAll()
//                .stream()
//                .filter(student-> student.getId().equals(id))
//                .findFirst()
//                .orElseThrow()
//
//
//    }

    @PostMapping("/newRegistration")  //for adding data
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
        studentService.addNewStudent(student);
    }

//
//    @PostMapping(path="/login")
//    public ResponseEntity<Student> loginUser(@RequestBody Student student) {
//        //your imp
//        return null;
//    }


    @PutMapping("/update/{id}")  //for change or updating data
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(id, firstName, lastName, email);
    }

    @DeleteMapping ("delete/{id}")   //for deleting data
public void deleteStudent(@PathVariable("id") Long id){
studentService.deleteStudent(id);
    }
}
