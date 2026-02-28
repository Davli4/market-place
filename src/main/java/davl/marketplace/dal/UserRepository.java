package davl.marketplace.dal;

import davl.marketplace.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository extends BaseRepository<User>{
    private static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (email, password, first_name, last_name, phone, role, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public UserRepository(JdbcTemplate jdbcTemplate, RowMapper<User> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public List<User> findAll() {return findAll(SELECT_ALL_USERS);}

    public Optional<User> findById (int id) {
        return findOne(SELECT_USER_BY_ID, id);
    }

    public User saveUser(User user) {
        int id = insert(INSERT_USER_QUERY,
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getRole() != null ? user.getRole().name() : "CUSTOMER",
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
        user.setId(id);
        return user;
    }
}
