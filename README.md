# Sobre

Projeto API REST de cadastro de produtos e categorias. Projto referente a matéria de Pogramação Orientada a Objeto II.


## Tecnologias

- Spring Boot (API Back-end)
- Postman (Teste dos endPoints)

## Rotas 

### Categorias
<table>
  <tr>
    <th>Verbo HTTP</th>
    <th>Rota</th>
    <th>Body</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>.../categorias/listar</td>
    <td>Não</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>.../categorias/byId/{id}</td>
    <td>Não</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>.../categorias/cadastrar</td>
    <td>Sim</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>.../categorias/altera/{id}</td>
    <td>Sim</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>.../categorias/excluir/{id}</td>
    <td>Não</td>
  </tr>
</table>

### Produtos

<table>
  <tr>
    <th>Verbo HTTP</th>
    <th>Rota</th>
    <th>Body</th>
  </tr>
  <tr>
    <tr>
    <td>GET</td>
    <td>.../produtos/listar</td>
    <td>Não</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>.../produtos/byId/{id}</td>
    <td>Não</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>.../produtos/cadastrar</td>
    <td>Sim</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>.../produtos/altera/{id}</td>
    <td>Sim</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>.../produtos/excluir/{id}</td>
    <td>Não</td>
  </tr>
</table>

