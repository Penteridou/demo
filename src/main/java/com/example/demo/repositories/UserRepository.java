package com.example.demo.repositories;

import com.example.demo.model.User;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends Neo4jRepository<User, Integer> {
   @Query("MATCH (n:User) RETURN n LIMIT 25")
   Collection<User> getAllUsers();

   @Query("LOAD CSV WITH HEADERS FROM \"file:///users.csv\" AS Line\n" +
           "CREATE p = (:User {name:Line.name, id:toInteger(Line.userId)})-[:RecordedBy]->(:Sensor {id: Line.sensorId, model: Line.sensorModel})\n" +
           "RETURN p\n")
   Collection<User> importData();

   @Query("MATCH (n)\n" +
           "DETACH DELETE n")
   Collection<User> clearData();


}
