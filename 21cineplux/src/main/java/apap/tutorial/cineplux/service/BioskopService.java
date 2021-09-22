package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
    void updateBioskop(BioskopModel bioskop);
    void deleteBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
    List<BioskopModel> findAllByOrderByNameBioskopAsc();
}
