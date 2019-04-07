package db.concurrency.service;

import db.concurrency.model.Request;
import db.concurrency.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class OracleRequestService {
    @Autowired
    private RequestRepository requestRepository;

    void update(int id) {
        Request requestFound = requestRepository.findByCode(id);
        requestFound.setName("hi there 4");
        requestRepository.save(requestFound);
    }
}
