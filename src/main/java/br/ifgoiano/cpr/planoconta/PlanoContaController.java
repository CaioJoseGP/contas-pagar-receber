package br.ifgoiano.cpr.planoconta;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/plano-contas")
public class PlanoContaController {

    private final PlanoContaService service;

    public PlanoContaController(PlanoContaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlanoConta>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<PlanoConta> salvar(@RequestBody PlanoConta planoConta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(planoConta));
    }
}