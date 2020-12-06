package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.Post;

import javax.sql.DataSource;
import java.util.List;

public class PostsRepositoryJdbcTemplateImpl implements PostsRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_INSERT_POST= "insert into posts(user_id, post_title, post_text) values (?, ?, ?)";


    private final RowMapper<Post> PostRowMapper = (row, i) -> Post.builder()
            .id(row.getLong("id"))
            .userId(row.getLong("user_id"))
            .title(row.getString("post_title"))
            .text(row.getString("post_text"))
            .likes(row.getInt("likes"))
            .dislikes(row.getInt("dislikes"))
            .build();


    public PostsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void save(Post entity) {
        jdbcTemplate.update(SQL_INSERT_POST, entity.getUserId(), entity.getTitle(), entity.getText());
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Post entity) {

    }


}
