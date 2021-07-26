package cs.lab;

import cs.lab.utils.GruposEdad;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cs.lab.utils.Constants;

public class DataVacunacion {
    String name;
    GruposEdad gruposEdad;
    GruposEdad avanceVacunacion;
    GruposEdad avanceVacunacionCompleto;

    List<CentroVacunacion> centrosVacunacion;

    DataVacunacion(String name) {
        this.name = name;
        initGruposEdad();
    }

    void initGruposEdad() {
        gruposEdad.grupos.put(Constants.gruposEdadString.get(0), 647355);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(1), 1271842);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(2), 2221241);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(3), 3277134);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(4), 4183174);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(5), 5031117);
        gruposEdad.grupos.put(Constants.gruposEdadString.get(6), 6303670);

        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(0), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(1), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(2), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(3), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(4), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(5), 0);
        avanceVacunacion.grupos.put(Constants.gruposEdadString.get(6), 0);

        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(0), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(1), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(2), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(3), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(4), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(5), 0);
        avanceVacunacionCompleto.grupos.put(Constants.gruposEdadString.get(6), 0);
    }

    void notificar() {
        for (var centro : centrosVacunacion) {
            var results = centro.report();

            var vacunadosParcial = results.get(0);
            var vacunadosTotal = results.get(1);

            for (var parcial : vacunadosParcial) {
                parcial.forEach((key, value) -> {
                    this.avanceVacunacion.grupos.put(key, this.avanceVacunacion.grupos.get(key) + value);
                });
            }

            for (var total : vacunadosTotal) {
                total.forEach((key, value) -> {
                    this.avanceVacunacion.grupos.put(key, this.avanceVacunacion.grupos.get(key) + value);
                });
            }
        }
    }

    void darBaja(CentroVacunacion centroVacunacion) {
        centrosVacunacion.remove(centroVacunacion);
    }

    void darAlta(CentroVacunacion centroVacunacion) {
        centrosVacunacion.add(centroVacunacion);
    }

    public List<CentroVacunacion> getCentrosVacunacion() {
        return centrosVacunacion;
    }
}
