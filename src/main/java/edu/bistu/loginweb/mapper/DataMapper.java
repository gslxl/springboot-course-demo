package edu.bistu.loginweb.mapper;

import edu.bistu.loginweb.domain.CovidData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMapper {

    @Select("select id,prov,date,cumulative,deadth,cure,increase from covid19")
    List<CovidData> selectAll();

    @Select("select count(1) from covid19")
    Integer selectCount();

    @Select("select id,prov,date,cumulative,deadth,cure,increase from covid19 where prov =#{prov} ")
    List<CovidData> queryProv(@Param("prov") String prov);

    @Insert("insert into covid19(prov,date,cumulative,deadth,cure,increase)  " +
            "VALUES(#{prov},#{date},#{cumulative},#{deadth},#{cure},#{increase})")
    int InsertOne(@Param("prov")String prov,
                  @Param("date")String date,
                  @Param("cumulative")Integer cumulative,
                  @Param("deadth")Integer deadth,
                  @Param("cure")Integer cure,
                  @Param("increase")Integer increase);

    @Update("update covid19 set prov=#{prov},date=#{date},cumulative=#{cumulative}," +
            "deadth=#{deadth},cure=#{cure},increase=#{increase} where prov=#{prov} and date=#{date}")
    int alter(
              @Param("prov")String prov,
              @Param("date")String date,
              @Param("cumulative")Integer cumulative,
              @Param("deadth")Integer deadth,
              @Param("cure")Integer cure,
              @Param("increase")Integer increase);
}
