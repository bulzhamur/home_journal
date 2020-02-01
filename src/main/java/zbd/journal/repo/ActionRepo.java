package zbd.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zbd.journal.domain.Action;

public interface ActionRepo extends JpaRepository<Action, Integer> {
}
