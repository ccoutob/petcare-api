<h1 align="center">
<br>Petcare 🐕
</h1>

<div align="center">


| Integrantes     |            Responsabilidades          | Turma      |   RM     |
| -------------   | ------------------------------------- | ---------- | -------- |
| Cauã Couto      | Desenvolvimento do projeto em Java    |  2TDSS     |  97755   |
| Kaique Agostinho| Mapeamento das tabelas e relações     |  2TDSS     |  550815  |
</div>

## 📝 Descrição do Projeto 

> O projeto Petcare foi criado para atender a necessidade de Petshops para garantir sua organização 

Nosso sistema fornece informações sobre o petshop e as entidades que estão associadas a ele, desde clientes até fornecedores.
Observe o diagrama e suas relações abaixo para entender melhor nosso projeto!

## 📋  Modelo Relacional das Entidades
![modelo_relacional](https://github.com/ccoutob/petcare-api/assets/126828978/b1efdafe-b3bf-41c8-bb55-f14f13062fa7)

<div>
<h1 align="center"> 📦 Pacotes do Projeto </h1>

<h2> 📦 Model </h2>
<li> Pacote contém as classes responsáveis por serem as base de modelagem da aplicação</li>
<li> Classes responsáveis por mapearem a tabela do Banco de Dados e suas colunas de acordo com as regras de negócio </li>

<h2> 📦 Dto </h2>
<li> As classes contidas nesse pacote são responsáveis pelo mapeamento das transferências que serão feitas no pacote controller</li>
<li> A princípio definem como as informações de nosso sistema serão navegadas e utilizadas</li>

<h2> 📦 Repository </h2>
<li> As classes contidas nesse pacote são responsáveis pela persistência JPA das tabelas</li>
<li> Essas classes serão utilizadas na controller para acessarmos o banco de dados</li>

<h2> 📦 Controller </h2>
<li> As classes contidas nesse pacote são responsáveis por controlarem as requisições que faremos no Postman</li>
<li> Contém o CRUD do projeto com os métodos GET, POST, PUT e DELETE</li>

<h2> 📦 Handler </h2>
<li> A classe nesse pacote é responsável por lançar a exceção de "error 404 not found"</li>
<li> A exceção será lançada caso tentemos realizar a requisição de algum dado que não existe, por exemplo, um id</li>
</div>

###
❗❗ Acesse o arquivo de requisições do postman <a href="https://github.com/ccoutob/Personal-Assist/blob/main/Personal_Assist_Postman_Collection">AQUI</a> ❗❗

### 🧑🏻‍💻 Autor 
> Cauã Couto Basques - Turma 2TDSS






