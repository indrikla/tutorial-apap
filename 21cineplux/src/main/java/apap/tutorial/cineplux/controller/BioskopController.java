package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    @RequestMapping("/bioskop/add")
    public String addBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        bioskopService.addBioskop(bioskopModel);

        model.addAttribute("idBioskop", idBioskop);

        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        model.addAttribute("listBioskop", listBioskop);

        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel != null) {
            model.addAttribute("bioskop", bioskopModel);

            return "view-bioskop";

        } else {
            return "error";
        }
    }
    @RequestMapping(value="/bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopWithPathVariable(
            @PathVariable(value = "idBioskop", required = true) String idBioskop, Model model) {
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskopModel != null) {
            model.addAttribute("bioskop", bioskopModel);
            return "view-bioskop";

        } else {
            return "error";
        }
    }

    @RequestMapping(value="/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateJumlahStudio(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model) {

        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskopModel != null) {
            bioskopModel.setJumlahStudio(jumlahStudio);

            model.addAttribute("bioskop", bioskopModel);
            return "update-bioskop";

        } else {
            return "error";
        }
    }

    @RequestMapping(value="/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model) {

        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskopModel != null) {
            bioskopService.getBioskopList().remove(bioskopModel);
            model.addAttribute("bioskop", bioskopModel);

            return "delete-bioskop";

        } else {
            return "error";
        }

    }

}
