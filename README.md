# Calculadora Pós-Fixada (Spring Boot)

Esta aplicação simula uma calculadora científica que avalia expressões aritméticas na notação pós-fixada (notação polonesa reversa), utilizando estrutura de **fila dinâmica** e **pilha**.

## Tecnologias
- Java 17+
- Spring Boot
- Thymeleaf
- HTML/CSS
- Maven

## Organização
O código está dividido em pacotes com responsabilidades bem definidas:
- `FilaDinamica.java`: implementação de fila usando `LinkedList`
- `Pilha.java`: pilha com `ArrayDeque`
- `PostfixCalculatorService.java`: lógica de cálculo
- `CalculadoraController.java`: camada web/controller
- `index.html`: interface com campo de entrada e exibição do resultado

Todos os métodos estão **comentados** explicando sua função.

## Execução local

```bash
git clone https://github.com/seu-usuario/calculadora-posfixada.git
cd calculadora-posfixada
./mvnw spring-boot:run
