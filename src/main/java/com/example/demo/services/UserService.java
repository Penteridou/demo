package com.example.demo.services;
import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        String query = "MATCH (t:Temperature)-[]-(s:Sensor)-[]-(u:User)\n" +
                "        where  u.id ="+userId+" and  t.date=date()\n" +
                "        RETURN  t.date as today, t.time.hour as time, collect(t.level)  as temperatures";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }

    public Result getUserDailyData(int userId) {
        Map<String,Object> params = new HashMap<>();
        String query = "MATCH (t:Temperature)-[]-(s:Sensor)-[]-(u:User)\n" +
                "        where u.id ="+userId+" \n" +
                "        RETURN t.date, collect(t.level)\n";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }
}
