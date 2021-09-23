package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
<<<<<<< HEAD
import org.springframework.data.domain.Sort;
=======
>>>>>>> 70ba2b3560fd1fa23c150b1677f8b51cd7afd606

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
<<<<<<< HEAD
    void updateBioskop(BioskopModel bioskop);
    void deleteBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
    List<BioskopModel> findAllByOrderByNameBioskopAsc();
=======

    List<BioskopModel> getBioskopList();

    BioskopModel getBioskopByIdBioskop(String idBioskop);
>>>>>>> 70ba2b3560fd1fa23c150b1677f8b51cd7afd606
}
