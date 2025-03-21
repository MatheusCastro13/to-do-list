async function concludTask(button){
	const taskId = button.getAttribute('data-task-id');
	const url = `/tasks/conclud/${taskId}`;
	const response = await fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(taskId)
	});
	
	if(!response.ok){
		alert("Não foi possível concluir atividade");
		throw new Error("Não foi possível concluir a atividade");
	}
	
	window.location.href = "/tasks";
}

async function deleteTask(button){
	const taskId = button.getAttribute('data-task-id');
	const url = `/tasks/delete/${taskId}`;
	const response = await fetch(url, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(taskId)
		});
		
		if(!response.ok){
			alert("Não foi possível excluir atividade");
			throw new Error("Não foi possível excluir a atividade");
		}
		window.location.href = "/tasks";
}

async function pendingTask(button){
	const taskId = button.getAttribute('data-task-id');
	const url = `/tasks/pending/${taskId}`;
	const response = await fetch(url, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(taskId)
		});
		
		if(!response.ok){
			alert("Não foi possível pender atividade");
			throw new Error("Não foi possível pender a atividade");
		}
		window.location.href = "/tasks";
}


async function openEditTaskModal(button){
	const taskId = button.getAttribute('data-task-id');
	
	const taskValue = document.querySelector(`#itemId${taskId} p`).textContent;
	
	const editModal = new bootstrap.Modal(document.getElementById('editTaskModal'));
	editModal.show();
	
	const editTaskInput = document.getElementById('editTaskInput');
	editTaskInput.value = taskValue;
	
	const saveEditButton = document.getElementById('saveEditButton');
	saveEditButton.setAttribute("data-task-id", taskId);
	
}


async function editTask(button){
	const taskId = button.getAttribute('data-task-id');
	const url = `/tasks/update/${taskId}`;
	
	const editTaskInput = document.getElementById('editTaskInput');
	const task = editTaskInput.value;
	
	const response = await fetch(url, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({task : task})
		});
		
		if(!response.ok){
			alert("Não foi possível editar atividade");
			throw new Error("Não foi possível editar a atividade");
		}
		window.location.href = "/tasks";
}




