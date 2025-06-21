import React, { useState } from 'react';

function AddTaskForm({ onAddTask }) {
  // State for each input field
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [priority, setPriority] = useState('MEDIUM'); // Default priority

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent page reload
    if (!title.trim()) {
        alert("Please enter a task title."); // Simple validation
        return;
    };
    // Call the handler passed from App.js with all values
    onAddTask(title, description, priority);
    // Clear the form fields
    setTitle('');
    setDescription('');
    setPriority('MEDIUM'); // Reset priority to default
  };

  return (
    <form onSubmit={handleSubmit} className="add-task-form">
      <div className="form-control">
        <label htmlFor="task-title">Title:</label>
        <input
          id="task-title"
          type="text"
          placeholder="Task title (required)"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </div>
      <div className="form-control">
        <label htmlFor="task-description">Description:</label>
        <input
          id="task-description"
          type="text"
          placeholder="Task description (optional)"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </div>
      <div className="form-control">
         <label htmlFor="task-priority">Priority:</label>
         <select
            id="task-priority"
            value={priority}
            onChange={(e) => setPriority(e.target.value)}
         >
            {/* Matches your Priority enum */}
            <option value="HIGH">High</option>
            <option value="MEDIUM">Medium</option>
            <option value="LOW">Low</option>
         </select>
      </div>
      <button type="submit">Add Task</button>
    </form>
  );
}

export default AddTaskForm;