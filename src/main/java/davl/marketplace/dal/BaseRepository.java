package davl.marketplace.dal;

import davl.marketplace.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseRepository<T>{
    protected final JdbcTemplate jdbcTemplate;
    protected final RowMapper<T> rowMapper;

    public Optional<T> findOne(String query, Object... args) {
        try {
            T res = jdbcTemplate.queryForObject(query, rowMapper, args);
            return Optional.ofNullable(res);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    protected List<T> findAll(String query, Object... args) {return jdbcTemplate.query(query, rowMapper, args);}

    protected void update(String query, Object... args) {
        int updateCount = jdbcTemplate.update(query, args);
        if (updateCount == 0) {
            throw new InternalServerException("No records found for query: " + query);
        }
    }

    protected Integer insert(String query, Object... args) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con ->  {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        return ps;}, keyHolder);

        return keyHolder.getKey().intValue();
    }

    protected boolean delete(String query, Object... args) {
        int  deleteCount = jdbcTemplate.update(query, args);
        return deleteCount > 0;
    }
}
