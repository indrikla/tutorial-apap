package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {

    @Autowired
    PenjagaDB penjagaDB;
    
    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public void updatePenjaga(PenjagaModel penjaga) { penjagaDB.save(penjaga); }

    @Override
    public void deletePenjaga(PenjagaModel penjaga) {
        penjagaDB.delete(penjaga);
        System.out.println("masuk ke detelte");
    }
}
