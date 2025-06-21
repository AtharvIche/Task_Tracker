package com.atharv.task_tracker.service;

import com.atharv.task_tracker.dto.TaskDTO;
import com.atharv.task_tracker.entity.Task;
import com.atharv.task_tracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        return taskRepository.save(task);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();

        for (int i = 0; i < tasks.size(); i++) {
            TaskDTO dto = TaskMapper.toDTO(tasks.get(i));
            taskDTOs.add(dto);
        }

        return taskDTOs;
    }

    public Optional<TaskDTO> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            TaskDTO dto = TaskMapper.toDTO(task);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    public Optional<TaskDTO> updateTask(Long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setCompleted(taskDTO.isCompleted());
            task.setPriority(taskDTO.getPriority());

            Task updatedTask = taskRepository.save(task);
            TaskDTO dto = TaskMapper.toDTO(updatedTask);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
