package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.SerieDTO;
import es.nosadd.nosadd.model.Serie;
import es.nosadd.nosadd.service.SerieService;
import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/serie")
@Tag(name = "Serie", description = "API de serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @PostMapping
    @Operation(summary = "Insertar una serie")
    public ResponseEntity<?> insertarSerie(@RequestBody SerieDTO serieDTO) {

        Serie serieConsultada = serieService.findById(serieDTO.toSerie().getId());

        if (serieConsultada == null) {
            serieService.save(serieDTO.toSerie());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.SERIE_CREADA);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_SERIE_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSerie(@PathVariable int id) {
        Serie serie = serieService.findById(id);
        if (serie != null) {
            return ResponseEntity.status(HttpStatus.OK).body(serie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIE_NO_ENCONTRADA);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSeries() {
        List<Serie> series = serieService.findAll();
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/titulo/{titulo}")
    public ResponseEntity<?> getSerieByTitulo(@PathVariable String titulo) {
        List<Serie> series = serieService.findAllByTitulo(titulo);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/temporadas/{temporadas}")
    public ResponseEntity<?> getSerieByTemporadas(@PathVariable int temporadas) {
        List<Serie> series = serieService.findAllByTemporadas(temporadas);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/temporadas/mayor/{temporadas}")
    public ResponseEntity<?> getSerieByTemporadasMayor(@PathVariable int temporadas) {
        List<Serie> series = serieService.findAllByTemporadasGreaterThan(temporadas);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/temporadas/menor/{temporadas}")
    public ResponseEntity<?> getSerieByTemporadasMenor(@PathVariable int temporadas) {
        List<Serie> series = serieService.findAllByTemporadasLessThan(temporadas);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/{valoracion}")
    public ResponseEntity<?> getSerieByValoracion(@PathVariable int valoracion) {
        List<Serie> series = serieService.findAllByValoracion(valoracion);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/mayor/{valoracion}")
    public ResponseEntity<?> getSerieByValoracionMayor(@PathVariable int valoracion) {
        List<Serie> series = serieService.findAllByValoracionGreaterThan(valoracion);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/menor/{valoracion}")
    public ResponseEntity<?> getSerieByValoracionMenor(@PathVariable int valoracion) {
        List<Serie> series = serieService.findAllByValoracionLessThan(valoracion);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/capitulos/{capitulos}")
    public ResponseEntity<?> getSerieByCapitulos(@PathVariable int capitulos) {
        List<Serie> series = serieService.findAllByCapitulos(capitulos);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/capitulos/mayor/{capitulos}")
    public ResponseEntity<?> getSerieByCapitulosMayor(@PathVariable int capitulos) {
        List<Serie> series = serieService.findAllByCapitulosGreaterThan(capitulos);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/capitulos/menor/{capitulos}")
    public ResponseEntity<?> getSerieByCapitulosMenor(@PathVariable int capitulos) {
        List<Serie> series = serieService.findAllByCapitulosLessThan(capitulos);
        if (series != null && !series.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(series);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIES_NO_ENCONTRADAS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSerie(@PathVariable int id, @RequestBody SerieDTO serieDTO) {
        Serie serieConsultada = serieService.findById(id);
        if (serieConsultada != null) {
            serieService.save(serieDTO.toSerie());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.SERIE_EDITADA);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIE_NO_ENCONTRADA);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable int id) {
        Serie serieConsultada = serieService.findById(id);
        if (serieConsultada != null) {
            serieService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.SERIE_ELIMINADA);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_SERIE_NO_ENCONTRADA);
        }
    }
}
