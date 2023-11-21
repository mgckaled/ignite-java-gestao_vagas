# *Annottations*

## Sumario

> [voltar](../../README.md) para a página anterior

- [*Annottations*](#annottations)
  - [Sumario](#sumario)
  - [Spring Boot](#spring-boot)
    - [`@SpringBootApplication`](#springbootapplication)
    - [`@RestController`](#restcontroller)
    - [`@RequestMapping`](#requestmapping)
    - [`@Autowired`](#autowired)
    - [`@Component`](#component)
    - [`@Service`](#service)
    - [`@Value`](#value)
    - [`@Configuration` e `@Bean`](#configuration-e-bean)
  - [Lombok](#lombok)
    - [`@Data`](#data)
    - [`@Builder`](#builder)
  - [Anotações de Testes](#anotações-de-testes)
    - [`@Test`](#test)
    - [`@DisplayName`](#displayname)
    - [`@ExtendWith`](#extendwith)
  - [Mockito](#mockito)
    - [`@InjectMocks`](#injectmocks)
    - [`@Mock`](#mock)

## Spring Boot

### `@SpringBootApplication`

Anotação especial no Spring Boot que é usada para marcar uma classe principal (geralmente a classe que contém o método `public static void main(String[] args)`) e informar ao Spring Boot que esta classe é a entrada principal para a aplicação Spring Boot. Essa anotação combina várias outras anotações do Spring Framework em uma única anotação conveniente.

A anotação `@SpringBootApplication` realiza o seguinte:

1. `@Configuration`: Indica que a classe é uma classe de configuração do Spring, permitindo a definição de beans gerenciados pelo Spring no aplicativo.

2. `@EnableAutoConfiguration`: Habilita a configuração automática do Spring Boot, que configura automaticamente o aplicativo com base nas bibliotecas e no ambiente em uso.

3. `@ComponentScan`: Especifica os pacotes a serem explorados em busca de componentes gerenciados pelo Spring, como controladores, serviços e repositórios.

No geral, `@SpringBootApplication` é uma anotação conveniente para configurar rapidamente um aplicativo Spring Boot e iniciar a configuração automática. A partir da classe principal anotada com `@SpringBootApplication`, você pode iniciar seu aplicativo Spring Boot e deixar o Spring Boot cuidar de grande parte da configuração e inicialização da aplicação.

Aqui está um exemplo de uso da anotação `@SpringBootApplication` em uma classe principal:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinhaAplicacaoSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacaoSpringBoot.class, args);
    }
}
```

Neste exemplo, a classe `MinhaAplicacaoSpringBoot` é a classe principal, e `@SpringBootApplication` é usada para configurar e iniciar a aplicação Spring Boot.

> [retornar](#annottations) para o topo da página

### `@RestController`

Anotação usada como um controlador de API REST. Controladores são componentes importantes em um aplicativo Spring Boot que lidam com solicitações HTTP e retornam respostas no formato JSON, XML ou outros formatos específicos da web, geralmente para construir uma API RESTful.

Ao usar a anotação `@RestController`, você está basicamente combinando duas outras anotações:

1. `@Controller`: Indica que a classe é um controlador do Spring, responsável por lidar com solicitações HTTP. Um controlador tradicional (anotado com `@Controller`) retorna principalmente visualizações HTML.

2. `@ResponseBody`: Indica que os métodos da classe controladora retornam diretamente dados no corpo da resposta HTTP, em vez de visualizações HTML. No contexto de uma API REST, esse é o comportamento desejado, pois os controladores REST retornam normalmente dados serializados no formato JSON, XML ou outro formato.

Portanto, ao anotar uma classe com `@RestController`, você não precisa mais adicionar `@ResponseBody` aos métodos individuais da classe, uma vez que a anotação `@RestController` já inclui essa funcionalidade.

Aqui está um exemplo de uso da anotação `@RestController`:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/recurso")
    public String obterRecurso() {
        return "Este é um exemplo de recurso da API REST.";
    }

    // Outros métodos do controlador para manipular diferentes endpoints da API
}
```

Neste exemplo, a classe `ExemploController` é marcada como um controlador REST usando `@RestController`, e o método `obterRecurso` manipula uma solicitação GET em `/api/recurso` e retorna uma resposta no formato de texto. O Spring Boot cuidará de serializar a resposta no formato apropriado (geralmente JSON) antes de enviá-la de volta ao cliente.

> [retornar](#annottations) para o topo da página

### `@RequestMapping`

Anotação usada para mapear URLs a métodos específicos em controladores. Ela permite que você especifique qual método de um controlador deve ser chamado quando uma solicitação HTTP específica é feita para um determinado URL.

A anotação `@RequestMapping` pode ser usada em nível de classe ou em nível de método em uma classe controladora e fornece flexibilidade na definição de mapeamentos de URLs. Você pode especificar o caminho da URL, o método HTTP, os tipos de mídia aceitos e várias outras opções de mapeamento.

Aqui está um exemplo de uso da anotação `@RequestMapping` em nível de classe e método:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/recurso")
    public String obterRecurso() {
        return "Este é um exemplo de recurso da API REST.";
    }

    @RequestMapping(value = "/outrarecurso", method = RequestMethod.POST)
    public ResponseEntity<String> criarRecurso() {
        // Lógica para criar um recurso
        return new ResponseEntity<>("Recurso criado com sucesso", HttpStatus.CREATED);
    }
}
```

Neste exemplo, a classe `ExemploController` é marcada com `@RestController` e `@RequestMapping("/api")`, o que significa que todos os métodos dentro dessa classe serão acessíveis a partir de URLs que começam com `/api`.

- O método `obterRecurso` é mapeado para a URL `/api/recurso` usando `@GetMapping("/recurso")`, o que significa que ele será chamado quando uma solicitação GET for feita para essa URL.

- O método `criarRecurso` é mapeado para a URL `/api/outrarecurso` e só será chamado quando uma solicitação HTTP POST for feita para essa URL. Além disso, ele retorna uma resposta de status HTTP 201 (CREATED) com uma mensagem.

`@RequestMapping` fornece muitas outras opções para personalizar mapeamentos de URL, como a inclusão de parâmetros de consulta, cabeçalhos personalizados e tipos de mídia aceitos. É uma ferramenta flexível para criar controladores em uma aplicação Spring Boot e manipular solicitações HTTP de maneira eficaz.

> [retornar](#annottations) para o topo da página

### `@Autowired`

A anotação `@Autowired` é usada no Spring Framework, incluindo o Spring Boot, para realizar a injeção de dependências automaticamente em componentes gerenciados pelo contêiner Spring, como serviços, controladores, repositórios e outros. Essa anotação é uma parte essencial do suporte à injeção de dependência no Spring, permitindo que você injete automaticamente beans (objetos) em outros beans sem a necessidade de criar instâncias manualmente.

A funcionalidade principal da anotação `@Autowired` é identificar e injetar automaticamente os beans necessários por tipo. Quando você anota um campo, um método setter ou um construtor com `@Autowired`, o contêiner Spring procurará por um bean que corresponda ao tipo desse campo, método ou construtor e o injetará automaticamente no componente.

Aqui está um exemplo simples de uso da anotação `@Autowired` em uma classe Spring Boot:

```java
@Service
public class MeuServico {

    private MeuRepositorio meuRepositorio;

    @Autowired
    public MeuServico(MeuRepositorio meuRepositorio) {
        this.meuRepositorio = meuRepositorio;
    }

    // Restante da lógica do serviço
}
```

Neste exemplo, o construtor de `MeuServico` é anotado com `@Autowired`, o que indica que o `MeuRepositorio` deve ser injetado automaticamente pelo Spring no momento da criação do `MeuServico`.

O uso de `@Autowired` torna o código mais limpo, ajuda a evitar a necessidade de criar manualmente instâncias de dependências e facilita a manutenção, tornando o gerenciamento de dependências no Spring mais eficiente. Note que, a partir da versão do Spring 4.3, a anotação `@Autowired` tornou-se opcional em construtores se houver apenas um construtor, mas ainda é comumente usada para maior clareza e consistência no código.

> [retornar](#annottations) para o topo da página

### `@Component`

A anotação `@Component` é uma das anotações principais do Spring Framework e é usada para indicar que uma classe é um componente gerenciado pelo contêiner Spring. Em particular, no contexto do Spring Boot, essa anotação é frequentemente usada para identificar classes que devem ser automaticamente escaneadas e registradas como beans no contexto do aplicativo.

Quando uma classe é marcada com `@Component`, o Spring irá detectá-la durante a varredura do classpath e registrá-la como um bean. Beans são objetos gerenciados pelo Spring, que são instanciados, configurados e injetados em outros objetos pelo contêiner Spring.

Exemplo:

```java
import org.springframework.stereotype.Component;

@Component
public class MinhaClasseComponent {
    // código da classe
}
```

Neste exemplo, a classe `MinhaClasseComponent` será automaticamente identificada e registrada como um bean quando o aplicativo Spring Boot for iniciado.

A anotação `@Component` é uma generalização, e existem anotações mais específicas que estendem `@Component`, como `@Service`, `@Repository` e `@Controller`, cada uma delas sendo usada para indicar um papel específico para a classe dentro da arquitetura de aplicativos Spring. No entanto, todas elas compartilham a funcionalidade básica de serem identificadas como componentes gerenciados pelo Spring.

> [retornar](#annottations) para o topo da página

### `@Service`

A anotação `@Service` é usada para marcar uma classe como um bean de serviço. Essa anotação é uma especialização da anotação `@Component` e é comumente usada para identificar classes de serviço na camada de negócios de uma aplicação.

Quando você marca uma classe com `@Service`, o Spring Boot a reconhece durante a varredura do classpath (escaneamento de componentes) e a registra como um bean no contexto do Spring. Beans anotados com `@Service` geralmente representam serviços ou lógica de negócios e são gerenciados pelo contêiner Spring.

A anotação `@Service` é útil por várias razões:

1. **Identificação Semântica:** A anotação ajuda a dar significado semântico ao papel da classe. Quando alguém vê `@Service`, isso sugere que a classe é uma parte do serviço ou da camada de negócios da aplicação.

2. **Injeção de Dependência:** Classes anotadas com `@Service` são elegíveis para injeção de dependência automática em outros componentes gerenciados pelo Spring, como controladores (`@Controller`) ou outros serviços.

3. **Tratamento Transacional:** O Spring fornece suporte transacional para métodos de classes marcadas com `@Service`. Isso significa que você pode usar transações declarativas para controlar a atomicidade das operações realizadas pelos métodos dessa classe.

Aqui está um exemplo simples de uma classe de serviço marcada com `@Service`:

```java
import org.springframework.stereotype.Service;

@Service
public class MeuServico {

    public String realizarOperacao() {
        // Lógica de negócios aqui
        return "Operação realizada com sucesso!";
    }
}
```

Essa classe `MeuServico` seria detectada e gerenciada pelo Spring como um bean de serviço. Pode então ser injetada em outras classes usando, por exemplo, a anotação `@Autowired`.

> [retornar](#annottations) para o topo da página

### `@Value`

Serve para injetar valores diretamente em propriedades de classes gerenciadas pelo contêiner Spring, como serviços, componentes, etc. Essa anotação é uma maneira de fornecer valores de propriedades a partir de várias fontes, como arquivos de propriedades, variáveis de ambiente, argumentos de linha de comando, entre outros.

A anotação `@Value` pode ser usada em métodos, campos ou construtores, e ela aceita expressões de linguagem de expressão de Spring (Spring Expression Language - SpEL). Aqui está um exemplo simples de como você pode usar a anotação `@Value`:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${my.property}")
    private String myProperty;

    // ... outros membros da classe
}
```

Neste exemplo, a propriedade `my.property` é injetada no campo `myProperty` da classe `MyComponent`. O valor dessa propriedade é geralmente definido em um arquivo de propriedades do Spring Boot ou em outras fontes externas.

Além disso, a anotação `@Value` pode ser usada para injetar valores diretamente em métodos ou construtores. Aqui está um exemplo com um método:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private String myProperty;

    @Value("${my.property}")
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    // ... outros membros da classe
}
```

Este método `setMyProperty` será chamado pelo contêiner Spring durante a inicialização, e o valor da propriedade `my.property` será passado como argumento para este método.

Em resumo, a anotação `@Value` é uma maneira conveniente de injetar valores em propriedades de componentes gerenciados pelo Spring Boot, proporcionando uma maior flexibilidade na configuração do aplicativo.

> [retornar](#annottations) para o topo da página

### `@Configuration` e `@Bean`

No Spring Boot, as annotations `@Configuration` e `@Bean` desempenham papéis importantes na configuração e definição de beans gerenciados pelo contêiner Spring.

1. **@Configuration:**
   - A anotação `@Configuration` é usada para marcar uma classe como uma classe de configuração no contexto do Spring. Isso significa que a classe contém métodos anotados com `@Bean` e pode ser usada para definir beans e suas configurações.
   - Classes anotadas com `@Configuration` são geralmente usadas para substituir a configuração XML tradicional, permitindo que você configure o contexto do Spring usando classes Java.

   Exemplo:

   ```java
   @Configuration
   public class AppConfig {
       // Métodos @Bean aqui
   }
   ```

2. **@Bean:**
   - A anotação `@Bean` é usada para indicar ao Spring que um método específico em uma classe `@Configuration` irá retornar um objeto que deve ser registrado como um bean no contexto do Spring.
   - O método anotado com `@Bean` é responsável por criar e configurar o bean que será gerenciado pelo contêiner Spring.

   Exemplo:

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public MinhaClasse meuBean() {
           return new MinhaClasse();
       }
   }
   ```

   Neste exemplo, o método `meuBean()` é um método de fábrica para a criação do bean `MinhaClasse`. Quando o Spring inicializa, ele detecta a classe `AppConfig`, identifica o método anotado com `@Bean`, chama esse método para obter a instância do bean e a registra no contexto do Spring.

Em resumo, `@Configuration` é usada para marcar classes que contêm métodos `@Bean`, enquanto `@Bean` é usado para marcar métodos que definem beans no contexto do Spring. Juntas, essas anotações ajudam a configurar e gerenciar beans no Spring Boot.

> [retornar](#annottations) para o topo da página

## Lombok

### `@Data`

A anotação `@Data` é uma característica do Projeto Lombok e é frequentemente usada em classes Java para reduzir a quantidade de código boilerplate relacionado a métodos como getters, setters, `toString()`, `equals()`, e `hashCode()`. Ao aplicar a anotação `@Data` a uma classe, o Lombok gera automaticamente esses métodos, tornando o código mais conciso e fácil de manter.

A anotação `@Data` combina funcionalidades de outras anotações do Lombok, como `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, e `@RequiredArgsConstructor`. Portanto, ao usar `@Data`, você obtém automaticamente os benefícios dessas outras anotações.

Aqui está um exemplo simples:

```java
import lombok.Data;

@Data
public class Exemplo {
    private String nome;
    private int idade;
}
```

Neste exemplo, a anotação `@Data` está sendo usada na classe `Exemplo`. O Lombok irá automaticamente gerar os métodos `toString()`, `equals()`, `hashCode()`, bem como os getters e setters para as propriedades `nome` e `idade`. Isso reduz a quantidade de código que você precisa escrever manualmente, melhorando a legibilidade e a manutenção do código.

> [retornar](#annottations) para o topo da página

### `@Builder`

A anotação `@Builder` faz parte da biblioteca Lombok no contexto do Java e é usada para simplificar a criação de padrões de construtor, seguindo o padrão de design conhecido como "Builder Pattern". O padrão de construtor é frequentemente utilizado quando uma classe tem muitos atributos opcionais e oferece uma maneira mais flexível e legível de construir objetos.

Ao aplicar a anotação `@Builder` a uma classe, o Lombok gera automaticamente um construtor que aceita todos os atributos da classe como parâmetros. Além disso, ele cria um construtor de "construção" (builder) interno que permite a construção do objeto passo a passo, definindo os valores desejados atributo por atributo.

Aqui está um exemplo simples de como você pode usar a anotação `@Builder`:

```java
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExemploBuilder {
    private String nome;
    private int idade;
    private String endereco;

    public static void main(String[] args) {
        ExemploBuilder pessoa = ExemploBuilder.builder()
                .nome("João")
                .idade(25)
                .endereco("Rua ABC, 123")
                .build();

        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getEndereco());
    }
}
```

Neste exemplo, a anotação `@Builder` elimina a necessidade de escrever manualmente um construtor com diversos parâmetros e fornece um construtor de "construção" que simplifica a criação de instâncias da classe `ExemploBuilder`.

Ao usar o padrão de construtor, você pode criar objetos de maneira mais legível e evitar construtores com muitos parâmetros, tornando seu código mais fácil de entender e manter.

> [retornar](#annottations) para o topo da página

## Anotações de Testes

### `@Test`

A anotação `@Test` faz parte do framework de teste JUnit 5, específicamente do módulo JUnit Jupiter (`org.junit.jupiter.api`). Essa anotação é usada para marcar um método como um método de teste. Quando você executa os testes, o JUnit Jupiter identifica e executa todos os métodos marcados com `@Test`.

Aqui estão algumas características e funcionalidades associadas à anotação `@Test`:

1. **Identificação de Métodos de Teste:**
   - Ao marcar um método com `@Test`, você está indicando ao JUnit que este método contém lógica de teste. Durante a execução dos testes, o JUnit executa todos os métodos marcados como testes.

2. **Asserções:**
   - Dentro de um método marcado com `@Test`, você geralmente encontra asserções que verificam se determinadas condições são verdadeiras. As asserções são usadas para validar o comportamento esperado do código sendo testado.

3. **Ciclo de Vida do Teste:**
   - O JUnit oferece métodos de ciclo de vida, como `@BeforeEach` e `@AfterEach`, que podem ser usados para executar código de configuração ou limpeza antes e depois de cada método de teste marcado com `@Test`. Isso ajuda a garantir um estado consistente antes da execução de cada teste.

4. **Parâmetros de Teste (JUnit 5+):**
   - O JUnit 5 introduziu a capacidade de passar parâmetros para métodos de teste. Você pode utilizar a anotação `@ParameterizedTest` ou `@ValueSource` para testes parametrizados.

5. **Testes de Exceção (JUnit 4):**
   - No JUnit 4, para testar exceções, você pode usar a atributo `expected` da anotação `@Test`. Já no JUnit 5, o suporte a testes de exceção foi aprimorado com a anotação `@Test` suportando diretamente a assertiva de exceção.

Exemplo de uso básico:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeuTeste {

    @Test
    public void meuMetodoDeTeste() {
        // Lógica de teste e asserções aqui
        assertEquals(2, 1 + 1);
    }
}
```

Neste exemplo, o método `meuMetodoDeTeste` é marcado como um teste usando `@Test`, e a asserção `assertEquals` verifica se a soma de 1 + 1 é igual a 2. Se a asserção falhar, o teste é considerado como falhado.

> [retornar](#annottations) para o topo da página

### `@DisplayName`

A anotação `@DisplayName` faz parte do framework de teste JUnit 5 (JUnit Jupiter) e é utilizada para fornecer um nome mais descritivo aos métodos de teste. Ela não afeta o resultado dos testes, mas pode ser útil para tornar os relatórios de testes mais legíveis e compreensíveis. Essa anotação é opcional e é uma prática recomendada para melhorar a clareza dos relatórios de execução de testes.

Aqui está um exemplo de como a anotação `@DisplayName` pode ser usada em conjunto com a anotação `@Test`:

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeuTeste {

    @Test
    @DisplayName("Teste de soma")
    public void meuMetodoDeTeste() {
        // Lógica de teste e asserções aqui
        assertEquals(2, 1 + 1);
    }
}
```

Neste exemplo, o método de teste `meuMetodoDeTeste` está marcado com a anotação `@DisplayName("Teste de soma")`. Isso significa que, ao executar os testes, o relatório indicará que este teste específico tem o nome "Teste de soma". Isso pode ser particularmente útil quando você tem muitos testes e deseja tornar o propósito de cada teste mais claro no relatório de execução.

Lembrando que a anotação `@DisplayName` é completamente opcional, e se não for fornecida, o nome do método de teste será utilizado nos relatórios padrão de execução de testes.

> [retornar](#annottations) para o topo da página

### `@ExtendWith`

A anotação `@ExtendWith` é parte do framework de teste JUnit 5 (JUnit Jupiter) e é utilizada para registrar extensões (extensions) que podem ser usadas para estender o comportamento dos testes. As extensões são uma forma de modularizar e reutilizar código que precisa ser compartilhado entre vários testes.

Aqui estão alguns pontos importantes sobre a anotação `@ExtendWith`:

1. **Registro de Extensões:**
   - `@ExtendWith` é usada para registrar uma ou mais classes que implementam a interface `Extension` (ou suas subinterfaces). Essas classes são então consideradas como extensões que afetam o comportamento dos testes.

2. **Uso de Extensões:**
   - As extensões podem ser utilizadas para adicionar funcionalidades extras aos testes, como ações de inicialização e limpeza, manipulação de contexto de teste, entre outros.

3. **Múltiplas Extensões:**
   - Você pode usar `@ExtendWith` para registrar várias extensões, criando assim uma cadeia de extensões. A ordem em que as extensões são registradas pode ser significativa, pois a execução ocorre na ordem em que as extensões são registradas.

4. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.junit.jupiter.api.extension.ExtendWith;
   import some.package.MyExtension;

   @ExtendWith(MyExtension.class)
   public class MeuTeste {

       @Test
       public void meuMetodoDeTeste() {
           // Lógica de teste aqui
       }
   }
   ```

   Neste exemplo, `MyExtension` é uma classe que implementa a interface `Extension`, e ela será utilizada como uma extensão para o teste.

5. **Extensões Padrão:**
   - O JUnit Jupiter fornece algumas extensões padrão, como `TestInfo`, `TestReporter`, `MockitoExtension`, entre outras. Essas extensões oferecem funcionalidades adicionais que podem ser úteis durante a execução dos testes.

Em resumo, a anotação `@ExtendWith` é usada para associar extensões aos métodos de teste, permitindo uma modularização e reutilização eficientes de código que afeta o comportamento dos testes.

> [retornar](#annottations) para o topo da página

## Mockito

### `@InjectMocks`

A anotação `@InjectMocks` é parte do framework de mocking Mockito em Java. Ela é usada em conjunto com a injeção de dependência para injetar automaticamente as dependências marcadas como `@Mock` ou `@Spy` em um objeto que está sendo testado.

Aqui estão alguns pontos-chave sobre a anotação `@InjectMocks`:

1. **Injeção de Dependência Automática:**
   - A anotação `@InjectMocks` é usada para injetar automaticamente as dependências mockadas (marcadas com `@Mock` ou `@Spy`) em um objeto que está sendo testado. Isso é particularmente útil para evitar a necessidade de criar manualmente instâncias de objetos mockados e configurar as dependências.

2. **Uso em Testes Unitários:**
   - Geralmente, você usará `@InjectMocks` em classes de teste unitário para injetar mocks ou espiões nas dependências da classe que está sendo testada.

3. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;

   import static org.mockito.Mockito.verify;
   import static org.mockito.Mockito.when;
   import org.mockito.junit.jupiter.MockitoExtension;
   import org.junit.jupiter.api.extension.ExtendWith;

   @ExtendWith(MockitoExtension.class)
   public class MeuTeste {

       @Mock
       private Dependencia dependenciaMock;

       @InjectMocks
       private ObjetoSobTeste objetoSobTeste;

       @Test
       public void meuMetodoDeTeste() {
           // Configuração do comportamento do mock
           when(dependenciaMock.metodoDoMock()).thenReturn("Algo");

           // Chama o método que está sendo testado
           objetoSobTeste.executarAlgumaLogica();

           // Verifica se o método do mock foi chamado
           verify(dependenciaMock).metodoDoMock();
       }
   }
   ```

   Neste exemplo, `dependenciaMock` é um mock de uma dependência, e `objetoSobTeste` é o objeto que está sendo testado. A anotação `@InjectMocks` injeta automaticamente `dependenciaMock` em `objetoSobTeste`.

4. **Considerações:**
   - É importante notar que `@InjectMocks` tenta injetar mocks nas propriedades da classe de teste. Se a injeção não for bem-sucedida (por exemplo, devido à falta de setters correspondentes), o Mockito pode lançar uma exceção.

5. **Compatibilidade com JUnit 5:**
   - A presença de `@ExtendWith(MockitoExtension.class)` indica que estamos usando o suporte do Mockito para JUnit 5. Certifique-se de que você tenha a dependência correta do Mockito no seu projeto para habilitar essa extensão.

> [retornar](#annottations) para o topo da página

### `@Mock`

A anotação `@Mock` faz parte do framework de mocking Mockito em Java. Ela é usada para criar objetos simulados (mocks) de classes ou interfaces. Esses mocks são usados em testes para isolar a unidade de código que está sendo testada, substituindo as dependências reais por comportamentos simulados controlados pelo teste.

Aqui estão alguns pontos-chave sobre a anotação `@Mock`:

1. **Criação de Mocks:**
   - A anotação `@Mock` é usada para criar um mock de uma classe ou interface. O Mockito cria automaticamente uma instância simulada do tipo da classe ou interface marcada com `@Mock`.

2. **Uso em Testes:**
   - Geralmente, você usará `@Mock` em classes de teste para substituir as dependências reais por mocks controlados pelo teste. Isso ajuda a isolar a unidade de código que está sendo testada, focando apenas no comportamento da unidade de código em questão.

3. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.mockito.Mock;

   import static org.mockito.Mockito.when;
   import static org.junit.jupiter.api.Assertions.assertEquals;

   public class MeuTeste {

       @Mock
       private MinhaClasse minhaClasseMock;

       @Test
       public void meuMetodoDeTeste() {
           // Configuração do comportamento do mock
           when(minhaClasseMock.metodoDoMock()).thenReturn("Algo");

           // Chama o método que está sendo testado
           String resultado = minhaClasseMock.metodoDoMock();

           // Verifica se o método do mock foi chamado
           assertEquals("Algo", resultado);
       }
   }
   ```

   Neste exemplo, `minhaClasseMock` é um mock da classe `MinhaClasse`. O comportamento do método `metodoDoMock` é configurado para retornar "Algo". No teste, verifica-se se o método do mock é chamado conforme esperado.

4. **Considerações:**
   - Os mocks geralmente são usados para isolar o código em teste de suas dependências externas, permitindo que o teste se concentre em um aspecto específico do comportamento do código.

5. **Compatibilidade com JUnit 5:**
   - O exemplo acima é para JUnit 5, mas o Mockito também é compatível com JUnit 4. Certifique-se de incluir as dependências apropriadas no seu projeto para usar o Mockito em conjunto com seu framework de teste preferido.

> [retornar](#annottations) para o topo da página
>
> [voltar](../../README.md) para a página anterior
