# *Annottations*

## Sumario

- [*Annottations*](#annottations)
  - [Sumario](#sumario)
  - [Spring Boot](#spring-boot)
    - [`@SpringBootApplication`](#springbootapplication)
    - [`@RestController`](#restcontroller)
    - [`@RequestMapping`](#requestmapping)
    - [`@Autowired`](#autowired)
  - [Lombok](#lombok)

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

## Lombok
