package cs.lab;

import cs.lab.utils.GruposEdad;
import java.util.logging.Logger;

import java.util.List;

import cs.lab.utils.Constants;

public class DataVacunacion {
    static final Logger logger = Logger.getLogger(DataVacunacion.class.getName());    
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

            vacunadosParcial.forEach((key,value) -> {
                this.avanceVacunacion.grupos.put(key,this.avanceVacunacion.grupos.get(key) + value);
            });

            vacunadosTotal.forEach((key,value) -> {
                this.avanceVacunacion.grupos.put(key,this.avanceVacunacion.grupos.get(key) + value);
            });
        }

        Integer totalVacunados = 0;
        Integer totalVacunadosCompletos = 0;
        Integer totalGente = 0;

        for (String key: this.gruposEdad.grupos.keySet()){
            totalGente += this.gruposEdad.grupos.get(key);
        }


        for (String key: this.avanceVacunacion.grupos.keySet()){
            totalVacunados += this.avanceVacunacion.grupos.get(key);
        }

        for (String key: this.avanceVacunacionCompleto.grupos.keySet()){
            totalVacunadosCompletos += this.avanceVacunacionCompleto.grupos.get(key);
        }

        float vacunadosP = totalVacunados / totalGente;
        float vacunadosCP = totalVacunadosCompletos / totalGente;


        logger.warning("Avance de la Vacunacion");
        logger.warning(String.valueOf(vacunadosP));
        logger.warning("Cobertura de la Vacunacion");
        logger.warning(String.valueOf(vacunadosCP));
        logger.warning("Numero de Centros de Vacunacion");
        Integer cantidadVacu = (Integer) this.centrosVacunacion.size();
        logger.warning(cantidadVacu.toString());
        logger.warning("Numero de personas vacunadas parcialmente");
        logger.warning(totalVacunados.toString());
        logger.warning("Numero de personas vacunadas completamente");
        logger.warning(totalVacunadosCompletos.toString());
    }

    void visualizarPorcentaje(){
        logger.warning("Vacunacion incompleta");
        this.avanceVacunacion.grupos.forEach((key,value) -> {
            logger.warning(key);
            logger.warning(value.toString());
        });
        logger.warning("Vacunacion completa");
        this.avanceVacunacionCompleto.grupos.forEach((key,value) -> {
            logger.warning(key);
            logger.warning(value.toString());
        });
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
