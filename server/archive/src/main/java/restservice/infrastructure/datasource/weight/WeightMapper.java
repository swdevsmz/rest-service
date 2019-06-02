package restservice.infrastructure.datasource.weight;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface WeightMapper {

    @Insert("INSERT INTO weight_history (measured_value, measured_date_time) VALUES (#{measured_value},#{measured_date_time});")
    void insert(@Param("measured_value") double measured_value,
                 @Param("measured_date_time") LocalDateTime localDateTime);

    List<WeightData> selectWeightHistoryData();
}
