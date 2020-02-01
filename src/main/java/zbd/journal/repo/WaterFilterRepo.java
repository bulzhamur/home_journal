package zbd.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zbd.journal.domain.WaterFilter;

public interface WaterFilterRepo extends JpaRepository<WaterFilter, Integer> {
}
