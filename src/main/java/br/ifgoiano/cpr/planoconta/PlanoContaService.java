package br.ifgoiano.cpr.planoconta;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PlanoContaService {

    private final PlanoContaRepository repository;

    public PlanoContaService(PlanoContaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<PlanoConta> listarTodas() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public PlanoConta buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano de conta não encontrado."));
    }

    @Transactional
    public PlanoConta salvar(PlanoConta planoConta) {
        return repository.save(planoConta);
    }
}