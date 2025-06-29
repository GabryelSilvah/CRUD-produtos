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
  </tr>
  <tr>
    <td>GET</td>
    <td>.../categorias/listar</td>
  </tr>
    <tr>
    <td>GET</td>
    <td>.../categorias/byId/{id}</td>
  </tr>
    <tr>
    <td>POST</td>
    <td>.../categorias/Cadastrar</td>
  </tr>
    <tr>
    <td>PUT</td>
    <td>.../categorias/altera/{id}</td>
  </tr>
    <tr>
    <td>DELETE</td>
    <td>.../categorias/excluir/{id}</td>
  </tr>
</table>

### Produtos

<table>
  <tr>
    <th>Verbo HTTP</th>
    <th>Rota</th>
  </tr>
  <tr>
    <tr>
    <td>GET</td>
    <td>.../produtos/listar</td>
  </tr>
    <tr>
    <td>GET</td>
    <td>.../produtos/byId/{id}</td>
  </tr>
    <tr>
    <td>POST</td>
    <td>.../produtos/Cadastrar</td>
  </tr>
    <tr>
    <td>PUT</td>
    <td>.../produtos/altera/{id}</td>
  </tr>
    <tr>
    <td>DELETE</td>
    <td>.../produtos/excluir/{id}</td>
  </tr>
</table>

