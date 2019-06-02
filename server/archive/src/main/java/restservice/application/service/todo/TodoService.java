package restservice.application.service.todo;

import org.springframework.stereotype.Service;
import restservice.domain.model.todo.Todo;
import java.util.List;

@Service
public interface TodoService {

    List<Todo> findAll();

}
