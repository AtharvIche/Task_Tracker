package com.atharv.task_tracker.controller;

import com.atharv.task_tracker.dto.TaskDTO;
import com.atharv.task_tracker.entity.Task;
import com.atharv.task_tracker.service.TaskService;
import com.atharv.task_tracker.service.TaskMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

   @Autowired
    private TaskService taskService;

   @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
       Task createdTask = taskService.createTask(taskDTO);
       TaskDTO responseDTO = TaskMapper.toDTO(createdTask);

       return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

   }

   @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTask(){

       return ResponseEntity.ok(taskService.getAllTasks());
   }

   @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id){
       return taskService.getTaskById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
       return taskService.updateTask(id,taskDTO)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
       return taskService.deleteTask(id)
               ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
