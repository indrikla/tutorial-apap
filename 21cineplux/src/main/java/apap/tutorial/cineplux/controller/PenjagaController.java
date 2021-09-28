package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping(value = "/penjaga/update/{noBioskop}/{noPenjaga}")
    public String updatePenjagaForm(@PathVariable Long noBioskop, @PathVariable Long noPenjaga, Model model) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> penjagaList = bioskop.getListPenjaga();
        List<BioskopModel> listBioskop = bioskopService.findAllByOrderByNameBioskopAsc();
        model.addAttribute("listBioskop", listBioskop);
        for (PenjagaModel penjaga : penjagaList) {
            if (penjaga.getNoPenjaga() == (noPenjaga)) {
                if (bioskop.getWaktuTutup().isBefore(LocalTime.now()) && bioskop.getWaktuBuka().isBefore(LocalTime.now())) {
                    model.addAttribute("penjaga", penjaga);
                    model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
                    model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
                    model.addAttribute("bioskop", bioskop);
                    return "form-update-penjaga";
                }
            }
        }
        return "ero";
    }

    @PostMapping(value = "/penjaga/update")
    public String updatePenjagaSubmit(@ModelAttribute PenjagaModel penjaga, Model model) {
        penjagaService.updatePenjaga(penjaga);
        model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
        return "update-penjaga";
    }

    @GetMapping(value = "/penjaga/delete/{noBioskop}/{noPenjaga}")
    public String deletePenjagaForm(@PathVariable Long noBioskop, @PathVariable Long noPenjaga, Model model) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> penjagaList = bioskop.getListPenjaga();
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", penjagaList);

        for (PenjagaModel p : penjagaList) {
            if (p.getNoPenjaga().equals(noPenjaga)) {
                if (bioskop.getWaktuTutup().isBefore(LocalTime.now()) && bioskop.getWaktuBuka().isBefore(LocalTime.now())) {
                    bioskop.getListPenjaga().remove(p);
                    bioskopService.updateBioskop(bioskop);
                    penjagaService.deletePenjaga(p);
                    model.addAttribute("noPenjaga", p.getNoPenjaga());
                    return "delete-penjaga";
                }
            }
        }
        return "ero";
    }
}
