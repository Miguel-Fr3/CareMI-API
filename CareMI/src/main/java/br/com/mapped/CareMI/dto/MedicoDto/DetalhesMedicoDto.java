package br.com.mapped.CareMI.dto.MedicoDto;

import br.com.mapped.CareMI.model.Medico;

public record DetalhesMedicoDto(Long id, String nome, String especializacao, String crm, String email, String celular) {

    public DetalhesMedicoDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEspecializacao(), medico.getCrm(), medico.getEmail(), medico.getCelular());
    }
}