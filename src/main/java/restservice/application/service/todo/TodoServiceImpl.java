package restservice.application.service.todo;

import org.springframework.stereotype.Service;
import restservice.domain.model.todo.Finished;
import restservice.domain.model.todo.Identifier;
import restservice.domain.model.todo.Title;
import restservice.domain.model.todo.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Override
    public List<Todo> findAll() {
        Todo todo = new Todo(
                    new Identifier(1),
                    new Title("TODOです"),
                    new Finished(false));

        return new ArrayList<Todo>(Arrays.asList(todo));
    }
}
