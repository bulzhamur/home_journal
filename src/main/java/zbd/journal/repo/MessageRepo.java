package zbd.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zbd.journal.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
