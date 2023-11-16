# task-api
Task To Do service 


O repositório TaskToDo contém o código-fonte de um serviço de gerenciamento de tarefas, denominado TaskToDoService. Este serviço é parte de uma aplicação mais ampla destinada a facilitar o controle e a organização de tarefas.

Principais Componentes:

1. TaskToDoService:
   - O serviço principal que implementa a interface TaskUseCase.
   - Responsável por manipular operações relacionadas a tarefas, como criação, exclusão, listagem e atualização.

2. TaskRepository:
   - Interface de repositório que fornece métodos para interagir com o banco de dados, como salvar, excluir, buscar e atualizar tarefas.

3. TaskToDoDTO:
   - Uma classe de Transferência de Dados (DTO) que representa uma tarefa. Usada para transferir dados entre as camadas do aplicativo.

4. StatusTaskToDo:
   - Uma enumeração que define os possíveis estados de uma tarefa, como "Pendente", "Em Progresso" ou "Concluída".

Funcionalidades Principais:

1. Criação de Tarefa:
   - Permite a criação de novas tarefas com título, descrição e status associados.

2. Exclusão de Tarefa:
   - Possibilita a exclusão de uma tarefa com base em seu identificador único.

3. Listagem de Tarefas:
   - Recupera a lista completa de tarefas armazenadas no banco de dados.

4. Consulta de Tarefa por ID:
   - Permite a busca e recuperação de detalhes de uma tarefa com base em seu identificador único.

5. Atualização de Tarefa:
   - Atualiza os detalhes de uma tarefa existente com base no título fornecido.

6. Atualização de Status de Tarefa:
   - (Método ainda não implementado) Planejado para atualizar o status de uma tarefa existente.

7. Listagem por Status de Tarefa:
   - Recupera todas as tarefas associadas a um determinado status.

Observações:
- O código faz uso do framework Spring Boot e utiliza injeção de dependência para interagir com o banco de dados.
- Foram implementadas verificações para lidar com situações como exclusão de tarefas inexistentes e atualização de tarefas não encontradas.
- Algumas funcionalidades, como a atualização do status da tarefa, estão marcadas como não implementadas e podem ser desenvolvidas em futuras iterações do projeto.
