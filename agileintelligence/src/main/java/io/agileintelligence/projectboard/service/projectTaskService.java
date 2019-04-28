package io.agileintelligence.projectboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.projectboard.domain.projectTask;
import io.agileintelligence.projectboard.repository.projectTaskRepository;

@Service
public class projectTaskService {
@Autowired
private projectTaskRepository projectTaskRepository;

	public projectTask saveorupdateProjectTask(projectTask projecttask) {
		if(projecttask.getStatus()==null||projecttask.getStatus()=="") {
			projecttask.setStatus("TO_DO");
		}
		
		return projectTaskRepository.save(projecttask);
	}

	   public Iterable<projectTask> findAll(){
	        return projectTaskRepository.findAll();
	    }

	    public projectTask findById(Long id){
	        return projectTaskRepository.getById(id);
	    }
}
