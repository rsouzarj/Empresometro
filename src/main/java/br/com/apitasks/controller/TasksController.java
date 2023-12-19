package br.com.apitasks.controller;

import br.com.apitasks.entity.Tasks;
import br.com.apitasks.service.TasksServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/task")

public class TasksController {

    private final TasksServiceImpl tasksService;


    public TasksController(TasksServiceImpl tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> buscarTodos() {
        return ResponseEntity.ok(tasksService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Tasks> salvar(@RequestBody Tasks tasks) {
        var novaTask = tasksService.salvar(tasks);
        return new ResponseEntity<>(novaTask, null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualiza(@PathVariable Long id, @RequestBody Tasks tasks) {
        tasks.setId(id);
        this.tasksService.salvar(tasks);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tasksService.delete(id);
        return ResponseEntity.ok().build();
    }
}

