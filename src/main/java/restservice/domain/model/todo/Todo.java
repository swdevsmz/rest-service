package restservice.domain.model.todo;

import java.io.Serializable;

public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Identifier identifier;
    private String title;
    private Boolean finished;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    //    private Identifier identifier;
//
//    private Title title;
//
//    private Finished finished;
//
//    public Todo(){
//    }
//
//    public Todo(Identifier identifier,
//                Title title,
//                Finished finished){
//        this.identifier = identifier;
//        this.title = title;
//        this.finished = finished;
//    }
//
//    public Identifier getIdentifier() {
//        return identifier;
//    }
//
//    public void setIdentifier(Identifier identifier) {
//        this.identifier = identifier;
//    }
//
//    public Title getTitle() {
//        return title;
//    }
//
//    public void setTitle(Title title) {
//        this.title = title;
//    }
//
//    public Finished getFinished() {
//        return finished;
//    }
//
//    public void setFinished(Finished finished) {
//        this.finished = finished;
//    }



}
