package io.agileintelligence.projectboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.projectboard.domain.projectTask;
import io.agileintelligence.projectboard.service.projectTaskService;
import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class projectTaskController {

	@Autowired
	private projectTaskService projectTaskService;
	
	@PostMapping("")
	public ResponseEntity<?> addPTTOBoard(@Valid @RequestBody projectTask projectask, BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error:result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		projectTask newPT = projectTaskService.saveorupdateProjectTask(projectask);
		return new ResponseEntity<projectTask>(newPT,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<projectTask> getALLPTs(){
		return projectTaskService.findAll();
	}
	
//	@GetMapping("/{pt_id}")
//	public ResponseEntity<?> getptBYID(@PathVariable Long pt_id){
//		projectTask projecttask = projectTaskService.findById(pt_id);
//		return new ResponseEntity<projectTask>(projecttask,HttpStatus.OK);
//	}

	 @GetMapping("/{pt_id}")
	    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
	        projectTask projecttask = projectTaskService.findById(pt_id);
	        return new ResponseEntity<projectTask>(projecttask, HttpStatus.OK);
	    }
	
}
