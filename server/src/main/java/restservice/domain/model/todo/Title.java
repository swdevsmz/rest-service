package restservice.domain.model.todo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Title {

    @NotNull
    @Size(min = 1, max = 30)
    String value = "";

    public Title(){
    }

    public Title(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
