package br.com.mapped.CareMI.model;

import br.com.mapped.CareMI.dto.EnderecoHospitalDto.AtualizacaoEnderecoHospitalDto;
import br.com.mapped.CareMI.dto.EnderecoHospitalDto.CadastroEnderecoHospitalDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="t_endereco_hospital")
@EntityListeners(AuditingEntityListener.class)
public class EnderecoHospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento")
    @SequenceGenerator(name = "atendimento", sequenceName = "seq_mi_atendimento", allocationSize = 1)
    @Column(name="cdEndereco", length = 9)
    private Long id;

    @Column(name="nrLogradouro", length = 7, nullable = false)
    private Integer logradouro;

    @Column(name="dsPontoReferencia", length = 100, nullable = false)
    private String pontoReferencia;

    @Column(name="dsComplemento", length = 100, nullable = false)
    private String complemento;



    public EnderecoHospital(CadastroEnderecoHospitalDto enderecoHospitalDto) {
        logradouro = enderecoHospitalDto.logradouro();
        pontoReferencia = enderecoHospitalDto.pontoReferencia();
        complemento = enderecoHospitalDto.complemento();
    }

    public void atualizarInformacoesEnderecoHospital(AtualizacaoEnderecoHospitalDto dto) {
        if (dto.logradouro() != null)
            logradouro = dto.logradouro();
        if (dto.pontoReferencia() != null)
            pontoReferencia = dto.pontoReferencia();
        if (dto.complemento() != null)
            complemento = dto.complemento();
    }
}
