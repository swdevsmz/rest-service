package restservice.presentation.controller.weight;

import lombok.experimental.var;
import org.springframework.web.bind.annotation.*;
import restservice.infrastructure.datasource.event.EventData;
import restservice.infrastructure.datasource.event.EventMapper;
import restservice.infrastructure.datasource.weight.WeightData;
import restservice.infrastructure.datasource.weight.WeightMapper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WeightController {

    WeightMapper weightMapper;

    WeightController(WeightMapper weightMapper){
        this.weightMapper = weightMapper;
    }

    @RequestMapping(value = "/weight/list", method = RequestMethod.GET)
    @ResponseBody
    public List<WeightData> jsonlist() {
        return weightMapper.selectWeightHistoryData();
    }

    @RequestMapping(value = "/weight/insert/{measured_value}", method = RequestMethod.GET)
    @ResponseBody
    public WeightData insert(@PathVariable("measured_value") double measured_value) {
        weightMapper.insert(measured_value,LocalDateTime.now());
        return weightMapper.selectWeightHistoryData().get(0);
    }
}
