package com.selawasna.repository.database;

import com.selawasna.service.SnakeServiceImpl;
import com.selawasna.utility.ConnectorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LeatherBoard {
    public SnakeServiceImpl service = new SnakeServiceImpl();
    public void result(){
        try (Connection connection = ConnectorUtil.getDataSource().getConnection()){
            String update = """
                    INSERT INTO peringkat (score, playtime) values (?,?)
                    """;
            try (PreparedStatement statement = connection.prepareStatement(update,Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, new SnakeServiceImpl().sizeSnake);
                statement.setString(2, );
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
