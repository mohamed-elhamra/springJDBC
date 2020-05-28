package com.melhamra.dao;

import com.melhamra.model.Cercle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public int getCercleCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM cercle", Integer.class);
    }

    public String getCercleName(int cercleId){
        return jdbcTemplate.queryForObject(
                "SELECT name FROM cercle WHERE id = ?", new  Object[] {cercleId}, String.class);
    }

    public Cercle getCercleForId(int cercleId){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM cercle WHERE id = ?", new  Object[] {cercleId}, new CercleMapper());
    }

    public List<Cercle> getAllCercles(){
        return jdbcTemplate.query(
                "SELECT * FROM cercle", new CercleMapper());
    }

    public void insertCercle(@NonNull Cercle cercle){
        jdbcTemplate.update(
                "INSERT INTO cercle(id,name) VALUES(?,?)", new Object[] {cercle.getId(), cercle.getName()});
    }


    public static final class CercleMapper implements RowMapper<Cercle>{

        @Override
        public Cercle mapRow(ResultSet resultSet, int index) throws SQLException {
            Cercle cercle = new Cercle();
            cercle.setId(resultSet.getInt("id"));
            cercle.setName(resultSet.getString("name"));
            return cercle;
        }
    }
}
