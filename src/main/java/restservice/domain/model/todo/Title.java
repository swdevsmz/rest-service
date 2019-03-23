package restservice.domain.model.todo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Title implements Serializable {

    @NotNull
    @Size(min = 1, max = 30)
    String value = "";

    public Title(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
