package db.concurrency.repository;

import db.concurrency.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Request findByCode(int code);

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends Request> S save(S request);
}
