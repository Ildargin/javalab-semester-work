package ru.itis.javalab.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

  public static final String SQL_UPDATE_USER = "update users set first_name = ? , last_name = ? , birth_date = ? where id = ?";
  private static final String SQL_SELECT_BY_ID = "select * from users where id = ?";
  private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users order by id limit :limit offset :offset ;";
  private static final String SQL_SELECT_BY_EMAIL = "select * from users where email = ?";
  private static final String SQL_SELECT_ALL = "select * from users";
  private static final String SQL_INSERT_USER = "insert into users(email, password) values (?, ?)";
  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final PasswordEncoder passwordEncoder;
  private final RowMapper<User> userRowMapper = (row, i) -> User.builder()
      .id(row.getLong("id"))
      .firstName(row.getString("first_name"))
      .lastName(row.getString("last_name"))
      .password(row.getString("password"))
      .email(row.getString("email"))
      .birthDate(row.getDate("birth_date"))
      .imagePath(row.getString("image_path"))
      .build();

  @Autowired
  public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
    this.passwordEncoder = new BCryptPasswordEncoder();
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }


  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
  }


  public List<User> findAll(int page, int size) {
    Map<String, Object> params = new HashMap<>();
    params.put("limit", size);
    params.put("offset", page * size);
    return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);
  }


  public Optional<User> findById(Long id) {
    User user;
    try {
      user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
    } catch (EmptyResultDataAccessException e) {
      user = null;
    }
    return Optional.ofNullable(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    User user;
    try {
      user = jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email);
    } catch (EmptyResultDataAccessException e) {
      user = null;
    }
    return Optional.ofNullable(user);
  }

  @Override
  public boolean saveUser(User entity) {
    try {
      jdbcTemplate.update(SQL_INSERT_USER, entity.getEmail(), passwordEncoder.encode(entity.getPassword()));
    } catch (Exception e) {
      return false;
    }
    return true;
  }


  @Override
  public void update(User entity) {
    jdbcTemplate
        .update(SQL_UPDATE_USER, entity.getFirstName(), entity.getLastName(), entity.getBirthDate(), entity.getId());
  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public void save(User entity) {

  }

  @Override
  public void delete(User entity) {

  }
}
