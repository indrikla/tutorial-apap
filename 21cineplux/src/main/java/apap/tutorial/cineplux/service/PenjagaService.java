package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    void updatePenjaga(PenjagaModel penjaga);
    void deletePenjaga(PenjagaModel penjaga);
}
