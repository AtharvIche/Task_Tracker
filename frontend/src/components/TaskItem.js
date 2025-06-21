import React from 'react';

function TaskItem({ task, onToggle, onDelete }) {
  // --- Use fields from your TaskDTO (id, title, description, completed, priority) ---
  const handleToggle = () => {
    onToggle(task.id); // Pass the ID to the handler
  };

  const handleDelete = () => {
    onDelete(task.id); // Pass the ID to the handler
  };

  return (
    // Add classes for styling based on completion and priority
    <li className={`task-item ${task.completed ? 'completed' : ''} priority-${task.priority?.toLowerCase()}`}>
      <div className="task-details">
         {/* Make title clickable to toggle completion */}
        <span
          className="task-title"
          onClick={handleToggle}
          style={{ textDecoration: task.completed ? 'line-through' : 'none', cursor: 'pointer' }}
        >
          {task.title}
        </span>
        {/* Display description if it exists */}
        {task.description && <p className="task-description">{task.description}</p>}
         {/* Display priority */}
         <span className="task-priority">Priority: {task.priority}</span>
      </div>

      <div className="task-actions">
        <button onClick={handleToggle} className="toggle-button">
            {task.completed ? 'Undo' : 'Complete'}
         </button>
        <button onClick={handleDelete} className="delete-button">
          Delete
        </button>
      </div>
    </li>
  );
  // ----------------------------------------------------------------------------------
}

export default TaskItem;