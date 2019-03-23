package restservice.presentation.controller.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import restservice.application.service.todo.TodoService;
import restservice.domain.model.todo.Todo;

import java.util.List;

@RestController
@RequestMapping("todoList")
public class TodoController {

    TodoService todoService;

    ObjectMapper objectMapper;

    public TodoController(TodoService todoService,
                          ObjectMapper objectMapper){
        this.todoService = todoService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodoList(){
        return todoService.findAll();
    }
}
