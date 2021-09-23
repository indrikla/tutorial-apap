package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService{
    private List<BioskopModel> listBioskop;

    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
<<<<<<< HEAD
    public void updateBioskop(BioskopModel bioskop) {

    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {

    }

    @Override
=======
>>>>>>> 70ba2b3560fd1fa23c150b1677f8b51cd7afd606
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

<<<<<<< HEAD

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        return null;
    }

    @Override
    public List<BioskopModel> findAllByOrderByNameBioskopAsc() {
        return null;
    }

=======
    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
        for (BioskopModel bioskopModel : listBioskop) {
            if (bioskopModel.getIdBioskop().equals(idBioskop)) {
                return bioskopModel;
            }
        }
        return null;
    }
>>>>>>> 70ba2b3560fd1fa23c150b1677f8b51cd7afd606
}
