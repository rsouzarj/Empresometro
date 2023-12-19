package br.com.apitasks.service;

import br.com.apitasks.entity.Tasks;
import br.com.apitasks.repository.TasksRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    public TasksServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public List<Tasks> buscarTodos() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks salvar(Tasks tasks) {
        return tasksRepository.save(tasks);
    }

    @Override
    public void atualizar(Long id) {
        try {
            tasksRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível excluir o registro");
        }
    }
    @Override
    public void delete(Long id) {
        try {
            tasksRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível excluir o registro");
        }
    }

    @Override
    public void deleteTask(Long id) {

    }

}