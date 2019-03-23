package restservice.domain.model.todo;

import java.io.Serializable;

public class Finished implements Serializable {

    Boolean value;

    public Finished(Boolean value){
        this.value = value;
    }

    Boolean value(){
        return this.value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
