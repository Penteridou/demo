package com.example.demo.services;

import com.example.demo.repositories.UserRepository;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService() {
    }

    public void importData() {
        userRepository.importData();
    }

    public void clearData() {
        userRepository.clearData();
    }

    public Result getUserTemperature(int userId){
        Map<String,Object> params = new HashMap<>();
        String query = "MATCH (t:Temperature)-[]-(s:Sensor)-[]-(u:User)\n" +
                "where u.id ="+userId+"\n" +
                "return t.level";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }

    public Result getUserHourlyData(int userId) {
        Map<String,Object> params = new HashMap<>();
        String query = "MATCH (temp:Temperature)-[]-(sen:Sensor)-[]-(user:User)\n" +
                "        where  user.id ="+userId+"  and  temp.date=date()\n" +
                "        WITH temp, toFloat(temp.level) AS tempLevelFloat\n" +
                "        RETURN  temp.date as today, temp.time.hour as time, " +
                "        collect(tempLevelFloat)  as temperatures,avg(tempLevelFloat) as AvgTemp," +
                "        min(tempLevelFloat) as minTemp, max(tempLevelFloat) as maxTemp";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }

    public Result getUserDailyData(int userId) {
        Map<String,Object> params = new HashMap<>();
        String query = "MATCH (temp:Temperature)-[]-(sen:Sensor)-[]-(user:User)\n" +
                "        where  user.id ="+userId+" \n" +
                "        WITH temp, toFloat(temp.level) AS tempLevelFloat\n" +
                "        RETURN temp.date as day, collect(tempLevelFloat)  as temperatures , " +
                "        avg(tempLevelFloat) as AvgTemp, min(tempLevelFloat) as minTemp, " +
                "        max(tempLevelFloat) as maxTemp";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }
}
