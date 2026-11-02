# Catálogo de Produtos — Configuração e estrutura

https://github.com/EdRauber/AP---React/tree/main

## 1. Instruções de execução e configuração da API

### Requisitos

- JDK 25 ou superior.
- Node.js v24.18.0 ou superior.

### Configuração do Spring Boot

No arquivo `src/main/resources/application.properties`, configure:

```properties
spring.application.name=catalogo
server.port=8080
```

No `ProdutoController`, permita o acesso pelo endereço do React:

```java
@CrossOrigin(origins = "http://localhost:5173")
```

### Execução da API

No PowerShell, dentro da pasta que contém o arquivo `pom.xml`, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

### Teste dos endpoints

| Método | Endereço | Resultado esperado |
|---|---|---|
| GET | `http://localhost:8080/produtos` | Lista de produtos em JSON |
| GET | `http://localhost:8080/produtos/1` | Detalhes do produto com ID 1 |
| GET | `http://localhost:8080/produtos/999` | Status 404, caso o produto não exista |

Os produtos são definidos em memória, na classe `ProdutoService.java`.
Após modificar a lista no Java, reinicie o Spring Boot e atualize a página do React.

### Configuração e execução do React

Em outro terminal, dentro da pasta do React, execute:

```powershell
npm install
npm run dev
```

Abra o endereço informado pelo Vite, normalmente `http://localhost:5173`.

Reinicie o servidor do React após alterar o arquivo `.env`.
A API e o React devem permanecer em execução simultaneamente.

## 2. Diagrama textual da árvore de componentes

```text
App
├── Header
├── ProductSearch
├── ProductList
│   └── ProductCard (um para cada produto)
└── ProductDetails (exibido ao selecionar um produto)
```

## 3. Fluxo de dados entre os componentes

O `App` consulta a API e armazena a lista de produtos e o texto da pesquisa em estados.  
O `ProductSearch` recebe o texto por props e comunica alterações ao `App` por uma função recebida por props.  
O `App` filtra os produtos pelo nome e envia a lista resultante ao `ProductList`.  
O `ProductList` percorre essa lista e passa cada produto para um `ProductCard`.  
Ao clicar em “Ver detalhes”, o `ProductCard` comunica o ID selecionado ao `App`, usando a função repassada pelo `ProductList`.  
O `App` consulta os detalhes na API e envia o produto, o carregamento e possíveis erros ao `ProductDetails`.  
Ao fechar os detalhes, o `ProductDetails` chama a função recebida do `App`, que limpa a seleção e oculta o painel.