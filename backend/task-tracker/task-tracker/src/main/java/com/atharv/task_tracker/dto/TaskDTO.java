package com.atharv.task_tracker.dto;

import com.atharv.task_tracker.entity.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // ✅ This adds all getters/setters automatically
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;
}
