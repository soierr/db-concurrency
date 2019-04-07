package db.concurrency.service;

import db.concurrency.model.Request;
import db.concurrency.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//here transaction needed for requestFound automatic
//persistance
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private OracleRequestService oracleRequestService;
    public void update(int requestCode) {
        Request requestFound = requestRepository.findByCode(requestCode);
        oracleRequestService.update(1);
        requestFound.setSla(requestFound.getSla()+1);
    }
}
