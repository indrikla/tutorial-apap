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

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;


@Controller
public class BioskopController {
    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop", new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());

        return "add-bioskop";
    }
    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model){
        List<BioskopModel> listBioskop = bioskopService.findAllByOrderByNameBioskopAsc();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);
        return "view-bioskop";
    }

    @GetMapping(value = "/bioskop/update/{noBioskop}")
    public String updateBioskopForm(@PathVariable Long noBioskop, Model model) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping(value = "/bioskop/update")
    public String updateBioskopSubmit(@ModelAttribute BioskopModel bioskop, Model model) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping(value = "/bioskop/delete/{noBioskop}")
    public String deleteBioskop(@PathVariable Long noBioskop, Model model) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        if (bioskop.getWaktuTutup().isBefore(LocalTime.now())) {
            if (listPenjaga.size() == 0) {
                bioskopService.getBioskopList().remove(bioskop);
                bioskopService.deleteBioskop(bioskop);
                model.addAttribute("noBioskop", bioskop.getNoBioskop());
                return "delete-bioskop";
            }
        }
        return "home";
    }

}