package system.design.controller;


import com.google.common.base.Stopwatch;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import system.design.utility.aspect.LogExecutionTime;

@RestController
@RequestMapping("/api")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        test();
        return "Hello, World!";
    }

    public  void test() {
        String url = "jdbc:mysql://52.87.234.187:3306/mysql";
        String user = "dheerajr";
        String password = "12345678";

        Stopwatch stopwatch = Stopwatch.createStarted();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        stopwatch.stop();
        logger.info("Task completed in {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
         stopwatch = Stopwatch.createStarted();
        String sql = "SELECT * FROM users";
        System.out.println(jdbcTemplate.queryForList(sql));
        stopwatch.stop();
        logger.info("Task completed in {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        getEvents();
    }

    @LogExecutionTime
    public void getEvents(){
        String sql = "SELECT * FROM users";
        System.out.println(jdbcTemplate.queryForList(sql));
    }
}
