package me.naveenmk.user_test.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    // findByNameContaining
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    public Iterable<User> findByNameContaining(@Param("name") String name);
}
