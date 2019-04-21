package restservice.infrastructure.datasource.todo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import restservice.domain.model.todo.Todo;

import java.util.List;

@Mapper
public interface TodoMapper {

    void insert(@Param("Todo") Todo todo);

    void updateFinished(@Param("identifier") Integer identifier, @Param("finished") Boolean finished);

    Todo selectByIdentifier(@Param("identifier") Integer identifier);

}
