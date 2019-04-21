package restservice.infrastructure.datasource.event;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EventMapper {
    @Select("SELECT * FROM time_event ORDER BY id")
    List<EventData> select();

    @Insert("INSERT INTO time_event (event_date_time) VALUES (#{datetime});")
    void insert(@Param("datetime") LocalDateTime localDateTime);

    List<EventData> selectEventData();
}
