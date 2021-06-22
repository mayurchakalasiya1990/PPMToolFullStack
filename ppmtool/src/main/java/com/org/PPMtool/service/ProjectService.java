package com.org.PPMtool.service;

import com.org.PPMtool.domain.Project;
import com.org.PPMtool.exception.ProjectIDException;
import com.org.PPMtool.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIDException("Project Id '"+project.getProjectIdentifier()+"' already exist.");
        }
    }

    public Project findProjectByProjectIdentifier(String projectId){
            return projectRepository.findByProjectIdentifier(projectId).orElseThrow(()->{throw new ProjectIDException("Project Id '"+projectId+"' not found");});
    }

    public Iterable<Project> findAllProject(){
        return projectRepository.findAll();
    }

    public void deleteProjectById(String projectId){
        Project project=findProjectByProjectIdentifier(projectId);
        projectRepository.delete(project);
    }

}
