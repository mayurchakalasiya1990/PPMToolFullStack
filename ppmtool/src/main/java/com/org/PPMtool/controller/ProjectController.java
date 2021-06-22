package com.org.PPMtool.controller;

import com.org.PPMtool.domain.Project;
import com.org.PPMtool.service.ProjectService;
import com.org.PPMtool.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project/")
@AllArgsConstructor
@CrossOrigin
public class ProjectController {

    private final ProjectService projectService;

    private final ValidationService validationService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> resultMap=validationService.mapValidation(result);
        if (resultMap!=null) return resultMap;
        return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project),HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findProjectByProjectId(@PathVariable String projectId){
        Project project= projectService.findProjectByProjectIdentifier(projectId);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProject(){
        return new ResponseEntity<>(projectService.findAllProject(),HttpStatus.OK);
    }

}
