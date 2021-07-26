package cs.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs.lab.utils.Constants;
import cs.lab.utils.GenerateFakeData;

public class CentroVacunacion {
    String name;

    List<Map<String, Integer>> report() {
        List<Map<String, Integer>> result = new ArrayList<>();
        Map<String, Integer> avanceVacunados = new HashMap<>();
        Map<String, Integer> avanceVacunadosCompletos = new HashMap<>();
        for (var grupoEdad : Constants.gruposEdadString) {
            avanceVacunados.put(grupoEdad, GenerateFakeData.generateVacunados());
            avanceVacunadosCompletos.put(grupoEdad, GenerateFakeData.generateVacunadosCompletos());
        }
        result.set(0, avanceVacunados);
        result.set(1, avanceVacunadosCompletos);
        return result;
    }
}
