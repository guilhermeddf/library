package br.com.saraiva.sales.costumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Valida funcionalidade dos serviços de costumer")
public class CostumerServiceTest {

    @Mock
    private CostumerRepository costumerRepository;

    @InjectMocks
    private CostumerServiceImpl costumerService;

    @Test
    @DisplayName("Deve salvar um costumer com sucesso")
    void shouldSaveSuccessfully() {

    }
}
