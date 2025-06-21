import React from 'react';
import TaskItem from './TaskItem';

function TaskList({ tasks, onToggle, onDelete }) {
  if (!tasks || tasks.length === 0) {
    return <p>No tasks yet! Add one using the form above.</p>;
  }

  return (
    <ul className="task-list">
      {/* Map over tasks and render TaskItem for each */}
      {/* Use task.id as the key (requires backend fix!) */}
      {tasks.map((task) => (
        <TaskItem
          key={task.id} // Use the unique ID from the backend
          task={task}   // Pass the whole task object
          onToggle={onToggle}
          onDelete={onDelete}
        />
      ))}
    </ul>
  );
}

export default TaskList;