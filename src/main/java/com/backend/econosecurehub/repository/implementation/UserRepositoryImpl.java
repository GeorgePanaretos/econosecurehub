package com.backend.econosecurehub.repository.implementation;

import com.backend.econosecurehub.domain.Role;
import com.backend.econosecurehub.domain.User;
import com.backend.econosecurehub.exception.ApiException;
import com.backend.econosecurehub.repository.RoleRepository;
import com.backend.econosecurehub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static com.backend.econosecurehub.enumeration.RoleType.ROLE_USER;
import static com.backend.econosecurehub.query.UserQuery.COUNT_USER_EMAIL_QUERY;
import static com.backend.econosecurehub.query.UserQuery.INSERT_USER_QUERY;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
//    private static final String COUNT_USER_EMAIL_QUERY = "";
//    private static final String INSERT__USER_QUERY = "";
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;

    @Override
    public User create(User user) {
        // Check Email is unique
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("Email already in use. Please use a different email and try again.");
        // Save new User
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
        }
        catch (EmptyResultDataAccessException exception){

        }
        catch (Exception exception){

        }

        return null;
    }

    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
    }
}
