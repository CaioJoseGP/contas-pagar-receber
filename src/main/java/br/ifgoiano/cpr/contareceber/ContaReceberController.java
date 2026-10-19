package br.ifgoiano.cpr.contareceber;

import br.ifgoiano.cpr.shared.dto.QuitacaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contas-receber")
public class ContaReceberController {

    private final ContaReceberService service;

    public ContaReceberController(ContaReceberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContaReceber>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<ContaReceber> lancar(@RequestBody ContaReceber conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.lancar(conta));
    }

    @PostMapping("/{id}/recebimento")
    public ResponseEntity<ContaReceber> receber(@PathVariable Long id, @RequestBody QuitacaoRequest request) {
        ContaReceber contaRecebida = service.receber(
                id,
                request.getData(),
                request.getDesconto(),
                request.getAcrescimo()
        );
        return ResponseEntity.ok(contaRecebida);
    }
}