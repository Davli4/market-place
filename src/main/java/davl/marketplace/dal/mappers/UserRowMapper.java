package davl.marketplace.dal.mappers;

import davl.marketplace.model.Role;
import davl.marketplace.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setPhone(resultSet.getString("phone"));

        Timestamp createdAt = resultSet.getTimestamp("created_at");
        Timestamp updatedAt = resultSet.getTimestamp("updated_at");

        user.setCreatedAt(createdAt.toLocalDateTime());
        user.setUpdatedAt(updatedAt.toLocalDateTime());

        String role = resultSet.getString("role");
        if(role != null) {
            try {
                user.setRole(Role.valueOf(role));
            } catch (IllegalArgumentException e) {
                user.setRole(Role.CUSTOMER);
            }
        }

        user.setOrders(new ArrayList<>());
        user.setProducts(new ArrayList<>());
        return  user;
    }
}
