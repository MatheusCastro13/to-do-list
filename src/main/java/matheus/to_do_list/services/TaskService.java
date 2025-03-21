package matheus.to_do_list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import matheus.to_do_list.model.Task;
import matheus.to_do_list.model.dtos.TaskSave;
import matheus.to_do_list.model.dtos.TaskUpdate;
import matheus.to_do_list.model.enums.Status;
import matheus.to_do_list.repositories.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}

	public void save(TaskSave taskSave) {
		Task task = new Task();
		task.setTask(taskSave.task());
		task.setStatus(Status.TODO);
		taskRepository.save(task);
	}

	@Transactional
	public void concludTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Task não encontrada"));
		
		task.setStatus(Status.CONCLUIDED);
	}

	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Task não encontrada"));
		taskRepository.delete(task);
	}

	@Transactional
	public void pendingTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Task não encontrada"));
		
		task.setStatus(Status.TODO);
		
	}

	@Transactional
	public void update(Long id, TaskUpdate taskUpdate) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Task não encontrada"));
		
		task.setTask(taskUpdate.task());
		
	}
}





