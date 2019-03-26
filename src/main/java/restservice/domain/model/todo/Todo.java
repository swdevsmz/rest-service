package restservice.domain.model.todo;

import java.io.Serializable;

public class Todo {

    private Identifier identifier;

    private Title title;

    private Finished finished;

    public Todo(){
        identifier = new Identifier();
        title = new Title();
        finished = new Finished();
    }

    public Todo(Identifier identifier,Title title,Finished finished){
        this.identifier = identifier;
        this.title = title;
        this.finished = finished;
    }

    public Identifier identifier(){
        return identifier;
    }

    public Title title(){
        return title;
    }

    public Finished finished(){
        return finished;
    }

    @Override
    public String toString(){
        return "Todo{" +
                "identifier=" + identifier +
                ", title=" + title +
                ", finished=" + finished +
                '}';
    }

}
