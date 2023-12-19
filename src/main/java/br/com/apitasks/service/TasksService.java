package br.com.apitasks.service;

import br.com.apitasks.entity.Tasks;
import java.util.List;

public interface TasksService {
    List<Tasks> buscarTodos();

    Tasks salvar(Tasks tasks);

    void atualizar(Long id);

    void delete(Long id);

    void deleteTask(Long id);
}


