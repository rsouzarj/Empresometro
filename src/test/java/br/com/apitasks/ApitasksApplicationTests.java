package br.com.apitasks;

import br.com.apitasks.entity.Tasks;
import br.com.apitasks.service.TasksService;
import br.com.apitasks.repository.TasksRepository;
import org.awaitility.Awaitility;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApitasksApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testTasksGetterSetter() {

        Tasks task = new Tasks();

        task.setId(1L);
        task.setNome("Tarefa de Teste");
        task.setTipo("Teste");
        task.setDescricao("Descrição da tarefa de teste");

        Date dataIni = new Date();
        task.setDataini(dataIni);

        assertEquals(1L, task.getId().longValue());
        assertEquals("Tarefa de Teste", task.getNome());
        assertEquals("Teste", task.getTipo());
        assertEquals("Descrição da tarefa de teste", task.getDescricao());
        assertEquals(dataIni, task.getDataini());


    }
	@DataJpaTest
	public class TasksIntegrationTest {

		@Autowired
		private TasksRepository tasksRepository;

		private TasksService tasksService;

		@Before
		public void setUp() {
			tasksService = new TasksService() {
				@Override
				public List<Tasks> buscarTodos() {
					return null;
				}

				@Override
				public Tasks salvar(Tasks tasks) {
					return null;
				}

				@Override
				public void atualizar(Long id) {

				}

				@Override
				public void delete(Long id) {

				}

				@Override
				public void deleteTask(Long id) {

				}
			};
		}

		@After
		public void tearDown() {
			tasksRepository.deleteAll();
		}

		@Test
		public void deletecomAwaitility() {
			Tasks task = new Tasks();
			task.setNome("Tarefa de teste");
			task.setTipo("Teste");
			task.setDescricao("Descrição de teste");
			task.setDataini(new Date());
			task.setDatafim(new Date());
			tasksRepository.save(task);

			// Checa se a tarefa foi incluida corretamente
			assertThat(tasksRepository.findById(task.getId())).isPresent();

			// Inicie a exclusão da tarefa em uma thread separada (com simulação assíncrona)
			new Thread(() -> tasksService.deleteTask(task.getId())).start();

			// Useando a Awaitility para esperar até que a tarefa seja excluída
			Awaitility.await().atMost(5, TimeUnit.SECONDS)
					.until(() -> !tasksRepository.findById(task.getId()).isPresent());

			// Verificando se a tarefa foi excluída corretamente
			assertThat(tasksRepository.findById(task.getId())).isEmpty();
		}
	}

}


