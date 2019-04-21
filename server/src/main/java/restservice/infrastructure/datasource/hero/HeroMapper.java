package restservice.infrastructure.datasource.hero;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import restservice.domain.model.hero.Hero;
import restservice.infrastructure.datasource.weight.WeightData;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HeroMapper {

    @Insert("INSERT INTO hero (name) VALUES (#{name});")
    void insert(@Param("name") String name);

    List<Hero> getHeroes();
}
