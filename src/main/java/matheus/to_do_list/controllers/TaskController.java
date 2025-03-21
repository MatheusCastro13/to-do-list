package matheus.to_do_list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import matheus.to_do_list.model.Task;
import matheus.to_do_list.model.dtos.TaskSave;
import matheus.to_do_list.model.dtos.TaskUpdate;
import matheus.to_do_list.model.enums.Status;
import matheus.to_do_list.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	
	private final TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public String allTasks(Model model) {
		List<Task> allTasks = taskService.findAll();
		
		List<Task> tasksToDo = allTasks.stream()
				.filter(task -> task.getStatus().equals(Status.TODO))
				.toList()
				.stream()
				.sorted((t1, t2) -> t1.getId().compareTo(t2.getId()))
				.toList();
		
		List<Task> tasksConcluid = allTasks.stream()
				.filter(task -> task.getStatus().equals(Status.CONCLUIDED))
				.toList()
				.stream()
				.sorted((t1, t2) -> t1.getId().compareTo(t2.getId()))
				.toList();
		
		model.addAttribute("tasksToDo", tasksToDo);
		model.addAttribute("tasksConcluid", tasksConcluid);
		
		return "tasks";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute TaskSave task, Model model) {
		taskService.save(task);
		return "redirect:/tasks";
	}
	
	@PostMapping("/conclud/{id}")
	public String conclud(@PathVariable Long id) {
		taskService.concludTask(id);
		return "redirect:/tasks";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/tasks";
	}
	
	@PostMapping("/pending/{id}")
	public String pending(@PathVariable Long id) {
		taskService.pendingTask(id);
		return "redirect:/tasks";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @RequestBody TaskUpdate taskUpdate) {
		taskService.update(id, taskUpdate);
		return "redirect:/tasks";
	}
	
}











