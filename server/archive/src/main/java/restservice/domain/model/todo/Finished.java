package restservice.domain.model.todo;

import java.io.Serializable;

public class Finished {

    Boolean value;

    public Finished(){

    }

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
