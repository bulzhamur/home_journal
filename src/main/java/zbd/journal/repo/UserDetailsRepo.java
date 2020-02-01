package zbd.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zbd.journal.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
