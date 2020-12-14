package se.kth.sda.ta.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This Interface is a Repository which gets User details from database(User table) and
 * stores updated user details to database(User table) */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
