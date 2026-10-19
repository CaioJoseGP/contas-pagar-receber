package br.ifgoiano.cpr.contapagar;

import br.ifgoiano.cpr.shared.dto.QuitacaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contas-pagar")
public class ContaPagarController {

    private final ContaPagarService service;

    public ContaPagarController(ContaPagarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContaPagar>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<ContaPagar> lancar(@RequestBody ContaPagar conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.lancar(conta));
    }

    @PostMapping("/{id}/pagamento")
    public ResponseEntity<ContaPagar> quitar(@PathVariable Long id, @RequestBody QuitacaoRequest request) {
        ContaPagar contaPaga = service.quitar(
                id,
                request.getData(),
                request.getDesconto(),
                request.getAcrescimo()
        );
        return ResponseEntity.ok(contaPaga);
    }
}