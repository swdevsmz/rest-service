package restservice.presentation.controller.event;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.infrastructure.datasource.event.EventData;
import restservice.infrastructure.datasource.event.EventMapper;

import java.util.List;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EventController {

    EventMapper eventMapper;

    EventController(EventMapper eventMapper){
        this.eventMapper = eventMapper;
    }

    @RequestMapping(value = "/event/hello",method = RequestMethod.GET)
    public Map hello(){
        Map<String, Object> response = new HashMap<>();
        response.put("response","hello");
        return response;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map list() {
        Map<String, Object> res = new HashMap<>();
        res.put("response", eventMapper.select().stream().map(v -> v.event_date_time).collect(Collectors.toList()));
        return res;
    }

    @RequestMapping(value = "/xmllist", method = RequestMethod.GET)
    public Map xmllist() {
        Map<String, Object> res = new HashMap<>();
        res.put("response", eventMapper.selectEventData().stream().map(v -> v.event_date_time).collect(Collectors.toList()));
        return res;
    }

    @RequestMapping(value = "/jsonlist", method = RequestMethod.GET)
    @ResponseBody
    public List<EventData> jsonlist() {
        return eventMapper.selectEventData();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Map insert() {
        eventMapper.insert(LocalDateTime.now());

        // 返却値
        List l = eventMapper.select();
        Map<String, Object> res = new HashMap<>();
        res.put("response", l.get(l.size() - 1));
        return res;

    }
}
