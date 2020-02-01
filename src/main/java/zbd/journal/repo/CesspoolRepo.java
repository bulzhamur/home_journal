package zbd.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zbd.journal.domain.Cesspool;

public interface CesspoolRepo extends JpaRepository<Cesspool, Integer> {
}
