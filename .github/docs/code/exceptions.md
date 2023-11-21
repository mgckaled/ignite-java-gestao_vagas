<!-- markdownlint-disable MD024 -->

# `exceptions/`

> [voltar](../c_code-analysis.md) para a página anterior

## Sumário

- [`exceptions/`](#exceptions)
  - [Sumário](#sumário)
  - [Função](#função)
  - [Análise do Código](#análise-do-código)
    - [`ErrorMessageDTO.java`](#errormessagedtojava)
    - [`ExceptionHandlerController.java`](#exceptionhandlercontrollerjava)
    - [`JobNotFoundException.java`](#jobnotfoundexceptionjava)
    - [`UserFoundException.java`](#userfoundexceptionjava)
    - [`UserNotFoundException.java`](#usernotfoundexceptionjava)

## Função

## Análise do Código

### `ErrorMessageDTO.java`

1. **Importações do Lombok:**

   ```java
   import lombok.AllArgsConstructor;
   import lombok.Data;
   ```

   - `@AllArgsConstructor`: Essa anotação do Lombok gera automaticamente um construtor que aceita todos os campos da classe como argumentos. Ele evita a necessidade de escrever explicitamente um construtor com todos os parâmetros.

   - `@Data`: Essa anotação combina várias outras anotações, incluindo `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` e `@RequiredArgsConstructor`. Em outras palavras, ela simplifica a criação de métodos comuns, tornando o código mais conciso e legível.

2. **Definição da Classe `ErrorMessageDTO`:**

   ```java
   public class ErrorMessageDTO {
   ```

   - `ErrorMessageDTO` é o nome da classe.

3. **Atributos da Classe:**

   ```java
   private String message;
   private String field;
   ```

   - `message` e `field` são atributos privados da classe.

4. **Métodos Gerados pelo Lombok:**
   - `@Data` gera automaticamente os seguintes métodos (entre outros):
      - Métodos `get` e `set` para os atributos `message` e `field`.
      - Um método `toString` que retorna uma representação de string da instância da classe.
      - Métodos `equals` e `hashCode` para comparação e geração de códigos hash com base nos valores dos atributos.

   - `@AllArgsConstructor` gera um construtor que aceita todos os atributos como parâmetros.

5. **Resultado Final:**
   Graças às anotações do Lombok, você pode criar uma instância da classe `ErrorMessageDTO`, acessar e modificar seus atributos de forma fácil e concisa, e obter automaticamente implementações adequadas de métodos comuns. Existe uma redução significativa da quantidade de código boilerplate que você normalmente escreveria para criar esses métodos manualmente.

### `ExceptionHandlerController.java`

### `JobNotFoundException.java`

### `UserFoundException.java`

### `UserNotFoundException.java`

> [retornar](#exceptions) para o topo da página
>
> [voltar](../c_code-analysis.md) para a página anterior
