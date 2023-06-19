# E-commerce

## Este repositório é um MVP de um sistema de E-commerce, um sistema de carrinho de compras.
O projeto do E-commerce é do primeiro desafio do programa de bolsas back-end da Compass Uol.
Esse projeto simula um carrinho de compras, onde é possível: adicionar, remover, listar, atualizar
e finalizar a compra do carrinho. Além disso, também é possível adicionar, remover, atualizar 
e listar os itens da loja.


### As tecnologias utilizadas foram:
 * Java
 * MySQL

### Pré Requisitos:
 * Instalar o Java no computador (oracle.com/br/java/technologies/downloads/)
 * Instalar o Xampp no computador (https://www.apachefriends.org/pt_br/download.html)
 * Instalar o driver do MySql (https://dev.mysql.com/downloads/connector/j/)
 * Possuir alguma IDE que rode Java, de preferência Intellij ou Eclipse
 * Possuir alguma IDE que rode MySQL, de preferência Workbench
 * Adicionar o driver do MySql na IDE utilizada

### Uso do projeto:
 * Clonar o repositório ou fazer o download em qualquer lugar do seu computador
 * Abrir o projeto na IDE de preferência
 * Abrir o Xampp e iniciar o MySql

### Banco de dados:
* O banco de dados do sistema é um requisito para o funcionamento do projeto
* O arquivo 'banco.sql' é o script do banco
* Abri-lo no Workbench
* Executar os comandos e as tabelas do script
* Obs: no script há alguns valores pré-colocados, entretanto, é possível inserir valores pelo console do programa.

### Carrinho de compras:
* O cliente pode:
 * Adicionar,
 * Remover,
 * Listar,
 * Atualizar,
 * Finalizar compra,
 * Sair do Supermercado,
* essas são as opções que podem ser feitas no carrinho de compras e pelo cliente.
* Após finalizar a compra, a quantidade de produtos será subtraida da quantidade total do produto na tabela produtos.

### Funcionários
* A classe Funcionários foi criada para fazer o contato direto com o banco de dados dos produtos do Supermercado,
* o funcionário é capaz de:
 * Adicionar,
 * Remover,
 * Listar,
 * Atualizar,
* os produtos do Supermercado.

### Procedimento
* É importante que na hora de manipular o produto, independente da opção, você escreva exatamente como está no banco de dados.
* O banco de dados está localizado localmente, então caso for upar o banco em outro local que não seja localhost, é necessário mudar o novo caminho do banco em todas as conexões do projeto.

#### Outras ferramentas
Método:
Foi utilizado o método Kanban para a organização e desenvolvimento do projeto
https://trello.com/b/qiwwaC3u/desafio-um


#### Dúvidas ou erros
Caso tenha alguma dúvida ou algum erro, entrar em contato comigo pelo e-mail:
analarapupo@gmail.com
